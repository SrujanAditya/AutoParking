package com.epam.rdtraining.parkingservicestest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.epam.rdtraining.entities.Car;
import com.epam.rdtraining.entities.Vehicle;
import com.epam.rdtraining.parkingservices.ParkingSlot;

/**
 * This Test case is used to test the parkingSlot class.
 * @author Srujan_Aditya
 *
 */
public class ParkingSlotTest {
    /**
     * Vehicle Slot Number.
     */
    private final int slotNo = 5;
    /**
     * Inject mock on ParkingSlot class.
     */
    @InjectMocks
    private ParkingSlot parkingSlotInstance = new ParkingSlot();
    /**
     * Test : To set and check slot no.
     */
    //TODO Set and check the parking Slot number.
    @Test
    public void testSetAndCheckSlotNo() {
        parkingSlotInstance.setSlotNo(slotNo);
        assertEquals(slotNo, parkingSlotInstance.getSlotNo());
    }
    /**
     * Test : To set and check slot no using 2 param constructor.
     */
    //TODO Set and check the parking Slot number using 2 param constructor.
    @Test
    public void testSetAndCheckSlotNoUsing2ParamsConst() {
        parkingSlotInstance = new ParkingSlot(slotNo, "TS2E123");
        assertEquals(slotNo, parkingSlotInstance.getSlotNo());
    }
    /**
     * Test : To set and check slot no using 3 param constructor.
     */
    //TODO Set and check the parking Slot number using 3 param constructor..
    @Test
    public void testSetAndCheckSlotNoUsing3ParamsConst() {
        parkingSlotInstance = new ParkingSlot(slotNo, "TS2E123", LocalDateTime.now());
        assertEquals(slotNo, parkingSlotInstance.getSlotNo());
    }
    /**
     * Test : To set and check inTime.
     */
    //TODO Set and check the parking inTime.
    @Test
    public void testSetAndCheckInTime() {
        parkingSlotInstance.setInTime();
        LocalDate inDate = LocalDateTime.now().toLocalDate();
        assertEquals(0,
               inDate.compareTo(parkingSlotInstance.getInTime().toLocalDate()));
    }
    /**
     * Test : To set and check inTime using 2 param constructor.
     */
    //TODO Set and check the parking inTime using 2 param constructor.
    @Test
    public void testSetAndCheckInTimeUsing2ParamConst() {
        parkingSlotInstance = new ParkingSlot(slotNo, "TS2E123");
        LocalDate inDate = LocalDateTime.now().toLocalDate();
        assertEquals(0,
               inDate.compareTo(parkingSlotInstance.getInTime().toLocalDate()));
    }
    /**
     * Test : To set and check inTime using 3 param constructor.
     */
    //TODO Set and check the parking inTime using 3 param constructor.
    @Test
    public void testSetAndCheckInTimeUsing3ParamConst() {
        parkingSlotInstance = new ParkingSlot(slotNo, "TS2E123", LocalDateTime.now());
        LocalDate inDate = LocalDateTime.now().toLocalDate();
        assertEquals(0,
               inDate.compareTo(parkingSlotInstance.getInTime().toLocalDate()));
    }
    /**
     * Test : To set and check inTime by params.
     */
    //TODO Set and check the parking inTime by params.
    @Test
    public void testSetAndCheckInTimeByParam() {
        LocalDate inDate = LocalDateTime.now().toLocalDate();
        parkingSlotInstance.setInTime(LocalDateTime.now());
        assertEquals(0,
               inDate.compareTo(parkingSlotInstance.getInTime().toLocalDate()));
    }
    /**
     * Test : To set and check parked vehicle object.
     */
    //TODO Set and check the parked vehicle object.
    @Test
    public void testSetAndCheckVehicle() {
        Vehicle vehicleObject = new Car();
        vehicleObject.setRegistrationNumber("AP2E123");
        parkingSlotInstance.setVehicleObject(vehicleObject);
        assertEquals(vehicleObject, parkingSlotInstance.getVehicleObject());
    }
    /**
     * Test : To set and check parked vehicle object using 2 param constructor.
     */
    //TODO Set and check the parked vehicle object using 2 param constructor.
    @Test
    public void testSetAndCheckVehicleUsing2ParamConst() {
        parkingSlotInstance = new ParkingSlot(slotNo, "TS2E123");
        assertEquals("TS2E123", parkingSlotInstance.getVehicleObject().getRegistrationNumber());
    }
    /**
     * Test : To set and check parked vehicle object using 3 param constructor.
     */
    //TODO Set and check the parked vehicle object using 3 param constructor.
    @Test
    public void testSetAndCheckVehicleUsing3ParamConst() {
        parkingSlotInstance = new ParkingSlot(slotNo, "TS2E123", LocalDateTime.now());
        assertEquals("TS2E123", parkingSlotInstance.getVehicleObject().getRegistrationNumber());
    }
}
