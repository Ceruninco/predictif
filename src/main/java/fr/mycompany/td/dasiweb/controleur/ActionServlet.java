/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mycompany.td.dasiweb.controleur;

import fr.insalyon.dasi.dao.JpaUtil;

import fr.insalyon.dasi.metier.service.Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.MediumAstrologue;

import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.MediumCartomancien;
import fr.insalyon.dasi.metier.modele.MediumSpirite;

import java.util.List;

/**
 *
 * @author jnicolas
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.init();
    }

    @Override
    public void destroy() {
        JpaUtil.destroy();
        super.destroy();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        String todo = request.getParameter("todo");

        Action action = null;
        Serialisation serialisation = null;
        switch (todo) {
            case "connecter": {
                action = new ConnecterClientAction();
                serialisation = new ConnecterClientSerialisation();
            }
            break;
            case "loadMediums": {
                action = new ListerMediumAction();
                serialisation = new ListerMediumSerialisation();
            }
            break;
            case "": {

            }
            break;

        }
        if (action != null && serialisation != null) {
            action.executer(request);
            serialisation.serialiser(request, response);
        } else {
            response.sendError(400, "Bad Request(pas d'Action ou de serialisation pour traiter cette requête");
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
