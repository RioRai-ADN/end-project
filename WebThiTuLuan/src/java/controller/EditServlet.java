/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestDao;
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

/**
 *
 * @author Rio.Rai
 */
public class EditServlet extends HttpServlet {

    QuestDao qd = new QuestDao();
    
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
        
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String url = "";
        int stt = 0;
        String editQuest = "";
        String editAnswer = "";
        
        if(request.getParameter("serial")!=null)
            stt = Integer.parseInt(request.getParameter("serial"));
        
        if(request.getParameter("question")!=null)
            editQuest = request.getParameter("question");
        
        if(request.getParameter("answer")!= null)
            editAnswer = request.getParameter("answer");
        
        try {
            qd.editQuestionBy(stt, editQuest, editAnswer);
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        url = "/viewQ.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    
}
