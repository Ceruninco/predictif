/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mycompany.td.dasiweb.controleur;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.MediumAstrologue;
import fr.insalyon.dasi.metier.modele.MediumSpirite;
import fr.insalyon.dasi.metier.service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jnicolas
 */
public class ConnecterClientAction extends Action {

    @Override
    public void executer(HttpServletRequest request) {

        Service service = new Service();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Client client;
        client = service.authentifierClient(login, password);
        request.setAttribute("client", client);

    }

}
