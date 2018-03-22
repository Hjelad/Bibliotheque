package classes;


public class Personne{
	
	private int identifiant;;
	private static int idCounter = 1;
	// pour l'auto increment de l'identifiant de la personne
	private String nom;
	private String prenom;
	private String mail;
	private String motDePasse;
	private Boolean admin;
	
	public Personne() {
		super();
		this.nom = null;
		this.prenom = null;
		this.mail = null;
		this.motDePasse = null;
		this.admin = false;
	}
	
	public Personne(String nom, String prenom, String mail, String motDePasse, Boolean admin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.admin = admin;
        this.identifiant = idCounter++;
	}
	
	// get/set
	
	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
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
	
	// Méthode

	public void supprimerPersonne () {
		
	}
	
}






















