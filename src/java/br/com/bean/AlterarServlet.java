/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.DAO.DAO;
import br.com.DAO.UsuarioDAO;
import br.com.controller.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joe
 */
public class AlterarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//        }
         Connection con;
        
        
        
        int id = Integer.parseInt(request.getParameter("id"));
            String usuario = request.getParameter("usuario"); 
            String senha = request.getParameter("senha"); 
             String noticia = request.getParameter("noticia"); 
           
             UsuarioDTO uDTO = new UsuarioDTO();
            
            try {
                con = DAO.Conexao();
                   uDTO.setId(id);
                   uDTO.setUsuario(usuario);
                   uDTO.setSenha(senha);
                   uDTO.setNoticia(noticia);
                   
                   UsuarioDAO uDAO = new UsuarioDAO(con);
                   uDAO.alterar(uDTO);
                   request.setAttribute("Noticia", "Dados atualizados");
                   RequestDispatcher rd = 
                    request.getRequestDispatcher("home.jsp");
                    rd.forward(request, response);}
               catch(Exception e){
                    //out.println(e);
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
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

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
