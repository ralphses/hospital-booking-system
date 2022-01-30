package com.myhospital.personObject;

import com.myhospital.intangibleObject.Name;

import java.util.Random;

public class ConsultantDoctor extends Doctor {

    private boolean teamLeader;

    public ConsultantDoctor(Name doctorName, String department, boolean teamLeader) {
        super(doctorName, department);
        this.teamLeader = teamLeader;

        setDoctorID(generateDoctorID());
    }

    public boolean isTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(boolean teamLeader) {
        this.teamLeader = teamLeader;
    }

    @Override
    public String generateDoctorID() {
        return "C" + new Random().nextInt(10) +
                new Random().nextInt(10) + new Random().nextInt(10)
                + new Random().nextInt(10);
    }

    @Override
    public String toString() {
        return super.toString() +
                "teamLeader=" + teamLeader +
                '}';
    }

    @Override
    public int compareTo(Name name) {
        return (name.toString().compareTo(this.getDoctorName().toString()) > 0) ? 1 : -1;
    }
}
