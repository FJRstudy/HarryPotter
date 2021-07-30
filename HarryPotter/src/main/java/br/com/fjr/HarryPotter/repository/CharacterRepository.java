package br.com.fjr.HarryPotter.repository;
import br.com.fjr.HarryPotter.entity.Character;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>{
	public List<Character> findByHouseLike(String houseId);
}
