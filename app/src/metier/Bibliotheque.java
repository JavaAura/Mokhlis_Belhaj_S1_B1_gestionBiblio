package metier;

import java.util.ArrayList;
import java.util.HashMap;

public class Bibliotheque {
	private ArrayList<Document> documents = new ArrayList<>();
	private HashMap<String, Document> indexDocuments = new HashMap<>();

	public void ajouterDocument(Document doc) {
			if (indexDocuments.containsKey(doc.id)) {
				System.out.println("Le document avec cet ID existe déjà.");
			} else {
				documents.add(doc);
				indexDocuments.put(doc.id, doc);
				System.out.println("Document ajouté : " + doc.titre);
			}
		}
	
	public void afficherTousLesDocuments() {
		documents.forEach(doc -> doc.afficherDetails()); 
	}

	public void emprunterDocument(String id) {
		Document doc = indexDocuments.get(id);
		if (doc != null) {
			if (doc.isEmprunte()) {
				System.out.println("\033[33m Document " + doc.titre + " n'est pas disponible.\033[0m"); 
			} else {
				doc.emprunter();
				System.out.println("\033[32m Document  {" + doc.titre + "} est emprunté. \033[0m"); 
			}
		} else {
			System.out.println("\033[31m Document non trouvé. \033[0m");
		}
	}
	

	public void retournerDocument(String id) {
		Document doc = indexDocuments.get(id);
		if (doc != null) {
			if (doc.isEmprunte()) {
				doc.retourner();
				System.out.println("\033[32m Document retourné : " + doc.titre + " \033[0m");
			} else {
				System.out.println("\033[33m Le document " + doc.titre + " n'est pas emprunté. \033[0m");
			}
		} else {
			System.out.println("\033[31m Document non trouvé. \033[0m");
		}
	}
	
	 public void rechercherDocument(String id) {
	        Document doc = indexDocuments.get(id);
	        if (doc != null) {
	            doc.afficherDetails();
	        } else {
	            System.out.println("Document non trouvé.");
	        }
	    }
	    }

