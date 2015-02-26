package Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elimination extends Tournoi {

    // attributs
    private List<Equipe> equipesEli = new ArrayList<>();

    public Elimination() {
        super();
    }

	// méthodes
    // création d'une nouvelle equipe en fonction de ses parametre et ajout dans
    // le tableau dynamique ELIMINATION
    public void addTeamEli(String descriptionConstructeur,
            int nbJoueursConstructeur) {
			// si l'equipe n'appartient pas deja a la liste on la cree et on
        // l'ajoute
        if (rechercheEquipe(descriptionConstructeur) == false) {
            Equipe team = new Equipe(descriptionConstructeur,
                    nbJoueursConstructeur);
            getEquipes().add(team);
        } else {
            System.out
                    .println("L'equipe selectionee fait deja partie du tournois");
        }

    }

    // méthode de définition du nombre d'équipe pour le prochain tour de jeu
    public static int tabSize(Equipe tab[]) {
        int resultSize = 0;// taille a retourner
        int initSize = tab.length;// taille du tableau entrant
        int rest = initSize % 2; // reste de la division euclidienne

        if (rest == 0) {
            resultSize = initSize / 2; // Si le nombre est pair le résultat est
            // la division par deux
        } else {
            resultSize = (((initSize - rest) / 2) + 1); // Si le nombre est
        }														// impair le resultat
        // est la partie entiere
        // de la division par
        // deux +1

        return resultSize;// on retourne la taille du prochain tableau

    }

	// méthode de transformation du tableau dynamique en tableau fixe --> Debut
    // du tournois
    public Equipe[] startTournois() {

        if (getEquipesEli().isEmpty() == false) {// a condition d'une liste non
            // vide
            // melange de la liste pour tournois aléatoire
            Collections.shuffle(getEquipesEli());
            Equipe[] tabFixe = getEquipesEli().toArray(
                    new Equipe[getEquipesEli().size()]);
            return tabFixe;
        }
        return null;
    }

    // détermine les gagnant et crée le nouveau tableau
    public Equipe[] lancerTour(Equipe[] tabInitial) throws Exception {
        int i = 0;// incrémenteur tableau initial
        int j = 0;// incrémenteur tableau du tour suivant
        Equipe tabSuivant[] = new Equipe[tabSize(tabInitial)];// tableau du tour

        // suivant
        System.out.println("TourSuivant !!!!!!!\n");
        // cas d'un tableau impair
        if ((tabInitial.length) % 2 != 0) {
			// On cherche le champion avec le meilleur goal average et on le
            // place automatiquement dans la première case du tableau suivant
            tabSuivant[0] = best(tabInitial);
            j = 1; // incrémenteur du tableau suivant passe à 1
        }

        while (i < (tabInitial.length) && (j < (tabSuivant.length))) {

            // affectation des points de tournois et de match
            pasEgalite(tabInitial[i], tabInitial[i + 1]);
            tabSuivant[j] = teamGagnante(tabInitial[i], tabInitial[i + 1]);
            // passage au prochain match du meme tour
            i = i + 2;
            // passage a la prochaine case du tableau du tour suivant
            j++;
        }

        // affichage du gagnant du tournois final
        if (tabSuivant.length == 1) {
            System.out
                    .println("**********Et le grand gagnant du tournois est : ***********");

        }
        // affichage du tableau du tour d'après
        affichage(tabSuivant);
        // On retourne le nouveau tableau de tour
        return tabSuivant;
    }

    public List<Equipe> getEquipesEli() {
        return equipesEli;
    }

    public void setEquipesEli(List<Equipe> equipesEli) {
        this.equipesEli = equipesEli;
    }
}
