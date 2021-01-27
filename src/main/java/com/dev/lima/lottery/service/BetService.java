package com.dev.lima.lottery.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.model.Bet;
import com.dev.lima.lottery.model.Person;
import com.dev.lima.lottery.repository.BetRepository;
import com.dev.lima.lottery.util.RandomNumber;

@Service
public class BetService {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private RandomNumber random;

	@Autowired
	private BetRepository repositoryBet;

	public List<Integer> validCreateBet(String email) {
		if (!emailExists(email)) {
			PersonDTO personDTO = new PersonDTO(email);
			Person personSave = personService.savePerson(personDTO);
			List<Integer> numbersSorty = createBet(personSave);

			return numbersSorty;

		} else {
			PersonDTO personDTO = personService.findPersonByEmail(email);
			Person person = new Person();
			BeanUtils.copyProperties(personDTO, person);
			List<Integer> numbersSorty = createBet(person);

			return numbersSorty;
		}
	}

	private List<Integer> createBet(Person person) {
		
		List<Integer> numbersListSorty = random.getNumberListSorty();
		
		Bet bet = new Bet(LocalDate.now());
		for (Integer number : numbersListSorty) {
			bet.getNumbers().add(number);
		}

		Bet betSave = saveBet(bet);

		person.getBets().add(betSave);

		PersonDTO personDTO = new PersonDTO();

		BeanUtils.copyProperties(person, personDTO);

		personService.savePerson(personDTO);

		betSave.setPerson(person);

		saveBet(bet);

		return numbersListSorty;

	}

	private Bet saveBet(Bet bet) {

		Bet betSave = repositoryBet.save(bet);
		return betSave;
	}

	private boolean emailExists(String email) {
		return personService.findPersonByEmail(email) != null;
	}

}
