package com.epam.rdtraining.jpaservices;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ParkingAreaEntity.
 *
 */
@Entity
@Table(name = "PARKING_AREA")
public class ParkingAreaEntity implements Serializable {
    /**
     * Primary Key is auto generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * Name of the parking area.
     */
    private String parkingAreaName;
    /**
     * Number of slots in the parking area.
     */
    private int noOfSlots;
    private static final long serialVersionUID = 1L;
    /**
     * Default constructor.
     */
    public ParkingAreaEntity() {
        super();
    }
    /**
     * Id getter method.
     * @return id
     */
    public int getID() {
        return this.id;
    }
    /**
     * Id setter method.
     * @param token id
     */
    public void setID(final int token) {
        this.id = token;
    }
    /**
     * parking area name getter method.
     * @return parking area name
     */
    public String getParkingAreaName() {
        return this.parkingAreaName;
    }
    /**
     * Parking area setter method.
     * @param name name
     */
    public void setParkingAreaName(final String name) {
        this.parkingAreaName = name;
    }
    /**
     * number of slots setter method.
     * @return no of slots
     */
    public int getNoOfSlots() {
        return this.noOfSlots;
    }
    /**
     * set number of slots.
     * @param slots number
     */
    public void setNoOfSlots(final int slots) {
        this.noOfSlots = slots;
    }

}
