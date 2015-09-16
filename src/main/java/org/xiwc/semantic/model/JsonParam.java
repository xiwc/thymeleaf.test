package org.xiwc.semantic.model;

import java.util.List;

public class JsonParam {

	private String name;
	private int age;
	private List<String> likes;
	private Sub sub;
	private List<Sub> subs;

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

	public List<String> getLikes() {
		return likes;
	}

	public void setLikes(List<String> likes) {
		this.likes = likes;
	}

	public Sub getSub() {
		return sub;
	}

	public void setSub(Sub sub) {
		this.sub = sub;
	}

	public List<Sub> getSubs() {
		return subs;
	}

	public void setSubs(List<Sub> subs) {
		this.subs = subs;
	}

}

class Sub {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
