package classes;

public class Emprunt {
	
	private static int idCounter = 1;
	private int idEmprunt;
	private String mail;
	private int idLivre;
	
	
	public Emprunt(String mail, int idLivre) {
		super();
		this.idEmprunt = idCounter++;
		this.mail = mail;
		this.idLivre = idLivre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public int getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	public int getIdEmprunt() {
		return idEmprunt;
	}
	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}
	
}
