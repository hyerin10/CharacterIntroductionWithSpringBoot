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

import com.characterintroduction.main.dto.CharacterDTO;
import com.characterintroduction.main.dto.MemoDTO;
import com.characterintroduction.main.service.CharacterService;
import com.characterintroduction.main.service.MemoService;

@RestController
@RequestMapping("/api")
public class CharacterController {
	@Autowired
	CharacterService characterService;
	
	@PostMapping("/character")
	public CharacterDTO insertMemo(@RequestBody CharacterDTO character) throws Exception {
		return characterService.insertCharacter(character);
	}
	
	@GetMapping("/characters")
	public List<CharacterDTO> getAllMemos() throws Exception {
		return characterService.getAllCharacters();
	}
	
	@GetMapping("/character/{characterNum}")
	public CharacterDTO getMemoByMemoNum(@PathVariable String characterNum) throws Exception {
		return characterService.getCharacterByCharacterNum(characterNum);
	}
	
	@PutMapping("/character/{characterNum}")
	public void updateMemo(@PathVariable String characterNum, @RequestBody CharacterDTO character) throws Exception {
		characterService.updateCharacter(characterNum, character);
	}
	
	@DeleteMapping("/character/{characterNum}")
	public void deleteMemo(@PathVariable String characterNum) throws Exception {
		characterService.deleteCharacter(characterNum);
	}
}
