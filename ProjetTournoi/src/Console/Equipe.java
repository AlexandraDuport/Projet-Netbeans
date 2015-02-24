package Console;

import java.util.Random;

public class Equipe {

	// Attributs

	// du
	// tournoi victoire -> +3 | nul -> +1 |
	// dfaite -> +0
	private int nbJoueurs = 11; // nb de joueurs dans l'quipe
	private int nbPointsMatch = 0; // nb de points que l'equipe marque pdt un
									// match
	private String description = "rien"; // description de l'quipe (ex:
											// nationnalit...)
	private int goalAverage = 0;
	private int nbPointsTournois = 0; // pts gagnes par l'equipe depuis le dbut
	final int ptMax = 8;// nombre de point maximal d'un tournois
	private Random rand = new Random();

	// Constructeurs

	// constructeur pour récupération par fichier
	public Equipe(String nom, int nbJoueursConstructeur, int goal, int match,
			int ptTournois) {
		nbPointsTournois = ptTournois;
		nbPointsMatch = match;
		goalAverage = goal;
		nbJoueurs = nbJoueursConstructeur;
		description = nom;
	}

	// constructeur pour nouveau tournois
	public Equipe(String nom, int nbJoueursConstructeur) {
		nbPointsTournois = 0;
		nbPointsMatch = 0;
		goalAverage = 0;
		nbJoueurs = nbJoueursConstructeur;
		description = nom;
	}

	public int getNbPointsTournois() {
		return nbPointsTournois;
	}

	public void setNbPointsTournois(int nbPointsTournois) {
		this.nbPointsTournois = nbPointsTournois;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGoalAverage() {
		return goalAverage;
	}

	public void setGoalAverage(int nouvelleDif) {
		this.goalAverage = goalAverage + nouvelleDif;
	}

	// affectation des points des match manuellement
	public void setNbPointsMatch(int nbPointsMatch) {
		this.nbPointsMatch = nbPointsMatch;
	}

	// getters setters
	public int getNbPointsMatch() {
		return nbPointsMatch;
	}

	// affectation d'un nombre de point aléatoire pour les match (pour tests
	// rapides)
	public void setNbPointsMatch() {
		this.nbPointsMatch = rand.nextInt(ptMax);

	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public void affichageConsole() {
		System.out.println("*******Equipe********:\nNom:"
				+ this.getDescription() + "\nNombre de joueurs:"
				+ this.getNbJoueurs() + "\nGoal Average:"
				+ this.getGoalAverage() + "\nScore du dernier match:"
				+ this.getNbPointsMatch() + "\nScore Tournois :"
				+ this.getNbPointsTournois());
	}
}