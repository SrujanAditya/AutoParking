package com.epam.rdtraining.validators;
/**
 * ValidateRegistrationNumber class contains
 * validate method which validates the vehicle registration number.
 * @author Srujan_Aditya
 * @version 1.0.0
 */
public class ValidateRegistrationNumber {
    /**
     * Valid pattern for vehicle registration number.
     */
    private final String validPattern = "^[a-zA-z]{2}[ ]{0,1}[0-9]{1,2}"
            + "[ ]{0,1}[a-zA-z]{1,2}[ ]{0,1}[0-9]{1,4}$";
    /**
     * validate method contains logic for checking the registration number.
     * @param regNo vehicle registration number.
     * @return boolean value if the regNo is validate or not
     */
    public boolean validate(final String regNo) {
        return regNo.matches(validPattern);
    }
}
