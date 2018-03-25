package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import XML.XMLAuteur;
import XML.XMLEmprunt;
import XML.XMLLivre;
import XML.XMLPersonne;
import classes.Auteur;
import classes.Emprunt;
import classes.Livre;
import classes.Personne;

/**
 * Servlet implementation class ServletRendreEmprunt
 */
@WebServlet("/ServletRendreEmprunt")
public class ServletRendreEmprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRendreEmprunt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Création ou récupération de la session */
		HttpSession session = request.getSession();
		Vector v = (Vector) session.getAttribute("vecteur");
		// Pour arborescence fichier depuis la servlet
		String path = request.getSession().getServletContext().getRealPath("/");

		// On instancie les emprunts
		ArrayList<Emprunt> listeEmprunt = new ArrayList<Emprunt>();
		int compteur = XMLEmprunt.nbEmprunt(path);
		for (int i = 1; i <= compteur; i++) {
			listeEmprunt.add(new Emprunt(XMLEmprunt.getVar(path, "mail", i), XMLEmprunt.getInt(path, "idLivre", i)));
		}

		
		// On instancie les livres empruntés
		int l = XMLAuteur.nbAuteur(path);
		int j = XMLLivre.nbLivre(path);
		ArrayList<Auteur> listeAuteur = new ArrayList<Auteur>();
		for (int i = 1; i <= l; i++) {
			listeAuteur.add(new Auteur(XMLAuteur.getVar(path, "nom", i), XMLAuteur.getVar(path, "prenom", i)));
		}
		ArrayList<Livre> listeLivre = new ArrayList<Livre>();
		for (int m = 0; m < listeEmprunt.size(); m++) {

			for (int i = 1; i <= j; i++) {
				String nomAuteur = XMLLivre.getAuteur(path, i);
				for (int k = 0; k < l; k++) {
					if (listeAuteur.get(k).getNom().equals(nomAuteur)) {
						if (listeEmprunt.get(m).getMail().equals(v.elementAt(3))) {
							listeLivre.add(new Livre(XMLLivre.getVar(path, "titre", i), listeAuteur.get(k),
									XMLLivre.getVar(path, "genre", i), XMLLivre.getVar(path, "ISBN", i),
									XMLLivre.getVar(path, "nomEditeur", i), XMLLivre.getVar(path, "edition", i),
									XMLLivre.getInt(path, "anneeEdition", i), XMLLivre.getVar(path, "commentaire", i),
									XMLLivre.getDispo(path, "disponible", i)));
						}
					}
				}
			}
		}
		
		System.out.println(listeEmprunt.get(2).getMail());
		System.out.println(v.elementAt(3));
		System.out.println(listeEmprunt.get(1).getMail().equals(v.elementAt(3)));

		// On effectue un emprunt et on actualise la liste des emprunts de l'utilisateur
		System.out.println(request.getParameter("titre"));
		if (!(request.getParameter("titre").equals(null))) {
			Vector vecteur = new Vector();
			vecteur.addElement(v.get(0));
			vecteur.addElement(v.get(1));
			vecteur.addElement(v.get(2));
			vecteur.addElement(v.get(3));
			for (int i = 0; i < listeEmprunt.size(); i++) {
				vecteur.addElement(listeLivre.get(i).getTitre());
				vecteur.addElement(listeLivre.get(i).getAuteur().getNom());
				vecteur.addElement(listeLivre.get(i).getGenre());
				vecteur.addElement(listeLivre.get(i).getNomEditeur());

			}
			vecteur.addElement(request.getParameter("titre"));
			vecteur.addElement(request.getParameter("auteur"));
			vecteur.addElement(request.getParameter("genre"));
			vecteur.addElement(request.getParameter("editeur"));

			request.setAttribute("vecteur", vecteur);

			getServletConfig().getServletContext().getRequestDispatcher("/RendreEmprunt.jsp").forward(request,
					response);
		} else {
			// Cas où on va sur la page pour rendre un emprunt
			Vector vecteur = new Vector();
			vecteur.addElement(v.get(0));
			vecteur.addElement(v.get(1));
			vecteur.addElement(v.get(2));
			vecteur.addElement(v.get(3));
			for (int i = 0; i < listeEmprunt.size(); i++) {
				vecteur.addElement(listeLivre.get(i).getTitre());
				vecteur.addElement(listeLivre.get(i).getAuteur().getNom());
				vecteur.addElement(listeLivre.get(i).getGenre());
				vecteur.addElement(listeLivre.get(i).getNomEditeur());

			}
		}

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
