package com.epam.rdtraining.consoleservices;

import java.util.Scanner;

import com.epam.rdtraining.parkingservices.ParkingOperations;
import com.epam.rdtraining.users.AdminLogin;

/**
 * Main program to run with command line args.
 * @author Srujan_Aditya
 *
 */
public class MainCommandLineArgs {
    /**
     * Magic number 3.
     */
    private static final int VALUETHREE = 3;
    /**
     * This method accepts input args and perform the operations. input args are [0] = admin username [1] = admin password [2] = 1 or 0; where 1 - Reset all files data and accept fourth argument slot
     * no 0 - read the data from files, if files doesnt exist then exit with an error.
     * @param args input args
     */
    public static void main(final String[] args) {
        System.out.println("\nWelcome to Auto Parking Application");
        try (Scanner scannerObject = new Scanner(System.in)) {
            final MainConsole mainObject = new MainConsole();
            final AdminLogin loginInstance = new AdminLogin();
            final PerformOpeartions performOp = new PerformOpeartions();
            final ParkingOperations parkingOpInstance = new ParkingOperations();
            if (loginInstance.login(args[0], args[1])) {
                if (args[2].equals("1")) {
                    performOp.resetAllFilesAndData();
                    parkingOpInstance.setAndStoreParkingSlots(Integer.parseInt(args[VALUETHREE]));
                    mainObject.performOperation(scannerObject, parkingOpInstance, performOp);
                } else if (args[2].equals("0")) {
                    final PopulateData populateInstance = new PopulateData();
                    populateInstance.populate();
                    mainObject.performOperation(scannerObject, parkingOpInstance, performOp);
                }
            }
        }
    }

}
