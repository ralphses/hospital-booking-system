package com.myhospital;

import com.myhospital.intangibleObject.*;
import com.myhospital.personObject.ConsultantDoctor;
import com.myhospital.personObject.Doctor;
import com.myhospital.personObject.JuniorDoctor;
import com.myhospital.personObject.Patient;
import com.myhospital.utility.MedicationComparatorImpl;
import com.myhospital.utility.RewardProccessor;
import com.myhospital.utility.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

public class PrescriptionTest {

    public static void main(String[] args) {

        Patient patient1 = new Patient(new Name("Raphael", "Eze"), "PAT1001", 16);
        Patient patient2 = new Patient(new Name("Christopher", "Eze"), "PAT1002", 23);
        Patient patient3 = new Patient(new Name("Michael", "Ezeagu"), "PAT1003", 37);

        Doctor doctor1 = new ConsultantDoctor(new Name("Felix", "Heenga"),"Radiography", true);
        Doctor doctor2 = new JuniorDoctor(new Name("Adaobi", "Aduaka"),"Consultancy", "Casualty");

        Appointment appointment = new Appointment(123, patient1, new Date(23,3,2001), true);
        Appointment appointment1 = new Appointment(342, patient2, new Date(2,5,2001), true);
        Appointment appointment2 = new Appointment(112, patient3, new Date(4,3,2001), false);

        Medication medication = new Medication("Paracetamol", 223, 156.9);
        Medication medication1 = new Medication("Panadol", 221, 256.9);
        Medication medication2 = new Medication("Corterm", 222, 356.9);
        Medication medication3 = new Medication("KuffRelief", 224, 556.9);
        Medication medication4 = new Medication("Boska", 225, 456.9);
        Medication medication5 = new Medication("Paracetamol1", 226, 656.9);
        Medication medication6 = new Medication("New Paracetamol", 227, 756.9);
        Medication medication7 = new Medication("Tramol", 228, 856.9);
        Medication medication8 = new Medication("Tramadolv", 229, 56.9);
        Medication medication9 = new Medication("Tramadola", 229, 56.9);

        DiscountedMedication discountedMedication = new DiscountedMedication("Paracetamol", 230, 456.9, 0.1);
        DiscountedMedication discountedMedication1 = new DiscountedMedication("Septrim", 231, 46.9, 0.2);
        DiscountedMedication discountedMedication2 = new DiscountedMedication("Cough Relief", 233, 656.9, 0.2);
        DiscountedMedication discountedMedication3 = new DiscountedMedication("Cold Time", 234, 4.9, 0.3);
        DiscountedMedication discountedMedication4 = new DiscountedMedication("Phlagin", 235, 454.9, 0.9);
        DiscountedMedication discountedMedication5 = new DiscountedMedication("Ciprofloxacin", 245, 6.9, 0.6);
        DiscountedMedication discountedMedication6 = new DiscountedMedication("NGC", 232, 45.9, 0.6);


        /**
            USE CASE 1: Initializes 2 Prescription Objects
            Populates them with both Medications and Discounted Medications
         */

        Prescription prescription1 = new Prescription(12,appointment, doctor1);
        Prescription prescription2 = new Prescription(123,appointment2, doctor2);

        prescription1.addMedication(medication);
        prescription1.addMedication(medication1);
        prescription1.addMedication(medication3);
        prescription1.addMedication(medication2);
        prescription1.addMedication(medication8);
        prescription1.addMedication(discountedMedication2);
        prescription1.addMedication(discountedMedication5);
        prescription1.addMedication(discountedMedication3);
        prescription1.addMedication(discountedMedication4);

        prescription2.addMedication(medication5);
        prescription2.addMedication(medication4);
        prescription2.addMedication(medication6);
        prescription2.addMedication(medication7);
        prescription2.addMedication(medication8);
        prescription2.addMedication(medication9);
        prescription2.addMedication(discountedMedication);
        prescription2.addMedication(discountedMedication1);
        prescription2.addMedication(discountedMedication6);

        /**
         * Using a for-each loop to print a formatted list of medications
         * in the prescription objects
         */
        //This static method is called to handle the formatted display
        Utility.displayPrescriptionContents(prescription1);
        Utility.displayPrescriptionContents(prescription2);

        /**
         USE CASE 2: Tests the sorting methods of the Prescription class
         */

        //Sorting in natural Order
        prescription2.sortMedication();

        //Using a lambda expression to pass Comparator
        prescription1.sortMedication((med1, med2) -> {
                if(med1.getFixedPrice() > med2.getFixedPrice()) {
                    return 1;
                }
                else if (med1.getFixedPrice() == med2.getFixedPrice()) {
                    if(med1.getMedicationName().compareTo(med2.getMedicationName()) < 0)
                        return 1;
                    else return -1;
                }
                else return -1;
            });

        //Using a custom defined class that implements the Comparator interface to perform the sorting
        prescription2.sortMedication(new MedicationComparatorImpl());

        /**
         USE CASE 3: Testing for Equality and writing a receipt to file
        */

        //Testing Equality
        //Removing a medication
        if(prescription2.removeMedication(medication5))
            System.out.println(medication5.getMedicationName() + " removed successfully");

        //checking for a medication
        if(prescription2.containsMedication(medication4))
            System.out.println(medication4.getMedicationName() + " is in the list");

        File receiptFile = new File("C:\\Users\\Ralphses\\Documents\\Records\\Prescription.txt"); //Change this path to yours
        PrintWriter receiptWriter = null;

        try {
            receiptWriter = new PrintWriter(receiptFile);
            receiptWriter.write(Utility.prepareReciept(prescription2));
            receiptWriter.flush();
            receiptWriter.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("File Path not found \nChange file path on this line 123 -  File receiptFile = new File(\"C:\\\\Users\\\\Ralphses\\\\Documents\\\\Records\\\\Prescription.txt\");");
        }

        /**
         USE CASE 4: Further testing of Appointments and Prescription Methods
         */

        // Testing Appointments methods
        Appointments appointments = new Appointments();

        //Test addAppointment(Appointment a) method
        appointments.addAppointment(appointment);
        appointments.addAppointment(appointment2);
        appointments.addAppointment(appointment1);

        //Test getAppointmentByID(int i) method
        System.out.println("Appointment by ID => " + appointments.getAppointmentByID(123));
        System.out.println();

        //Test getAppointmentByPatient(Patient p) method
        System.out.println("Appointment by Patient => " +appointments.getAppointmentByPatient(patient3));
        System.out.println();

        //Print all Completed Appointments
        System.out.println("List of all completed Appointments");
        appointments.getCompletedAppointment().forEach(System.out::println);
        System.out.println();

        //Print all Pending Appointments
        System.out.println("List of all Pending Appointments");
        appointments.getPendingAppointment().forEach(System.out::println);
        System.out.println();

        //Sort all Appointments by ID
        System.out.println("Sorted Appointments By ID");
        appointments.sortAppointmentsByID().forEach(System.out::println);
        System.out.println();

        //Sort all Appointments by Patient name
        System.out.println("Sorted Appointments by Patient Name");
        appointments.sortAppointmentByPatientFirstName().forEach(System.out::println);
        System.out.println();

        //Testing the iterator
        System.out.println("Testing iterator");
        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // Testing Prescription methods
        Prescription prescription = new Prescription(765, appointment1, doctor2);

        //Testing addMedication(Medication m)
        prescription.addMedication(medication1);
        prescription.addMedication(medication3);
        prescription.addMedication(medication2);

        //Testing retrieveMedicationByID()
        System.out.println("Retrieve Medication by ID");
        Medication m = prescription.retrieveMedication(221);
        System.out.println(m);
        System.out.println();

        //Testing checkMedication()
        System.out.println("Check existence of Medication by ID");
        if(prescription.checkForMedication(3))
            System.out.println("Medication with ID 3 exists");
        else System.out.println("Medication with ID 3 does not exists");
        System.out.println();

        //Testing the iterator
        System.out.println("Testing iterator");
        Iterator<Medication> it = prescription.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        //Adding a new Medication
        prescription.addMedication(new Medication("Omeprazol", 10000, 356.9));
        System.out.println(Utility.prepareReciept(prescription));

        /**
         USE CASE 5: Creating and testing a reward Processor
         */
        RewardProccessor rewardProccessor = new RewardProccessor();

        //Adding some rewardable medications
        rewardProccessor.addMedication(medication2);
        rewardProccessor.addMedication(medication3);
        rewardProccessor.addMedication(medication5);
        rewardProccessor.addMedication(medication);

        int rewardPoints = rewardProccessor.rewardPoints(prescription1);

        System.out.println("Total reward points for " + prescription1.getAppointment().getPatient().getName() + " is " +rewardPoints);
    }

}
