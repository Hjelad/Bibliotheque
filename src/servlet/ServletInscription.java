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

import XML.XMLPersonne;
import classes.Personne;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletInscription() {
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

		String path = request.getSession().getServletContext().getRealPath("/");

		// On instancie les Personnes présent dans notre fichier XML
		ArrayList<Personne> listePersonne = new ArrayList<Personne>();
		int j = XMLPersonne.nbPersonne(path);
		for (int i = 1; i <= j; i++) {
			listePersonne.add(new Personne(XMLPersonne.getVar(path, "nom", i), XMLPersonne.getVar(path, "prenom", i),
					XMLPersonne.getVar(path, "mail", i), XMLPersonne.getVar(path, "motDePasse", i),
					XMLPersonne.getStatut(path, "admin", i)));
		}

		// On créé un tableau contenant des objets de type Personne

		String mail = request.getParameter("email");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String password = request.getParameter("password");
		boolean admin = false;
		int compteur = 0;

		for (int i = 0; i < listePersonne.size(); i++) {
			if (!(mail.equals(listePersonne.get(i).getMail()))) {
				compteur++;
			}
		}

		if (compteur == listePersonne.size()) {
			// Inscription réussie, on instancie un objet Personne et on redirige
			// l'utilisateur vers la page d'accueil
			Personne pers = new Personne(nom, prenom, mail, password, false);
			listePersonne.add(pers);
			XMLPersonne.serialisation(listePersonne, path);
			Vector vecteur = new Vector();
			vecteur.addElement(prenom);
			vecteur.addElement(nom);
			vecteur.addElement(admin);
			vecteur.addElement(mail);
			request.setAttribute("vecteur", vecteur);
			session.setAttribute("vecteur", vecteur);
			getServletConfig().getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
		} else {
			// Echec de l'inscription, on invite l'utilisateur à de nouveau s'inscrire
			getServletConfig().getServletContext().getRequestDispatcher("/ErreurInscription.jsp").forward(request,
					response);
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
