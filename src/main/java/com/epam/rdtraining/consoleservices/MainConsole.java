/**
 * @(#)MainConsole.java         07/24/18
 * This file contains main method.
 */
package com.epam.rdtraining.consoleservices;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.epam.rdtraining.customexceptions.InvalidVehicleNumberException;
import com.epam.rdtraining.parkingfilesdao.StoreNoOfSlotsInFile;
import com.epam.rdtraining.parkingservices.Parking;
import com.epam.rdtraining.parkingservices.ParkingOperations;

/**
 * MainConsole class contains main method.
 * @version 1.0.0
 * @author SRUJAN ADITYA DASA
 */
public class MainConsole {
    /**
     * Used for logging.
     */
    private static Logger logger = Logger.getLogger(MainConsole.class);
    /**
     * main method calls a method which starts the parking application.
     *@param args input
     */
    public static void main(final String[] args) {
        logger.debug("Starting Main Method");
        logger.debug("Calling startJob Method");
        startJob();
        logger.debug("Existing Main Method");
    }
    /**
     * This method starts the operations.
     */
    public static void startJob() {
        logger.debug("####Inside startJob Method####");
        System.out.println("\nWelcome to Auto Parking Application");
        try (Scanner scannerObject = new Scanner(System.in)) {
            final MainConsole mainObject = new MainConsole();
            final PerformOpeartions performOp = new PerformOpeartions();
            logger.debug("Calling adminLoginMenu Method to perform admin login");
            performOp.adminLoginMenu(scannerObject);
            final ParkingOperations parkingOpInstance = new ParkingOperations();
            logger.debug("Calling checkParkingSlotDetails Method");
            checkParkingSlotDetails(scannerObject,
                    performOp, parkingOpInstance);
            logger.debug("Calling performOperation Method");
            mainObject.performOperation(scannerObject,
                    parkingOpInstance, performOp);
        }
        logger.debug("####Exiting startJob Method####");
    }
    /**
     * This method is used to check
     * whether any vehicles are parked in the parking area or not.
     * And if the file doesnt exist then get the input from the user
     * or populate the data from the file to the maps.
     * @param scannerObject scanner object
     * @param performOp parform Operations class object
     * @param parkingOpInstance parking instance object
     */
    public static void checkParkingSlotDetails(final Scanner scannerObject,
            final PerformOpeartions performOp,
            final ParkingOperations parkingOpInstance) {
        logger.debug("####Inside checkParkingSlotDetails Method####");
        StoreNoOfSlotsInFile storeFileInstance
            = StoreNoOfSlotsInFile.getInstance();
        if (storeFileInstance.checkIfFileExists()) {
            PopulateData populateInstance = new PopulateData();
            logger.debug("Calling populate Method");
            populateInstance.populate();
        } else {
            logger.debug("Calling setAndStoreParkingSlots Method");
            parkingOpInstance.setAndStoreParkingSlots(
                    performOp.getNumberOfSlots(scannerObject));
        }
        logger.debug("####Exiting checkParkingSlotDetails Method####");
    }
    /**
     * This method is used to monitor the menu,
     * get the vehicle number,validate the vehicle number,
     * call the respective parking operations.
     * @param scannerObject scanner object
     * @param parkingOpInstance poarking instance
     * @param performOp PerformOpeartions object
     */
    public void performOperation(final Scanner scannerObject,
          final ParkingOperations parkingOpInstance,
          final PerformOpeartions performOp) {
        logger.debug("####Inside performOperation Method####");
        int choice;
        do {
            logger.debug("Calling displayMenu Method");
            PerformOpeartions.displayMenu();
            try {
              choice = Integer.parseInt(scannerObject.nextLine());
            } catch (Exception e) {
                logger.debug("InValid choice entered");
                choice = 0;
            }
            logger.debug("performing choose operation by calling chooseOperation Method");
        } while (!chooseOperation(choice, scannerObject,
            parkingOpInstance, performOp));
        logger.debug("####Exiting performOperation Method####");
    }
    /**
     * This method is used to choose the operation,
     * desided by the choice entered by the user.
     * @param choice option entered by the user
     * @param scannerObject scanner object
     * @param parkingOpInstance poarking instance
     * @param performOp PerformOpeartions object
     * @return boolean false if the opeartion is to exit.
     */
    public boolean chooseOperation(final int choice,
            final Scanner scannerObject,
            final ParkingOperations parkingOpInstance,
            final PerformOpeartions performOp) {
        logger.debug("####Inside chooseOperation Method####");
        boolean terminateFlag = false;
        String vehicleNo;
        switch (choice) {
        case 1:
            logger.debug("Reading the Vehicle Number by calling readVehicleRegNo method");
            vehicleNo = performOp.readVehicleRegNo(scannerObject);
            logger.debug("$$$$vehicleNo = " + vehicleNo);
            try {
                if (performOp.checkVehicleRegNo(vehicleNo)) {
                      parkingOpInstance.performParkOperation(vehicleNo);
                  }
            } catch (InvalidVehicleNumberException e) {
                System.out.println(e.getMessage());
            }
            break;
        case 2:
            logger.debug("Reading the Vehicle Number by calling readVehicleRegNo method");
            vehicleNo = performOp.readVehicleRegNo(scannerObject);
            logger.debug("$$$$vehicleNo = " + vehicleNo);
            try {
                if (performOp.checkVehicleRegNo(vehicleNo)) {
                      parkingOpInstance.performUnparkOperation(vehicleNo);
                  }
            } catch (InvalidVehicleNumberException e) {
                System.out.println(e.getMessage());
            }
            break;
        case 3:
            System.out.println(Parking.displaySlots());
            break;
        case 4:
            performOp.resetAllFilesAndData();
            System.out.println("Do you want to continue parking : Y/N");
            String shouldContinue = scannerObject.nextLine();
            if (shouldContinue.equalsIgnoreCase("Y")) {
                parkingOpInstance.setAndStoreParkingSlots(
                    performOp.getNumberOfSlots(scannerObject));
            } else {
                System.out.println("Thank You");
                terminateFlag = true;
            }
            break;
        case 5:
            logger.info("Thank you");
            terminateFlag = true;
            break;
        default :
            System.out.println("Wrong Choice!!!Try Again");
        }
        logger.debug("####Exiting chooseOperation Method####");
        return terminateFlag;
    }
}
