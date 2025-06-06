package com.example.demo.java8;

public class Emp {
	
	int id; 
	String name;
	int sal; 
	String dept;
	
	public Emp(int id, String name, int sal, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp[id=" + id + ",name=" + name + ",sal=" + sal + ",dept=" + dept + "]";
	} 
	
	
	
	
}
