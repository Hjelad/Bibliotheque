package classes;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "personne")
//If you want you can define the order in which the fields are written
//Optional
@XmlType(propOrder = { "nom", "prenom", "mail", "motDePasse", "admin" })
public class Personne{
	
	
	private String nom;
	private String prenom;
	private String mail;
	private String motDePasse;
	private Boolean admin;
	
	public Personne() {
		
	}
	
	public Personne(String nom, String prenom, String mail, String motDePasse, Boolean admin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}
	
	// get/set
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean estAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	
}
























