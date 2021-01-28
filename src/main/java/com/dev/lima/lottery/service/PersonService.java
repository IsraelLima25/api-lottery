package com.dev.lima.lottery.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lima.lottery.dto.BetDTO;
import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.model.Bet;
import com.dev.lima.lottery.model.Person;
import com.dev.lima.lottery.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repositoryPerson;

	public PersonDTO findPersonByEmail(String email) {
		Optional<Person> person = repositoryPerson.findOptionalByEmail(email);
		PersonDTO personDTO = new PersonDTO();
		if(person.isPresent()) {
			personDTO = new PersonDTO();
			BeanUtils.copyProperties(person.get(), personDTO);
			
			for(Bet bet : person.get().getBets()) {
				BetDTO betDTO = new BetDTO();
				betDTO.setId(bet.getId());
				betDTO.setNumbers(bet.getNumbers());
				betDTO.setDate(bet.getDate());
				betDTO.setPerson(bet.getPerson());
				personDTO.getBets().add(betDTO);
			}
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
