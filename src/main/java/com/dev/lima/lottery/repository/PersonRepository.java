package com.dev.lima.lottery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.lima.lottery.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	public Optional<Person> findOptionalByEmail(String email);

}
