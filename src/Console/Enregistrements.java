package Console;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Enregistrements {

	private String nomFichierEquipe;// nom du fichier contenant les equipes
	private List<Equipe> equipes = new LinkedList<>();// ensemble des
															// equipes du
															// programme

	// constructeur
	public Enregistrements(String valNomEquipe) {

		nomFichierEquipe = valNomEquipe;

		try {
			chargerListeEquipes();

		} catch (FileNotFoundException ex) {
			Logger.getLogger(Enregistrements.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Enregistrements.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

	// méthodes

	// méthode permettant de charger la liste des equipes existantes
	public void chargerListeEquipes() throws FileNotFoundException, IOException {
		// initialisation de la liste des attributs
		equipes = new LinkedList<>();
		// ouverture du fichier en mode lecture
		FileReader entree = new FileReader(nomFichierEquipe);
            // lit et retourne une ligne entiere
            try (BufferedReader br = new BufferedReader(entree)) {
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
            }
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
                String fichier;
            try (BufferedReader br = new BufferedReader(entree)) {
                String ligne = br.readLine();
                // nom du nouvel attribut
                fichier = team.getDescription() + ";" + team.getNbJoueurs();
                // on stocke le nouvel attribut et on y concatene toute les lignes du
                // fichier
                while (ligne != null) {
                    fichier = fichier.concat("\r\n" + ligne);
                    ligne = br.readLine();
                }
                // on arrete la lecture
            }
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

	// méthode qui permet de supprimer une equipe grace a son nom
	public void suppTeam(String nomEquipe) throws FileNotFoundException,
			IOException {
		// ouverture en mode lecture
		FileReader entree = new FileReader(nomFichierEquipe);
                String fichier;
            // lit et retourne une ligne entiere
            try (BufferedReader br = new BufferedReader(entree)) {
                // lit et retourne une ligne entiere
                String ligne = br.readLine();
                // on recupere la chaine de caractere du fichier sans l'equipe
                // recherchee
                fichier = null;
                while (ligne != null) {
                    // on ne recupere donc pas la chaine de caractere de la ligne a
                    // supprimer
                    if (ligne.contains(nomEquipe) == true) {
                        // on passe donc Ã  l'equipe suivante
                        ligne = br.readLine();
                    } else {
                        
                        // on concatene toutes les lignes du fichier dans une chaine de
                        // caractere
                        if (fichier != null) {
                            fichier = fichier.concat("\n" + ligne);
                        } else {
                            fichier = ligne;
                        }
                        ligne = br.readLine();
                    }
                }
		// on arrete la lecture
            }

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
		}
		return null;

	}
}
