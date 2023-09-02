package com.characterintroduction.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.characterintroduction.main.dto.MemoDTO;
import com.characterintroduction.main.service.MemoService;

@RestController
@RequestMapping("/api")
public class MemoController {
	@Autowired
	MemoService memoService;
	
	@PostMapping("/memo")
	public MemoDTO insertMemo(@RequestBody MemoDTO memo) throws Exception {
		memoService.insertMemo(memo);
		return memo;
	}
	
	@GetMapping("/memos")
	public List<MemoDTO> getAllMemos() throws Exception {
		return memoService.getAllMemos();
	}
	
	@GetMapping("/memo/{memoNum}")
	public MemoDTO getMemoByMemoNum(@PathVariable String memoNum) throws Exception {
		return memoService.getMemoByMemoNum(memoNum);
	}
	
	@PutMapping("/memo/{memoNum}")
	public void updateMemo(@PathVariable String memoNum, @RequestBody MemoDTO memo) throws Exception {
		memoService.updateMemo(memoNum, memo);
	}
	
	@DeleteMapping("/memo/{memoNum}")
	public void deleteMemo(@PathVariable String memoNum) throws Exception {
		memoService.deleteMemo(memoNum);
	}
}
