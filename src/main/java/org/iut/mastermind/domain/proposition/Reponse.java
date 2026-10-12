
package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    public void compare(String essai) {
        resultat.clear();

        boolean[] utilise = new boolean[motSecret.length()];

        verifierLettresPlacees(essai, utilise);
        verifierLettresNonPlacees(essai, utilise);
    }

    private void verifierLettresPlacees(String essai, boolean[] utilise) {
        for (int i = 0; i < essai.length(); i++) {
            if (essai.charAt(i) == motSecret.charAt(i)) {
                resultat.add(Lettre.PLACEE);
                utilise[i] = true;
            } else {
                resultat.add(Lettre.INCORRECTE);
            }
        }
    }

    private void verifierLettresNonPlacees(String essai, boolean[] utilise) {
        for (int i = 0; i < essai.length(); i++) {
            if (resultat.get(i) == Lettre.PLACEE) {
                continue;
            }

            for (int j = 0; j < motSecret.length(); j++) {
                if (!utilise[j] && essai.charAt(i) == motSecret.charAt(j)) {
                    resultat.set(i, Lettre.NON_PLACEE);
                    utilise[j] = true;
                    break;
                }
            }
        }
    }

    public boolean lettresToutesPlacees() {
        if (resultat.isEmpty()) {
            return false;
        }

        for (Lettre lettre : resultat) {
            if (lettre != Lettre.PLACEE) {
                return false;
            }
        }
        return true;
    }

    public List<Lettre> lettresResultat() {
        return Collections.unmodifiableList(resultat);
    }
}
