package com.IRC.IRC_Main_server.payload.response;

import java.util.List;

public class JwtResponse {
	
	private Long id;
	private String username;
	private String email;
	private List<String> roles;
	private SessionToken session;
	private SessionToken refresh;
	public JwtResponse() {
		super();
	}
	public JwtResponse(Long id, String username, String email, List<String> roles, SessionToken session,
			SessionToken refresh) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.session = session;
		this.refresh = refresh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((refresh == null) ? 0 : refresh.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JwtResponse other = (JwtResponse) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (refresh == null) {
			if (other.refresh != null)
				return false;
		} else if (!refresh.equals(other.refresh))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JwtResponse [id=" + id + ", username=" + username + ", email=" + email + ", roles=" + roles
				+ ", session=" + session + ", refresh=" + refresh + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public SessionToken getSession() {
		return session;
	}
	public void setSession(SessionToken session) {
		this.session = session;
	}
	public SessionToken getRefresh() {
		return refresh;
	}
	public void setRefresh(SessionToken refresh) {
		this.refresh = refresh;
	}
	
	
	

	
	
	
}
