package com.dev.lima.lottery.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.lima.lottery.service.BetService;

@RestController
@RequestMapping(value = "/bets")
public class BetResource {

	@Autowired
	private BetService betService;

	@GetMapping("/api/create/bet")
	public ResponseEntity<List<Integer>> createBet(@RequestParam String email) {

		List<Integer> listNumbersSorty = betService.validCreateBet(email);
		return ResponseEntity.ok(listNumbersSorty);
	}

}
