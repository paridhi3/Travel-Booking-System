package com.travelbookingsystem.travel.model;

public class Admin {
    private long adminId;
    private String fullName;
    private String email;
    private String password;
    
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(long adminId, String fullName, String email, String password) {
		super();
		this.adminId = adminId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public Admin(String fullName, String email, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ "]";
	}
    
    
}
