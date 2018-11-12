package com.epam.rdtraining.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutServlet.
 */
@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
    /**
     * It is a serializable class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is a used to perform the logout operation.
     * @param request  request from client
     * @param response response to the client
     * @throws ServletException servlet exception
     * @throws IOException      IoException
     */
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("loginPage.jsp");
    }
}
