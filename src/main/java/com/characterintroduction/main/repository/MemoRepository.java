package com.characterintroduction.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.characterintroduction.main.dto.MemoDTO;

@Repository
public class MemoRepository {

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
