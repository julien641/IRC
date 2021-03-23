package com.IRC.IRC_Main_server.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IRC.IRC_Main_server.models.ERole;
import com.IRC.IRC_Main_server.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
