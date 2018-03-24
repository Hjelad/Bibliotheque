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
import classes.Auteurs;

public class XMLAuteur {

	static Document document;
	static Element racine;

	public static void serialisation(ArrayList<Auteur> listeAuteur, String path) {

		// create bookstore, assigning book
		Auteurs auteurs = new Auteurs();
		auteurs.setListAuteur(listeAuteur);

		// create JAXB context and instantiate marshaller
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(Auteurs.class);
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
			m.marshal(auteurs, new File(path + "auteur.xml"));
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
			document = sxb.build(new File(path + "auteur.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		// On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List liste = racine.getChild("listauteur").getChildren("auteur");

		Iterator i = liste.iterator();
		Element courant = null;
		for (int j = 0; j < compteur; j++) {
			courant = (Element) i.next();
		}
		return courant.getChild(var).getText();
	}
	

	public static int nbAuteur(String path) {
		int nb = 0;
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			// Le parsing est terminé ;)
			document = sxb.build(new File(path + "auteur.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		// On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List liste = racine.getChild("listauteur").getChildren("auteur");

		Iterator i = liste.iterator();
		while (i.hasNext()) {

			Element courant = (Element) i.next();
			nb++;
		}

		return nb;
	}

}