package metier;

import java.time.LocalDate;

public class Livre extends Document {
    private final  String isbn; 

    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages) {
        super(titre, auteur, datePublication, nombreDePages);
        this.isbn = generateISBN();
    }

   

    

    @Override
    public void afficherDetails() {
        String empruntStatus = this.emprunter ? "Emprunté" : "Disponible";
        System.out.println("Livre -Id:"+ id + " Titre : " + titre + ", Auteur : " + auteur + ", ISBN : " + isbn + ", Statut : " + empruntStatus);
    }
    @Override
	public void emprunter(){
			this.emprunter = true; 
	}
	@Override
	public void retourner() {
		this.emprunter = false; 
	}

    
    public static String generateISBN() {
        long currentTimeMillis = System.currentTimeMillis();
        String uniqueID = String.valueOf(currentTimeMillis);
        StringBuilder isbn = new StringBuilder("978");
        isbn.append(uniqueID.substring(uniqueID.length() - 9));
        isbn.append(calculateCheckDigit(isbn.toString()));
        return isbn.toString();
    }

    private static int calculateCheckDigit(String isbn) {
        int sum = 0;
        for (int i = 0; i < isbn.length(); i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        return (10 - (sum % 10)) % 10;
    }
    
}
