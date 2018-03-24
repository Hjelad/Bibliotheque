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
import XML.XMLLivre;
import XML.XMLPersonne;
import classes.Auteur;
import classes.Livre;
import classes.Personne;

/**
 * Servlet implementation class ServletEmprunter
 */
@WebServlet("/ServletEmprunter")
public class ServletEmprunter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEmprunter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Pour arborescence fichier depuis la servlet
		String path = request.getSession().getServletContext().getRealPath("/");
		
		// On instancie la liste des auteurs
		ArrayList<Auteur> listeAuteur = new ArrayList<Auteur>();
		int l = XMLAuteur.nbAuteur(path);
		for (int i = 1; i <= l; i++) {
			listeAuteur.add(new Auteur(XMLAuteur.getVar(path, "nom", i),XMLAuteur.getVar(path, "prenom", i)));
		}

		// On instancie la liste des livres
		ArrayList<Livre> listeLivre = new ArrayList<Livre>();
		int j = XMLLivre.nbLivre(path);
		for (int i = 1; i <= j; i++) {
			listeLivre.add(new Livre(XMLLivre.getVar(path, "titre", i), listeAuteur.get(1),
					XMLLivre.getVar(path, "genre", i), XMLLivre.getVar(path, "ISBN", i),
					XMLLivre.getVar(path, "nomEditeur", i),XMLLivre.getVar(path, "edition", i),XMLLivre.getAnnee(path, "anneeEdition", i),XMLLivre.getVar(path, "commentaire", i),XMLLivre.getDispo(path, "disponible", i)));
		}

		String titreOuvrage = "";
		String nomAuteur = "";
		String genre = "";
		String nomEditeur = "";
		int compteur = 0;

		/* Création ou récupération de la session */
		HttpSession session = request.getSession();

		if (request.getParameter("rechercheEmprunt") != null) {
			// Cas où on effectue une recherche sur la page Emprunter
			;
			String recherche = request.getParameter("rechercheEmprunt");

			for (int i = 0; i < listeLivre.size(); i++) {
				if (recherche.equals(listeLivre.get(i).getTitre())) {
					titreOuvrage = listeLivre.get(i).getTitre();
					nomAuteur = listeLivre.get(i).getAuteur().getNom();
					genre = listeLivre.get(i).getGenre();
					nomEditeur = listeLivre.get(i).getNomEditeur();
				} else {
					compteur++;
				}
			}

			if (compteur != listeLivre.size()) {
				// La recherche est fructueuse
				Vector v = (Vector) session.getAttribute("vecteur");
				Vector vecteur = new Vector();
				vecteur.addElement(v.elementAt(0));
				vecteur.addElement(v.elementAt(1));
				vecteur.addElement(v.elementAt(2));
				vecteur.addElement(titreOuvrage);
				vecteur.addElement(nomAuteur);
				vecteur.addElement(genre);
				vecteur.addElement(nomEditeur);
				// On ajoute le titre de la liste de tous les ouvrages pour l'auto-complétion de
				// la recherche
				for (int i = 0; i < listeLivre.size(); i++) {
					vecteur.addElement(listeLivre.get(i).getTitre());
				}
				vecteur.addElement(listeLivre.size());

				System.out.println(vecteur.size());

				request.setAttribute("vecteur", vecteur);
				getServletConfig().getServletContext().getRequestDispatcher("/Recherche.jsp").forward(request,
						response);
			} else {
				// La recherche ne renvoie à aucun résultat
				Vector v = (Vector) session.getAttribute("vecteur");
				Vector vecteur = new Vector();
				vecteur.addElement(v.elementAt(0));
				vecteur.addElement(v.elementAt(1));
				vecteur.addElement(v.elementAt(2));
				vecteur.addElement(titreOuvrage);
				vecteur.addElement(nomAuteur);
				vecteur.addElement(genre);
				vecteur.addElement(nomEditeur);

				// On ajoute le titre de la liste de tous les ouvrages pour l'auto-complétion de
				// la recherche
				for (int i = 0; i < listeLivre.size(); i++) {
					vecteur.addElement(listeLivre.get(i).getTitre());
				}
				vecteur.addElement(listeLivre.size());
				System.out.println(vecteur.size());

				request.setAttribute("vecteur", vecteur);
				getServletConfig().getServletContext().getRequestDispatcher("/Recherche.jsp").forward(request,
						response);
			}
		} else {
			// Cas où on accède à la page Emprunter depuis une autre page
			// On affiche tous les livres

			Vector vecteur = (Vector) session.getAttribute("vecteur");
			if (vecteur.size() != 4) {
				for (int i = vecteur.size(); i > 3; i--) {
					vecteur.removeElementAt(i - 1);
				}
			}
			for (int i = 0; i < listeLivre.size(); i++) {
				titreOuvrage = listeLivre.get(i).getTitre();
				nomAuteur = listeLivre.get(i).getAuteur().getNom();
				genre = listeLivre.get(i).getGenre();
				nomEditeur = listeLivre.get(i).getNomEditeur();
				vecteur.addElement(titreOuvrage);
				vecteur.addElement(nomAuteur);
				vecteur.addElement(genre);
				vecteur.addElement(nomEditeur);
			}

			// On ajoute le titre de la liste de tous les ouvrages pour l'auto-complétion de
			// la recherche
			for (int i = 0; i < listeLivre.size(); i++) {
				vecteur.addElement(listeLivre.get(i).getTitre());
			}
			vecteur.addElement(listeLivre.size());

			request.setAttribute("vecteur", vecteur);
			System.out.println(vecteur.size());
			getServletConfig().getServletContext().getRequestDispatcher("/Recherche.jsp").forward(request, response);

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
