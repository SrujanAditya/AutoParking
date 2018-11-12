package com.epam.rdtraining.controllerstest;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.rdtraining.controllers.LogOutServlet;

/**
 * @author Srujan_Aditya
 *
 */
public class LogOutServletTest {
    /**
     * To Inject mock to the loginServlet class.
     */
    @InjectMocks
    private LogOutServlet instance = new LogOutServlet();
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
     * @throws IOException  e
     * @throws ServletException s
     */
    @Before
    public void setUp() throws ServletException, IOException {
        MockitoAnnotations.initMocks(this);
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        Mockito.when(request.getSession()).thenReturn(Mockito.mock(HttpSession.class));
    }
    /**
     * Test : To check the doGet method of logoutservlet.
     * @throws IOException  io
     * @throws ServletException servlet
     */
    // TODO To check the doGet method of logoutservlet.
    @Test
    public void testLogoutServletDeGet() throws ServletException, IOException {
        instance.doGet(request, response);
    }

}
