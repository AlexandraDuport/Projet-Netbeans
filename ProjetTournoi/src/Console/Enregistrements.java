package Console;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Enregistrements {

	// attributs
	private List<Equipe[]> tournois = new LinkedList<Equipe[]>(); // liste
																	// contenant
																	// le
																	// dernier
																	// tournois
																	// en cours
																	// (liste de
																	// tableau
																	// de tour)
	private String nomFichierEquipe;// nom du fichier contenant les equipes
	private String nomFichierTournois;// nom du fichier contenant le dernier
										// tournois en cours
	// Iterator<Regles> itRegle; //itÃ©rateur qui pointe sur la liste des
	// rÃ¨gles
	private List<Equipe> equipes = new LinkedList<Equipe>();// ensemble des
															// equipes du
															// programme
	private BufferedReader br;

	// constructeur
	public Enregistrements(String valNomEquipe, String valNomTournois) {

		nomFichierEquipe = valNomEquipe;
		nomFichierTournois = valNomTournois;

		try {
			chargerListeEquipes();

		} catch (FileNotFoundException ex) {
			Logger.getLogger(Enregistrements.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Enregistrements.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		/*
		 * try { chargerTournois(); } catch (FileNotFoundException ex) {
		 * Logger.getLogger(Enregistrements.class.getName()).log(Level.SEVERE,
		 * null, ex); } catch (IOException ex) {
		 * Logger.getLogger(Enregistrements.class.getName()).log(Level.SEVERE,
		 * null, ex); }
		 */

	}

	// méthodes

	// méthode permettant de charger la liste des equipes existantes
	public void chargerListeEquipes() throws FileNotFoundException, IOException {
		// initialisation de la liste des attributs
		equipes = new LinkedList<Equipe>();
		// ouverture du fichier en mode lecture
		FileReader entree = new FileReader(nomFichierEquipe);
		BufferedReader br = new BufferedReader(entree);
		// lit et retourne une ligne entiere
		String ligne = br.readLine();

		while (ligne != null) {
			// lit jusqu'a un caractere en particulier
			String tab[] = ligne.split(";");
			String nom = tab[0];
			int nbJoueurs = Integer.parseInt(tab[1]);

			// creation d'une nouvelle equipe et ajout dans la liste d'équipes
			// preexistante
			Equipe e = new Equipe(nom, nbJoueurs);
			equipes.add(e);
			// on lit la ligne suivante du fichier
			ligne = br.readLine();
		}
		br.close();
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	// mÃ©thode qui reecrit le fichier equipe en ecrivant une nouvelle equipe au
	// debut du fichier
	public void reecritEquipe(Equipe team) throws FileNotFoundException,
			IOException {
		// ouverture du fichier en mode lecture
		FileReader entree = new FileReader(nomFichierEquipe);
		BufferedReader br = new BufferedReader(entree);
		String ligne = br.readLine();

		// nom du nouvel attribut
		String fichier = team.getDescription() + ";" + team.getNbJoueurs();
		// on stocke le nouvel attribut et on y concatene toute les lignes du
		// fichier
		while (ligne != null) {
			fichier = fichier.concat("\r\n" + ligne);
			ligne = br.readLine();
		}
		// on arrete la lecture
		br.close();
		// on ecrit la chaine de caractÃ¨re du fichier entier en ecrivant par
		// dessus l'ancien
		try {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(
					new File(nomFichierEquipe)))) {
				writer.write(fichier);
			}
		} catch (IOException e) {
		}
	}

	public Equipe[] toArray(List<Equipe> eq) {
		Equipe[] tab = eq.toArray(new Equipe[eq.size()]);
		return tab;
	}

	// A REVOIR
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// méthode qui permet de supprimer une equipe grace a son nom
	public void suppTeam(String nomEquipe) throws FileNotFoundException,
			IOException {
		// ouverture en mode lecture
		FileReader entree = new FileReader(nomFichierEquipe);
		BufferedReader br = new BufferedReader(entree);
		// lit et retourne une ligne entiere
		String ligne = br.readLine();

		// on recupere la chaine de caractere du fichier sans l'equipe
		// recherchee
		String fichier = null;
		while (ligne != null) {
			// on ne recupere donc pas la chaine de caractere de la ligne a
			// supprimer
			if (ligne.contains(nomEquipe) == false) {
				// on passe donc Ã  l'equipe suivante
				ligne = br.readLine();
			}

			// on concatene toutes les lignes du fichier dans une chaine de
			// caractere
			if (fichier != null) {
				fichier = fichier.concat("\n" + ligne);
			} else {
				fichier = ligne;
			}
			ligne = br.readLine();
		}
		// on arrete la lecture
		br.close();

		// on reecrit le fichier equipe
		try {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(
					new File(nomFichierEquipe)))) {
				writer.write(fichier);
			}
		} catch (IOException e) {
		}
		// on charge la nouvelle liste dequipe
		chargerListeEquipes();
	}

	// méthode d'affichage de la liste d'equipe
	public void afficherListeEquipes() {
		Iterator<Equipe> it = equipes.iterator();
		while (it.hasNext() == true) {
			Equipe e = it.next();
			e.affichageConsole();
			;
		}
	}

	// méthode qui retourne une equipe en particulier à partir de son nom
	public Equipe rechercheEquipe(String nom) {
		Iterator<Equipe> it = equipes.iterator();
		while (it.hasNext() == true) {
			Equipe e = it.next();
			if (e.getDescription().matches(nom) == true) {
				return e;
			}
			return null;

		}
		return null;
		
	}

	// methode qui efface le fichier tournois et en crée un nouveau vierge pour
	// supporter la nouvelle sauvegarde
	public void suppTournois() throws FileNotFoundException, IOException {
		// lecture du fichier tournois

	}

	// méthode qui ecrit dans le fichier tournois en fonction du type de
	// tournois l'ecriture se fait a la fin du fichier
	public void recordTournois(Equipe[] tab) throws IOException {
		// on ajoute des données a la fin du fichier
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(
				nomFichierTournois, true)));

		// ecriture des renseignements d'une equipe par ligne
		for (int i = 0; i < tab.length; i++) {
			// ecriture d la ligne
			String aEcrire = tab[i].getDescription() + ";"
					+ tab[i].getNbJoueurs() + ";" + tab[i].getGoalAverage()
					+ ";" + tab[i].getNbPointsMatch() + ";"
					+ tab[i].getNbPointsTournois() + "\n";
			// passage a la lignes suivante
			writer.write(aEcrire);
		}
		// on indique que le tour est terminé
		writer.write("tourSuivant");
		// on arrete d'ecrire
		writer.close();

	}
	
	
	//méthode qui permet d'effacer le contenu du fichier tournois
	public void effaceTournois() throws IOException{
		 new FileWriter(new File(nomFichierTournois)).close();

	}

	// méthode permettant de charger le dernier tournois en cours
	public void chargerTournois() throws FileNotFoundException, IOException {
		// lecture du fichier tournois
		FileReader entree = new FileReader(nomFichierTournois);
		br = new BufferedReader(entree);
		// lit et retourne une ligne entiere
		String ligne = br.readLine();
		List<Equipe> eq = new LinkedList<Equipe>();
		while (ligne != null) {

			// lit jusqu'a un caractere en particulier (jusquÃ  la sÃ©paration
			// condition/condition et conclusion/conclusion

			// separer conditions / conclusions
			String tab[] = ligne.split(";");

			// nom d'equipe
			String nom = tab[0];
			// nombre de joueurs par equipe
			String nbJoueurs = tab[1];
			int convertJoueur = Integer.parseInt(nbJoueurs);
			// goal average
			String goalAverage = tab[2];
			int convertGoal = Integer.parseInt(goalAverage);
			// point dernier match
			String nbPointMatch = tab[3];
			int convertMatch = Integer.parseInt(nbPointMatch);
			// point tournois
			String nbPointTournois = tab[3];
			int convertTournois = Integer.parseInt(nbPointTournois);
			// initialiser une condition
			Equipe team = new Equipe(nom, convertJoueur, convertGoal,
					convertMatch, convertTournois);

			// ajout de l'equipe récupérée dans la liste d'equipe
			eq.add(team);
			// lecture de la ligne suivante
			ligne = br.readLine();

			// si on passe au toursuivant
			if (ligne.equals("TourSuivant") == true) {
				// on ajoute le tableau d'un tour dans la liste du tournois
				tournois.add(toArray(eq));
				// on vide la liste pour en preparer une nouvelle
				eq.clear();
			}
		}
	}

}
