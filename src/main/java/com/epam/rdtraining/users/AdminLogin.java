/*
 * @(#)AdminLogin.java         07/24/18
 * This file contains adminLogin class
 */
package com.epam.rdtraining.users;

import com.epam.rdtraining.customexceptions.InvalidCredentialsException;

/**
 * AdminLogin class contains admin attributes which are private.
 * We have login method which is used to validate the username and password and login to the application.
 * @version 1.0.0
 * @author SRUJAN ADITYA DASA
 */
public class AdminLogin {

    /** To store admin user name. */
    private String adminUserName = "admin";

    /** To store admin password. */
    private char[] adminPassword = "epam123".toCharArray();

    /**
     * Login method is used to validate the entered user name and password.
     * We take input from the console and validate with the stored values.
     * @param userName     store user name
     * @param userPassword store user password
     * @return boolean value if the login is successful.
     */
    public boolean login(final String userName, final String userPassword) {
        boolean isValid = false;
        if (userName.equals(adminUserName) && userPassword.equals(String.valueOf(adminPassword))) {
            System.out.println("\nWelcome " + userName);
            isValid = true;
        } else {
            try {
                throw new InvalidCredentialsException();
            } catch (InvalidCredentialsException e) {
                System.out.println(e.getMessage());
            }
        }
        return isValid;
    }
}
