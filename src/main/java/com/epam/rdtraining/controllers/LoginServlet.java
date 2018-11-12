package com.epam.rdtraining.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.rdtraining.consoleservices.PopulateData;
import com.epam.rdtraining.parkingfilesdao.StoreNoOfSlotsInFile;
import com.epam.rdtraining.users.AdminLogin;

/**
 * Servlet implementation class LoginServlet.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    /**
     * It is a serializable class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * This is a used to check the user name and password, and perform the login operation.
     * @param request  request from client
     * @param response response to the client
     * @throws ServletException servlet exception
     * @throws IOException      IoException
     */
    @Override
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("pass");
        final AdminLogin loginInstance = new AdminLogin();
        if (loginInstance.login(userName, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminID", userName);
            StoreNoOfSlotsInFile storeFileInstance = StoreNoOfSlotsInFile.getInstance();
            if (storeFileInstance.checkIfFileExists()) {
                PopulateData populateInstance = new PopulateData();
                populateInstance.populate();
                response.sendRedirect("Home.jsp");
            } else {
                response.sendRedirect("SlotsPage.jsp");
            }
        } else {
            request.setAttribute("message", "Invalid Credentials");
            request.getRequestDispatcher("loginPage.jsp").include(request, response);
        }
    }
}
