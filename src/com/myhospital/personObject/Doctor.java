package com.myhospital.personObject;

import com.myhospital.intangibleObject.Name;

public abstract class Doctor implements Comparable<Name>{

    private String doctorID;
    private Name doctorName;
    private String department;

    public abstract String generateDoctorID();

    public Doctor(Name doctorName, String department) {
        this.doctorName = doctorName;
        this.department = department;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public Name getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(Name doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID='" + doctorID + '\'' +
                ", doctorName=" + doctorName +
                ", department='" + department + '\'';
    }
}
