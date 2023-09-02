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

	MemoDTO memoDTO;

	public void insertMemo(MemoDTO memoDTO) throws Exception {
		memoRepository.insertMemo(memoDTO);
	}

	public MemoDTO getMemoByMemoNum(String memoNum) throws Exception {
		return memoRepository.getMemoByMemoNum(memoNum);
	}
	
	public List<MemoDTO> getAllMemos() throws Exception {
		return memoRepository.getAllMemos();
	}
	
	public void updateMemo(String memoNum, MemoDTO memoDTO) throws Exception {
		memoRepository.updateMemo(memoNum, memoDTO);
	}
	
	public void deleteMemo(String memoNum) throws Exception {
		memoRepository.deleteMemo(memoNum);
	}
}
