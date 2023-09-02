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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
@Api(tags = "Memo Controller")
public class MemoController {
	@Autowired
	MemoService memoService;
	
	@PostMapping("/memo")
	@ApiOperation("Insert a new memo")
	public MemoDTO insertMemo(@RequestBody @ApiParam(value = "Memo information to insert") MemoDTO memo) throws Exception {
		memoService.insertMemo(memo);
		return memo;
	}
	
	@GetMapping("/memos")
	@ApiOperation("Get list of all memos")
	public List<MemoDTO> getAllMemos() throws Exception {
		return memoService.getAllMemos();
	}
	
	@GetMapping("/memo/{memoNum}")
	@ApiOperation("Get memo by memo number")
	public MemoDTO getMemoByMemoNum(@PathVariable @ApiParam(value = "Memo number", example = "1") String memoNum) throws Exception {
		return memoService.getMemoByMemoNum(memoNum);
	}
	
	@PutMapping("/memo/{memoNum}")
	@ApiOperation("Update memo information")
	public void updateMemo(@PathVariable @ApiParam(value = "Memo number", example = "1") String memoNum, @RequestBody @ApiParam(value = "Updated memo information") MemoDTO memo) throws Exception {
		memoService.updateMemo(memoNum, memo);
	}
	
	@DeleteMapping("/memo/{memoNum}")
	@ApiOperation("Delete memo by memo number")
	public void deleteMemo(@PathVariable @ApiParam(value = "Memo number", example = "1") String memoNum) throws Exception {
		memoService.deleteMemo(memoNum);
	}
}
