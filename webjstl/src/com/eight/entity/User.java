package com.eight.entity;

public class User {

	private String userName;
	private String password;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String[] habits;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getHabits() {
		return habits;
	}
	public void setHabits(String[] habits) {
		this.habits = habits;
	}
}
