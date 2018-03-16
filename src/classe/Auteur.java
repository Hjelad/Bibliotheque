package classe;

import java.util.Objects;

public class Auteur {
	private String nom;
	private String prenom;
	
	public Auteur() {
		super();
		this.nom = null;
		this.prenom = null;
	}
	
	public Auteur(String nom, String prenom, String dateNaissance, boolean admin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.nom, this.prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Auteur))
			return false;
		Auteur a = (Auteur) obj;
		return (a.getNom().equals(this.nom) && a.getPrenom().equals(this.prenom));
	}

	@Override
	public String toString() {
		return "Auteur [nom=" + this.nom + ", prenom=" + this.prenom + "]";
	}
	
	
	
}
