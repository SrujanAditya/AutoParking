package com.epam.rdtraining.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.rdtraining.customexceptions.InvalidSlotNumberException;
import com.epam.rdtraining.parkingservices.Parking;
import com.epam.rdtraining.parkingservices.ParkingOperations;

/**
 * Servlet implementation class SlotsServlet.
 * This servlet is used to get the request with params as number of slots,
 * which is used to assign the number of parking slots.
 */
@WebServlet("/SlotsServlet")
public class SlotsServlet extends HttpServlet {
    /**
     * It is a serializable class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlotsServlet() {
        super();
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
        try {
            String slots = request.getParameter("noOfSlots");
            if (!slots.matches("[0-9]+") || Integer.parseInt(slots) <= 0) {
                throw new InvalidSlotNumberException();
            } else {
                final ParkingOperations parkingOpInstance = new ParkingOperations();
                parkingOpInstance.setAndStoreParkingSlots(Integer.parseInt(slots));
                String displayslots = Parking.displaySlots();
                request.setAttribute("displayslots", displayslots.replaceAll("\n", ";").replaceAll("\t", ","));
                request.getRequestDispatcher("Home.jsp").include(request, response);
            }
        } catch (InvalidSlotNumberException e) {
            request.setAttribute("message", "Invalid Number Of Slots");
            request.getRequestDispatcher("SlotsPage.jsp").include(request, response);
        }
    }

}
