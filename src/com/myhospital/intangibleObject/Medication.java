package com.myhospital.intangibleObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Medication implements Comparable<Medication>{

    private String medicationName;
    private int medicationID;
    private double fixedPrice;

    private Map<String, Double> medicationPriceList;

    public Medication(String medicationName, int medicationID, double fixedPrice) {
        this.medicationName = medicationName;
        this.medicationID = medicationID;
        this.fixedPrice = fixedPrice;

        this.medicationPriceList = new HashMap<>();
    }

    @Override
    public boolean equals(Object medication) {
        return Double.compare (((Medication)medication).fixedPrice, this.fixedPrice) ==0;
    }

    public void addVariousPrice(String patientType, double price) {
        medicationPriceList.putIfAbsent(patientType, price);
    }

    public double getPatientPrice(String patientType) {

        for(Map.Entry<String, Double> entry : medicationPriceList.entrySet()) {
            if(entry.getKey() == patientType) {
                return new BigDecimal(entry.getValue()).setScale(2, RoundingMode.CEILING).doubleValue();
            }
        }
        return 0.0;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public Map<String, Double> getMedicationPriceList() {
        return medicationPriceList;
    }

    public int getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(int medicationID) {
        this.medicationID = medicationID;
    }

    public double getFixedPrice() {
        return new BigDecimal(fixedPrice).setScale(2, RoundingMode.CEILING).doubleValue();
    }

    public void setFixedPrice(double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationName='" + medicationName + '\'' +
                ", medicationID=" + medicationID +
                ", fixedPrice=" + fixedPrice +
                ", medicationPriceList=" + medicationPriceList +
                '}';
    }

    @Override
    public int compareTo(Medication name) {
        return (name.getMedicationName().compareTo(this.getMedicationName()) > 0) ? 1 : -1;
    }
}
