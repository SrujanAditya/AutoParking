package com.epam.rdtraining.entities;

/**
 * Vehicle interface which contains abstract methods such as:.
 * getRegistration method.
 * @author Srujan_Aditya
 * @version 1.0.0
 */

public interface Vehicle {
    /**
     *  To getRegistrationNumber of the vehicle.
     *  @return vehicle registration number
     */
    String getRegistrationNumber();
    /**
     * to set the registration number of the vechicle.
     * @param regNo vehicle registration number
     */
    void setRegistrationNumber(String regNo);
}
