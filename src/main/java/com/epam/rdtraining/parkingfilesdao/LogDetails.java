package com.epam.rdtraining.parkingfilesdao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Properties;

import com.epam.rdtraining.parkingservices.ParkingSlot;
/**
 * to log all the details into log file.
 * @author Srujan_Aditya
 *
 */
public class LogDetails {
    /**
     * static instance of the class.
     */
    private static LogDetails logInstance = new LogDetails();
    /**
     * inputFile which stores all the parked vehicle details.
     */
    private static String inputFile;
    static {
        Properties prop = new Properties();
        try {
            prop.load(LogDetails.class.getResourceAsStream("/AutoParking.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputFile = prop.getProperty("LogTxt");
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
    public static synchronized LogDetails getInstance() {
        return logInstance;
    }
    /**
     * to log all the vehicle parked and unparked details.
     * @param parkingSlotObject parkingslot instance
     * @param time out time
     */
    public void logDetails(
            final ParkingSlot parkingSlotObject, final LocalDateTime time) {
        try (PrintWriter printWriter = new PrintWriter(getFileWriter())) {
            printWriter.print(
                parkingSlotObject.getVehicleObject().getRegistrationNumber()
                        + "," + parkingSlotObject.getSlotNo()
                        + "," + parkingSlotObject.getInTime());
            if (time != null) {
                    printWriter.println("," + time + "-> UnParked");
            } else {
                printWriter.println("-> Parked");
            }
            printWriter.flush();
        }
    }
}
