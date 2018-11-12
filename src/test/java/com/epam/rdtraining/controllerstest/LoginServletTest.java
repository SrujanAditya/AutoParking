package com.epam.rdtraining.controllerstest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.rdtraining.consoleservices.PerformOpeartions;
import com.epam.rdtraining.controllers.LoginServlet;
import com.epam.rdtraining.parkingservices.ParkingOperations;

/**
 * @author Srujan_Aditya
 *
 */
public class LoginServletTest {
    /**
     * To Inject mock to the loginServlet class.
     */
    @InjectMocks
    private LoginServlet instance = new LoginServlet();
    /**
     * http request.
     */
    private HttpServletRequest request;
    /**
     * http response.
     */
    private HttpServletResponse response;
    /**
     * To setUp The required params and variables before running the test.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        Mockito.when(request.getSession()).thenReturn(Mockito.mock(HttpSession.class));
    }

    /**
     * Test : doPost method of LoginServlet with valid creds.
     * @throws IOException  io
     * @throws ServletException servlet
     */
    // TODO Test the doPost method of LoginServlet with valid creds.
    @Test
    public void testLoginServletDoPostWithValidCreds() throws ServletException, IOException {
        Mockito.when(request.getParameter("username")).thenReturn("admin");
        Mockito.when(request.getParameter("pass")).thenReturn("epam123");
        instance.doPost(request, response);
    }

    /**
     * Test : doPost method of LoginServlet with Invalid creds.
     * @throws IOException      io
     * @throws ServletException servlet
     */
    // TODO Test the doPost method of LoginServlet with Invalid creds.
    @Test
    public void testLoginServletDoPostWithInvalidCreds() throws ServletException, IOException {
        RequestDispatcher patch = Mockito.mock(RequestDispatcher.class);
        Mockito.when(request.getParameter("username")).thenReturn("ad3min");
        Mockito.when(request.getParameter("pass")).thenReturn("epam@123");
        Mockito.when(request.getRequestDispatcher("loginPage.jsp")).thenReturn(patch);
        instance.doPost(request, response);
    }
    /**
     * Test : doPost method of LoginServlet with Valid creds and no slots.
     * @throws IOException      io
     * @throws ServletException servlet
     */
    // TODO Test the doPost method of LoginServlet with Valid creds and no slots.
    @Test
    public void testLoginServletDoPostWithValidCredsAndNoSlots() throws ServletException, IOException {
        Mockito.when(request.getParameter("username")).thenReturn("admin");
        Mockito.when(request.getParameter("pass")).thenReturn("epam123");
        PerformOpeartions.reset();
        instance.doPost(request, response);
        final ParkingOperations parkingOpInstance = new ParkingOperations();
        parkingOpInstance.setAndStoreParkingSlots(5);
    }
}
