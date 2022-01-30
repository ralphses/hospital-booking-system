package com.myhospital.utility;

import com.myhospital.intangibleObject.Medication;
import com.myhospital.intangibleObject.Prescription;

public class Utility {

    public static String prepareReciept(Prescription prescription) {
        StringBuilder builder = new StringBuilder();
        String content = "******************************************\n" +
                "   PERFECT CARE CLINIC AND MATERNITY\n" +
                "******************************************\n" +
                "\tPrescription Details\n" +
                "Name of Patient: - - - " + prescription.getAppointment().getPatient().getName() +"\n" +
                "Date of Appointment: - " + prescription.getAppointment().getDate() + "\n" +
                "Appointment Status: -  " + prescription.getAppointment().getStatus() + "\n" +
                "Doctor in charge: - -  " + prescription.getDoctor().getDoctorName() + "\n" +
                "------------------------------------------\n" +
                "\tList of Medications\n";
        builder.append(content);
        builder.append(getPrescriptionContents(prescription));
        builder.append("\n\n******************************************\n");

        return builder.toString();

    }

    public static void displayPrescriptionContents(Prescription prescription) {
        System.out.println("\nMedications in Prescription - " + prescription.getPrescriptionID());
        for(Medication medication : prescription.getMedicationList()) {
            System.out.printf("%s\t - - - - -\t£%.2f\n", medication.getMedicationName(), medication.getFixedPrice());
        }
        printPresSummary(prescription);
    }
    public static String getPrescriptionContents(Prescription prescription) {
        StringBuilder builder = new StringBuilder();
        for(Medication medication : prescription.getMedicationList()) {
            builder.append(String.format("%s\t - - - - -\t£%.2f\n", medication.getMedicationName(), medication.getFixedPrice()));
        }
        builder.append("\n------------------------------------------\n");
        builder.append(getPresSummary(prescription));

        return builder.toString();
    }

    public static void printPresSummary(Prescription prescription) {
        System.out.println("TOTAL ITEMS: " + prescription.getMedicationList().size());
        System.out.printf("TOTAL COST: %.2f", prescription.getCost());
    }

    public static String getPresSummary(Prescription prescription) {
        return "TOTAL ITEMS: " + prescription.getMedicationList().size() + "\n" +
                String.format("TOTAL COST: %.2f", prescription.getCost());
    }
}
