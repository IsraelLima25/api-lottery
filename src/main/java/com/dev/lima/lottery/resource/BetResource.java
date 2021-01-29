package com.dev.lima.lottery.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev.lima.lottery.dto.BetDTO;
import com.dev.lima.lottery.dto.PersonDTO;
import com.dev.lima.lottery.service.BetService;

@RestController
@RequestMapping(value = "/bets")
public class BetResource {

	@Autowired
	private BetService betService;

	@PostMapping
	public ResponseEntity<List<Integer>> create(@Valid @RequestBody PersonDTO obj) {

		BetDTO betCreated = betService.builderBet(obj.getEmail());
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(betCreated.getId()).toUri();
		
		return ResponseEntity.created(uri).body(betCreated.getNumbers());
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity<BetDTO> findById(@PathVariable("id") Integer id){
		
		BetDTO betFind = betService.findById(id);
		return ResponseEntity.ok(betFind); 
	}
}
