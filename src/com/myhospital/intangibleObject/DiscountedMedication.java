package com.myhospital.intangibleObject;

public class DiscountedMedication extends Medication {

    private double discount;

    public DiscountedMedication(String medicationName, int medicationID, double fixedPrice, double discount) {
        super(medicationName, medicationID, fixedPrice);
        this.discount = discount;

        setFixedPrice(applyDiscount(fixedPrice));
    }

    @Override
    public void addVariousPrice(String patientType, double price) {
        getMedicationPriceList().putIfAbsent(patientType, applyDiscount(price));
    }

    private double applyDiscount(double price) {
        return  price - (discount * price);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
