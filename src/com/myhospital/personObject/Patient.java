package com.myhospital.personObject;

import com.myhospital.intangibleObject.Name;

public class Patient {

    private Name name;
    private String uniqueID;
    private int age;
    private int rewardPoints;

    public Patient(Name name, String uniqueID, int age) {
        this.name = name;
        this.uniqueID = uniqueID;
        this.age = age;
        this.rewardPoints = 0;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void addRewardPoints(int rewardPoints) {
        this.rewardPoints += rewardPoints;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object patient) {
        return this.uniqueID == ((Patient)patient).getUniqueID();
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name=" + name +
                ", uniqueID='" + uniqueID + '\'' +
                ", age=" + age +
                '}';
    }
}
