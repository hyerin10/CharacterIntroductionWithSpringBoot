package com.characterintroduction.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.characterintroduction.main.dto.MemoDTO;

@Repository
public class MemoRepository {
	
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:13306";
	private static final String USER = "";
	private static final String PW = "";
	
	public void Connection() throws Exception {
		Class.forName(DRIVER);
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(con);
			System.out.println("연결 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static public ArrayList<MemoDTO> memos;

	static {
		memos = new ArrayList<>();
		memos.add(new MemoDTO("1", "1", "title1", "content1"));
		memos.add(new MemoDTO("2", "1","title2", "content2"));
		memos.add(new MemoDTO("3", "2", "title3", "content3"));
	}
	
	public MemoDTO insertMemo(MemoDTO memo) {
		memos.add(memo);
		return memo;
	}

	public List<MemoDTO> getAllMemos() {
		return memos;
	}

	public MemoDTO getMemobyMemoNum(String memoNum) {
		return memos.stream()
				.filter(memoDTO -> memoDTO.getMemoNum().equals(memoNum))
				.findAny()
				.orElse(new MemoDTO("","","",""));
	}

	public void updateMemo(String memoNum, MemoDTO memo) {
		memos.stream()
		.filter(memoDTO -> memoDTO.getMemoNum().equals(memoNum))
		.findAny()
		.orElse(new MemoDTO("","","",""))
		.setMemoTitle(memo.getMemoTitle());

		memos.stream()
		.filter(memoDTO -> memoDTO.getMemoNum().equals(memoNum))
		.findAny()
		.orElse(new MemoDTO("","","",""))
		.setMemoContent(memo.getMemoContent());
	}

	public void deleteMemo(String memoNum) {
		memos.removeIf(memoDTO -> memoDTO.getMemoNum().equals(memoNum));
	}
	
}
