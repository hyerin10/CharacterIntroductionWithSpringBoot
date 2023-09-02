package com.characterintroduction.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.characterintroduction.main.dto.CharacterDTO;
import com.characterintroduction.main.dto.MemoDTO;

@Repository
public class CharacterRepository {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:13306/characterintroduction";
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
	
	public CharacterDTO insertCharacter(CharacterDTO character) throws Exception {
		
		Connection con = ConnectionDB();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into character_information (name, gender, theme_color, character_image_url, eyes, skin, hair, clothing, etc, weather_conditions) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, character.getName());
	        pstmt.setString(2, character.getGender());
	        pstmt.setString(3, character.getThemeColor());
	        pstmt.setString(4, character.getCharacterImageURL());
	        pstmt.setString(5, character.getEyes());
	        pstmt.setString(6, character.getSkin());
	        pstmt.setString(7, character.getHair());
	        pstmt.setString(8, character.getClothing());
	        pstmt.setString(9, character.getEtc());
	        pstmt.setString(10, character.getWeatherConditions());

	        int rowsAffected = pstmt.executeUpdate();

	        if (rowsAffected > 0) 
	            System.out.println("테이블 삽입이 성공했습니다.");
	        else 
	            System.out.println("테이블 삽입이 실패했습니다.");
	        
		} catch (SQLException ex) {
			System.out.println("테이블 삽입 SQLException<br>");
			System.out.println("SQLException: "+ex.getMessage());
		} finally {
			if(pstmt != null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		return character;
	}
	
	public List<CharacterDTO> getAllCharacters() throws Exception {
		
		Statement stmt = null;
		Connection con = ConnectionDB();
		ResultSet rsForTotal = null;
		ResultSet rsForAllData = null;
		List<CharacterDTO> characterList = new ArrayList<>();
		
		String sqlForTotal = "select count(*) from character_information;";
		stmt = con.createStatement();
		rsForTotal = stmt.executeQuery(sqlForTotal);
		int total = 0;
		if (rsForTotal.next()) {
		    total = rsForTotal.getInt("count(*)");
		}
		System.out.println(total);
		try {
			String sqlForAllData = "select * from character_information";
			stmt = con.createStatement();
			rsForAllData = stmt.executeQuery(sqlForAllData);
			
			while(rsForAllData.next()) {
				CharacterDTO character = new CharacterDTO("", "", "", "", "", "", "", "", "", "", "");
				
				int num = rsForAllData.getInt("num");
				System.out.println(num);
				
				character.setNum(String.valueOf(rsForAllData.getInt("num")));
				character.setName(rsForAllData.getString("name"));
				character.setCharacterImageURL(rsForAllData.getString("character_image_url"));
				character.setClothing(rsForAllData.getString("clothing"));
				character.setEtc(rsForAllData.getString("etc"));
				character.setEyes(rsForAllData.getString("eyes"));
				character.setGender(rsForAllData.getString("gender"));
				character.setHair(rsForAllData.getString("hair"));
				character.setSkin(rsForAllData.getString("skin"));
				character.setThemeColor(rsForAllData.getString("theme_color"));
				character.setWeatherConditions(rsForAllData.getString("weather_conditions"));
				
				characterList.add(character);
			}
			System.out.println("테이블 조회가 성공했습니다.");
		} catch (SQLException ex) {
			System.out.println("테이블 조회가 실패했습니다.<br>");
			System.out.println("SQLException: "+ex.getMessage());
		} finally {
			if(stmt != null)
				stmt.close();
		}
		
		
		System.out.println(characterList);
		
		if(con!=null)
			con.close();
		
		return characterList;
	}
	
	public CharacterDTO getCharacterByCharacterNum(String num) throws Exception {
		Statement stmt = null;
		Connection con = ConnectionDB();
		ResultSet rs = null;
		CharacterDTO character = new CharacterDTO("", "", "", "", "", "", "", "", "", "", "");
		
		try {
			String sql = "select * from character_information where num ='"+num+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				character.setNum(String.valueOf(rs.getInt("num")));
				character.setName(rs.getString("name"));
				character.setGender(rs.getString("gender"));
				character.setThemeColor(rs.getString("theme_color"));
				character.setCharacterImageURL(rs.getString("character_image_url"));
				character.setEyes(rs.getString("eyes"));
				character.setSkin(rs.getString("skin"));
				character.setHair(rs.getString("hair"));
				character.setClothing(rs.getString("clothing"));
				character.setEtc(rs.getString("etc"));
				character.setWeatherConditions(rs.getString("weather_conditions"));
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
		return character;
	}
	
	public void updateCharacter(String characterNum, CharacterDTO character) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = ConnectionDB();
		
		try {
			String sql = "update character_information set num=?, name=?, gender=?, theme_color=?, character_image_url=?, eyes=?, skin=?, hair=?, clothing=?, etc=?, weather_conditions=? where num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(character.getNum()));
		    pstmt.setString(2, character.getName());
		    pstmt.setString(3, character.getGender());
		    pstmt.setString(4, character.getThemeColor());
		    pstmt.setString(5, character.getCharacterImageURL());
		    pstmt.setString(6, character.getEyes());
		    pstmt.setString(7, character.getSkin());
		    pstmt.setString(8, character.getHair());
		    pstmt.setString(9, character.getClothing());
		    pstmt.setString(10, character.getEtc());
		    pstmt.setString(11, character.getWeatherConditions());
		    pstmt.setInt(12, Integer.parseInt(characterNum));
		    
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
	
	public void deleteCharacter(String characterNum) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = ConnectionDB();
		
		try {
			String sql = "delete from character_information where num=?";
			pstmt = con.prepareStatement(sql);
			
		    pstmt.setInt(1, Integer.parseInt(characterNum));
		    
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
