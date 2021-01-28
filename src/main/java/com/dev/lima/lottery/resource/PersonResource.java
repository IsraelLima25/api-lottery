package com.dev.lima.lottery.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonResource {

	@Autowired
	private PersonService servicePerson;

	@GetMapping(value = "/person")
	public ResponseEntity<PersonDTO> findPersonsByEmail(@RequestParam String email) {
		PersonDTO person = servicePerson.findPersonByEmail(email);
		return ResponseEntity.ok(person);
	}
}
