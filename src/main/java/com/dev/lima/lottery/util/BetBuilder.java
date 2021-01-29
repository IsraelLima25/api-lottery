package com.dev.lima.lottery.util;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.lima.lottery.dto.BetDTO;
import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.model.Bet;
import com.dev.lima.lottery.model.Person;
import com.dev.lima.lottery.service.BetService;
import com.dev.lima.lottery.service.PersonService;

@Component
public class BetBuilder implements Serializable {

	@Autowired
	private RandomNumber random;

	@Autowired
	private BetService serviceBet;

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonBuilder personBuilder;
	
	@Autowired
	private ConverterPerson converterPerson;

	private static final long serialVersionUID = 1L;

	private Bet bet;

	public BetBuilder() {

	}

	public void withPerson(Person person) {
		this.bet.setPerson(person);
	}

	public Bet getBet() {
		return bet;
	}

	public BetDTO confirmBuilder(String emailPerson) {
		bet = new Bet();
		Person person = personBuilder.confirmBuilder(emailPerson);		
		this.bet.setPerson(person);
		this.bet.setDate(LocalDate.now());
		this.bet.setNumbers(random.getNumberListSorty());

		Bet betSave = serviceBet.saveBet(bet);

		this.bet.getPerson().getBets().add(betSave);

		PersonDTO personDTO = new PersonDTO();

		personDTO = converterPerson.toPersonDTOFromPerson(person);

		personService.savePerson(personDTO);

		betSave.setPerson(betSave.getPerson());

		serviceBet.saveBet(bet);

		BetDTO betDTO = new BetDTO();

		BeanUtils.copyProperties(betSave, betDTO);

		return betDTO;

	}

}
