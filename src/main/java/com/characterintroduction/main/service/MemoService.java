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

	public void save(MemoDTO memoDTO) {
		
	}

	
}
