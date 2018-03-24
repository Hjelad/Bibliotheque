package classes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//This statement means that class "Bookstore.java" is the root-element of our example
@XmlRootElement(namespace = "classes")
public class Auteurs {

    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "listauteur")
    // XmlElement sets the name of the entities
    @XmlElement(name = "auteur")
    private ArrayList<Auteur> listAuteur;
    
    public void setListAuteur(ArrayList<Auteur> listAuteur) {
        this.listAuteur =  listAuteur;
    }

    public ArrayList<Auteur> getListsAuteur() {
        return  listAuteur;
    }
}