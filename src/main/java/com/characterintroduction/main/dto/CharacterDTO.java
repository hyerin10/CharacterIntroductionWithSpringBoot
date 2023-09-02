package com.characterintroduction.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {
	private String num;
	private String name;
	private String gender;
	private String themeColor;
	private String characterImageURL;
	private String eyes;
	private String skin;
	private String hair;
	private String clothing;
	private String etc;
	private String weatherConditions;
	
	public CharacterDTO(String num, String name, String gender, String themeColor, String characterImageURL, String eyes, String skin, String hair, String clothing, String etc, String weatherConditions) {
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.themeColor = themeColor;
		this.characterImageURL = characterImageURL;
		this.eyes = eyes;
		this.skin = skin;
		this.hair = hair;
		this.clothing = clothing;
		this.etc = etc;
		this.weatherConditions = weatherConditions;
	}
}
