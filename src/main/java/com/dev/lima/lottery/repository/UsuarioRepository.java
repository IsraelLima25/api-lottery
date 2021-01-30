package com.dev.lima.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.lima.lottery.model.UserAPI;

@Repository
public interface UsuarioRepository extends JpaRepository<UserAPI, Integer> {
	
	public UserAPI findByEmail(String email);
}
