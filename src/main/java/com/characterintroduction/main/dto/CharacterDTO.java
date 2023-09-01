package com.characterintroduction.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CharacterDTO {
	private String characterNum;
	private String characterName;
	private String gender;
	private String themeColor;
	private String characterImageURL;
	private String eyes;
	private String skin;
	private String hair;
	private String clothing;
	private String etc;
	private String weatherConditions;
}
