package br.com.fjr.HarryPotter.character.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fjr.HarryPotter.character.controller.dto.CharacterCreateInputDto;
import br.com.fjr.HarryPotter.character.controller.dto.CharacterUpdateInputDto;
import br.com.fjr.HarryPotter.entity.Character;
import br.com.fjr.HarryPotter.repository.CharacterRepository;
import br.com.fjr.HarryPotter.services.CharacterCreateService;
import br.com.fjr.HarryPotter.services.CharacterDeletService;
import br.com.fjr.HarryPotter.services.CharacterUpdateService;
import br.com.fjr.HarryPotter.exeptionConf.NotFoundException;

@CrossOrigin
@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

	@Autowired
	private CharacterRepository characterRepository;

	    @Autowired
	    private CharacterCreateService characterCreateService;
	    @Autowired
	    private CharacterUpdateService charactersUpdateService;
	    
	    @Autowired
	    private CharacterDeletService characterDeletService;

	    
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Character show(@PathVariable Long id) {
		return characterRepository.findById(id).orElseThrow(() -> new NotFoundException("Character not found"));
	}

	@GetMapping()
    @ResponseStatus(HttpStatus.OK)
	public List<Character> index(@RequestParam(required = false, defaultValue ="%") String house){
		return characterRepository.findByHouseLike(house);
	}

	    @PostMapping()
	    @ResponseStatus(HttpStatus.CREATED)
	    public Character create(@RequestBody CharacterCreateInputDto inputDto) {
	        return characterCreateService.execute(inputDto);
	    }
	    
	    @PutMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public Character update(@PathVariable Long id, @RequestBody CharacterUpdateInputDto inputDto) {
	        return charactersUpdateService.execute(id, inputDto);
	    }

	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void delete(@PathVariable Long id) {
	    	characterDeletService.execute(id);
	    }

}
