package com.IRC.IRC_Main_server.payload.request;

import java.util.Set;

public class SignupRequest {
	
	
	   private Set<String> role;
		private String username;
		private String email;
		private String password;
		
		public SignupRequest() {
			super();
		}
		
		public SignupRequest(String username, String email, String password) {
			super();
			this.username = username;
			this.email = email;
			this.password = password;
		}
		
		@Override
		public String toString() {
			return "SignupRequest [role=" + role + ", username=" + username + ", email=" + email + ", password="
					+ password + "]";
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((role == null) ? 0 : role.hashCode());
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
			SignupRequest other = (SignupRequest) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (role == null) {
				if (other.role != null)
					return false;
			} else if (!role.equals(other.role))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}
		public Set<String> getRole() {
			return role;
		}
		public void setRole(Set<String> role) {
			this.role = role;
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		
		
}
