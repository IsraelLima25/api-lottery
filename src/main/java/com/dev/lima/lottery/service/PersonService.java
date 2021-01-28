package com.dev.lima.lottery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lima.lottery.dto.BetDTO;
import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.exception.ResourceNotFoundException;
import com.dev.lima.lottery.model.Person;
import com.dev.lima.lottery.repository.PersonRepository;
import com.dev.lima.lottery.util.ConverterPerson;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repositoryPerson;
	
	@Autowired
	private ConverterPerson converterPerson;
	
	
	public PersonDTO findPersonByEmail(String email) {
		Optional<Person> person = repositoryPerson.findOptionalByEmail(email);
		if(!person.isPresent()) {
			throw new ResourceNotFoundException();
		}
		
		PersonDTO personDTO = new PersonDTO();
		
		personDTO = new PersonDTO();
		BeanUtils.copyProperties(person.get(), personDTO);
		List<BetDTO> listBetDTO = converterPerson.toBetFromBetDTO(person.get().getBets());
		
		for(BetDTO betDTO: listBetDTO) {
			personDTO.getBets().add(betDTO);
		}

		return personDTO;
	}

	public Person savePerson(PersonDTO personDTO) {
		Person person = new Person();
		BeanUtils.copyProperties(personDTO, person);

		Person personSave = repositoryPerson.save(person);

		return personSave;
	}

}
