package com.epam.rdtraining.parkingservices;

import java.time.LocalDateTime;

import com.epam.rdtraining.parkingfilesdao.FileOperations;
import com.epam.rdtraining.parkingfilesdao.StoreNoOfSlotsInFile;


/**
 * Parking class contains the attributes as:.
 * parked vechile number
 * isAvailable
 * @author Srujan_Aditya
 * @version 1.0.0
 */
public class ParkingOperations {
    /**
     * Parking class instance.
     */
    private final Parking parkingInstance = new Parking();
    /**
     * This method is used to set the slot number
     * and store it in a file.
     * @param slots number of slots
     */
    public void setAndStoreParkingSlots(final int slots) {
        parkingInstance.setNoOfSlots(slots);
        StoreNoOfSlotsInFile storeFileInstance
                = StoreNoOfSlotsInFile.getInstance();
        storeFileInstance.storeNumberOfSlots(slots);
    }
    /**
     * Check whether the parking is full or not.
     * Then call the park method passing vehicle number and parkingSlot object.
     * @param regNo vehicle registration number
     * @return result string
     */
    public String performParkOperation(final String regNo) {
        String resultString = "";
        if (!parkingInstance.isParkingFull()
                && !parkingInstance.checkIfVehicleAvailable(regNo)) {
            ParkingSlot parkingSlotInstance = parkingInstance.park(regNo);
            resultString = printParkedVehicleDetails(parkingSlotInstance);
            final FileOperations fileObject = FileOperations.getInstance();
            fileObject.parkedVehicleDetails(parkingSlotInstance);
        } else {
            if (parkingInstance.checkIfVehicleAvailable(regNo)) {
                resultString = "Vehicle already available.";
            } else {
                resultString = "Parking Full";
            }
        }
        System.out.println(resultString);
        return resultString;
    }
    /**
     * This method is used to print the summary of the parked vehicle.
     * @param parkingSlotInstance unparked vehicle instance
     * @return result string
     */
    public String printParkedVehicleDetails(
            final ParkingSlot parkingSlotInstance) {
       return ("Vehicle Parked Successfully\nVehicle Number : "
        + parkingSlotInstance.getVehicleObject().getRegistrationNumber()
        + "\nSlot Number : " + parkingSlotInstance.getSlotNo()
        + "\nIn Time : " + parkingSlotInstance.getInTime());
    }
    /**
     * Check whether the vehicle is available in the parking area.
     * perform unpark operation.
     * and display the details of unparked vehicle.
     * @param regNo vehicle registration number
     * @return result string
     */
    public String performUnparkOperation(final String regNo) {
        String resultString = "";
        if (parkingInstance.checkIfVehicleAvailable(regNo)) {
            ParkingSlot parkingSlotInstance = parkingInstance.unpark(regNo);
            resultString = printUnparkedVehicleDetails(parkingSlotInstance);
            FileOperations fileObject = FileOperations.getInstance();
            fileObject.unparkedVehicleDetails(parkingSlotInstance);
        } else {
            resultString = "Vehicle Unavailable";
        }
        System.out.println(resultString);
        return resultString;
    }
    /**
     * This method is used to print the summary of the unparked vehicle.
     * @param parkingSlotInstance unparked vehicle instance
     * @return result string
     */
    public String printUnparkedVehicleDetails(
            final ParkingSlot parkingSlotInstance) {
        return ("Vehicle Unparked Successfully\nVehicle Number : "
        + parkingSlotInstance.getVehicleObject().getRegistrationNumber()
        + "\nSlot Number : " + parkingSlotInstance.getSlotNo()
        + "\nIn Time : " + parkingSlotInstance.getInTime()
        + "\nOut Time : " + LocalDateTime.now());
    }
}
