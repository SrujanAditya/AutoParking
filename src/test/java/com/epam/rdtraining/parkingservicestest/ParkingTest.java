package com.epam.rdtraining.parkingservicestest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.epam.rdtraining.parkingservices.Parking;
import com.epam.rdtraining.parkingservices.ParkingSlot;

/**
 * This class contains junit test cases
 * to test parking class.
 * @author Srujan_Aditya
 *
 */
public class ParkingTest {
    /**
     * To create a mock of Parking Class.
     */
    @InjectMocks
    private static Parking parkingInstance = new Parking();
    /**
     * List to maintain all the available slots.
     */
    private static List<Integer> availableSlots;
    /**
     * Map to maintain all the parked vehicle details.
     */
    private static  Map<String, ParkingSlot> parkedVehicle;

    /**
     * To set up the variable at the beginning of the test.
     */
    @BeforeClass
    public static void setUp() {
        availableSlots = new ArrayList<Integer>();
        parkedVehicle = new HashMap<String, ParkingSlot>();
        availableSlots.add(1);
        parkedVehicle.put("TS2E123", new ParkingSlot(2, "TS2E123"));
    }
    /**
     * Test : setNoOfSlots and get method.
     */
    @Test
    // TODO Set and get the no of slots.
    public void testNoOfSlots() {
        parkingInstance.setNoOfSlots(2);
        boolean result = (Parking.getAvailableSlots().size() == 2);
        assertTrue("Slots Setted Successfully", result);
    }
    /**
     * Test : set and get availableSlots method.
     */
    @Test
    // TODO Set and get the parked vehicles.
    public void testAvailableSlots() {
        Parking.setAvailableSlots(availableSlots);
        boolean result =  availableSlots.equals(Parking.getAvailableSlots());
        assertTrue("Both the lists are equal", result);
    }
    /**
     * Test : set and get parking slots method.
     */
    @Test
    // TODO Set and get the parked vehicles.
    public void testParkingSlots() {
        Parking.setParkedVehicle(parkedVehicle);
        boolean result =  parkedVehicle.equals(Parking.getParkedVehicle());
        assertTrue("Both the lists are equal", result);
    }
    /**
     * Test : check if the vehicle is which available in the parking area.
     */
    @Test
    // TODO check for the vehicle which available in the parking area.
    public void testForAvailableVehicle() {
        Parking.setParkedVehicle(parkedVehicle);
        assertTrue("Vehicle is Available", parkingInstance.checkIfVehicleAvailable("TS2E123"));
    }
    /**
     * Test : check if the vehicle is which available in the parking area.
     */
    @Test
    // TODO check for the vehicle which is not available in the parking area.
    public void testForNotAvailableVehicle() {
        Parking.setParkedVehicle(parkedVehicle);
        assertFalse("Vehicle Not Available", parkingInstance.checkIfVehicleAvailable("TS2R123"));
    }
    /**
     * Test : check parking if the parking is full.
     */
    @Test
    // TODO check parking if the parking is full.
    public void testParkingFull() {
        parkingInstance.setNoOfSlots(0);
        assertTrue("Parking Full", parkingInstance.isParkingFull());
    }
    /**
     * Test : check parking if the parking is not full.
     */
    @Test
    // TODO check parking if the parking is not full.
    public void testNotParkingFull() {
        parkingInstance.setNoOfSlots(2);
        assertFalse("Parking Available", parkingInstance.isParkingFull());
    }
    /**
     * Test : To perform the park operation.
     */
    @Test
    //TODO Perform park operation
    public void testPark() {
        parkingInstance.setNoOfSlots(2);
        ParkingSlot psInstance = parkingInstance.park("TS2E123");
        assertEquals("Parked Successfully", "TS2E123", psInstance.getVehicleObject().getRegistrationNumber());
    }
    /**
     * Test : To perform the unpark operation.
     */
    @Test
    //TODO Perform unpark operation
    public void testUnpark() {
        parkingInstance.setNoOfSlots(2);
        ParkingSlot psInstance = parkingInstance.park("TS2E123");
        psInstance = parkingInstance.unpark("TS2E123");
        assertEquals("Unparked Successfully", "TS2E123", psInstance.getVehicleObject().getRegistrationNumber());
    }
    /**
     * Test : To perform the display slot operation.
     */
    @Test
    //TODO Test displaySlots Method
    public void testDisplay() {
        parkingInstance.setNoOfSlots(2);
        ParkingSlot psInstance = parkingInstance.park("TS2E123");
        String expected = "Slot \t Vechicle Number \t InTime\n"
                            + psInstance.getSlotNo() + " \t" + "TS2E123"
                            + " \t" + psInstance.getInTime() + "\n";
        assertEquals("Displayed Slots Successfully", expected, Parking.displaySlots());
    }
}
