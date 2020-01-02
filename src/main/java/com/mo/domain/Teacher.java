package com.mo.domain;

import java.util.List;

public class Teacher {
	private String teach_id;
	private String name;
	private String password;
	private String sex;
	private List<Lesson> lessons;
	public String getTeach_id() {
		return teach_id;
	}
	public void setTeach_id(String teach_id) {
		this.teach_id = teach_id;
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

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"teach_id='" + teach_id + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", lessons=" + lessons +
				'}';
	}
}
