package servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Création ou récupération de la session */
		HttpSession session = request.getSession();
		
		// On instancie des objets de la classe Personne
		
			Personne p1 = new Personne("LÉZÉ","Gérard","gege.leze@gmail.com","gegedu41",false);
			Personne p2 = new Personne("DORÉ","Gaëtan","gaga.dore@gmail.com","gagadu37",false);
			Personne p3 = new Personne("CHALLEAU","Killian","kiki.challeau@gmail.com","kikidu64",true);

		// On créé un tableau contenant des objets de type Personne
				
			Personne[] p = {p1,p2,p3};		
			String mail = request.getParameter("email");
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			String password = request.getParameter("password");
			boolean admin = false;
			int compteur = 0;
			
			for (int i=0;i<p.length;i++) {
				if(!(mail.equals(p[i].getMail()))) {
					compteur++;
				}
			}
			
			if(compteur == p.length) {
				// Inscription réussie, on instancie un objet Personne et on redirige l'utilisateur vers la page d'accueil
				Personne pers  = new Personne(nom,prenom,mail,password,false);
				Vector vecteur = new Vector();
				vecteur.addElement(prenom);
				vecteur.addElement(nom);
				vecteur.addElement(admin);
				request.setAttribute("vecteur", vecteur);
				getServletConfig().getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
			}else {
				// Echec de l'inscription, on invite l'utilisateur à de nouveau s'inscrire
				getServletConfig().getServletContext().getRequestDispatcher("/ErreurInscription.jsp").forward(request, response);
			}
			
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
