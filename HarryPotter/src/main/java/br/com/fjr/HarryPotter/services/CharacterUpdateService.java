package br.com.fjr.HarryPotter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fjr.HarryPotter.character.controller.dto.CharacterUpdateInputDto;
import br.com.fjr.HarryPotter.character.controller.dto.HouseInputDto;
import br.com.fjr.HarryPotter.repository.CharacterRepository;
import br.com.fjr.HarryPotter.entity.Character;
import br.com.fjr.HarryPotter.exeptionConf.NotFoundException;

@Service
public class CharacterUpdateService {
	@Autowired
    private CharacterRepository personageRepository;
    @Autowired
    private PotterApiService potterApiService;

    @Transactional
    public Character execute(Long id, CharacterUpdateInputDto dto) {
        Character personage = personageRepository.findById(id)
        		.orElseThrow(() -> new NotFoundException("Personage not found"));
       

        HouseInputDto housePotter = potterApiService.findHouseById(dto.getHouse());
        if (housePotter == null) {
            throw new NotFoundException("House not found");
        }
        personage.setName(dto.getName());
        personage.setHouse(dto.getHouse());
        personage.setPatronus(dto.getPatronus());
        personage.setRole(dto.getRole());
        personage.setSchool(housePotter.getSchool());
        return personageRepository.save(personage);
    }
}
