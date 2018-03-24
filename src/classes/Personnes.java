package classes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//This statement means that class "Bookstore.java" is the root-element of our example
@XmlRootElement(namespace = "classes")
public class Personnes {

    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "listpersonne")
    // XmlElement sets the name of the entities
    @XmlElement(name = "personne")
    private ArrayList<Personne> listPersonne;
    
    public void setListPersonne(ArrayList<Personne> listPersonne) {
        this.listPersonne =  listPersonne;
    }

    public ArrayList<Personne> getListsPersonne() {
        return  listPersonne;
    }
}
