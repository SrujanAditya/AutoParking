package com.epam.rdtraining.entities;

/**
 * Car class implements the vehicle interface.
 * @author Srujan_Aditya
 * @version 1.0.0
 */
public class Car implements Vehicle {
    /**
     * Used to store registrationNumber of the car.
     */
    private String registrationNumber;
    /**
     * @return vehicle registration number
     */
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }
    /**
     * This method is used to set the registration number of the vehicle.
     * @param regNo registration Number
     */
    public void setRegistrationNumber(final String regNo) {
        this.registrationNumber = regNo;
    }
}
