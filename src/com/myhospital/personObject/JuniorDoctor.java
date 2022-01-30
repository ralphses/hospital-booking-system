package com.myhospital.personObject;

import com.myhospital.intangibleObject.Name;

import java.util.Random;

public class JuniorDoctor extends Doctor {

    private String teamAssigned;

    public JuniorDoctor(Name doctorName, String department, String teamAssigned) {
        super(doctorName, department);
        this.teamAssigned = teamAssigned;
    }

    public String getTeamAssigned() {
        return teamAssigned;
    }

    public void setTeamAssigned(String teamAssigned) {
        this.teamAssigned = teamAssigned;
    }

    @Override
    public String generateDoctorID() {
        return "J" + new Random().nextInt(10) +
                new Random().nextInt(10) + new Random().nextInt(10)
                + new Random().nextInt(10);
    }

    @Override
    public String toString() {
        return super.toString() +
                "teamAssigned='" + teamAssigned + '\'' +
                '}';
    }

    @Override
    public int compareTo(Name name) {
        return (name.toString().compareTo(this.getDoctorName().toString()) > 0) ? 1 : -1;
    }
}
