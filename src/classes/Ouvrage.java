package classes;

public class Ouvrage {
	
	private String titre;
	private Auteur auteur;
	

	public Ouvrage(String titre, Auteur auteur) {
		super();
		this.titre = titre;
		this.auteur = auteur;
	}
	
	public Ouvrage() {
		super();
		this.titre = null;
		this.auteur = null;
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

	
	
}
