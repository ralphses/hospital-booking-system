package com.myhospital.utility;

import com.myhospital.intangibleObject.Appointment;

import java.util.Comparator;

public class AppointmentComparatorImpl implements Comparator<Appointment> {
    @Override
    public int compare(Appointment appointment1, Appointment appointment2) {
        return (appointment1.getPatient().getName().getFirstName()
                .compareTo(appointment1.getPatient().getName().getFirstName()) > 0) ? 1 : -1;
    }

}
