package com.blogboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String surname;
	private String firstname;
	private String lastname;
	private String birthdate;
	private String email;
	private String mobilenumber;
	private String password;
	private String registrationdate;
	private String time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistrationdate() {
		return registrationdate;
	}
	public void setRegistrationdate(String registrationdate) {
		this.registrationdate = registrationdate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public User(int id, String surname, String firstname, String lastname, String birthdate, String email,
			String mobilenumber, String password, String registrationdate, String time) {
		super();
		this.id = id;
		this.surname = surname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.password = password;
		this.registrationdate = registrationdate;
		this.time = time;
	}

	public User() {

	}
	@Override
	public String toString() {
		return "User [id=" + id + ", surname=" + surname + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", birthdate=" + birthdate + ", email=" + email + ", mobilenumber=" + mobilenumber + ", password="
				+ password + ", registrationdate=" + registrationdate + ", time=" + time + "]";
	}
	public User get() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
