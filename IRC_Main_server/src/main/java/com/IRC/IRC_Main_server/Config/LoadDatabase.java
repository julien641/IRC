package com.IRC.IRC_Main_server.Config;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.IRC.IRC_Main_server.Repository.RoleRepository;
import com.IRC.IRC_Main_server.Repository.UserRepository;
import com.IRC.IRC_Main_server.models.ERole;
import com.IRC.IRC_Main_server.models.Role;
import com.IRC.IRC_Main_server.models.User;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	 @Bean
	CommandLineRunner initDatabase(UserRepository repository,
			 PasswordEncoder passwordEncoder,RoleRepository roleRepository) {

	    return args -> {
	    	log.info("Preloading "+roleRepository.save(new Role(ERole.ROLE_USER)));
	    	log.info("Preloading "+roleRepository.save(new Role(ERole.ROLE_ADMIN)));
	    	log.info("Preloading "+roleRepository.save(new Role(ERole.ROLE_MODERATOR)));
	    	roleRepository.flush();
	    	User user = new User("root",passwordEncoder.encode("1234"),"julien641@yahoo.com");
	    	Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	    	
	    	Set<Role> set =new HashSet<>();
	    	set.add(adminRole);
	    	user.setRoles(set);
	      log.info("Preloading " + repository.save(user));
	      
	    };
	  }
	 
	
	 
	 

}
