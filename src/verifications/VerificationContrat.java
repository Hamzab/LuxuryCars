/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verifications;

import contrat.Contrat;


public class VerificationContrat {

    Contrat contrat;

    public VerificationContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public boolean verifierDureeContrat() {
        boolean res = true;
        if (contrat.getDureeContrat() < 1 || contrat.getDureeContrat() > 3) {
            res = false;
        }
        return res;
    }
}