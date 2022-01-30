package com.myhospital.intangibleObject;

import com.myhospital.personObject.Doctor;

import java.util.*;
import java.util.stream.Collectors;

public class Prescription implements Iterable<Medication>{

    private int prescriptionID;
    private List<Medication> medicationList;
    private Appointment appointment;
    private Doctor doctor;

    public Prescription(int prescriptionID, Appointment appointment, Doctor doctor) {
        this.prescriptionID = prescriptionID;
        this.appointment = appointment;
        this.doctor = doctor;

        this.medicationList = new ArrayList<>();
    }

    public boolean addMedication(Medication medication) {
        return medicationList.add(medication);
    }

    public Medication retrieveMedication(int medicationID) {
        for(Medication medication : medicationList) {
            if(medication.getMedicationID() == medicationID) {
                return medication;
            }
        }
        return null;
    }

    public double getCost() {
        double cost = 0.0;
        for (Medication medication : medicationList) {
            cost += medication.getFixedPrice();
        }
        return cost;
    }

    public boolean checkForMedication(int medicationID) {
        for(Medication medication : medicationList) {
            return medication.getMedicationID() == medicationID;
        }
        return false;
    }

    public void sortMedication() {
        medicationList = medicationList.stream().sorted().collect(Collectors.toList());
    }
    public void sortMedication(Comparator<Medication> sorter) {
        Collections.sort(medicationList, sorter);
    }

    public boolean containsMedication(Medication medication) {
        return medicationList.indexOf(medication) >= 0;
    }

    public boolean removeMedication(Medication medication) {
        return medicationList.remove(medication);
    }

    @Override
    public Iterator<Medication> iterator() {
        return new Iterator<Medication>() {
            int cursor;
            int lastRet = -1;

            @Override
            public boolean hasNext() {
                return lastRet != medicationList.size() -1;
            }

            @Override
            public Medication next() {
                lastRet++;
                if(lastRet < medicationList.size())
                    cursor = lastRet;
                return medicationList.get(cursor);
            }
        };
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
