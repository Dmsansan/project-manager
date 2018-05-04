package com.sansan.dao;


public class User {
	private Integer userID;
	private String userName;
	private String passWord;
	private String name;
	private Integer sex;
	private Integer age;
	private String phone;
	private String address;
	private Integer positionID;
	private String logStamp;
	//属性集合
	private Position position;
	
	public User(){
		
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPositionID() {
		return positionID;
	}

	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}

	public String getLogStamp() {
		return logStamp;
	}

	public void setLogStamp(String logStamp) {
		this.logStamp = logStamp;
	}

	

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", passWord=" + passWord + ", name=" + name
				+ ", sex=" + sex + ", age=" + age + ", phone=" + phone + ", address=" + address + ", positionID="
				+ positionID + ", logStamp=" + logStamp + ", position=" + position + "]";
	}
}
