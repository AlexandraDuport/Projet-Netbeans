package Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Poule extends Tournoi {

	// attributs
	private Enregistrements unRecord = new Enregistrements("Equipes.txt");//fichier a remplir
	private List<Equipe> listeEquipesPoule = new ArrayList<Equipe>(); // tableau
																		// regroupant
																		// toutes
																		// les
																		// équipes
																		// qui
																		// vont
																		// etre
																		// réparties
																		// dans
																		// les
																		// poules
																		// de
																		// 4
	private List<Equipe[]> listePoulesTournoi = new ArrayList<Equipe[]>(); // liste

	// qui
	// va
	// contenir
	// les
	// tableaux
	// de
	// poule

	public Poule() {
		super();
	}

	// Methodes

	public void addTeamPoule(String descriptionConstructeur,
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
			return;
		}

	}

	public void startPoule() {
		// on mélange la liste des équipes rentrées pour avoir un tirage au sort
		// des poules aléatoires
		listeEquipesPoule=getListeEquipesPoule();
		Collections.shuffle(listeEquipesPoule);

		// toutes les 4 equipes on crée un nouveau tableau
		
		for (int i = 0; i < listeEquipesPoule.size(); i++) {
			Equipe[] tabPoule = new Equipe[4];
			for (int j = 1; j <= 4; j++) {
				tabPoule[j - 1] = listeEquipesPoule.get(i);
				i++;

				// on ajoute le tableau créé a la liste de poules lorsque
				// l'indice est multiple de 4
				if (j % 4 == 0) {
					listePoulesTournoi.add(tabPoule);
				}
			}
			i--;
		}
	}

	// organise les matchs, demande la saisie des scores, affecte le nb de
	// points en cas d'égalité, victoire et défaire puis calcule le goal average
	public void matchPoule(Equipe[] poule) {
		System.out.println("1er match de phase de poule :" + poule[0].getDescription() + " VS "
				+ poule[1].getDescription());
		winLose(poule[0], poule[1]);
		teamGagnante(poule[0], poule[1]);

		System.out.println("2eme match de phase de poule:" + poule[0].getDescription() + " VS "
				+ poule[2].getDescription());
		winLose(poule[0], poule[2]);
		teamGagnante(poule[0], poule[2]);

		System.out.println("3eme match de phase de poule:" + poule[0].getDescription() + " VS "
				+ poule[3].getDescription());
		winLose(poule[0], poule[3]);
		teamGagnante(poule[0], poule[3]);

		System.out.println("4eme match de phase de poule:" + poule[1].getDescription() + " VS "
				+ poule[2].getDescription());
		winLose(poule[1], poule[2]);
		teamGagnante(poule[1], poule[2]);

		System.out.println("5eme match de phase de poule:" + poule[1].getDescription() + " VS "
				+ poule[3].getDescription());
		winLose(poule[1], poule[3]);
		teamGagnante(poule[1], poule[3]);

		System.out.println("6eme match de phase de poule:" + poule[2].getDescription() + " VS "
				+ poule[3].getDescription());
		winLose(poule[2], poule[3]);
		teamGagnante(poule[2], poule[3]);
	}

	// methode qui va trier les poules en fct du nombre de points de chaques
	// equipes et qui va ajouter les 2 gagnants dans la liste de gagnants qu'on
	// va ensuite transformer en tableau fixe pour l'insérer dans l'algorithme
	// d'elimination
	public void gagnantsPoule(Equipe[] poule, ArrayList<Equipe> listeApresPoule) {

		Comparator<Equipe> pointsTournoi;
		pointsTournoi = new Comparator<Equipe>() {
			@Override
			public int compare(Equipe eq1, Equipe eq2) {
				return eq1.getNbPointsTournois() - eq2.getNbPointsTournois();
			}
		};

		Arrays.sort(poule, pointsTournoi);

		// une fois le tableau de poule trié selon le nb de points de chaque
		// équipe on prend les 2 gagnants qu'on range dans la liste de gagnants
		// des poules

		listeApresPoule.add(poule[2]);
		listeApresPoule.add(poule[3]);
	}
	
	public void affichagePoule(){
		for (int i=0;i<listePoulesTournoi.size();i++){
			System.out.println("****Nouvelle Poule****");
			affichage(listePoulesTournoi.get(i));
			System.out.println("\n");
		}
	}
        
        	public boolean rechercheEquipe(String nom) {
		Iterator<Equipe> it = getListeEquipesPoule().iterator();
		while (it.hasNext() == true) {
			Equipe e = it.next();
			if (e.getDescription().matches(nom) == true) {
				return true;
			} 			
		}
		return false;
	}

	public List<Equipe> getListeEquipesPoule() {
		return listeEquipesPoule;
	}

	public void setListeEquipesPoule(List<Equipe> listeEquipesPoule) {
		this.listeEquipesPoule = listeEquipesPoule;
	}

	public List<Equipe[]> getListePoulesTournoi() {
		return listePoulesTournoi;
	}

	public void setListePoulesTournois(List<Equipe[]> listePouleTournoi) {
		this.listePoulesTournoi = listePouleTournoi;
	}

	public void setListeEquipesPoule(ArrayList<Equipe> listeEquipesPoule) {
		this.listeEquipesPoule = listeEquipesPoule;
	}

	public void setListePoulesTournoi(ArrayList<Equipe[]> listePouleTournoi) {
		this.listePoulesTournoi = listePouleTournoi;
	}

	public Enregistrements getUnRecord() {
		return unRecord;
	}

	public void setUnRecord(Enregistrements unRecord) {
		this.unRecord = unRecord;
	}
}