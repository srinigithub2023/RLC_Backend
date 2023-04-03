package au.com.rlc.spring.boot.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import au.com.rlc.spring.boot.models.ERole;
import au.com.rlc.spring.boot.models.Role;
import au.com.rlc.spring.boot.models.User;
import au.com.rlc.spring.boot.payload.request.LoginRequest;
import au.com.rlc.spring.boot.payload.request.SignupRequest;
import au.com.rlc.spring.boot.payload.response.JwtResponse;
import au.com.rlc.spring.boot.payload.response.MessageResponse;
import au.com.rlc.spring.boot.repository.RoleRepository;
import au.com.rlc.spring.boot.repository.UserRepository;
import au.com.rlc.spring.boot.security.jwt.JwtUtils;
import au.com.rlc.spring.boot.security.services.UserDetailsImpl;
import au.com.rlc.spring.boot.util.Util;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
	
	 private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	  
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		logger.info(" Authenticate  User");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		logger.info(" Authenticate  Success with roles : ", roles.toString());
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/create")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) throws JsonProcessingException {
		
		logger.info("Register User ");
		
		
		
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}
		Set<Role> roles = new HashSet<>();
		if(!signUpRequest.getRole().isBlank()) {
			Set<String> roleSet = new HashSet<String>(Arrays.asList(signUpRequest.getRole()));
			signUpRequest.setRoleSet(roleSet);
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));
			
		Set<String> strRoles = signUpRequest.getRoleSet();
		
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				
				switch (role) {
				case "admin":
					
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					logger.info("Return admin User :: ", roles.toString());
					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					logger.info("Return mod User :: ", roles.toString());	
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
					logger.info("Return normal User :: ", roles.toString());
				}
			});
		}
		
		user.setRoles(roles);
		
		userRepository.save(user);
		logger.info(" User Created Successfully", user.toString());	
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
}
