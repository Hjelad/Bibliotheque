package classes;

public class Editeur {
	private String nomEditeur;

	public Editeur(String nomEditeur) {
		super();
		this.nomEditeur = nomEditeur;
	}
	
	public Editeur() {
		super();
		this.nomEditeur = null;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}
	
	
}
