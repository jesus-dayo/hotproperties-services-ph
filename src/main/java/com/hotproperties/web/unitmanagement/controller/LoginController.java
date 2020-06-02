package com.hotproperties.web.unitmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotproperties.web.entity.ApplicationUser;
import com.hotproperties.web.security.ApplicationUserRepository;
import com.hotproperties.web.vo.request.Credentials;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class LoginController {

	private ApplicationUserRepository applicationUserRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public LoginController(ApplicationUserRepository applicationUserRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.applicationUserRepository = applicationUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Credentials> user(@RequestBody Credentials credential) {
		try {
			return new ResponseEntity<Credentials>(credential, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// EmailServiceImpl emailService = new EmailServiceImpl();
			// emailService.sendErrorEmail(e.getMessage());
			return new ResponseEntity<Credentials>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		applicationUserRepository.save(user);
	}

}
