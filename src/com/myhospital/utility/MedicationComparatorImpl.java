package com.myhospital.utility;

import com.myhospital.intangibleObject.Medication;

import java.util.Comparator;

public class MedicationComparatorImpl implements Comparator<Medication> {
    @Override
    public int compare(Medication medication1, Medication medication2) {
        if(medication1.getFixedPrice() > medication2.getFixedPrice()) {
            return 1;
        }
        else if (medication1.getFixedPrice() == medication2.getFixedPrice()) {
            if(medication1.getMedicationName().compareTo(medication2.getMedicationName()) < 0)
                return 1;
            else return -1;
        }
        else return -1;
    }
}
