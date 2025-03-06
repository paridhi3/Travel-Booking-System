package com.travelbookingsystem.travel.model;

public class Passenger {
	private long passengerId;
    private String full_name;
    private String email;
    private String password;
    private String gender;
    private int age;
    private String contact;
    
    public Passenger(String full_name, String email, String password, String gender, int age, String contact) {
		super();
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.contact = contact;
	}
    
    public Passenger(long passengerId, String full_name, String email, String password, String gender, int age,
			String contact) {
		super();
		this.passengerId = passengerId;
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.contact = contact;
	}



	public Passenger() {
		super();
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", full_name=" + full_name + ", email=" + email + ", password="
				+ password + ", gender=" + gender + ", age=" + age + ", contact=" + contact + "]";
	}
    
    
}





