package com.IRC.IRC_Main_server.Controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IRC.IRC_Main_server.Repository.RoleRepository;
import com.IRC.IRC_Main_server.Repository.UserRepository;
import com.IRC.IRC_Main_server.models.ERole;
import com.IRC.IRC_Main_server.models.Role;
import com.IRC.IRC_Main_server.models.User;
import com.IRC.IRC_Main_server.payload.request.LoginRequest;
import com.IRC.IRC_Main_server.payload.request.RefreshTokenRequest;
import com.IRC.IRC_Main_server.payload.request.SignupRequest;
import com.IRC.IRC_Main_server.payload.response.JwtResponse;
import com.IRC.IRC_Main_server.payload.response.MessageResponse;
import com.IRC.IRC_Main_server.payload.response.SessionToken;
import com.IRC.IRC_Main_server.security.jwt.JwtUtils;

import com.IRC.IRC_Main_server.security.services.UserDetailsImpl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SignupController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@RequestBody RefreshTokenRequest refreshToken) {
	
		String username = jwtUtils.getUserNameFromRefreshJwtToken(refreshToken.getRefreshtoken());
		Optional<User> opuser=userRepository.findByUsername(username);
		

		SessionToken refresh = jwtUtils.generateJwtToken(username);
		User user = opuser.get();
		return ResponseEntity.ok(
				new RefreshResponse(refresh));
		
	// sessionToken();
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return sessionToken(authentication);
	}

	

	

	public ResponseEntity<?> sessionToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		SessionToken jwt = jwtUtils.generateJwtToken(userPrincipal.getUsername());
		SessionToken refreshjwtString = jwtUtils.generateRefreshJwtToken(userPrincipal.getUsername());
		// todo create a session variable
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(
				new JwtResponse( userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles,jwt,refreshjwtString));

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}
		// Create new user's account
		User user = new User(signUpRequest.getUsername(), passwordEncoder.encode(signUpRequest.getPassword()),
				signUpRequest.getEmail());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ROLE_ADMIN":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "ROLE_MODERATOR":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}

}
class RefreshResponse{

	private SessionToken token;
	public RefreshResponse( SessionToken token) {
		super();
		this.token = token;
	}
	public RefreshResponse() {
		super();
	}

	
	public SessionToken getToken() {
		return token;
	}
	public void setToken(SessionToken token) {
		this.token = token;
	}
	
	
}
