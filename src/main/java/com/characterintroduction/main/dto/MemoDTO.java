package com.characterintroduction.main.dto;

import lombok.Data;

@Data
public class MemoDTO {
	private String memoNum;
	private String characterNum;
	private String memoTitle;
	private String memoContent;
	
	public MemoDTO(String memoNum, String characterNum, String memoTitle, String memoContent) {
		this.memoNum = memoNum;
		this.characterNum = characterNum;
		this.memoTitle = memoTitle;
		this.memoContent = memoContent;
	}
}
