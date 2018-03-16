package servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.Personne;
/**
 * Servlet implementation class Test_TD3
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// On instancie des objets de la classe Personne
		
		Personne p1 = new Personne("LÉZÉ","Gérard","gege.leze@gmail.com","gegedu41",false);
		Personne p2 = new Personne("DORÉ","Gaëtan","gaga.dore@gmail.com","gagadu37",false);
		Personne p3 = new Personne("CHALLEAU","Killian","kiki.challeau@gmail.com","kikidu64",true);

		// On créé un tableau contenant des objets de type Personne
		
		Personne[] p = {p1,p2,p3};		
		String mail = request.getParameter("email");
		String password = request.getParameter("password");
		String nom = null;
		String prenom=null;
		int compteur = 0;
		
		// Boucle permettant d'obtenir le nom et prénom d'une personne en fonction de l'adresse mail et du mot de passe
		// Si l'adresse mail et le mot de passe n'existent dans aucune instance, on renvoie un message d'erreur
		for (int i=0;i<p.length;i++) {
			if(mail.equals(p[i].getMail()) && password.equals(p[i].getMotDePasse())) {
				nom = p[i].getNom();
				prenom = p[i].getPrenom();
			}else{
				compteur++;
			}
		}
		
		if(compteur == p.length) {
			// Echec de connexion, on invite l'utilisateur à se reloguer
			getServletConfig().getServletContext().getRequestDispatcher("/ErreurConnexion.jsp").forward(request, response);

		}else {
			// Connexion réussie, on redirige l'utilisateur vers la page d'accueil
			Vector vecteur = new Vector();
			vecteur.addElement(prenom);
			vecteur.addElement(nom);
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
