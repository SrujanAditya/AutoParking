package com.epam.rdtraining.parkingservices;
import java.time.LocalDateTime;
import com.epam.rdtraining.entities.Car;
import com.epam.rdtraining.entities.Vehicle;
/**
 * This class contains attributes as slot number,
 * vehicle which is parked in this slot,
 * in time of the vehicle.
 * @author Srujan Aditya
 * @version 1.0.0
 */
public class ParkingSlot {
    /**
     * Parking slot number.
     */
    private int slotNo;
    /**
     * Vehicle object which is parked in this slot.
     */
    private Vehicle vehicleObject;
    /**
     * inTime of the vehicle parked.
     */
    private LocalDateTime inTime;
    /**
     * Default Constructor.
     */
    public ParkingSlot() { }
    /**
     * To set the parkingSlot attributes like slot and vehicle object.
     * @param slot parking slot number
     * @param vehicleNo vehicle number
     */
    public ParkingSlot(final int slot, final String vehicleNo) {
        this.slotNo = slot;
        this.vehicleObject = new Car();
        vehicleObject.setRegistrationNumber(vehicleNo);
        this.inTime = LocalDateTime.now();
    }
    /**
     * To set the parkingSlot attributes like slot, vehicle object and inTime.
     * @param slot parking slot number
     * @param vehicleNo vehicle number
     * @param timeIn In time of the vehicle
     */
    public ParkingSlot(final int slot, final String vehicleNo, final LocalDateTime timeIn) {
        this.slotNo = slot;
        this.vehicleObject = new Car();
        vehicleObject.setRegistrationNumber(vehicleNo);
        this.inTime = timeIn;
    }
    /**
     * To get the slot number.
     * @return slot number
     */
    public int getSlotNo() {
      return slotNo;
    }
    /**
     * This method is used to set the slot number.
     * @param slot slot number in the parking slot
     */
    public void setSlotNo(final int slot) {
      this.slotNo = slot;
    }
    /**
     * To get the vehicle object which is parked in this slot.
     * @return vehicle object
     */
    public Vehicle getVehicleObject() {
      return vehicleObject;
    }
    /**
     * Set the vehicle object which is parked.
     * @param vehicleObj vehicle object
     */
    public void setVehicleObject(final Vehicle vehicleObj) {
      this.vehicleObject = vehicleObj;
    }
    /**
     * to get the in time of the vehicle.
     * @return in time of the vehicle parked
     */
    public LocalDateTime getInTime() {
      return inTime;
    }
    /**
     * To set the in time of the vehicle.
     */
    public void setInTime() {
      this.inTime = LocalDateTime.now();
    }
    /**
     * To set the in time of the vehicle.
     * @param timeIn in time of the vehicle
     */
    public void setInTime(final LocalDateTime timeIn) {
      this.inTime = timeIn;
    }
}