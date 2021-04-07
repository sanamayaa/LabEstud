/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;




import co.edu.unipiloto.estudiante.entry.Estudiante;
import co.edu.unipiloto.estudiante.session.EstudianteFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago Amaya
 */
@WebServlet(name = "StudentInfo", urlPatterns = {"/StudentInfo"})
public class StudentInfo extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

//    @EJB
//    private EstudianteFacadeLocal estudianteFacade;
    

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
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String yearLevelStr = request.getParameter("yearlevel");
            String studentIdStr = request.getParameter("studentid");
            Integer studentId = 0;
            Integer yearLevel = 0;
            if (yearLevelStr != null && !yearLevelStr.equals("")) {
                studentId = Integer.parseInt(studentIdStr);
            }
            if (studentIdStr != null && !studentIdStr.equals("")) {
                yearLevel = Integer.parseInt(yearLevelStr);
            }

            Estudiante est = new Estudiante(studentId, firstName, lastName, yearLevel);

            if (action.equals("Add")) {
                estudianteFacade.create(est);
            } else if (action.equals("Edit")) {
                estudianteFacade.edit(est);
            } else if (action.equals("Delete")) {
                estudianteFacade.remove(est);
            } else if (action.equals("Search")) {
                est=estudianteFacade.find(est.getStudentid());
            }

            request.setAttribute("student", est);
            request.setAttribute("allStudent", estudianteFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentInfo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentInfo at " + request.getContextPath() + "</h1>");
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
