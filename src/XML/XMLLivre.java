package XML;

import java.io.File;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import org.jdom2.*;
import org.jdom2.input.*;
import java.util.List;
import java.util.Iterator;

import classes.Auteur;
import classes.Bibliotheque;
import classes.Livre;

public class XMLLivre {

	static Document document;
	static Element racine;

	public static void serialisation(ArrayList<Livre> listeLivre, String path) {

		// create bookstore, assigning book
		Bibliotheque bibliotheque = new Bibliotheque();
		bibliotheque.setListLivre(listeLivre);

		// create JAXB context and instantiate marshaller
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(Bibliotheque.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Marshaller m = null;
		try {
			m = context.createMarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Write to File
		try {
			m.marshal(bibliotheque, new File(path + "livre.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getVar(String path, String var, int compteur) {
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			// Le parsing est terminé ;)
			document = sxb.build(new File(path + "livre.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		// On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List liste = racine.getChild("listlivre").getChildren("livre");

		Iterator i = liste.iterator();
		Element courant = null;
		for (int j = 0; j < compteur; j++) {
			courant = (Element) i.next();
		}
		return courant.getChild(var).getText();
	}
	
	public static Auteur getAuteur(String path, String var) {
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			// Le parsing est terminé ;)
			document = sxb.build(new File(path + "livre.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		// On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List liste = racine.getChild("listlivre").getChildren("livre");

		Iterator i = liste.iterator();
		Element courant = null;
		courant = (Element) i.next();
		Auteur auteur = (Auteur) courant.getChild(var).getChildren();
		return auteur;
	}
	
	public static int getAnnee(String path, String var, int compteur) {
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			// Le parsing est terminé ;)
			document = sxb.build(new File(path + "livre.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		// On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List liste = racine.getChild("listlivre").getChildren("livre");

		Iterator i = liste.iterator();
		Element courant = null;
		for (int j = 0; j < compteur; j++) {
			courant = (Element) i.next();
		}
		int annee = Integer.parseInt(courant.getChild(var).getText());
		return annee;
	}
	
	public static boolean getDispo(String path, String var, int compteur) {
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			// Le parsing est terminé ;)
			document = sxb.build(new File(path + "livre.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		// On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List liste = racine.getChild("listlivre").getChildren("livre");

		Iterator i = liste.iterator();
		Element courant = null;
		for (int j = 0; j < compteur; j++) {
			courant = (Element) i.next();
		}
		String convert = courant.getChild(var).getText();
		boolean dispo = false;
		if (convert == "true") {
			dispo = true;
		}
		return dispo;
	}
	

	public static int nbLivre(String path) {
		int nb = 0;
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			// Le parsing est terminé ;)
			document = sxb.build(new File(path + "livre.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		// On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List liste = racine.getChild("listlivre").getChildren("livre");

		Iterator i = liste.iterator();
		while (i.hasNext()) {

			Element courant = (Element) i.next();
			nb++;
		}

		return nb;
	}

}