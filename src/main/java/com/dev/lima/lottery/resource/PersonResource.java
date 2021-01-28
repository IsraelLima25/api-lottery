package com.dev.lima.lottery.resource;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.service.PersonService;

@RestController
@RequestMapping("/persons")
@Validated
public class PersonResource {

	@Autowired
	private PersonService servicePerson;
	
	@GetMapping(value = "/person")
	public ResponseEntity<PersonDTO> findPersonsByEmail(@Email @NotBlank @RequestParam("email") String email) {
		
		PersonDTO person = servicePerson.findPersonByEmail(email);
		return ResponseEntity.ok(person);
	}
}
