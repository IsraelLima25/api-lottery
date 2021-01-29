package com.dev.lima.lottery.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.model.Person;
import com.dev.lima.lottery.service.PersonService;

@Component
public class PersonBuilder {

	private Person person = new Person();

	@Autowired
	private PersonService personService;

	public Person confirmBuilder(String emailPerson) {

		PersonDTO personDTO = new PersonDTO();

		try {
			personDTO = personService.findPersonByEmail(emailPerson);
			
			BeanUtils.copyProperties(personDTO, this.person);
			return getPerson();

		} catch (RuntimeException e) {

			personDTO.setEmail(emailPerson);
			this.person = personService.savePerson(personDTO);
			return getPerson();
		}
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
