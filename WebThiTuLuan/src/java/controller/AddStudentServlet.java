/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rio.Rai
 */
public class AddStudentServlet extends HttpServlet {

    UserDao userDao = new UserDao();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String userName = request.getParameter("username");
        String password = request.getParameter("pass");
        String type = request.getParameter("type");
        String url = "";

        try {
            if (userDao.checkUserName(userName)) {
                url = "/addS.jsp";
                session.setAttribute("message", "<div class=\"alert alert-danger\" role=\"alert\">\n"
                        + "  User Name already exist!\n"
                        + "</div>");
            } else {
                url = "/addS.jsp";
                userDao.insertNewUser(userName, password, type);
                session.setAttribute("message", "<div class=\"alert alert-success\" role=\"alert\">\n"
                        + "  Add Student Success!\n"
                        + "</div>");

            }
        } catch (SQLException ex) {
            Logger.getLogger(AddStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
