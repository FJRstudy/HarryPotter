package br.com.fjr.HarryPotter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fjr.HarryPotter.exeptionConf.NotFoundException;
import br.com.fjr.HarryPotter.repository.CharacterRepository;
import br.com.fjr.HarryPotter.entity.Character;



@Service
public class CharacterDeletService {

	@Autowired
    private CharacterRepository personageRepository;

    @Transactional
    public void execute(Long id) {
    	Character character = personageRepository.findById(id)
        		.orElseThrow(() -> new NotFoundException("Character not found in the base"));
        personageRepository.delete(character);
    }
	
}
