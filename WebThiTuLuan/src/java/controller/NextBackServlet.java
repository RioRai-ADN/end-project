/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnswerDao;
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
import model.TraLoi;

/**
 *
 * @author Rio.Rai
 */
public class NextBackServlet extends HttpServlet {

   AnswerDao answerDao = new AnswerDao();
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
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        
        int iq = Integer.parseInt(request.getParameter("iq"));
        int i = iq;
        String url = "/quest.jsp";
        
        ArrayList<TraLoi> l = (ArrayList<TraLoi>) session.getAttribute("answer");
        
        if(request.getParameter("btn_click")!=null && "finish".equals(request.getParameter("btn_click"))) {
        
            l.forEach((item) -> {
                try {
                    if(item.getCauTraLoi()!=null)
                        answerDao.insertAnswer(item);
                } catch (SQLException ex) {
                    Logger.getLogger(NextBackServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            url = "/final.jsp";
        }
        
        if(request.getParameter("btn_click")!= null && "next".equals(request.getParameter("btn_click")))
        {
            l.get(i).setCauTraLoi(request.getParameter("answer"));
            i++;
        }
        if(request.getParameter("btn_click")!= null && "previous".equals(request.getParameter("btn_click")))
        {
            l.get(i).setCauTraLoi(request.getParameter("answer"));
            i--;
        }
        
        session.setAttribute("answer", l);
        
        if(i < 0)
        {
            i = 0;
            session.setAttribute("i", i);
        }
        else if(i > 4)
        {
            i = 4;
            session.setAttribute("i", i);
        }
        else
            session.setAttribute("i", i);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    
}
