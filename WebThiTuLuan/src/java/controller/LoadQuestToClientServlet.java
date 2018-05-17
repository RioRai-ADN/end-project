/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CauHoi;
import model.TraLoi;

/**
 *
 * @author Rio.Rai
 */
public class LoadQuestToClientServlet extends HttpServlet {

    QuestDao questDao = new QuestDao();

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
        
        try {
            ArrayList<CauHoi> list = questDao.getQuestionList(5);
            
            ArrayList<TraLoi> aw = new ArrayList<>();
            
            for(int i = 0; i <list.size(); i++) {
            
                TraLoi tl = new TraLoi();
                tl.setCauTraLoi("");
                tl.setSttCauHoi(list.get(i).getSttCauHoi());
                tl.setUserName(session.getAttribute("userName").toString());
                
                aw.add(tl);
            }
            
            session.setAttribute("answer", aw);
            session.setAttribute("question", list);
        } catch (SQLException ex) {
            Logger.getLogger(LoadQuestToClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/quest.jsp");
        rd.forward(request, response);
    }

}
