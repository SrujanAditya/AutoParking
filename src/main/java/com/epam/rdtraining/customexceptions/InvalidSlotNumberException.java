package com.epam.rdtraining.customexceptions;

/**
 * @author Srujan_Aditya
 *
 */
public class InvalidSlotNumberException extends Exception {
    /**
     * as it is a serialization class.
     */
    private static final long serialVersionUID = 1L;
    /**
     * This method is used to return a string when this type of custom exceptions occur.
     */
    @Override
    public String getMessage() {
        return "Invalid Slot Number";
    }
}
