package com.epam.rdtrainingcustomexceptionstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.epam.rdtraining.customexceptions.InvalidVehicleNumberException;

/**
 * @author Srujan_Aditya
 *
 */
public class InvalidVehicleNumberExceptionTest extends InvalidVehicleNumberException {
    /**
     * Since it is a serializable class.
     */
    private static final long serialVersionUID = -1597510341567739026L;

    /**
     * Test : To Test the message returned when we through a custom exception.
     */
    @Test
    //TODO Test the message returned when we through a custom exception.
    public void testMessage() {
        try {
            throw new InvalidVehicleNumberException();
        } catch (InvalidVehicleNumberException e) {
            assertEquals("Invalid Vehicle Number", e.getMessage());
        }
    }

}
