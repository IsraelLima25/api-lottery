package com.dev.lima.lottery.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	
	private List<BetDTO> betsDTO = new ArrayList<>(); 

	public PersonDTO() {

	}

	public PersonDTO(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<BetDTO> getBetsDTO() {
		return betsDTO;
	}

}