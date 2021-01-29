package com.dev.lima.lottery.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.lima.lottery.dto.BetDTO;
import com.dev.lima.lottery.exception.ResourceNotFoundException;
import com.dev.lima.lottery.model.Bet;
import com.dev.lima.lottery.repository.BetRepository;
import com.dev.lima.lottery.util.BetBuilder;

@Service
public class BetService {

	@Autowired
	private BetBuilder builderBet;

	@Autowired
	private BetRepository repositoryBet;

	public BetDTO findById(Integer id) {

		Optional<Bet> betFind = repositoryBet.findById(id);

		if (betFind.isEmpty()) {
			throw new ResourceNotFoundException();
		}

		BetDTO betDTO = new BetDTO();

		BeanUtils.copyProperties(betFind.get(), betDTO);

		return betDTO;
	}

	public BetDTO builderBet(String emailPerson) {
		
		BetDTO betBuilder = builderBet.confirmBuilder(emailPerson);
		
		return betBuilder;
	}

	public Bet saveBet(Bet bet) {

		Bet betSave = repositoryBet.save(bet);
		return betSave;
	}


}
