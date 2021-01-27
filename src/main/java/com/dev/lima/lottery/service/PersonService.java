package com.dev.lima.lottery.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.model.Person;
import com.dev.lima.lottery.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repositoryPerson;

	public PersonDTO findPersonByEmail(String email) {
		Optional<Person> optionalPerson = repositoryPerson.findById(email);
		PersonDTO personDTO = new PersonDTO();
		BeanUtils.copyProperties(optionalPerson, personDTO);

		return personDTO;
	}

	public Person savePerson(PersonDTO personDTO) {
		Person person = new Person();
		BeanUtils.copyProperties(personDTO, person);

		Person personSave = repositoryPerson.save(person);

		return personSave;
	}

}
