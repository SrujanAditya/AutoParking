package com.epam.rdtraining.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.rdtraining.consoleservices.PerformOpeartions;
import com.epam.rdtraining.customexceptions.InvalidVehicleNumberException;
import com.epam.rdtraining.parkingservices.ParkingOperations;

/**
 * Servlet implementation class ParkingServlet.
 */
@WebServlet("/ParkingServlet")
public class ParkingServlet extends HttpServlet {
    /**
     * It is a serializable class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParkingServlet() {
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int choice = Integer.parseInt(request.getParameter("choice"));
        String vehicleNo = request.getParameter("vehicleNo");
        final PerformOpeartions performOp = new PerformOpeartions();
        final ParkingOperations parkingOpInstance = new ParkingOperations();
        String resultString = "";
        switch (choice) {
        case 1:
            if (checkVehicleNumber(request, response, vehicleNo, performOp)) {
                resultString = parkingOpInstance.performParkOperation(vehicleNo);
            }
            break;
        case 2:
            if (checkVehicleNumber(request, response, vehicleNo, performOp)) {
                resultString = parkingOpInstance.performUnparkOperation(vehicleNo);
            }
            break;
        case 4:
            resultString = performOp.resetAllFilesAndData();
            response.sendRedirect("SlotsPage.jsp");
            break;
        default:
            out.println("Wrong Choice!!!");
        }
        if (choice != 4) {
            out.println(resultString.replaceAll("\n", "<br>").replaceAll("\t", "&nbsp&nbsp&nbsp&nbsp"));
        }
    }

    /**
     * to check and display the appropriate message if the vehicle number is wrong.
     * @param request http request
     * @param response http response
     * @param vehicleNo vehicle number
     * @param performOp perform operation instance
     * @return return boolean if the vehicle number is true or false
     * @throws ServletException servlet exception
     * @throws IOException IOException
     */
    public boolean checkVehicleNumber(final HttpServletRequest request,
            final HttpServletResponse response,
            final String vehicleNo, final PerformOpeartions performOp)
                    throws ServletException, IOException {
        boolean terminateFlag = false;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            terminateFlag = performOp.checkVehicleRegNo(vehicleNo);
        } catch (InvalidVehicleNumberException e) {
            out.println(e.getMessage());
        }
        return terminateFlag;
    }

}
