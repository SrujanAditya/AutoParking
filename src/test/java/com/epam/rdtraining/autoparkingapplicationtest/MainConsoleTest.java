package com.epam.rdtraining.autoparkingapplicationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

import com.epam.rdtraining.consoleservices.MainConsole;
import com.epam.rdtraining.consoleservices.PerformOpeartions;
import com.epam.rdtraining.consoleservices.PopulateData;
import com.epam.rdtraining.customexceptions.InvalidVehicleNumberException;
import com.epam.rdtraining.parkingfilesdao.LogDetails;
import com.epam.rdtraining.parkingfilesdao.StoreNoOfSlotsInFile;
import com.epam.rdtraining.parkingservices.ParkingOperations;

/**
 * Junit for testing main console progam flow.
 * @author Srujan_Aditya
 *
 */
public class MainConsoleTest {
    /**
     * Test AdminLoginMenu method.
     */
    @Test
    public void testMainFlow() {
        PerformOpeartions.reset();
        StringBuilder input = new StringBuilder();
        input.append("admin\nepam12\n");
        input.append("adin\nepam123\n");
        input.append("admin\nepam123\n");
        input.append("0\n");
        input.append("adsd\n");
        input.append("-5\n");
        input.append("2\n");
        input.append("aeds\n1\n");
        input.append("TS2E123\n");
        input.append("1\n");
        input.append("TS2E11231\n");
        input.append("3\n");
        input.append("2\n");
        input.append("TS2E123432\n");
        input.append("aeds\n2\n");
        input.append("TS2E123\n");
        input.append("3\n4\n4\n");
        input.append("1\nTS2E123\n");
        input.append("1\nTS2ER123\n");
        input.append("2\nTS2E123\n");
        input.append("3\n5\n5\n");
        ByteArrayInputStream inputStream
            = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(inputStream);
        System.out.println("main");
        MainConsole.main(null);
    }
    /**
     * test GetNumberOfSlots method.
     */
    @Test
    public void testGetNumberOfSlots() {
        PerformOpeartions performOpObject = new PerformOpeartions();
        StringBuilder input = new StringBuilder();
        input.append("0\n");
        input.append("adsd\n");
        input.append("-5\n");
        input.append("2\n");
        ByteArrayInputStream inputStream
            = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(inputStream);
        Scanner scannerObject = new Scanner(System.in);
        performOpObject.getNumberOfSlots(scannerObject);
    }
    /**
     * test readVehicleRegNo method.
     */
    @Test
    public void testReadVehicleRegNo() {
        PerformOpeartions mainObject = new PerformOpeartions();
        StringBuilder input = new StringBuilder();
        input.append("TS2E11231\n");
        ByteArrayInputStream inputStream
            = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(inputStream);
        Scanner scannerObject = new Scanner(System.in);
        assertEquals("TS2E11231", mainObject.readVehicleRegNo(scannerObject));
    }
    /**
     * test checkVehicleRegNo method.
     * @throws InvalidVehicleNumberException Invalid vehicle number
     */
    @Test
    public void testCheckVehicleRegNo() throws InvalidVehicleNumberException {
        PerformOpeartions mainObject = new PerformOpeartions();
        assertTrue(mainObject.checkVehicleRegNo("TS2E123"));
        //assertFalse(mainObject.checkVehicleRegNo("TS234E123"));
    }
    /**
     * Populate data.
     */
    @Test
    public void testPopulateData() {
        StringBuilder input = new StringBuilder();
        input.append("admin\nepam123\n");
        input.append("5\n");
        input.append("1\n");
        input.append("TS2E123\n");
        input.append("1\nTS2ER123\n");
        input.append("1\nTS3ER123\n");
        input.append("1\nTS4ER123\n");
        input.append("2\nTS4ER123\n");
        input.append("3\n5\n5\n");
        ByteArrayInputStream inputStream
        = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(inputStream);
        MainConsole.startJob();
        PopulateData popObject = new PopulateData();
        popObject.populate();
        PerformOpeartions.reset();
    }
    /**
     * To test the read operation from a file.
     */
    @Test
    public void testReadNoOfSlots() {
        PerformOpeartions.reset();
        StoreNoOfSlotsInFile instance = StoreNoOfSlotsInFile.getInstance();
        instance.readNoOfSlots();
        LogDetails.getFileWriter();
        LogDetails.getFileWriter();
    }
    /**
     * to chedck the parking slot details method.
     */
    @Test
    public void testCheckParkingSlotDetails() {
        PerformOpeartions.reset();
        StringBuilder input = new StringBuilder();
        input.append("admin\nepam123\n");
        input.append("2\n");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.toString().getBytes());
        System.setIn(inputStream);
        Scanner scannerObject = new Scanner(System.in);
        final PerformOpeartions performOp = new PerformOpeartions();
        final ParkingOperations parkingOpInstance = new ParkingOperations();
        MainConsole.checkParkingSlotDetails(scannerObject, performOp, parkingOpInstance);
    }
}
