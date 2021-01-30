package com.dev.lima.lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dev.lima.lottery.model.Profile;
import com.dev.lima.lottery.model.UserAPI;
import com.dev.lima.lottery.repository.UsuarioRepository;

@SpringBootApplication
public class ApiLotteryApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ApiLotteryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Integer sizerUsers = userRepository.findAll().size();

		if (sizerUsers == 0) {

			UserAPI user = new UserAPI();
			user.setEmail("ilima@gmail.com");
			user.setPassword(bCryptPasswordEncoder.encode("123"));

			Profile profile = new Profile();
			profile.setDescription("ROLE_ADM");

			user.getProfiles().add(profile);

			userRepository.save(user);
		}

	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
