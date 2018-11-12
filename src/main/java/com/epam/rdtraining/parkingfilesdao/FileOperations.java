package com.epam.rdtraining.parkingfilesdao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Properties;

import com.epam.rdtraining.parkingservices.ParkingSlot;

/**
 * Perform file read and write operations.
 * @author Srujan_Aditya
 *
 */
public class FileOperations {
    /**
     * static instance of the class.
     */
    private static FileOperations fileInstance = new FileOperations();
    /**
     * inputFile which stores all the parked vehicle details.
     */
    private static File inputFile;
    /**
     * inputfile path in string.
     */
    private static String inputFileString;
    static {
        Properties prop = new Properties();
        try {
            prop.load(FileOperations.class.getResourceAsStream("/AutoParking.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputFile = new File(prop.getProperty("ParkingInfoCSV"));
        inputFileString = prop.getProperty("ParkingInfoCSV");
    }
    /**
     * getFileWriter method to send the single instance of the file writer.
     * @return single instance
     */
    public static synchronized FileWriter getFileWriter() {
        FileWriter writer = null;
        try {
            writer = new FileWriter(inputFileString, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }
    /**
     * getIntance method to send the single instance of the class.
     * @return single instance
     */
    public static synchronized FileOperations getInstance() {
        return fileInstance;
    }
    /**
     * Store the parked vehicle details into file.
     * @param parkingSlotObject parked vehicle object
     */
    public void parkedVehicleDetails(
            final ParkingSlot parkingSlotObject) {
        try (PrintWriter printWriter = new PrintWriter(getFileWriter())) {
            printWriter.println();
            printWriter.println(parkingSlotObject.getVehicleObject().getRegistrationNumber()
                        + "," + parkingSlotObject.getSlotNo()
                        + "," + parkingSlotObject.getInTime() + ",");
            printWriter.flush();
        }
        logParkVehicleDetails(parkingSlotObject);
    }
    /**
     * To log the unparked vehicle details.
     * @param parkingSlotObject unparked vehicle object
     */
    public void unparkedVehicleDetails(
            final ParkingSlot parkingSlotObject) {
        File tempFile = new File("D:/temp.csv");
        try (BufferedReader bufReader
                = new BufferedReader(new FileReader(inputFile))) {
            try (BufferedWriter bufWriter
                    = new BufferedWriter(new FileWriter(tempFile))) {
                String lineToRemove =
                   parkingSlotObject.getVehicleObject().getRegistrationNumber()
                    + "," + parkingSlotObject.getSlotNo()
                    + "," + parkingSlotObject.getInTime() + ",";
                String currentLine;
                while ((currentLine = bufReader.readLine()) != null) {
                    String trimmedLine = currentLine.trim();
                    if (trimmedLine.equals(lineToRemove)) {
                        continue;
                    }
                    bufWriter.write(currentLine);
                    bufWriter.newLine();
                    bufWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputFile.delete();
        tempFile.renameTo(inputFile);
        logUnparkVehicleDetails(parkingSlotObject);
    }
    /**
     * To reset the files.
     */
    public void resetFiles() {
        inputFile.delete();
    }
    /**
     * Logging parked vehicle details into log file.
     * @param parkingSlotObject parking slot object
     */
    public void logParkVehicleDetails(final ParkingSlot parkingSlotObject) {
        LogDetails logInstance = LogDetails.getInstance();
        logInstance.logDetails(parkingSlotObject, null);
    }
    /**
     * logging unparked vehicle details in to log file.
     * @param parkingSlotObject parking slot object
     */
    public void logUnparkVehicleDetails(final ParkingSlot parkingSlotObject) {
        LogDetails logInstance = LogDetails.getInstance();
        logInstance.logDetails(parkingSlotObject, LocalDateTime.now());
    }
}
