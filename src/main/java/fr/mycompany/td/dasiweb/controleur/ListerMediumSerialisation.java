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
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.MediumAstrologue;
import fr.insalyon.dasi.metier.modele.MediumSpirite;
import fr.insalyon.dasi.metier.service.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jnicolas
 */
public class ListerMediumSerialisation extends Serialisation {

    @Override
    public void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        JsonObject container = new JsonObject();
        JsonArray jsonListeMediums = new JsonArray();
        List<Medium> listeMedium = (List<Medium>) request.getAttribute("listeMedium");
        for (int i = 0; i < listeMedium.size(); i++) {
            Medium med = listeMedium.get(i);
            JsonObject jsonMedium = new JsonObject();
            jsonMedium.addProperty("type", med.getClass().getSimpleName());
            jsonMedium.addProperty("nom", med.getDenomination());
            jsonMedium.addProperty("presentation", med.getPresentation());
            jsonMedium.addProperty("genre", med.getGenre());

            switch (med.getClass().getSimpleName()) {
                case "MediumAstrologue":
                    MediumAstrologue med2 = (MediumAstrologue) listeMedium.get(i);
                    jsonMedium.addProperty("formation", med2.getFormation());
                    jsonMedium.addProperty("promotion", med2.getPromotion());
                    break;
                case "MediumCartomancien":

                    break;
                case "MediumSpirite":
                    MediumSpirite med3 = (MediumSpirite) listeMedium.get(i);
                    jsonMedium.addProperty("support", med3.getSupport());
                    break;
                default:
                // code block
            }

            jsonListeMediums.add(jsonMedium);
        }
        container.add("listeMediums", jsonListeMediums);
        PrintWriter out = this.getWriter(response);
        gson.toJson(container, out);
        out.close();
    }

}
