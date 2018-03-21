package classes;

public class Editeur {
	private String nomEditeur;
	private String paysOriginaire;

	public Editeur(String nomEditeur, String paysOriginaire) {
		super();
		this.nomEditeur = nomEditeur;
		this.paysOriginaire = paysOriginaire;
	}
	
	public Editeur() {
		super();
		this.nomEditeur = null;
		this.paysOriginaire = null;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}
	
	public String getPaysOriginaire() {
		return paysOriginaire;
	}

	public void setPaysOriginaire(String paysOriginaire) {
		this.paysOriginaire = paysOriginaire;
	}
	
	
}
