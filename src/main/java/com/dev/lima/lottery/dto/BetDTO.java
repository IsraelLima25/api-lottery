package com.dev.lima.lottery.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dev.lima.lottery.model.Person;

public class BetDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDate date;

	private List<Integer> numbers = new ArrayList<>();

	private Person person;

	public BetDTO() {
	}

	public BetDTO(Integer id, LocalDate date, List<Integer> numbers, Person person) {
		super();
		this.id = id;
		this.date = date;
		this.numbers = numbers;
		this.person = person;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
