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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
@Api(tags = "Character Controller")
public class CharacterController {
	@Autowired
	CharacterService characterService;
	
	@PostMapping("/character")
	@ApiOperation("Insert a new character")
	public CharacterDTO insertCharacter(@RequestBody CharacterDTO character) throws Exception {
		return characterService.insertCharacter(character);
	}
	
	@GetMapping("/characters")
	@ApiOperation("Get list of all characters")
	public List<CharacterDTO> getAllCharacters() throws Exception {
		return characterService.getAllCharacters();
	}
	
	@GetMapping("/character/{characterNum}")
	@ApiOperation("Get character by character number")
	public CharacterDTO getCharacterByCharacterNum(@PathVariable @ApiParam(value = "Character number", example = "1") String characterNum) throws Exception {
		return characterService.getCharacterByCharacterNum(characterNum);
	}
	
	@PutMapping("/character/{characterNum}")
	@ApiOperation("Update character information")
	public void updateCharacter(@PathVariable @ApiParam(value = "Character number", example = "1") String characterNum, @RequestBody @ApiParam(value = "Updated character information") CharacterDTO character) throws Exception {
		characterService.updateCharacter(characterNum, character);
	}
	
	@DeleteMapping("/character/{characterNum}")
	@ApiOperation("Delete character by character number")
	public void deleteCharacter(@PathVariable @ApiParam(value = "Character number", example = "1")  String characterNum) throws Exception {
		characterService.deleteCharacter(characterNum);
	}
}
