package com.dev.lima.lottery.util;

import org.springframework.stereotype.Component;

import com.dev.lima.lottery.dto.BetDTO;
import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.model.Bet;
import com.dev.lima.lottery.model.Person;

@Component
public class ConverterPerson {

	public PersonDTO toPersonDTOFromPerson(Person person) {

		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(person.getId());
		personDTO.setEmail(person.getEmail());

		for (Bet bet : person.getBets()) {
			BetDTO betDTO = new BetDTO();
			betDTO.setId(bet.getId());
			betDTO.setNumbers(bet.getNumbers());
			betDTO.setPerson(bet.getPerson());
			betDTO.setDate(bet.getDate());

			personDTO.getBets().add(betDTO);
		}

		return personDTO;
	}
	
	public Person toPersonFromPersonDTO(PersonDTO personDTO) {

		Person person = new Person();
		person.setId(personDTO.getId());
		person.setEmail(personDTO.getEmail());

		for (BetDTO betDTO : personDTO.getBets()) {
			Bet bet = new Bet();
			bet.setId(betDTO.getId());
			bet.setNumbers(betDTO.getNumbers());
			bet.setPerson(betDTO.getPerson());
			bet.setDate(betDTO.getDate());

			person.getBets().add(bet);
		}

		return person;
	}

}
