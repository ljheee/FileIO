package com.ljheee.io.entity;

import java.io.Serializable;

public class Person implements Serializable {
	
	//序列化版本ID--属于这个序列化类；相当于类的指纹，类改变了，它也会改变。
	private static final long serialVersionUID = -2835832101204598610L;
	
	
	private String name;
	private int age;
	
	//瞬时的==持久化时，不保存
	private transient String phone;
	private boolean isSingle;
	private Address address;
	
	public Person(String name, int age, String phone, boolean isSingle) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.isSingle = isSingle;
	}
	
	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.age = 18;
		this.isSingle = true;
	}
	
	public Person() {
		this.age = 18;
		this.isSingle = true;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isSingle() {
		return isSingle;
	}
	public void setSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", phone=" + phone + ", isSingle=" + isSingle + ", address="
				+ address+"]";
	}
	
	
	
	
	

}
