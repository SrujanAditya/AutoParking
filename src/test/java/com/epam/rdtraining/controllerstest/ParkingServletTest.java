package com.epam.rdtraining.controllerstest;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.epam.rdtraining.controllers.ParkingServlet;
import com.epam.rdtraining.customexceptions.InvalidVehicleNumberException;

/**
 * @author Srujan_Aditya
 *
 */
public class ParkingServletTest {
    /**
     * To Inject mock to the loginServlet class.
     */
    @InjectMocks
    private ParkingServlet instance = new ParkingServlet();
    /**
     * http request.
     */
    private HttpServletRequest request;
    /**
     * http response.
     */
    private HttpServletResponse response;
    /**
     * PerformOpeartions instance.
     */
    private PerformOpeartions performOp;
    /**
     * To setUp The required params and variables before running the test.
     * @throws IOException  e
     * @throws ServletException s
     */
    @Before
    public void setUp() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        PrintWriter out = Mockito.mock(PrintWriter.class);
        performOp = new PerformOpeartions();
        Mockito.when(request.getSession()).thenReturn(Mockito.mock(HttpSession.class));
        Mockito.when(response.getWriter()).thenReturn(out);
    }
    /**
     * Test : To check the vehicle number with valid number.
     * @throws IOException  io
     * @throws ServletException servlet
     * @throws InvalidVehicleNumberException  exception
     */
    // TODO check the vehicle number with valid number.
    @Test
    public void testCheckVehicleNumberValid() throws ServletException, IOException, InvalidVehicleNumberException {
        assertTrue("Valid Vehicle Number", instance.checkVehicleNumber(request, response, "ts2e123", performOp));
    }
    /**
     * Test : doPost method of ParkingServlet to check park function.
     * @throws IOException      io
     * @throws ServletException servlet
     */
    // TODO Test the doPost method of ParkingServlet to check park function.
    @Test
    public void testParkingServletDoPostPark() throws ServletException, IOException {
        Mockito.when(request.getParameter("choice")).thenReturn("1");
        Mockito.when(request.getParameter("vehicleNo")).thenReturn("ts2e123");
        //instance.doPost(request, response);
    }
}
