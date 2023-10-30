package com.characterintroduction.main.repository;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.characterintroduction.main.dto.MemoDTO;

@Repository
public class MemoRepository {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:13306/character_introduction";
	private static final String USER = "";
	private static final String PW = "";
	
	public Connection ConnectionDB() throws Exception {
		Class.forName(DRIVER);
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			System.out.println(con);
			System.out.println("연결 성공");
		} catch(SQLException e) {
			System.out.println("connection failed!");
		}
		
		return con;
	}

	public MemoDTO insertMemo(MemoDTO memo) throws Exception {
		Statement stmt = null;
		Connection con = ConnectionDB();

		try {
			String sql = "insert into memo (character_num, memo_title, memo_content) values ('"+memo.getCharacterNum()+"', '"+memo.getMemoTitle()+"', '"+memo.getMemoContent()+"')";
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("테이블 삽입이 성공했습니다.");
		} catch (SQLException ex) {
			System.out.println("테이블 삽입이 실패했습니다.<br>");
			System.out.println("SQLException: "+ex.getMessage());
		} finally {
			if(stmt != null)
				stmt.close();
			if(con!=null)
				con.close();
		}
		return memo;
	}

	public List<MemoDTO> getAllMemos() throws Exception {
		
		Statement stmt = null;
		Connection con = ConnectionDB();
		ResultSet rsForTotal = null;
		ResultSet rsForAllData = null;
		List<MemoDTO> memoList = new ArrayList<>();
		
		String sqlForTotal = "select count(*) from memo;";
		stmt = con.createStatement();
		rsForTotal = stmt.executeQuery(sqlForTotal);
		int total = 0;
		if (rsForTotal.next()) {
		    total = rsForTotal.getInt("count(*)");
		}
		System.out.println(total);
		try {
			String sqlForAllData = "select * from memo";
			stmt = con.createStatement();
			rsForAllData = stmt.executeQuery(sqlForAllData);
			
			while(rsForAllData.next()) {
				MemoDTO memo = new MemoDTO("", "", "", "");
				
				int num = rsForAllData.getInt("memo_num");
				System.out.println(num);
				
				memo.setMemoNum(String.valueOf(rsForAllData.getInt("memo_num")));
				memo.setCharacterNum(String.valueOf(rsForAllData.getInt("character_num")));
				memo.setMemoTitle(rsForAllData.getString("memo_title"));
				memo.setMemoContent(rsForAllData.getString("memo_content"));
				
				memoList.add(memo);
			}
			System.out.println("테이블 조회가 성공했습니다.");
		} catch (SQLException ex) {
			System.out.println("테이블 조회가 실패했습니다.<br>");
			System.out.println("SQLException: "+ex.getMessage());
		} finally {
			if(stmt != null)
				stmt.close();
		}
		
		
		System.out.println(memoList);
		
		if(con!=null)
			con.close();
		
		return memoList;
	}

	public MemoDTO getMemoByMemoNum(String memoNum) throws Exception {
		
		Statement stmt = null;
		Connection con = ConnectionDB();
		ResultSet rs = null;
		MemoDTO memo = new MemoDTO("", "", "", "");
		
		try {
			String sql = "select * from memo where memo_num ='"+memoNum+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt("memo_num");
				System.out.println(num);
				memo.setMemoNum(String.valueOf(rs.getInt("memo_num")));
				memo.setCharacterNum(String.valueOf(rs.getInt("character_num")));
				memo.setMemoTitle(rs.getString("memo_title"));
				memo.setMemoContent(rs.getString("memo_content"));
			}
			
			System.out.println("테이블 조회가 성공했습니다.");
		} catch (SQLException ex) {
			System.out.println("테이블 조회가 실패했습니다.<br>");
			System.out.println("SQLException: "+ex.getMessage());
		} finally {
			if(stmt != null)
				stmt.close();
			if(con!=null)
				con.close();
		}
		return memo;
	}

	public void updateMemo(String memoNum, MemoDTO memo) throws Exception {

		PreparedStatement pstmt = null;
		Connection con = ConnectionDB();
		
		try {
			String sql = "update memo set memo_num=?, memo_title=?, memo_content=? where memo_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(memo.getMemoNum()));
		    pstmt.setString(2, memo.getMemoTitle());
		    pstmt.setString(3, memo.getMemoContent());
		    pstmt.setInt(4, Integer.parseInt(memoNum));
		    
		    int rowsAffected = pstmt.executeUpdate();
		    
		    if (rowsAffected > 0) {
		        System.out.println("테이블 수정이 성공했습니다.");
		    } else {
		        System.out.println("테이블 수정이 실패했습니다.");
		    }
			
		} catch (SQLException ex) {
			System.out.println("테이블 수정 SQLException<br>");
			System.out.println("SQLException: "+ex.getMessage());
		} finally {
			if(pstmt != null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
	}

	public void deleteMemo(String memoNum) throws Exception {
		
		PreparedStatement pstmt = null;
		Connection con = ConnectionDB();
		
		try {
			String sql = "delete from memo where memo_num=?";
			pstmt = con.prepareStatement(sql);
			
		    pstmt.setInt(1, Integer.parseInt(memoNum));
		    
		    int rowsAffected = pstmt.executeUpdate();
		    
		    if (rowsAffected > 0) {
		        System.out.println("테이블 삭제가 성공했습니다.");
		    } else {
		        System.out.println("테이블 삭제가 실패했습니다.");
		    }
			
		} catch (SQLException ex) {
			System.out.println("테이블 삭제 SQLException<br>");
			System.out.println("SQLException: "+ex.getMessage());
		} finally {
			if(pstmt != null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
	}
	
}
