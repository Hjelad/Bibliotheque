package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Auteur;
import classes.Editeur;
import classes.Livre;
import classes.Ouvrage;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// On instancie des auteurs
		
		Auteur a1 = new Auteur("Camus","Albert");
		Auteur a2 = new Auteur("Tolkien","J. R. R.");

		
		// On instancie des ouvrages
		
		Ouvrage o1 = new Ouvrage("L'Étranger",a1,"Roman");
		Ouvrage o2 = new Ouvrage("L'Homme révolté",a1,"Essai");
		Ouvrage o3 = new Ouvrage("La Peste",a1,"Roman");
		Ouvrage o4 = new Ouvrage("Le Seigneur des anneaux - La Communauté de l'anneau",a2,"Roman");
		Ouvrage o5 = new Ouvrage("Le Seigneur des anneaux - Les Deux Tours",a2,"Roman");
		Ouvrage o6 = new Ouvrage("Le Seigneur des anneaux - Le Retour du roi",a2,"Roman");


		
		// On instancie des Editeurs
		
		Editeur e1 =new Editeur("Hachette Livre","Français");
		Editeur e2 =new Editeur("Édition Atlas","Français");
		Editeur e3 =new Editeur("Pearson Plc","Royaume-Uni");

		
		// On instancie des livres

		Livre l1 = new Livre(o1,e1,"2-266-11156-6","Première édition",1942,"Bon état général",true);
		Livre l2 = new Livre(o2,e1,"7-546-65483-1","Troisième édition",1951,"R.A.S",false);
		Livre l3 = new Livre(o3,e2,"8-493-29586-3","Edition rare",1947,"Première de couverture en mauvais état",false);
		Livre l4 = new Livre(o4,e3,"7-394-43947-2","Edition Alan Lee",1954,"Etat OK",false);
		Livre l5 = new Livre(o5,e3,"8-453-43298-6","Edition Alan Lee",1954,"R.A.S",false);
		Livre l6 = new Livre(o6,e3,"1-463-75843-3","Edition Alan Lee",1955,"Page 54 manquante",true);

		
		
		
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
