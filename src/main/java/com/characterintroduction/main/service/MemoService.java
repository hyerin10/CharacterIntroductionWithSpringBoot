package com.characterintroduction.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.characterintroduction.main.dto.MemoDTO;
import com.characterintroduction.main.repository.MemoRepository;

@Service
public class MemoService {
	@Autowired
	MemoRepository memoRepository;
	
	public MemoDTO insertMemo(MemoDTO memo) {
		return memoRepository.insertMemo(memo);
	}
	
	public List<MemoDTO> getAllMemos() {
		return memoRepository.getAllMemos();
	}
	
	public MemoDTO getMemoByMemoNum(String memoNum) {
		return memoRepository.getMemobyMemoNum(memoNum);
	}
	
	public void updateMemo(String memoNum, MemoDTO memo) {
		memoRepository.updateMemo(memoNum, memo);
	}
	
	public void deleteMemo(String memoNum) {
		memoRepository.deleteMemo(memoNum);
	}
}
