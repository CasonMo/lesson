package com.mo.domain;

import java.util.List;

public class Student {
	private String stu_id;
	private String name;
	private String password;
	private String sex;
	private String class_id;
	private Class_ aClass;
	private List<Lesson> lessons;


	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public Class_ getaClass() {
		return aClass;
	}

	public void setaClass(Class_ aClass) {
		this.aClass = aClass;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public String toString() {
		return "Student{" +
				"stu_id='" + stu_id + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", class_id='" + class_id + '\'' +
				", aClass=" + aClass +
				", lessons=" + lessons +
				'}';
	}
}
