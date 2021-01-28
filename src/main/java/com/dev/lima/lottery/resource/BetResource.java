package com.dev.lima.lottery.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.service.BetService;

@RestController
@RequestMapping(value = "/bets")
public class BetResource {

	@Autowired
	private BetService betService;

	@PostMapping("/create")
	public ResponseEntity<List<Integer>> createBet(@Valid @RequestBody PersonDTO obj) {

		List<Integer> listNumbersSorty = betService.validCreateBet(obj.getEmail());
		return ResponseEntity.ok(listNumbersSorty);
	}

}
