package com.epam.rdtraining.entitiestest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.epam.rdtraining.entities.Car;
import com.epam.rdtraining.entities.Vehicle;

/**
 * @author Srujan_Aditya
 *
 */
public class CarTest {
    /**
     * To test the car class methods.
     */
    @Test
    public void test() {
        Vehicle vehicleObject = new Car();
        vehicleObject.setRegistrationNumber("AP2E123");
        assertEquals("AP2E123", vehicleObject.getRegistrationNumber());
    }
}
