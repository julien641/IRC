package com.IRC.IRC_Main_server.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roles_ID", unique = true, nullable = false)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
	
	public Role() {
		super();
	}
	public Role(ERole role) {
		this.name= role;
		
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (name != other.name)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}


}
