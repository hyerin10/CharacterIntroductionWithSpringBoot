package com.characterintroduction.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemoDTO {
	private String memoNum;
	private String characterNum;
	private String memoTitle;
	private String memoContent;	
}
