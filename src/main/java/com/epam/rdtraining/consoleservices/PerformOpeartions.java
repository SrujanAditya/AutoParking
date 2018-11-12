package com.epam.rdtraining.consoleservices;

import java.util.Scanner;

import com.epam.rdtraining.customexceptions.InvalidSlotNumberException;
import com.epam.rdtraining.customexceptions.InvalidVehicleNumberException;
import com.epam.rdtraining.parkingfilesdao.FileOperations;
import com.epam.rdtraining.parkingfilesdao.StoreNoOfSlotsInFile;
import com.epam.rdtraining.parkingservices.Parking;
import com.epam.rdtraining.users.AdminLogin;
import com.epam.rdtraining.validators.ValidateRegistrationNumber;

/**
 * This class is used to perform the parking operation based on the user choice.
 * @author Srujan_Aditya
 *
 */
public class PerformOpeartions {
    /**
     * this method is used to validate the vehicle number,
     * and print the respective statements.
     * @param regNo vehicle registration number
     * @return validate the vehicle number
     * @throws InvalidVehicleNumberException invalid vehicle number
     */
    public boolean checkVehicleRegNo(final String regNo) throws InvalidVehicleNumberException {
        final ValidateRegistrationNumber validateObject
                = new ValidateRegistrationNumber();
        boolean checkFlag = true;
        if (!validateObject.validate(regNo)) {
            throw new InvalidVehicleNumberException();
        }
        return checkFlag;
    }
    /**
     * This method is used to get the vehicle registration number.
     * @param scannerObject scanner object
     * @return vehicle registration number
     */
    public String readVehicleRegNo(final Scanner scannerObject) {
        System.out.print("Enter the Vehicle number : ");
        return scannerObject.nextLine();
    }
    /**
     * method to display the menu.
     */
    public static void displayMenu() {
        String printMenu = "\n Menu \n1. Park\n2. Unpark\n"
            + "3. Show Parking Grid\n4. Reset Parking Grid\n"
            + "5. Exit\nEnter your choice : ";
        System.out.print(printMenu);
    }
    /**
     * This method takes input from the user.
     * @param scannerObject scanner object.
     * @return number Of Slots in parking area.
     */
    public int getNumberOfSlots(final Scanner scannerObject) {
        String slots = "0";
        do {
            System.out.print("\nEnter no of Parking slots : ");
            try {
                slots = scannerObject.nextLine();
                if (!slots.matches("[0-9]+") || Integer.parseInt(slots) <= 0) {
                    throw new InvalidSlotNumberException();
                }
            } catch (InvalidSlotNumberException e) {
                System.out.println(e.getMessage());
                slots = "0";
            }
        } while (Integer.parseInt(slots) <= 0);
        return Integer.parseInt(slots);
    }
    /**
     * This method is used to call adminLogin method
     * which validated the login credentials.
     * @param scannerObject scanner object.
     * @return login status(only if the login is successfull).
     */
    public boolean adminLoginMenu(final Scanner scannerObject) {
        final AdminLogin loginInstance = new AdminLogin();
        boolean loginFlag = false;
        do {
            System.out.print("\nUser Name : ");
            String userName = scannerObject.nextLine();
            System.out.print("Password : ");
            String userPassword = scannerObject.nextLine();
            loginFlag = loginInstance.login(userName, userPassword);
        } while (!loginFlag);
        return loginFlag;
    }
    /**
     * To reset all the files.
     * @return result string
     */
    public String resetAllFilesAndData() {
        String resultString = "Reset Successful";
        try {
            FileOperations fileInstance = FileOperations.getInstance();
            fileInstance.resetFiles();
            StoreNoOfSlotsInFile slotInstance = StoreNoOfSlotsInFile.getInstance();
            slotInstance.resetFiles();
        } catch (Exception e) {
            resultString = "Files doesnot exist";
        }
        try {
            Parking.getParkedVehicle().clear();
            Parking.getAvailableSlots().clear();
        } catch (Exception e) {
            resultString = "Successfully cleared";
        }
        System.out.println(resultString);
        return resultString;
    }
    /**
     * Manual reset all files for junit.
     */
    public static void reset() {
        try {
            FileOperations fileInstance = FileOperations.getInstance();
            fileInstance.resetFiles();
            StoreNoOfSlotsInFile slotInstance = StoreNoOfSlotsInFile.getInstance();
            slotInstance.resetFiles();
            Parking.getParkedVehicle().clear();
            Parking.getAvailableSlots().clear();
        } catch (Exception e) {
            System.out.println("Files doesnot exist");
        }
    }
}
