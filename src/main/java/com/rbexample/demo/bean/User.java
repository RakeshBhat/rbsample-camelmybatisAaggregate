package com.rbexample.demo.bean;

public class User {

	String fname;
	String lname;
	int age;
	String title;
	String country;
	String city;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	@Override
	public String toString() {
		return String.format("User [fname=%s, lname=%s, age=%s, jobTitle=%s, country=%s, city=%s]", fname,
				lname, age, title, country, city);
	}
	
	
	
	
	
}
