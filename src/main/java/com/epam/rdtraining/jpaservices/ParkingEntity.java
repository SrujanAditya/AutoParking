package com.epam.rdtraining.jpaservices;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ParkinEntity.
 *
 */
@Entity
@Table(name = "CURRENT_PARKING_AREA")
public class ParkingEntity implements Serializable {
    /**
     * slot number.
     */
    @Column(name = "SLOT_NO")
    private int slotNo;
    /**
     * vehicle number: primary key.
     */
    @Id
    @Column(name = "VEHICLE_NO")
    private String vehicleNo;
    /**
     * in time.
     */
    @Column(name = "IN_TIME")
    private LocalDateTime inTime;
    /**
     * parking assigned by id.
     */
    @Column(name = "ASSIGNED_BY_ID")
    private int assignedById;
    /**
     * unpark assigned by id.
     */
    @Column(name = "PARKING_AREA_ID")
    private int parkingAreaId;
    private static final long serialVersionUID = 1L;
    /**
     * default constructor.
     */
    public ParkingEntity() {
        super();
    }
    /**
     * Parametereised constructor.
     * @param slot slot number
     * @param vehicleNum vehilce number
     * @param assignedByid assigned by
     * @param parkingAreaid parking area id
     */
    public ParkingEntity(final int slot, final String vehicleNum,
            final int assignedByid, final int parkingAreaid) {
        this.slotNo = slot;
        this.vehicleNo = vehicleNum;
        this.inTime = LocalDateTime.now();
        this.assignedById = assignedByid;
        this.parkingAreaId = parkingAreaid;
    }
    /**
     * get slot number method.
     * @return slot number
     */
    public int getSlotNo() {
        return this.slotNo;
    }
    /**
     * set slot number method.
     * @param slot number
     */
    public void setSlotNo(final int slot) {
        this.slotNo = slot;
    }
    /**
     * get vehicle number method.
     * @return number
     */
    public String getVehicleNo() {
        return this.vehicleNo;
    }
    /**
     * set vehicle number method.
     * @param vehicleNum number
     */
    public void setVehicleNo(final String vehicleNum) {
        this.vehicleNo = vehicleNum;
    }
    /**
     * get local time method.
     * @return time
     */
    public LocalDateTime getInTime() {
        return this.inTime;
    }
    /**
     * set local time method.
     * @param intime time
     */
    public void setInTime(final LocalDateTime intime) {
        this.inTime = intime;
    }
    /**
     * get assigned by id method.
     * @return id
     */
    public int getAssignedById() {
        return this.assignedById;
    }
    /**
     * set assigned by id method.
     * @param assignedByid id
     */
    public void setAssignedById(final int assignedByid) {
        this.assignedById = assignedByid;
    }
    /**
     * get parking area id method.
     * @return parking area id
     */
    public int getParkingAreaId() {
        return this.parkingAreaId;
    }
    /**
     * set parking area id method.
     * @param parkingAreaid id
     */
    public void setParkingAreaId(final int parkingAreaid) {
        this.parkingAreaId = parkingAreaid;
    }

}
