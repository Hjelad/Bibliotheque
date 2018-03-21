package classes;

public class Ouvrage {
	
	private String titre;
	private Auteur auteur;
	private String genre;
	

	public Ouvrage(String titre, Auteur auteur, String genre) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.genre = genre;
	}
	
	public Ouvrage() {
		super();
		this.titre = null;
		this.auteur = null;
		this.genre = null;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	
}
