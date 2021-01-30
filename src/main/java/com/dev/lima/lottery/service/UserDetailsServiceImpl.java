package com.dev.lima.lottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.lima.lottery.model.UserAPI;
import com.dev.lima.lottery.repository.UsuarioRepository;
import com.dev.lima.lottery.security.UserSS;

@Service	
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserAPI usuario = usuarioRepository.findByEmail(email);

		if (usuario == null) {
			throw new UsernameNotFoundException("Email ou senha imválidos" + email);
		}

		return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getPassword(), usuario.getProfiles());

	}

}
