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

import com.epam.rdtraining.controllers.SlotsServlet;

/**
 * @author Srujan_Aditya
 *
 */
public class SlotsServletTest {
    /**
     * To Inject mock to the loginServlet class.
     */
    @InjectMocks
    private SlotsServlet instance = new SlotsServlet();
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
     * Test : doPost method of SlotServlet with invalid slot number(no digits).
     * @throws IOException  io
     * @throws ServletException servlet
     */
    // TODO Test the doPost method of LoginServlet with invalid slot number(no digits).
    @Test
    public void testSlotServletDoPostWithInvalidSlot() throws ServletException, IOException {
        Mockito.when(request.getParameter("noOfSlots")).thenReturn("admin");
        RequestDispatcher patch = Mockito.mock(RequestDispatcher.class);
        Mockito.when(request.getRequestDispatcher("SlotsPage.jsp")).thenReturn(patch);
        instance.doPost(request, response);
    }
    /**
     * Test : doPost method of SlotServlet with invalid negative slot number.
     * @throws IOException  io
     * @throws ServletException servlet
     */
    // TODO Test the doPost method of LoginServlet with invalid negative slot number.
    @Test
    public void testSlotServletDoPostWithInvalidNegativeSlot() throws ServletException, IOException {
        Mockito.when(request.getParameter("noOfSlots")).thenReturn("-5");
        RequestDispatcher patch = Mockito.mock(RequestDispatcher.class);
        Mockito.when(request.getRequestDispatcher("SlotsPage.jsp")).thenReturn(patch);
        instance.doPost(request, response);
    }
    /**
     * Test : doPost method of SlotServlet with zero slot number.
     * @throws IOException  io
     * @throws ServletException servlet
     */
    // TODO Test the doPost method of LoginServlet with zero slot number.
    @Test
    public void testSlotServletDoPostWithZeroSlot() throws ServletException, IOException {
        Mockito.when(request.getParameter("noOfSlots")).thenReturn("0");
        RequestDispatcher patch = Mockito.mock(RequestDispatcher.class);
        Mockito.when(request.getRequestDispatcher("SlotsPage.jsp")).thenReturn(patch);
        instance.doPost(request, response);
    }
    /**
     * Test : doPost method of SlotServlet with valid slot number.
     * @throws IOException  io
     * @throws ServletException servlet
     */
    // TODO Test the doPost method of LoginServlet with valid slot number.
    @Test
    public void testSlotServletDoPostWithValidSlot() throws ServletException, IOException {
        Mockito.when(request.getParameter("noOfSlots")).thenReturn("5");
        RequestDispatcher patch = Mockito.mock(RequestDispatcher.class);
        Mockito.when(request.getRequestDispatcher("Home.jsp")).thenReturn(patch);
        instance.doPost(request, response);
    }
}
