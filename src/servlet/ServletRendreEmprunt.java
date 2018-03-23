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
		
		/* Création ou récupération de la session */
		HttpSession session = request.getSession();
		
		Vector vecteur = (Vector) session.getAttribute("vecteur");
		request.setAttribute("vecteur", vecteur);
		
		getServletConfig().getServletContext().getRequestDispatcher("/RendreEmprunt.jsp").forward(request, response);

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
