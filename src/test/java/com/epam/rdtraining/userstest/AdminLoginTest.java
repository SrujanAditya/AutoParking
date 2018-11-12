package com.epam.rdtraining.userstest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.epam.rdtraining.users.AdminLogin;

/**
 * This class contains test cases to validate the login method in AdminLogin
 * class.
 * @author Srujan_Aditya
 *
 */
public class AdminLoginTest {
    /**
     * To InjectMock for this class.
     */
    @InjectMocks
    private AdminLogin instance = new AdminLogin();

    /**
     * Before annotation.
     */
    @Before
    public void setUp() {
        org.mockito.MockitoAnnotations.initMocks(this);
        // instance = Mockito.mock(AdminLogin.class);
    }
    /**
     * Test : Admin Login with empty username and password.
     */
    // TODO Admin Login with empty username and password
    @Test
    public void testEmptyUAndP() {
        assertFalse("Invalid Credentials", instance.login("", ""));
    }
    /**
     * Test : Admin Login with wrong username and empty password.
     */
    // TODO Admin Login with wrong username and empty password
    @Test
    public void testWorngUAndEmptyP() {
        assertFalse("Invalid Credentials", instance.login("Test", ""));
    }
    /**
     * Test : Admin Login with empty username and worng password.
     */
    // TODO Admin Login with empty username and worng password
    @Test
    public void testEmptyUAndWrongP() {
        assertFalse("Invalid Credentials", instance.login("", "password@123"));
    }
    /**
     * Test : Admin Login with correct username and empty password.
     */
    // TODO Admin Login with correct username and empty password
    @Test
    public void testCorrectUAndEmptyP() {
        assertFalse("Invalid Credentials", instance.login("admin", ""));
    }
    /**
     * Test : Admin Login with correct username and wrong password.
     */
    // TODO Admin Login with correct username and wrong password
    @Test
    public void testCorrectUAndWrongP() {
        assertFalse("Invalid Credentials",
                    instance.login("admin", "password@123"));
    }
    /**
     * Test : Admin Login with empty username and correct password.
     */
    // TODO Admin Login with empty username and correct password
    @Test
    public void testEmptyUAndCorrectP() {
        assertFalse("Invalid Credentials", instance.login("", "epam123"));
    }
    /**
     * Test : Admin Login with wrong username and correct password.
     */
    // TODO Admin Login with wrong username and correct password
    @Test
    public void testWrongUAndCorrectP() {
        assertFalse("Invalid Credentials", instance.login("Users", "epam123"));
    }
    /**
     * Test : Admin Login with correct username and correct password.
     */
    // TODO Admin Login with correct username and correct password
    @Test
    public void testCorrectUAndCorrectP() {
        assertTrue("Valid Credentials", instance.login("admin", "epam123"));
    }
}
