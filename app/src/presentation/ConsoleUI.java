package presentation;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import metier.Bibliotheque;
import metier.Livre;
import metier.Magazine;
import util.DateUtils;

public class ConsoleUI {
	private static final Scanner scanner = new Scanner(System.in) ;
	private static final Bibliotheque bibliotheque = new Bibliotheque();
	
	public static void main (String[] args) {
				int choix ;
			do {
				afficherMenu();
				choix = lireEntier();
				gererChoix(choix);
			} while (choix != 6);
		}
	public static void afficherMenu() {
	        System.out.println("1. Ajouter un document");
	        System.out.println("2. Emprunter un document");
	        System.out.println("3. Retourner un document");
	        System.out.println("4. Afficher tous les documents");
	        System.out.println("5. Rechercher un document");
	        System.out.println("6. Quitter");
	        System.out.print("Veuillez entrer votre choix (1-6) : ");
	     }
	 private static int lireEntier() {
	        while (true) {
	            try {
	                return scanner.nextInt();
	            } catch (InputMismatchException e) {
	                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
	                scanner.nextLine(); 
	            }
	        }
	    }
	 private static void gererChoix(int choix) {
		 
		 switch (choix) {
         case 1:
             ajouterDocument();
             break;
         case 2:
             EmprunterDocument();
             break;
         case 3:
             RetournerDocument();
             break;
         case 4:
             AfficherDocument();
             break;
         case 5:
             RechercherDocument();
             break;
         case 6:
             System.out.println("Au revoir !");
             break;
         default:
             System.out.println("Choix invalide, veuillez réessayer.");
             break;
       }
	 }
	 
	 private static void ajouterDocument() {
		 int type;
		 do {
		     System.out.println("Entrez le type de document  \n |0  Retourner au menu principal \n |1  Livre \n |2  Magazine  ");
		     type = lireEntier();
		     if (type == 0) return;
		     if (type != 1 && type != 2) {
		         System.out.println("\033[1;31mType de document invalide. Veuillez réessayer.\033[0m");
		     }
		 } while (type != 1 && type != 2);
		 
		 scanner.nextLine(); 
		 String titre;
		 do {
		     System.out.print("Entrez le titre du document : ");
		     titre = scanner.nextLine();
		     if (titre.isEmpty()) {
		         System.out.println("\033[1;31mLe titre ne peut pas être vide. Veuillez réessayer.\033[0m");
		     }
		 } while (titre.isEmpty());

		 String auteur;
		 do {
		     System.out.print("Entrez l'auteur : ");
		     auteur = scanner.nextLine();
		     if (auteur.isEmpty()) {
		         System.out.println("\033[1;31mL'auteur ne peut pas être vide. Veuillez réessayer.\033[0m");
		     }
		 } while (auteur.isEmpty());

		 LocalDate date;
		 while (true) {
		     System.out.print("Entrez la date de publication (AAAA-MM-JJ) : ");
		     String datePublication = scanner.nextLine();
		     date = DateUtils.convertirStringEnDate(datePublication);
		     if (date != null) break;
		     System.out.println("\033[1;31mDate invalide. Veuillez entrer une date au format AAAA-MM-JJ.\033[0m");
		 }

		 int nombreDePages;
		 do {
		     System.out.print("Entrez le nombre de pages : ");
		     nombreDePages = lireEntier();
		     if (nombreDePages <= 0) {
		         System.out.println("\033[1;31mLe nombre de pages doit être un entier positif. Veuillez réessayer.\033[0m");
		     }
		 } while (nombreDePages <= 0);
		 scanner.nextLine(); 

		 if (type == 1) {
		     Livre livre = new Livre(titre, auteur, date, nombreDePages);
		     bibliotheque.ajouterDocument(livre);
		     System.out.println("\033[1;32mLivre ajouté avec succès !\033[0m");
		 } else if (type == 2) {
		     int numero;
		     do {
		         System.out.print("Entrez le numéro du magazine : ");
		         numero = lireEntier();
		         if (numero <= 0) {
		             System.out.println("\033[1;31mLe numéro du magazine doit être un entier positif. Veuillez réessayer.\033[0m");
		         }
		     } while (numero <= 0);
		     scanner.nextLine(); 
		     Magazine magazine = new Magazine(titre, auteur, date, nombreDePages, numero);
		     bibliotheque.ajouterDocument(magazine);
		     System.out.println("\033[1;32mMagazine ajouté avec succès !\033[0m");
		 }
	 }
	 private static void EmprunterDocument() {
		 
			System.out.println("\033[1;34m0. Retourner au menu principal\033[0m");
			System.out.print("Entrez l'ID du document à emprunter : ");
			scanner.nextLine(); 
		        String id = scanner.nextLine();
		        if (id.equals("0")) return; 
		        bibliotheque.emprunterDocument(id);
	 }
	 private static void RetournerDocument() {
		 
			System.out.println("\033[1;34m0. Retourner au menu principal\033[0m");
			System.out.print("Entrez l'ID du document à retourner : ");
			scanner.nextLine(); 
		        String id = scanner.nextLine();
		        if (id.equals("0")) return; 
		        bibliotheque.retournerDocument(id);
	 }
	 private static void AfficherDocument() {
		bibliotheque.afficherTousLesDocuments();
	 }
	 private static void RechercherDocument() {
		 
			System.out.println("\033[1;34m0. Retourner au menu principal\033[0m");
	        System.out.print("Entrez l'ID du document à rechercher : ");
	        String id = scanner.nextLine();
	        if (id.equals("0")) return; 
	        bibliotheque.rechercherDocument(id);
	 }
	}













