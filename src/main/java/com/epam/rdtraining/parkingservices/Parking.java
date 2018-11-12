package com.epam.rdtraining.parkingservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * This class contains all the methods which are used for parking,
 * unpark, displaySlots, checkAvailableSlots, isParkingFull.
 * @author Srujan_Aditya
 * @version 1.0.0
 */
public class Parking {
    /**
     * to Store the string which is to be printed.
     */
    private static String printString;
    /**
     * ArrayList used to store parked vechicle numbers.
     */
    private static List<Integer> availableSlots;
    /**
     * Map variable to store the vehicle number as key
     * and parkingSlots object as value.
     * Value object contains slot number, vehicle object and intime.
     */
    private static Map<String, ParkingSlot> parkedVehicle;
    /**
     * This method is used to set the number of parking slots.
     * @param slots no of parking slots
     */
    public void setNoOfSlots(final int slots) {
        setAvailableSlots(new ArrayList<Integer>());
        IntStream.range(1, slots + 1).forEach(iterator -> {
            availableSlots.add(iterator);
        });
        setParkedVehicle(new HashMap<String, ParkingSlot>());
    }
    /**
     * This method is used to set the available slot list.
     * @param slotsAvailable array of available slots.
     */
    public static void setAvailableSlots(final List<Integer> slotsAvailable) {
        Parking.availableSlots = slotsAvailable;
    }
    /**
     * @return the availableSlots
     */
    public static List<Integer> getAvailableSlots() {
        return availableSlots;
    }
    /**
     * This method is used to set the Map with parked vehicle details.
     * @param vehiclesParked set hashmap with parked vehicle details.
     */
    public static void setParkedVehicle(final Map<String, ParkingSlot> vehiclesParked) {
        Parking.parkedVehicle = vehiclesParked;
    }
    /**
     * This method is used to return the parkedVehicle map.
     * @return the parkedVehicle
     */
    public static Map<String, ParkingSlot> getParkedVehicle() {
        return parkedVehicle;
    }
    /**
     * Used to display the slot and vehicle mapping.
     * @return result string
     */
    public static String  displaySlots() {
        printString = "Slot \t Vechicle Number \t InTime\n";
        if (getParkedVehicle() != null) {
            getParkedVehicle().forEach((key, value) -> {
                printString += value.getSlotNo() + " \t" + key
                        + " \t" + value.getInTime() + "\n";
            });
        }
        return printString;
    }
    /**
     * This method is used to map the vehicle with available slot.
     * @param regNo store the vehicle registration number
     * @return parking slot object
     */
    public ParkingSlot park(final String regNo) {
        ParkingSlot parkingSlotInstance = new ParkingSlot(availableSlots.get(availableSlots.size() - 1), regNo);
        availableSlots.remove(availableSlots.size() - 1);
        parkedVehicle.put(regNo, parkingSlotInstance);
        return parkingSlotInstance;
    }
    /**
     * This method is used to unpark the vehicle
     * by clearing the mapping with slot number.
     * And adding the slot number in the available slots array.
     * @param regNo vechile registration number
     * @return parking slot instance which is unparked
     */
    public ParkingSlot unpark(final String regNo) {
        ParkingSlot parkingSlotInstance = parkedVehicle.get(regNo);
        parkedVehicle.remove(regNo);
        availableSlots.add(parkingSlotInstance.getSlotNo());
        return parkingSlotInstance;
    }
    /**
     * This method is used to check whether the vehicle
     * is available in the parking area or not.
     * @param regNo vehicle registration number.
     * @return check if vehicle is available in the parking area or no
     */
    public boolean checkIfVehicleAvailable(final String regNo) {
        return (getParkedVehicle().containsKey(regNo)) ? true : false;
    }
    /**
     * This method is used check whether the parking is full or not.
     * @return if parking is full or not
     */
    public boolean isParkingFull() {
        return getAvailableSlots().isEmpty();
    }
}
