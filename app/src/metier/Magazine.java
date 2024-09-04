package metier;

import java.time.LocalDate;

public class Magazine extends Document {
	
    private int numero;


	public Magazine(String titre, String auteur, LocalDate datePublication, int nombreDePages, int numero) {
		super(titre, auteur, datePublication, nombreDePages);
		
		this.numero = numero;
	}
	@Override
	public void emprunter(){
			this.emprunter = true; 
	}

	
	@Override
	public void retourner() {
		this.emprunter = false; 
	}

	@Override
	public void afficherDetails() {
		        String empruntStatus = this.emprunter ? "Emprunté" : "Disponible";
        System.out.println("Magazine - Id: "+ id + " Titre : " + titre + ", Auteur : " + auteur + ", Numéro : " + numero + ", Date de publication : " + datePublication + "Statut : " + empruntStatus );
	}
}

