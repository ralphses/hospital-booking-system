package com.myhospital.utility;

import com.myhospital.intangibleObject.Appointment;
import com.myhospital.intangibleObject.Medication;
import com.myhospital.intangibleObject.Prescription;
import com.myhospital.personObject.Patient;

import java.util.HashSet;
import java.util.List;

public class RewardProccessor {

    private HashSet<Medication> medications = new HashSet<>();

    public boolean addMedication(Medication medication) {
        return medications.add(medication);
    }

    public int rewardPoints(Prescription prescription) {
        int totalPoints = 0;
        Appointment appointment = prescription.getAppointment();
        Patient patient = appointment.getPatient();
        List<Medication> med = prescription.getMedicationList();
        for(Medication m : medications) {
            if(med.contains(m)) {
                if(patient.getAge() < 18 || patient.getAge() > 65) {
                    appointment.getPatient().addRewardPoints(1);
                    totalPoints += 1;
                }
            }
        }

        return totalPoints;
    }
}
