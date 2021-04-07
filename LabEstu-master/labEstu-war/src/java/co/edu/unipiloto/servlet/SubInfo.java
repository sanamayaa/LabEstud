/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.estudiante.entry.Curso;
import co.edu.unipiloto.estudiante.session.CursoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago Amaya
 */
public class SubInfo extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            String name = request.getParameter("name");
            String codeStr = request.getParameter("code");
            String creditStr = request.getParameter("credit");
            String semesterStr = request.getParameter("semester");
            String cantityStr = request.getParameter("cantity");
            Integer code=0;
            Integer semester=0;
            Integer credit=0;
            Integer cantity=0;
            
            if (codeStr != null && !codeStr.equals("")) {
                code = Integer.parseInt(codeStr);
            }
            if (creditStr != null && !creditStr.equals("")) {
                credit = Integer.parseInt(creditStr);
            }
            if (semesterStr != null && !semesterStr.equals("")) {
                semester = Integer.parseInt(semesterStr);
            }
            if (cantityStr != null && !cantityStr.equals("")) {
                cantity = Integer.parseInt(cantityStr);
            }
            
            Curso cursoinf = new Curso (code, name, semester, cantity,credit);
            
            if (action.equals("Add")) {
                cursoFacade.create(cursoinf);
            } else if (action.equals("Search")) {
                cursoinf=cursoFacade.find(cursoinf.getCode());
            }
            
            request.setAttribute("course", cursoinf);
            //request.setAttribute("allStudents", cursoFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SubInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubInfo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
