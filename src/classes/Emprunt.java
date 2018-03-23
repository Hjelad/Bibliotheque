package classes;

public class Emprunt {
	
	private static int idCounter = 1;
	private int idEmprunt;
	private int mail;
	private int idLivre;
	
	
	public Emprunt(int idEmprunt,int mail, int idLivre) {
		super();
		this.idEmprunt = idCounter++;
		this.mail = mail;
		this.idLivre = idLivre;
	}
	public int getMail() {
		return mail;
	}
	public void setMail(int mail) {
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
