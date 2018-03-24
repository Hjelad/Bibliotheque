package XML;

import java.io.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.filter.*;
import java.util.List;
import java.util.Iterator;

public class JDOM2 {
	static org.jdom.Document document;
	static Element racine;

	// Ajouter cette méthodes à la classe JDOM2
	static void afficheALL() {
		// On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List liste = racine.getChild("listpersonne").getChildren("personne");
		
		// On crée un Iterator sur notre liste
		Iterator i = liste.iterator();
		while (i.hasNext()) {
			// On recrée l'Element courant à chaque tour de boucle afin de
			// pouvoir utiliser les méthodes propres aux Element comme :
			// sélectionner un nœud fils, modifier du texte, etc...
			Element courant = (Element) i.next();
			// On affiche le nom de l&#8217;élément courant
			System.out.println(courant.getChild("nom").getText());
		}
	}

	public static void main(String[] args) {
		// On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			// Le parsing est terminé ;)
			document = sxb.build(new File("/Users/Killian/Documents/Etudes/M1 MIAGE/Semestre 7/POO/TD/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Bibliotheque/personne.xml"));
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();

		// Méthode définie dans la partie 3.2. de cet article
		afficheALL();
	}
}