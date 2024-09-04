package metier;

import java.time.LocalDate;

public abstract class Document {
	 
	private static int idCounter = 0; 
	protected String id;
	protected String titre;
	protected String auteur;
	protected LocalDate datePublication;
	protected int nombreDePages;
	protected boolean emprunter = false;

	public Document(String titre, String auteur, LocalDate datePublication, int nombreDePages) {
		this.id = generateurid();
		this.titre = titre;
		this.auteur = auteur;
		this.datePublication = datePublication;
		this.nombreDePages = nombreDePages;
		this.emprunter = false; 
	}

	private static synchronized String generateurid() {
		return String.valueOf(++idCounter); 
	}

	public boolean isEmprunte() {
		return emprunter;
	}

	public abstract void emprunter(); 
	public abstract void retourner();
	public abstract void afficherDetails();
}

