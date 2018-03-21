package classes;

import java.util.concurrent.atomic.AtomicInteger;

public class Livre implements Bibliotheque{

	private static int identifiant;
	// pour l'auto increment de l'identifiant du livre
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
	private Ouvrage ouvrage;
	private Editeur editeur;
	private String ISBN;
	private String edition;
	private int anneeEdition;
	private String commentaire;
	private boolean disponible;

	public Livre(Ouvrage ouvrage, Editeur editeur, String ISBN, String edition, int anneeEdition, String commentaire, boolean disponible) {
		super();
		this.identifiant = atomicInteger.incrementAndGet();
		this.ouvrage = ouvrage;
		this.editeur = editeur;
		this.ISBN = ISBN;
		this.edition = edition;
		this.anneeEdition = anneeEdition;
		this.commentaire = commentaire;
		this.disponible = disponible;
	}

	public Livre() {
		super();
		this.ouvrage = null;
		this.editeur = null;
		this.ISBN = null;
		this.edition = null;
		this.anneeEdition = 0;
		this.commentaire = null;
		this.disponible = false;
	}

	public static int getIdentifiant() {
		return identifiant;
	}

	public static void setIdentifiant(int identifiant) {
		Livre.identifiant = identifiant;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getAnneeEdition() {
		return anneeEdition;
	}

	public void setAnneeEdition(int anneeEdition) {
		this.anneeEdition = anneeEdition;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	// METHODES

	public void emprunter() {
		if (disponible == false) {
			System.out.println("Oeuvre non disponible");
		} else {
			disponible = false;
		}

	}

	public void rendreEmprunt() {
		if (disponible == true) {
			System.out.println("Oeuvre déjà disponible");
		} else {
			disponible = true;
		}
	}

}
