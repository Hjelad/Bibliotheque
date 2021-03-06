package classes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//This statement means that class "Bookstore.java" is the root-element of our example
@XmlRootElement(namespace = "classes")
public class Bibliotheque {

    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "listlivre")
    // XmlElement sets the name of the entities
    @XmlElement(name = "livre")
    private ArrayList<Livre> listLivre;
    
    public void setListLivre(ArrayList<Livre> listLivre) {
        this.listLivre =  listLivre;
    }

    public ArrayList<Livre> getListsLivre() {
        return  listLivre;
    }
}