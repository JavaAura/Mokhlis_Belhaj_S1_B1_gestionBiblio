package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
//	 convertir une chaîne de caractères en LocalDate
	public static LocalDate convertirStringEnDate(String dateStr) {
		try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateStr, formatter);
		 } catch (DateTimeParseException e) {
	            System.out.println("Format de date invalide. Utilisez le format AAAA-MM-JJ.");
	            return null;
	        }
		
	
	}
//  formater une LocalDate en chaîne de caractères
	public static String formaterDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
	
	  //  obtenir la date actuelle
    public static LocalDate obtenirDateActuelle() {
        return LocalDate.now();
    }

}
