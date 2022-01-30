package com.myhospital.intangibleObject;

import com.myhospital.personObject.Patient;

public class Appointment {

     private int appointmentID;
     private Patient patient;
     private Date date;
     private boolean completed;

    public Appointment(int appointmentID, Patient patient, Date date, boolean completed) {
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.date = date;
        this.completed = completed;
    }

    @Override
    public boolean equals(Object appointment) {
        return this.patient == ((Appointment)appointment).patient &&
                this.date == ((Appointment)appointment).date;
    }

    public String getStatus() {
        return (completed) ? "Completed" : "Pending";
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID=" + appointmentID +
                ", patient=" + patient +
                ", date=" + date +
                ", completed=" + completed +
                '}';
    }
}