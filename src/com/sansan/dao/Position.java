package com.sansan.dao;

public class Position {
    private Integer positionID;

    private String name;

    private Integer numbers;

    public Integer getPositionid() {
        return positionID;
    }

    public void setPositionid(Integer positionID) {
        this.positionID = positionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}