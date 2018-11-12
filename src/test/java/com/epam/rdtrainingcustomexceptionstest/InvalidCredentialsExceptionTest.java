package com.epam.rdtrainingcustomexceptionstest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.epam.rdtraining.customexceptions.InvalidCredentialsException;

/**
 * @author Srujan_Aditya
 *
 */
public class InvalidCredentialsExceptionTest extends InvalidCredentialsException {
    /**
     * Since it is a serializable class.
     */
    private static final long serialVersionUID = -7150749707857397818L;

    /**
     * Test : To Test the message returned when we through a custom exception.
     */
    @Test
    //TODO Test the message returned when we through a custom exception.
    public void testMessage() {
        try {
            throw new InvalidCredentialsException();
        } catch (InvalidCredentialsException e) {
            assertEquals("Invalid Credentials", e.getMessage());
        }
    }

}
