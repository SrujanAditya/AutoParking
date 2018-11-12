package com.epam.rdtraining.jpaservices;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ParkingUsersEntity.
 *
 */
@Entity
@Table(name = "PARKING_USER")
public class ParkingUsersEntity implements Serializable {
    /**
     * Id : primary key.
     */
    @Id
    @Column(name = "ID")
    private int id;
    /**
     * User Name.
     */
    @Column(name = "USERNAME")
    private String userName;
    /**
     * Password.
     */
    @Column(name = "PASSWORD")
    private String password;
    /**
     * Foreign key: role ID.
     */
    @Column(name = "ROLE_ID")
    private int roleId;
    private static final long serialVersionUID = 1L;
    /**
     * default constructor.
     */
    public ParkingUsersEntity() {
        super();
    }
    /**
     * get id.
     * @return id
     */
    public int getId() {
        return this.id;
    }
    /**
     * set id.
     * @param iD id
     */
    public void setID(final int iD) {
        this.id = iD;
    }
    /**
     * get username.
     * @return name
     */
    public String getUserName() {
        return this.userName;
    }
    /**
     * set username.
     * @param username name
     */
    public void setUserName(final String username) {
        this.userName = username;
    }
    /**
     * get password.
     * @return password
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * set password.
     * @param pass password
     */
    public void setPassword(final String pass) {
        this.password = pass;
    }
    /**
     * get role id.
     * @return id
     */
    public int getRoleID() {
        return this.roleId;
    }
    /**
     * set role id.
     * @param roleID id
     */
    public void setRoleID(final int roleID) {
        this.roleId = roleID;
    }

}
