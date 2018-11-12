package com.epam.rdtrainingcustomexceptionstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.epam.rdtraining.customexceptions.InvalidSlotNumberException;

/**
 * @author Srujan_Aditya
 *
 */
public class InvalidSlotNumberExceptionTest extends InvalidSlotNumberException {
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
            throw new InvalidSlotNumberException();
        } catch (InvalidSlotNumberException e) {
            assertEquals("Invalid Slot Number", e.getMessage());
        }
    }
}
