package org.iut.mastermind.domain.partie;

public record Joueur(String nom) {

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Joueur)) {
            return false;
        }

        Joueur joueur = (Joueur) o;

        return this.nom.equals(joueur.nom);
    }
}
