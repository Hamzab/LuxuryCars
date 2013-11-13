package date;

import java.util.Date;

public class LaDate {

    static Date maintenant;
    static int ceMois;
    static int cetteAnnee;
    static int annees;

    public static int getAnneeDeNaissance(String dateDeNaissance) {
        return Integer.parseInt(dateDeNaissance.substring(0, 4));
    }

    public static int getMoisDeNaissance(String dateDeNaissance) {
        return Integer.parseInt(dateDeNaissance.substring(5, 7));
    }

    public static int getJourDeNaissance(String dateDeNaissance) {
        return Integer.parseInt(dateDeNaissance.substring(8, 10));
    }

    public static void getParametreDeDate(String dateDeNaissance) {
        maintenant = new Date();
        ceMois = maintenant.getMonth() + 1;
        cetteAnnee = maintenant.getYear() + 1900;
        annees = cetteAnnee - getAnneeDeNaissance(dateDeNaissance);
    }

    public static int getAnnees(String dateDeNaissance) {
        getParametreDeDate(dateDeNaissance);
        if (getMoisDeNaissance(dateDeNaissance) > ceMois) {
            annees--;
        } else if (getMoisDeNaissance(dateDeNaissance) == ceMois) {
            int aujourdhui = maintenant.getDate();
            if (getJourDeNaissance(dateDeNaissance) > aujourdhui) {
                annees--;
            }
        }
        return annees;
    }
}
