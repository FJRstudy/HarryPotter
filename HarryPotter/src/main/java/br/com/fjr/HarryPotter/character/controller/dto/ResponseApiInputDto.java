package br.com.fjr.HarryPotter.character.controller.dto;

import java.util.List;

public class ResponseApiInputDto {
private List<HouseInputDto> houses;

public List<HouseInputDto> getHouses() {
	return houses;
}

public void setHouses(List<HouseInputDto> houses) {
	this.houses = houses;
}


}
