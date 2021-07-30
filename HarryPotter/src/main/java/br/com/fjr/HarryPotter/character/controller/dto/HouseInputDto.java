package br.com.fjr.HarryPotter.character.controller.dto;

public class HouseInputDto {

	private String id;
	private String school;

	public HouseInputDto() {
		
	}
	
	public HouseInputDto(String id, String school) {
		this.id = id;
		this.school = school;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
	
	
	
}
