package classes;


public class Livre{

	private int identifiant;
	private static int idCounter = 1;
	// pour l'auto increment de l'identifiant du livre
	private String titre;
	private Auteur auteur;
	private String genre;
	private String ISBN;
	private String nomEditeur;
	private String edition;
	private int anneeEdition;
	private String commentaire;
	private boolean disponible;

	public Livre(String titre, Auteur auteur,String genre,String ISBN ,String nomEditeur, String edition, int anneeEdition, String commentaire, boolean disponible) {
		super();
		this.identifiant = idCounter++;
		this.titre=titre;
		this.auteur=auteur;
		this.genre=genre;
		this.nomEditeur = nomEditeur;
		this.ISBN = ISBN;
		this.edition = edition;
		this.anneeEdition = anneeEdition;
		this.commentaire = commentaire;
		this.disponible = disponible;
	}


	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre=genre;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
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
	
	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
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


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}

}
