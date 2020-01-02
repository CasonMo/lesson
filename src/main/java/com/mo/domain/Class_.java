package com.mo.domain;

public class Class_ {
	private String class_id;
	private String department;
	private String name;
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Class [class_id=" + class_id + ", department=" + department + ", name=" + name + "]";
	}
	

}
