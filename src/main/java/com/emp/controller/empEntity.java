package com.emp.controller;

import java.io.Serializable;

public class empEntity implements Serializable 
{
	private int id;
	private String name;
	private int age;
	private double salary;
	private String work;
	
	public empEntity()
	{
		
	}
	public empEntity(int id, String name, int age, double salary, String work) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.work = work;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	@Override
	public String toString() {
		return "empEntity [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", work=" + work
				+ "]";
	}
}
