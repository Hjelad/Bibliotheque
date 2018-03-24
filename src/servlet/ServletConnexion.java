package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import XML.XMLPersonne;
import classes.Personne;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")

public class ServletConnexion extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletConnexion() {
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

		// On instancie la personne qui se connecte
	    // Pour arborescence fichier depuis la servlet
	       String path = request.getSession().getServletContext().getRealPath("/");
	    // On affiche les noms (fixés en dur dans la fonction de la classe XMLPersonne)
		
		


		if (request.getParameter("email") != null) {

			// On instancie les Personnes présent dans notre fichier XML
			ArrayList<Personne> listePersonne = new ArrayList<Personne>();
		    int j =XMLPersonne.nbPersonne(path);
			for(int i=1;i<=j;i++) {
				listePersonne.add(new Personne(XMLPersonne.getVar(path, "nom",i),XMLPersonne.getVar(path, "prenom",i),XMLPersonne.getVar(path, "mail",i),XMLPersonne.getVar(path, "motDePasse",i),XMLPersonne.getStatut(path, "admin",i)));
		    }


			// On créé un tableau contenant des objets de type Personne

			String mail = request.getParameter("email");
			String password = request.getParameter("password");
			String nom = null;
			String prenom = null;
			boolean admin = false;
			int compteur = 0;

			// Boucle permettant d'obtenir le nom et prénom d'une personne en fonction de
			// l'adresse mail et du mot de passe
			// Si l'adresse mail et le mot de passe n'existent dans aucune instance, on
			// renvoie un message d'erreur
			for (int i = 0; i < listePersonne.size(); i++) {
				if (mail.equals(listePersonne.get(i).getMail()) && password.equals(listePersonne.get(i).getMotDePasse())) {
					nom = listePersonne.get(i).getNom();
					prenom = listePersonne.get(i).getPrenom();
					admin= listePersonne.get(i).getAdmin();
				} else {
					compteur++;
				}
			}

			if (compteur == listePersonne.size()) {
				// Echec de connexion, on invite l'utilisateur à se reloguer
				getServletConfig().getServletContext().getRequestDispatcher("/ErreurConnexion.jsp").forward(request,
						response);

			} else {
				// Connexion réussie, on redirige l'utilisateur vers la page d'accueil
				Vector vecteur = new Vector();
				vecteur.addElement(prenom);
				vecteur.addElement(nom);
				vecteur.addElement(admin);
				vecteur.addElement(mail);
				session.setAttribute("vecteur", vecteur);
				request.setAttribute("vecteur", vecteur);
				getServletConfig().getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);

			}
		}else {
			Vector vecteur = (Vector) session.getAttribute("vecteur");
			request.setAttribute("vecteur", vecteur);
			getServletConfig().getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
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
