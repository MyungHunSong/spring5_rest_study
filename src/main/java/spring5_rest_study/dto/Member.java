package spring5_rest_study.dto;

import java.time.LocalDateTime;

import spring5_rest_study.exception.WrongIdPasswordException;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	public Member() {}

	public void changePassword(String oldPassword,String newPassword) {
		if(!password.equals(oldPassword)) {
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}
	
		public Member(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

		public boolean matchPassword(String password) {
			System.out.println(this.password);
			return this.password.equals(password);
		}
	
	public Member( String email,   String name, String password, LocalDateTime registerDateTime) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.registerDateTime = registerDateTime;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}


	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

	@Override
	public String toString() {
		return String.format("Member [id=%s, email=%s,  name=%s, password=%s, registerDateTime=%s]", id, email, 
				name, password, registerDateTime);
	}

}
