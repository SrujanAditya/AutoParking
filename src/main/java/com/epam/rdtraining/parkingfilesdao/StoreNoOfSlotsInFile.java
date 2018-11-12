package com.epam.rdtraining.parkingfilesdao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * This file is to store the number of slots in the parking slot.
 * @author Srujan_Aditya
 */
public class StoreNoOfSlotsInFile {
    /**
     * static instance of the class.
     */
    private static StoreNoOfSlotsInFile fileInstance
                        = new StoreNoOfSlotsInFile();
    /**
     * inputFile which stores all the parked vehicle details.
     */
    private static File inputFile;
    static {
        Properties prop = new Properties();
        try {
            prop.load(StoreNoOfSlotsInFile.class.getResourceAsStream("/AutoParking.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputFile = new File(prop.getProperty("SlotFile"));
    }
    /**
     * getFileWriter method to send the single instance of the file writer.
     * @return single instance
     */
    public static synchronized FileWriter getFileWriter() {
        FileWriter writer = null;
        try {
            writer = new FileWriter(inputFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }
    /**
     * getIntance method to send the single instance of the class.
     * @return single instance
     */
    public static synchronized StoreNoOfSlotsInFile getInstance() {
        return fileInstance;
    }
    /**
     * Check if file exists.
     * @return boolean value if file exists.
     */
    public boolean checkIfFileExists() {
        return (inputFile.exists()) ? true : false;
    }
    /**
     * Delete the file from location.
     */
    public void resetFiles() {
        inputFile.delete();
    }
    /**
     * Store the no od slots into a file.
     * @param noOfSlots  slots in parking area.
     */
    public void storeNumberOfSlots(final int noOfSlots) {
        try (PrintWriter printWriter = new PrintWriter(getFileWriter())) {
            printWriter.println(noOfSlots);
            printWriter.flush();
        }
    }
    /**
     * Read Number of slots.
     * @return Number of slots
     */
    public int readNoOfSlots() {
        int noOfSlots = 0;
        try (BufferedReader br
                = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine().trim();
            noOfSlots = Integer.parseInt(line);
        } catch (Exception expe) {
            expe.printStackTrace();
        }
        return noOfSlots;
    }
}
