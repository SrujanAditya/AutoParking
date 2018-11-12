package com.epam.rdtraining.consoleservices;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.epam.rdtraining.parkingfilesdao.StoreNoOfSlotsInFile;
import com.epam.rdtraining.parkingservices.Parking;
import com.epam.rdtraining.parkingservices.ParkingSlot;

/**
 * @author Srujan_Aditya
 *
 */
public class PopulateData {
    /**
     * ParkedSlots array.
     */
    private List<Integer> parkedSlots = new ArrayList<Integer>();
    /**
     * This method is used to populate the map
     * and available slots data in the parking class.
     */
    public void populate() {
        StoreNoOfSlotsInFile storeFileInstance
            = StoreNoOfSlotsInFile.getInstance();
        int noOfSlots = storeFileInstance.readNoOfSlots();
        File parkingDetails = new File("D:/ParkingInfo.csv");
        if  (parkingDetails.exists()) {
            Map<String, ParkingSlot> restoreData = populateVehicleMap(noOfSlots);
            Parking.setParkedVehicle(restoreData);
        }
        List<Integer> availableSlots = populateAvailableSlots(noOfSlots);
        Parking.setAvailableSlots(availableSlots);
    }
    /**
     * populate the available vehicles details in the map.
     * @param slots number of slots
     * @return hashmap with parked vehicle details
     */
    public Map<String, ParkingSlot> populateVehicleMap(final int slots) {
        Map<String, ParkingSlot> restoreData
            = new HashMap<String, ParkingSlot>();
        try (Stream<String> stream = Files.lines(
                Paths.get("D:/ParkingInfo.csv"))) {
            stream.forEach(line -> {
                if (line.length() > 1) {
                    String[] splitLine = line.split(",");
                    ParkingSlot parkingSlotInstance
                        = new ParkingSlot(Integer.parseInt(splitLine[1]),
                                splitLine[0],
                                LocalDateTime.parse(splitLine[2]));
                    restoreData.put(splitLine[0], parkingSlotInstance);
                    parkedSlots.add(Integer.parseInt(splitLine[1]));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restoreData;
    }
    /**
     * Return the available slots arraylist.
     * @param slots number of slots.
     * @return available slots.
     */
    public List<Integer> populateAvailableSlots(final int slots) {
        List<Integer> restoreSlots = new ArrayList<Integer>();
        IntStream.range(1, slots + 1).forEach(iterator -> {
            if (!parkedSlots.contains(iterator)) {
                restoreSlots.add(iterator);
            }
        });
        return restoreSlots;
    }
}
