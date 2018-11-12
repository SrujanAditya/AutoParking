package com.epam.rdtraining.parkingservicestest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.epam.rdtraining.parkingservices.Parking;
import com.epam.rdtraining.parkingservices.ParkingOperations;
import com.epam.rdtraining.parkingservices.ParkingSlot;

/**
 * @author Srujan_Aditya
 *
 */
public class ParkingOperationsTest {
     /**
      * Injecting mock on parking operations class.
      */
    @InjectMocks
    private final ParkingOperations pOInstance = new ParkingOperations();
    /**
     * Parking slot instance.
     */
    private static ParkingSlot parkingSlotInstance;
    /**
     * Steps to execute before the test cases are runned.
     */
    @BeforeClass
    public static void setUp() {
        parkingSlotInstance = new ParkingSlot(2, "TS2E123");
    }
    /**
     * Test : To test the printParkedVehicleDetails method.
     */
    @Test
    // TODO test the printParkedVehicleDetails method.
    public void testPrintParkedVehicleDetails() {
       String expected = "Vehicle Parked Successfully\nVehicle Number : "
               + parkingSlotInstance.getVehicleObject().getRegistrationNumber()
               + "\nSlot Number : " + parkingSlotInstance.getSlotNo()
               + "\nIn Time : " + parkingSlotInstance.getInTime();
       String actual = pOInstance.printParkedVehicleDetails(parkingSlotInstance);
       assertEquals("Printed Successfully", expected, actual);
    }
    /**
     * Test : To test the printUnparkedVehicleDetails method.
     */
    @Test
    // TODO test the printUnparkedVehicleDetails method.
    public void testPrintUnparkedVehicleDetails() {
       String expected = "Vehicle Unparked Successfully\nVehicle Number : "
               + parkingSlotInstance.getVehicleObject().getRegistrationNumber()
               + "\nSlot Number : " + parkingSlotInstance.getSlotNo()
               + "\nIn Time : " + parkingSlotInstance.getInTime()
               + "\nOut Time : " + LocalDateTime.now();
       String actual = pOInstance.printUnparkedVehicleDetails(parkingSlotInstance);
       assertEquals("Printed Successfully", expected, actual);
    }
    /**
     * Test : To set and store the slot numbers.
     */
    @Test
    // TODO Set the slot numbers and store it into a file.
    public void testSetAndStoreParkingSlots() {
        pOInstance.setAndStoreParkingSlots(2);
        assertEquals("Slot Number Matched", 2, Parking.getAvailableSlots().size());
    }
    /**
     * Test : performParkOperation when the parking is full.
     */
    @Test
    // TODO Test performParkOperation when the parking is full
    public void testPerformParkOperationWhenParkingFull() {
        pOInstance.setAndStoreParkingSlots(1);
        pOInstance.performParkOperation("TS2E123");
        String expected = "Parking Full";
        assertEquals("Results Matched", expected, pOInstance.performParkOperation("TS2R123"));
    }
    /**
     * Test : performParkOperation when the vehicle is already parked.
     */
    @Test
    // TODO Test performParkOperation when the vehicle is already parked
    public void testPerformParkOperationWhenVehicleIsParkedAlready() {
        pOInstance.setAndStoreParkingSlots(2);
        pOInstance.performParkOperation("TS2E123");
        String expected = "Vehicle already available.";
        assertEquals("Results Matched", expected, pOInstance.performParkOperation("TS2E123"));
    }
    /**
     * Test : performParkOperation when the vehicle arrived for parking.
     */
    @Test
    // TODO Test performParkOperation when the vehicle arrived for parking
    public void testPerformParkOperationWhenParkingNotFull() {
        pOInstance.setAndStoreParkingSlots(2);
        pOInstance.performParkOperation("TS2E123");
        String actual = pOInstance.performParkOperation("TS2R123");
        String expected = "Vehicle Parked Successfully\nVehicle Number : "
                + "TS2R123"
                + "\nSlot Number : 1"
                + "\nIn Time : " + LocalDateTime.now();
        assertEquals("Results Matched", expected.split("T")[0], actual.split("T")[0]);
    }
    /**
     * Test : performUnParkOperation when vehicle is not available.
     */
    @Test
    // TODO Test performUnParkOperation when vehicle is not available.
    public void testPerformUnparkOperationWhenVehicleNotAvailable() {
        pOInstance.setAndStoreParkingSlots(1);
        pOInstance.performParkOperation("TS2E123");
        String expected = "Vehicle Unavailable";
        assertEquals("Results Matched", expected, pOInstance.performUnparkOperation("TS2R123"));
    }
    /**
     * Test : performUnParkOperation for the vehicle.
     */
    @Test
    // TODO Test performUnParkOperation for the vehicle..
    public void testPerformUnparkOperationWhenVehicleAvailable() {
        pOInstance.setAndStoreParkingSlots(2);
        pOInstance.performParkOperation("TS2E123");
        String actual = pOInstance.performUnparkOperation("TS2E123");
        String expected = "Vehicle Unparked Successfully\nVehicle Number : "
                + "TS2R123"
                + "\nSlot Number : 2"
                + "\nIn Time : " + LocalDateTime.now()
                + "\nOut Time : " + LocalDateTime.now();
        assertEquals("Results Matched", expected.split("2")[0], actual.split("2")[0]);
    }
}
