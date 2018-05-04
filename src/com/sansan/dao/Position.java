package com.sansan.dao;


public class Position {
	private Integer positionID;
	private String name;
	private Integer numbers;
	
	
	public Integer getPositionID() {
		return positionID;
	}
	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumbers() {
		return numbers;
	}
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
	
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Position [positionID=" + positionID + ", name=" + name + ", numbers=" + numbers + "]";
	}
	
	
	
	
}
