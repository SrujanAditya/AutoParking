package com.epam.rdtraining.jpaservices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA operations class.
 * @author Srujan_Aditya
 *
 */
public final class JpaOperations {
    /**
     * Static instance of the class.
     */
    private static JpaOperations jpaOperations;
    /**
     * Static instance of EntityManagerFactory.
     */
    private static EntityManagerFactory factory;
    /**
     * Static instance of EntityManager.
     */
    private static EntityManager manager;
    /**
     * Default constructor.
     */
    private JpaOperations() {
        init();
    }
    /**
     * to get the static instance of the class.
     * @return instance
     */
    public static JpaOperations getInstance() {
            jpaOperations  = new JpaOperations();
        return jpaOperations;
    }
    /**
     * Init method to declare the entityManager factory and entity manager.
     */
    private void init() {
        factory = Persistence.createEntityManagerFactory("autoparking");
        manager = factory.createEntityManager();
    }
    /**
     * To perform park operation.
     * @param slotno slot number
     * @param vehicleNo vehicle number
     * @param assignedById assigned by id
     * @param parkingAreaId parking area id
     */
    public void park(final int slotno, final String vehicleNo,
            final int assignedById, final int parkingAreaId) {
        manager.getTransaction().begin();
        ParkingEntity entity = new ParkingEntity(slotno, vehicleNo, assignedById, parkingAreaId);
        manager.persist(entity);
        manager.getTransaction().commit();
    }
    /**
     * unpark operation.
     * @param vehicleNo vehicle number
     * @param unassignedById unassigned by id
     */
    public void unpark(final String vehicleNo, final int unassignedById) {
        manager.getTransaction().begin();
        ParkingEntity record = manager.find(ParkingEntity.class, vehicleNo);
        System.out.println(record);
        ParkingLogEntity logEntity
            = new ParkingLogEntity(record.getSlotNo(),
                record.getVehicleNo(), record.getInTime(),
                record.getAssignedById(), unassignedById,
                record.getParkingAreaId());
        manager.remove(record);
        manager.persist(logEntity);
        manager.getTransaction().commit();
    }
    /*
    public List<String> adminLogin(final String username, final String password) {
        List<String> privileges = null;
        String statement = "SELECT ROLE_ID,ID FROM AUTOPARKING.PARKING_USER "
                + "WHERE USERNAME=\"" + username +"\" and PASSWORD=\"" + password +"\";";
        Query query = manager.createNativeQuery(statement);
        if (!query.getResultList().isEmpty()) {
            privileges = query.getResultList();
        }
        System.out.println(privileges);
        return privileges;
    }*/
}
