package com.iaeste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class JwtUser {
	
	@Id
	@GeneratedValue
    private long id;
	
	@Column(name="username",length=50,nullable=false)
    private String userName;
	
	@Column(name="password",length=800,nullable=false)
	private String password;
	

	@Column(name="email",length=50,nullable=false)
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="role",length=50,nullable=false)
    private String role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtUser [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", role=" + role + "]";
	}

	
    
    
}