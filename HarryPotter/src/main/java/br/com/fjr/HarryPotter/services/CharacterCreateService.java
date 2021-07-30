package br.com.fjr.HarryPotter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fjr.HarryPotter.character.controller.dto.CharacterCreateInputDto;
import br.com.fjr.HarryPotter.character.controller.dto.HouseInputDto;
import br.com.fjr.HarryPotter.entity.Character;
import br.com.fjr.HarryPotter.exeptionConf.NotFoundException;
import br.com.fjr.HarryPotter.repository.CharacterRepository;

@Service
public class CharacterCreateService {
	
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private PotterApiService potterApiService;

    @Transactional
    public Character execute(CharacterCreateInputDto inputDto) {
    	HouseInputDto housePotter = potterApiService.findHouseById(inputDto.getHouse());
    	
        if (housePotter == null) {
        	throw new NotFoundException("House not found");
        }

        
        Character personage = new Character();
        personage.setName(inputDto.getName());
        personage.setHouse(inputDto.getHouse());
        personage.setPatronus(inputDto.getPatronus());
        personage.setRole(inputDto.getRole());
        personage.setSchool(housePotter.getSchool());
        return characterRepository.save(personage);
    }
}
