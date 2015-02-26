package Console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public abstract class Tournoi {

	// attributs
	private ArrayList<Equipe> equipes = new ArrayList<Equipe>();

	private Scanner sc1;
	private Scanner sc2;

	// Methode vérifiant qu'il n'y a pas d'égalité dans un match car dans une
	// elimination directe il n'y a pas égalité
	public void pasEgalite(Equipe eq1, Equipe eq2) {

		System.out.println("Nouveaux resultats de match : "
				+ eq1.getDescription() + " VS " + eq2.getDescription());

		do {
			System.out
					.println("Veuillez saisir les résultats du match ! (Attention, il ne peut pas y avoir d'egalite)");

			saisieScores(eq1, eq2);

			// prévenir de la ressaisie si les scores entrés sont égaux
			if (eq1.getNbPointsMatch() == eq2.getNbPointsMatch()) {
				System.out
						.println("Un match d'elimination ne peut obtenir d'egalite, merci de ressaisir le score");
			}

		} while (eq1.getNbPointsMatch() == eq2.getNbPointsMatch());
	}

	public void saisieScores(Equipe eq1, Equipe eq2) {
		// indicateur qui laisse passer à la saisie suivante que si la
		// derniere est conforme
		boolean indicateur = false;
		do {
			sc1 = new Scanner(System.in);
			sc2 = new Scanner(System.in);

			int score = 0;// score du match

			try {

				// saisie du score de l'equipe 1
				System.out.println("Score " + eq1.getDescription() + " : ");
				score = sc1.nextInt();
				// pas d'autorisation de score négatif
				if (score < 0)
					throw new Exception();
				// affectation des points
				eq1.setNbPointsMatch(score);

				// saisie des scoresde l'equipe 2
				System.out.println("Score " + eq2.getDescription() + " : ");
				score = sc2.nextInt();
				// pas d'autorisation de score négatif
				if (score < 0)
					throw new Exception();
				// afectation des points
				eq2.setNbPointsMatch(score);

				indicateur = true;
				// levée de l'exception d'un score négatif

			} catch (InputMismatchException pbFormat) {
				System.out
						.println("Erreur, veuillez taper un nombre entier positif! Merci de ressaisir les scores");
				indicateur = false;
			} catch (Exception nbPositif) {
				System.out
						.println("Erreur, veuillez taper un nombre entier positif! Merci de ressaisir les scores");
				indicateur = false;
			}

		} while (indicateur == false);
	}

	


	

	// méthode d'ajout d'équipe dans le tableau dynamique
	public void ajoutTeamDynamique(Equipe uneTeam) {
		getEquipes().add(uneTeam);

	}

	// ajout equipe dans un tableau fixe
	public Equipe[] ajoutTeamFixe(int i, Equipe[] tab, Equipe uneTeam) {
		tab[i] = uneTeam;
		return tab;
	}

	// Methode affectant le nb de points suivant que l'équipe ait gagné, perdu
	// ou ait fait match null
	public void winLose(Equipe eq1, Equipe eq2) {

		saisieScores(eq1, eq2);

		if (eq1.getNbPointsMatch() < eq2.getNbPointsMatch()) {
			eq2.setNbPointsTournois(eq2.getNbPointsTournois() + 3);
		}

		if (eq1.getNbPointsMatch() > eq2.getNbPointsMatch()) {
			eq1.setNbPointsTournois(eq1.getNbPointsTournois() + 3);
		}

		if (eq1.getNbPointsMatch() == eq2.getNbPointsMatch()) {
			eq2.setNbPointsTournois(eq2.getNbPointsTournois() + 1);
			eq2.setNbPointsTournois(eq2.getNbPointsTournois() + 1);
		}

	}

	

	// fonction d'affichage d'un tableau d'equipe
	public void affichage(Equipe[] tab) {
		try {
			for (int i = 0; i < tab.length; i++) {

				tab[i].affichageConsole();
			}
		} catch (NullPointerException listeVide) {
			System.out.println("liste vide, rien à afficher");
		}
	}

	// retrourne meilleure equipe en terme de goal average d'un tour de tournois
	// si les goal average sont les meme le tirage est aléatoire puisque le
	// tableau de match de départ est aléatoire
	public Equipe best(Equipe[] tab) {
		Equipe best = tab[0];
		// Recherche pour trouver le meilleur goalAverage
		for (int i = 0; i < tab.length-1; i++) {
			if ((tab[i].getGoalAverage()) < (tab[i + 1].getGoalAverage())) {
				best = tab[i + 1];
			} else
				best = tab[i];

		}
		// retourne la meilleur equipe
		return best;
	}

	// détermination equipe gagnante
	public Equipe teamGagnante(Equipe teamUn, Equipe teamDeux) {
		Equipe EquipeGagnante;
		// affectation des goal average
		teamUn.setGoalAverage(teamUn.getNbPointsMatch()
				- teamDeux.getNbPointsMatch());
		teamDeux.setGoalAverage(teamDeux.getNbPointsMatch()
				- teamUn.getNbPointsMatch());
		if (teamDeux.getNbPointsMatch() < teamUn.getNbPointsMatch()) {
			EquipeGagnante = teamUn;
		}

		else
			EquipeGagnante = teamDeux;
		return EquipeGagnante;
	}

	// recherche d'equipe dans le tournois
	// utilisee dans addTeam: permettra de verifier qu'une equipe ne peut pas
	// être ajoutée deux fois retourne vrai si l'equipe existe deja, faux sinon
	public boolean rechercheEquipe(String nom) {
		Iterator<Equipe> it = getEquipes().iterator();
		while (it.hasNext() == true) {
			Equipe e = it.next();
			if (e.getDescription().matches(nom) == true) {
				return true;
			} 			
		}
		return false;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(ArrayList<Equipe> equipes) {
		this.equipes = equipes;
	}
}