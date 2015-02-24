package Execution;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Console.Elimination;
import Console.Enregistrements;
import Console.Equipe;
import Console.Poule;

public class Execution {
	private static Scanner sc;
	private static Scanner scNom;
	private static Scanner scNbJoueurs;
	private static Scanner scChoix;
	
	private static Scanner scRecord;
	private static String record;
	private static Scanner teamSelection;

	public static void main(String[] args) throws Exception {

		int compteur = 0; // compteur du nombre d'equipes crées
		// Chargement des fichiers textes
		Enregistrements unRecord = new Enregistrements("Equipes.txt",
				"Tournois.txt");

		// affichage de bienvenue
		System.out
				.println("Bienvenue dans le logiciel de cration de tournois mesdames et messieuuuuuurs");
		// demande de continuer une partie enregistrée

		System.out
				.println("Vous avez un tournois en cours. Souhaitez vous le continuer ou l'ecraser et en commencer un nouveau?");

		String choixTypeTournoi = " ";
		do // boucle qui verifie que la saisie utilisateur est validee et
			// concorde avec les 2 choix possibles
		{// proposition d'un nouveau tournois (elimination ou poule)
			System.out
					.println("Voulez vous faire un tournoi a elimination directe (tapez ED) ou par poules (tapez P) ?");
			// saisie du type de tournois
			sc = new Scanner(System.in);
			choixTypeTournoi = sc.nextLine();

			// Choix du type de tournoi
			switch (choixTypeTournoi) {

			case "ED": // lancer algo elimination ;
				// début d'un tournois en mode élimination
				compteur = 0; // init du compteur
				Elimination tournoiElimi = new Elimination();
				// lancement du tournois

				String choix;
				// On continue la boucle tant qu'on a pas choisi de débuter le
				// tournois
				do {
					System.out
							.println("Souhaitez vous ajouter une nouvelle equipe (Tapez E) ou tout simplement commencer le tournois (Tapez C) ? :");

					scChoix = new Scanner(System.in);
					choix = scChoix.nextLine();

					String nom = "";// nom pour la saisie

					switch (choix) {
					// cas d'ajout d'une nouvelle equipe
					case "E":
						// proposition de selectionner une equipe préexistante
						// dans le fichier equipe
						record = selecTeamFile(tournoiElimi, null, unRecord,
								compteur, record);
						// on passe a une action suivante si on a effectivement
						// ajouté une nouvelle equipe existante
						if (record.matches("O") == true) {
							break;
						}
						// sasie d'une nouvelle equipe
						// saisie jusqu'a avoir un nom
						System.out
								.println("vous choisissez de creer une nouvelle equipe");
						System.out
								.println("Quel est le nom de votre equipe ? :");
						scNom = new Scanner(System.in);
						nom = scNom.nextLine();

						int nbJoueurs = 0;
						try {
							System.out
									.println("Combien de joueurs compte votre equipe ? :");
							scNbJoueurs = new Scanner(System.in);
							nbJoueurs = scNbJoueurs.nextInt(); // vérification
																// nombre entier
																// et supérieur
							// a 0

							// soulever une exception si le nombre entré est
							// négatif
							if (nbJoueurs <= 0)
								throw new Exception();
							Equipe e = new Equipe(nom, nbJoueurs);
							tournoiElimi.ajoutTeamDynamique(e);
							compteur++;
							System.out.println("Il y'a " + compteur
									+ " equipes dans votre tournoi");
							// on propose d'enregistrer la nouvelle equipe dans
							// le fichier des equipes dans le cas ou cette
							// equipe n'existe pas deja dans le ficher

							recordNewTeam(e, unRecord);

						} catch (InputMismatchException pbFormat) {
							System.out
									.println("veuillez taper un nombre entier positif");
						} catch (Exception nbNegatif) {
							System.out
									.println("veuillez taper un nombre entier positif");
						}
						// ajout de l'équipe dans la liste

						break;
					// début de tournois si la liste des equipe est non vide
					case "C":
						try {
							// ICI
							Equipe[] tabInitial = tournoiElimi.startTournois();
							tournoiElimi.affichage(tabInitial);

							while (tabInitial.length > 1) {
								tabInitial = tournoiElimi
										.lancerTour(tabInitial);
							}
						} catch (NullPointerException listeVide) {
							System.out
									.println("Vous ne pouvez pas commencer de tournois sans equipe");
							// on remet le choix a une chaine vide
							choix = "";
						}
						break;

					default:
						System.out.println("Saisie incorrecte");
						break;
					}
				} while (choix.matches("C") == false);

				break;

			case "P":
				compteur = 0;
				// création d'un tournois de poule
				Poule tournoiPoule = new Poule();

				// lancement du tournoi

				String choixP;
				// On continue la boucle tant qu'on a pas choisi de débuter le
				// tournois

				do {
					do {
						System.out
								.println("ATTENTION DANS CE MODE LES POULES CONTIENNENT 4 EQUIPES DONC LE NOMBRE TOTAL D'EQUIPES DOIT ETRE UN MULTIPLE DE 4");
						System.out
								.println("Souhaitez vous ajouter une nouvelle equipe (Tapez E) ou tout simplement commencer le tournois (Tapez C) ? :");

						scChoix = new Scanner(System.in);
						choixP = scChoix.nextLine();
						String nom = "";// nom pour la saisie

						switch (choixP) {
						// cas d'ajout d'une nouvelle equipe

						case "E":
							// saisie jusqu'a avoir un nom
							// proposition de selectionner une equipe
							// préexistante dans le fichier equipe
							record = selecTeamFile(null, tournoiPoule,
									unRecord, compteur, record);
							// on passe a une action suivante si on a
							// effectivement
							// ajouté une nouvelle equipe existante
							if (record.matches("O") == true) {
								break;
							}

							System.out
									.println("Quel est le nom de votre equipe ? :");
							scNom = new Scanner(System.in);
							nom = scNom.nextLine();

							int nbJoueurs = 0;
							try {
								System.out
										.println("Combien de joueurs compte votre equipe ? :");
								scNbJoueurs = new Scanner(System.in);
								nbJoueurs = scNbJoueurs.nextInt(); // vérification
																	// nombre
																	// entier
																	// et
																	// supérieur
								// a 0

								// soulever une exception si le nombre entré est
								// négatif
								if (nbJoueurs <= 0)
									throw new Exception();

							} catch (InputMismatchException pbFormat) {
								System.out
										.println("veuillez taper un nombre entier positif");
							} catch (Exception nbNegatif) {
								System.out
										.println("veuillez taper un nombre entier positif");
							}
							Equipe e = new Equipe(nom, nbJoueurs);
							tournoiPoule.getListeEquipesPoule().add(e);
							compteur++;
							System.out.println("Il y'a " + compteur
									+ " equipes dans votre tournoi");
							// ajout de l'équipe dans la liste

							// on propose d'enregistrer la nouvelle equipe dans
							// le fichier des equipes dans le cas ou cette
							// equipe n'existe pas deja dans le ficher
							recordNewTeam(e, unRecord);

							break;

						// début de tournois si la liste des equipe est non vide
						case "C":

							try {
								// interception d'exception dans le cas ou le
								// nombre d'equipe n'est un multiple de 4 en
								// commencant le tournois
								if (tournoiPoule.getListeEquipesPoule().size() % 4 != 0)
									throw new Exception();
								// On commence le tournois de poule en formant
								// automatiquement et aléatoirement les poules
								tournoiPoule.startPoule();
								// à cet endroit on a une liste de
								// poules.[[poule1]] [[poule2]] [[poule3]] ...

								
								//affichage de toutes les poules
								tournoiPoule.affichagePoule();
								// organisation des matchs pour chaque poule du
								// tableau de poules
								for (int j = 0; j < tournoiPoule
										.getListePoulesTournoi().size(); j++) {
									tournoiPoule.matchPoule(tournoiPoule
											.getListePoulesTournoi().get(j));							
								}
								
								//affichage des poules apres les matchs
								System.out.println("Voici la répartition de vous poules");
								tournoiPoule.affichagePoule();

								// creation d'une liste vide pour recueillir les
								// equipes gagnantes des tableaux [2]
								ArrayList<Equipe> listeApresPoule = new ArrayList<Equipe>();

								for (int k = 0; k < tournoiPoule
										.getListePoulesTournoi().size(); k++) {
									tournoiPoule.gagnantsPoule(tournoiPoule
											.getListePoulesTournoi().get(k),
											listeApresPoule);
								}

								// LANCER ALGO ELIMINATIONS

								try {
									// création d'une nouvelle instance
									// delimination
									tournoiElimi = new Elimination();
									// afectation de la liste des equipes a la
									// fin des tours de poules dans un algo
									// classique d'élimination
									tournoiElimi.setEquipesEli(listeApresPoule);
									// on démarre le tournois
									Equipe[] tabInitial = tournoiElimi
											.startTournois();
									
									System.out.println("Debut de la phase d'elimination !");
									tournoiElimi.affichage(tabInitial);

									while (tabInitial.length > 1) {
										tabInitial = tournoiElimi
												.lancerTour(tabInitial);
									}

								} catch (NullPointerException listeVide) {
									System.out
											.println("Vous ne pouvez pas commencer de tournois sans equipe");
									// on remet le choix a une chaine vide
									choix = "";
								}

							} catch (NullPointerException listeVide) {
								System.out
										.println("Vous ne pouvez pas commencer de tournois sans equipe");
								// on remet le choix a une chaine vide
								choix = "";
							} catch (Exception quatre) {
								System.out
										.println("Le tournois ne comporte pas un nombre d'equipe multiple de 4 veuillez saisir de nouvelles equipes");
							}
							break;

						default:
							System.out.println("Saisie incorrecte");
							break;

						}
					} while (tournoiPoule.getListeEquipesPoule().size() %4 != 0);
				} while (choixP.matches("C") == false);

				// déroulement des tour jusqu'a trouver le gagnant

				break;

			default:
				System.out.println("Saisie incorrecte");
				break;

			}

		} while (choixTypeTournoi.matches("ED") == false
				&& choixTypeTournoi.matches("P") == false);
	}

	// méthodes permettant de saisir une équipe existante dans le fichier equipe
	public static String selecTeamFile(Elimination tournoiElimi,
			Poule tournoiPoule, Enregistrements unRecord, int compteur,
			String record) {
		// saisie selection d'une equipe preexistante

		scRecord = new Scanner(System.in);
		System.out
				.println("Souhaitez vous utiliser une equipe deja enregistree ? (O)ui ? ou (N)on ?");

		record = scRecord.nextLine();

		boolean indicateur = false;
		switch (record) {

		case "O":
			System.out
					.println("Veuillez selectionner l'equipe que vous voulez ajouter a votre tournois en tapant son nom ou (A)nnuler pour choisir d'entrer une nouvelle equipe");
			// affichage des equipes disponibles
			unRecord.afficherListeEquipes();

			// Selection d'equipes

			do {
				// booleen qui indique si la selection a marché
				// ou non
				
				
				try {
					 teamSelection = new Scanner(System.in);
					String selection="";
					selection = teamSelection.nextLine();

					// recherche de l'equipe demandée dans le
					// fichier et ajout dans la liste du
					// tournois si celle ci ne figure pas deja
					// dans le tournois
					Equipe e = unRecord.rechercheEquipe(selection);

					// dans le cas d'une elimination directe
					if ((tournoiElimi != null)
							&& (tournoiElimi.rechercheEquipe(e
									.getDescription()) == false)) {
						tournoiElimi.addTeamEli(e.getDescription(),
								e.getNbJoueurs());

						System.out.println("Vous venez d'ajouter l'equipe "
								+ e.getDescription() + " a votre tournois!");

						// indicateur a vrai pour passer a autre
						// chose
						compteur++;
						System.out.println("Il y'a " + compteur
								+ " equipes dans votre tournoi");
						indicateur = true;
					}

					// dans le cas d'une poule
					else if ((tournoiPoule != null)
							&& (tournoiPoule.rechercheEquipe(e
									.getDescription()) ==false)) {
						tournoiPoule.addTeamPoule(e.getDescription(),
								e.getNbJoueurs());
						System.out.println("Vous venez d'ajouter l'equipe "
								+ e.getDescription() + " a votre tournois!");

						// indicateur a vrai pour passer a autre
						// chose
						compteur++;
						System.out.println("Il y'a " + compteur
								+ " equipes dans votre tournoi");
						indicateur = true;
					}

					else {
						System.out
								.println("Cette equipe fait déjà partie du tournois");
					}

					break;
				} catch (NullPointerException saisieFausse) {
					System.out
							.println("Cette equipe n'existe pas. Veuillez retaper votre selection : ");
				}

				
			} while (indicateur == false);

			break;

		case "N":
			break;

		default:
			System.out
					.println("Erreur de saisie tapez O pour OUI et N pour non");
			break;
		}
		while ((record.matches("O") == false) && (record.matches("N") == false))
			;
		return record;
	}



	public static void recordNewTeam(Equipe e, Enregistrements unRecord)
			throws FileNotFoundException, IOException {
		if (unRecord.rechercheEquipe(e.getDescription()) == null) {
			System.out
					.println("Desirez vous enregistrer votre nouvelle equipe afin de pouvoir la réutiliser dans un prochain tournois ? (O)ui ? ou (N)on?");

			String record = scRecord.nextLine();
			switch (record) {
			case "O":
				unRecord.reecritEquipe(e);
				System.out.println("Votre equipe a bien été enregistree !");

			case "N":
				break;
			default:
				System.out
						.println("Erreur de saisie tapez O pour OUI et N pour non");
				break;

			}
			while (record.matches("O") == false && record.matches("N") == false)
				;
		}
	}
}
