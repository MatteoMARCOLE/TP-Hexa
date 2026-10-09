package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();
    private int position;

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    // on récupère la lettre à la position spécifiée en paramètre dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        for (int l = 0; l < essai.length(); l++) {
            position = l;
            resultat.add(evaluationCaractere(essai.charAt(l)));
        }
    }

    // vrai si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
        for (Lettre l : resultat) {
            if (l != Lettre.PLACEE)
                return false;
        }
        return true;
    }

	// méthode obligatoire - à ne pas supprimer
    public List<Lettre> lettresResultat() {
        return Collections.unmodifiableList(resultat);
    }

    // renvoie le statut du caractère (incorrect, mal placé, placé)
    private Lettre evaluationCaractere(char carCourant) {
        if (estPresent(carCourant)) {
            if (estPlace(carCourant)) {
                return Lettre.PLACEE;
            } else {
                return Lettre.NON_PLACEE;
            } 
        } else {
            return Lettre.INCORRECTE;
        }
    }

    // vrai si le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        for (int i = 0; i < this.motSecret.length(); i++) {
            if (motSecret.charAt(i) == carCourant) {
                return true;
            }
        }
        return false;
    }

    // vrai si le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant) {
        return motSecret.charAt(position) == carCourant;
    }
}
