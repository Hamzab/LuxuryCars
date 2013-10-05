/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verifications;

import java.util.ArrayList;
import java.util.List;


public class VerifierFormatJSON {

    public static boolean verifierFormatDate(String uneDate) {
        boolean res = true;
        try {
            if (uneDate.length() == 10
                    && uneDate.charAt(4) == '-'
                    && uneDate.charAt(7) == '-') {
                int annee = Integer.parseInt(uneDate.substring(0, 4));
                int mois = Integer.parseInt(uneDate.substring(5, 7));
                int jour = Integer.parseInt(uneDate.substring(8, 10));
                if (mois < 1 || mois > 12 || jour < 1 || jour > 31) {
                    res = false;
                }
            } else {
                res = false;
            }
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public static boolean verifierLeSexeCond(String sexe) {
        boolean res = true;
        if (!sexe.equals("F") && !sexe.equals("M")) {
            res = false;
        }
        return res;
    }

    public static boolean verifierDureeContrat(int duree) {
        boolean res = true;
        if (duree < 1 || duree > 3) {
            res = false;
        }
        return res;
    }

    public static List<String> getResultats(String dateNaissance,
            String dateFinCours, String sexe, int duree) {
        List res = new ArrayList<String>();
        if (!verifierFormatDate(dateNaissance) || !verifierFormatDate(dateFinCours)) {
            res.add(" Les dates sont toujours dans le format ISO 8601.");
        }
        if (!verifierLeSexeCond(sexe)) {
            res.add("Le champ conducteur.sexe n'accepte que les valeurs 'M' et 'F'");
        }
        if (!verifierDureeContrat(duree)) {
            res.add(" Le champ duree_contrat n'accepte que les valeurs 1, 2 et 3.");
        }
        return res;
    }
}