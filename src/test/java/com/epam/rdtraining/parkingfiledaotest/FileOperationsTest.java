package com.epam.rdtraining.parkingfiledaotest;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.epam.rdtraining.consoleservices.PopulateData;
import com.epam.rdtraining.parkingfilesdao.FileOperations;
import com.epam.rdtraining.parkingfilesdao.LogDetails;
import com.epam.rdtraining.parkingfilesdao.StoreNoOfSlotsInFile;
import com.epam.rdtraining.parkingservices.ParkingSlot;

/**
 * To test the all the file operations.
 * @author Srujan_Aditya
 *
 */
public class FileOperationsTest {
    /**
     * Test cases to catch the IOExceptions.
     * @throws IOException file exceptions
     */
    @Test
    public void testToCatchBlocks() throws IOException {
        File logFile = new File("src/main/resources/logFile.txt");
        System.out.println(logFile.isDirectory());
        System.out.println(logFile.delete());
        logFile = new File("src/main/resources/ParkingInfo.csv");
        System.out.println(logFile.isDirectory());
        System.out.println(logFile.delete());
        logFile = new File("src/main/resources/SlotsInfo.txt");
        System.out.println(logFile.isDirectory());
        System.out.println(logFile.delete());
        File fdelete = new File("src/main/resources");
        System.out.println(fdelete.isDirectory());
        System.out.println(fdelete.delete());
        FileOperations instance = FileOperations.getInstance();
        final ParkingSlot parkingSlotInstance = new ParkingSlot(1, "TS2e123");
        instance.unparkedVehicleDetails(parkingSlotInstance);
        new PopulateData().populateVehicleMap(2);
        new File("src/main/resources").mkdirs();
        new FileOperationsTest().getFileWriter();
    }

    /**
     * To test the getFileWriter methods.
     * @throws IOException IOException
     */
    public void getFileWriter() throws IOException {
        File logFile = new File("src/main/resources/logFile.txt");
        System.out.println(logFile.isDirectory());
        System.out.println(logFile.delete());
        File fdelete = new File("src/main/resources");
        System.out.println(fdelete.isDirectory());
        System.out.println(fdelete.delete());
        LogDetails.getFileWriter();
        FileOperations.getFileWriter();
        StoreNoOfSlotsInFile.getFileWriter();
        PopulateData popDataObject = new PopulateData();
        popDataObject.populateVehicleMap(2);
        new File("src/main/resources").mkdirs();
        logFile = new File("src/main/resources/ParkingInfo.csv");
        logFile.setWritable(false);
        FileOperations.getFileWriter();
        logFile.setWritable(true);
        logFile = new File("src/main/resources/SlotsInfo.txt");
        logFile.setWritable(false);
        StoreNoOfSlotsInFile.getFileWriter();
        logFile.setWritable(true);
        logFile = new File("src/main/resources/logFile.txt");
        logFile.setWritable(false);
        LogDetails.getFileWriter();
        logFile.setWritable(true);
    }

}
