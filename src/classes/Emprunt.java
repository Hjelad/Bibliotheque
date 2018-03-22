package classes;

public class Emprunt {
	
	private int idEmprunt;
	private int idPersonne;
	private int idLivre;
	
	
	public Emprunt() {
		super();
	}
	
	public Emprunt(int idEmprunt,int idPersonne, int idLivre) {
		super();
		this.idEmprunt = idEmprunt;
		this.idPersonne = idPersonne;
		this.idLivre = idLivre;
	}
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
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
