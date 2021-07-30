package br.com.fjr.HarryPotter.character.controller.dto;

public class CharacterUpdateInputDto {
	private String name;
	private String role;
	private String house;
	private String patronus;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getPatronus() {
		return patronus;
	}
	public void setPatronus(String patronus) {
		this.patronus = patronus;
	}
	
	
}
