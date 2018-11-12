package com.epam.rdtraining.jpaservices;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: UserRolesEntity.
 *
 */
@Entity
@Table(name = "USER_ROLES")
public class UserRolesEntity implements Serializable {
    /**
     * Role_id : primary key.
     */
    @Id
    @Column(name = "ROLE_ID")
    private int roleId;
    /**
     * access permission for the user.
     */
    @Column(name = "ACCESS_PERMISSION")
    private String accessPermission;
    private static final long serialVersionUID = 1L;
    /**
     * default constructor.
     */
    public UserRolesEntity() {
        super();
    }
    /**
     * get role id.
     * @return id
     */
    public int getRoleId() {
        return this.roleId;
    }
    /**
     * Set role Id.
     * @param roleid id
     */
    public void setRoleId(final int roleid) {
        this.roleId = roleid;
    }
    /**
     * get access permissions.
     * @return access permission
     */
    public String getAccessPermission() {
        return this.accessPermission;
    }
    /**
     * set access permissions.
     * @param permission accessPermission
     */
    public void setAccessPermission(final String permission) {
        this.accessPermission = permission;
    }

}
