package com.characterintroduction.main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.characterintroduction.main.dto.CharacterDTO;

@Repository
public class CharacterRepository {

	static public ArrayList<CharacterDTO> characters;
	
	static {
		characters = new ArrayList<>();
		characters.add(new CharacterDTO("1", "kim", "male", "blue", "character_images/test.jpg", "bk", "bk", "bk", "hoodie", "etc", "rainy"));
		characters.add(new CharacterDTO("2", "lee", "male", "green", "character_images/test.jpg", "bk", "yellow", "bk", "hoodie", "etc", "rainy"));
		characters.add(new CharacterDTO("3", "choi", "female", "red", "character_images/test.jpg", "brown", "bk", "bk", "hoodie", "etc", "rainy"));
	}
	
	public CharacterDTO insertCharacter(CharacterDTO character) {
		characters.add(character);
		return character;
	}
	
	public List<CharacterDTO> getAllCharacters() {
		return characters;
	}
	
	public CharacterDTO getCharacterByCharacterNum(String characterNum) {
		return characters.stream()
				.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
				.findAny()
				.orElse(new CharacterDTO("","","","","","","","","","",""));
	}
	
	public void updateCharacter(String characterNum, CharacterDTO character) {
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setCharacterName(character.getCharacterName());
		
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setCharacterImageURL(character.getCharacterImageURL());
		
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setClothing(character.getClothing());
		
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setEtc(character.getEtc());
		
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setEyes(character.getEyes());
		
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setGender(character.getGender());
		
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setHair(character.getHair());
		
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setSkin(character.getSkin());
		
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setThemeColor(character.getThemeColor());
		
		characters.stream()
		.filter(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum))
		.findAny()
		.orElse(new CharacterDTO("","","","","","","","","","",""))
		.setWeatherConditions(character.getWeatherConditions());
	}
	
	public void deleteCharacter(String characterNum) {
		characters.removeIf(CharacterDTO -> CharacterDTO.getCharacterNum().equals(characterNum));
	}
}
