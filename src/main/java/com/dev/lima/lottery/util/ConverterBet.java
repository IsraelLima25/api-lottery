package com.dev.lima.lottery.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dev.lima.lottery.dto.BetDTO;
import com.dev.lima.lottery.model.Bet;

@Component
public class ConverterBet {
	
	public List<BetDTO> toBetListFromBetLisDTO(List<Bet> betObj){
		
		List<BetDTO> listBetDTO = new ArrayList<>();
		
		for(Bet bet : betObj) {
			BetDTO betDTO = new BetDTO();
			betDTO.setId(bet.getId());
			betDTO.setNumbers(bet.getNumbers());
			betDTO.setDate(bet.getDate());
			betDTO.setPerson(bet.getPerson());
			listBetDTO.add(betDTO);
		}
		
		return listBetDTO;
	}
	
}
