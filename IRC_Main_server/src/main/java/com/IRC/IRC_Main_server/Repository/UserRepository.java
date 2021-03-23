package com.IRC.IRC_Main_server.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.IRC.IRC_Main_server.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("Select c.password from User c WHERE c.username = :u")
	String isValid( @Param("u") String name);
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
