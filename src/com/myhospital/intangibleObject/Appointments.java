package com.myhospital.intangibleObject;

import com.myhospital.personObject.Patient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Appointments implements Comparator<Appointment>, Iterable<Appointment> {

    private final List<Appointment> appointments = new ArrayList<>();

    public boolean addAppointment(Appointment appointment) {
        return appointments.add(appointment);
    }

    public Appointment getAppointmentByID(int appointmentID) {
        for(Appointment appointment : appointments) {
            if(appointment.getAppointmentID() == appointmentID) {
                return appointment;
            }
        }
        return null;
    }

    public List<Appointment> getAppointmentByPatient(Patient patient) {
       return appointments.stream()
               .filter(a -> (a.getPatient().equals(patient)))
               .collect(Collectors.toList());
    }

    public List<Appointment> getCompletedAppointment() {
        return appointments.stream()
                .filter(a -> (a.isCompleted()))
                .collect(Collectors.toList());
    }

    public List<Appointment> getPendingAppointment() {
        return appointments.stream()
                .filter(a -> (!(a.isCompleted())))
                .collect(Collectors.toList());
    }

    public List<Appointment> sortAppointmentsByID() {
        return appointments.stream().sorted( (o1, o2) -> {
                return (o1.getAppointmentID() > o2.getAppointmentID()) ? 1 : -1; }).collect(Collectors.toList());
    }

    public List<Appointment> sortAppointmentByPatientFirstName() {
        return appointments.stream().sorted(this).collect(Collectors.toList());
    }

    @Override
    public int compare(Appointment appointment1, Appointment appointment2) {
        return (appointment1.getPatient().getName().getFirstName()
                .compareTo(appointment1.getPatient().getName().getFirstName()) > 0) ? 1 : -1;
    }

    @Override
    public Iterator<Appointment> iterator() {
        return new Iterator<Appointment>() {
            int cursor;
            int lastRet = -1;

            @Override
            public boolean hasNext() {
                return lastRet != appointments.size() -1;
            }

            @Override
            public Appointment next() {
                lastRet++;
                if(lastRet < appointments.size())
                    cursor = lastRet;
                return appointments.get(cursor);
            }

        };
    }
}
