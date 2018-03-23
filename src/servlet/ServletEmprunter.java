package servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Auteur;
import classes.Editeur;
import classes.Livre;
import classes.Ouvrage;

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

		// On instancie des auteurs

		Auteur a1 = new Auteur("Camus", "Albert");
		Auteur a2 = new Auteur("Tolkien", "J. R. R.");

		// On instancie des ouvrages

		Ouvrage o1 = new Ouvrage("L'Étranger", a1, "Roman");
		Ouvrage o2 = new Ouvrage("L'Homme révolté", a1, "Essai");
		Ouvrage o3 = new Ouvrage("La Peste", a1, "Roman");
		Ouvrage o4 = new Ouvrage("Le Seigneur des anneaux - La Communauté de l'anneau", a2, "Roman");
		Ouvrage o5 = new Ouvrage("Le Seigneur des anneaux - Les Deux Tours", a2, "Roman");
		Ouvrage o6 = new Ouvrage("Le Seigneur des anneaux - Le Retour du roi", a2, "Roman");

		// On instancie des Editeurs

		Editeur e1 = new Editeur("Hachette Livre", "Français");
		Editeur e2 = new Editeur("Édition Atlas", "Français");
		Editeur e3 = new Editeur("Pearson Plc", "Royaume-Uni");

		// On instancie des livres

		Livre l1 = new Livre(o1, e1, "2-266-11156-6", "Première édition", 1942, "Bon état général", true);
		Livre l2 = new Livre(o2, e1, "7-546-65483-1", "Troisième édition", 1951, "R.A.S", false);
		Livre l3 = new Livre(o3, e2, "8-493-29586-3", "Edition rare", 1947, "Première de couverture en mauvais état",
				false);
		Livre l4 = new Livre(o4, e3, "7-394-43947-2", "Edition Alan Lee", 1954, "Etat OK", false);
		Livre l5 = new Livre(o5, e3, "8-453-43298-6", "Edition Alan Lee", 1954, "R.A.S", false);
		Livre l6 = new Livre(o6, e3, "1-463-75843-3", "Edition Alan Lee", 1955, "Page 54 manquante", true);
		Livre[] l = { l1, l2, l3, l4, l5, l6 };
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

			for (int i = 0; i < l.length; i++) {
				if (recherche.equals(l[i].getOuvrage().getTitre())) {
					titreOuvrage = l[i].getOuvrage().getTitre();
					nomAuteur = l[i].getOuvrage().getAuteur().getNom();
					genre = l[i].getOuvrage().getGenre();
					nomEditeur = l[i].getEditeur().getNomEditeur();
				} else {
					compteur++;
				}
			}

			if (compteur != l.length) {
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
				for (int i = 0; i < l.length; i++) {
					vecteur.addElement(l[i].getOuvrage().getTitre());
				}
				vecteur.addElement(l.length);

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
				for (int i = 0; i < l.length; i++) {
					vecteur.addElement(l[i].getOuvrage().getTitre());
				}
				vecteur.addElement(l.length);
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
			for (int i = 0; i < l.length; i++) {
				titreOuvrage = l[i].getOuvrage().getTitre();
				nomAuteur = l[i].getOuvrage().getAuteur().getNom();
				genre = l[i].getOuvrage().getGenre();
				nomEditeur = l[i].getEditeur().getNomEditeur();
				vecteur.addElement(titreOuvrage);
				vecteur.addElement(nomAuteur);
				vecteur.addElement(genre);
				vecteur.addElement(nomEditeur);
			}
			
			// On ajoute le titre de la liste de tous les ouvrages pour l'auto-complétion de
			// la recherche
			for (int i = 0; i < l.length; i++) {
				vecteur.addElement(l[i].getOuvrage().getTitre());
			}
			vecteur.addElement(l.length);

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
