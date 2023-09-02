package com.characterintroduction.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.characterintroduction.main.dto.CharacterDTO;
import com.characterintroduction.main.dto.MemoDTO;
import com.characterintroduction.main.repository.CharacterRepository;

@Service
public class CharacterService {
	@Autowired
	CharacterRepository characterRepository;
	
	public CharacterDTO insertCharacter(CharacterDTO character) throws Exception {
		return characterRepository.insertCharacter(character);
	}
	
	public List<CharacterDTO> getAllCharacters() throws Exception {
		return characterRepository.getAllCharacters();
	}
	
	public CharacterDTO getCharacterByCharacterNum(String characterNum) throws Exception {
		return characterRepository.getCharacterByCharacterNum(characterNum);
	}
	
	public void updateCharacter(String characterNum, CharacterDTO character) throws Exception {
		characterRepository.updateCharacter(characterNum, character);
	}
	
	public void deleteCharacter(String characterNum) throws Exception {
		characterRepository.deleteCharacter(characterNum);
	}
}
