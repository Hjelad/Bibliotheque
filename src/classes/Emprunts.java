package classes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//This statement means that class "Bookstore.java" is the root-element of our example
@XmlRootElement(namespace = "classes")
public class Emprunts {

    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "listemprunt")
    // XmlElement sets the name of the entities
    @XmlElement(name = "emprunt")
    private ArrayList<Emprunt> listEmprunt;
    
    public void setListEmprunt(ArrayList<Emprunt> listEmprunt) {
        this.listEmprunt =  listEmprunt;
    }

    public ArrayList<Emprunt> getListsEmprunt() {
        return  listEmprunt;
    }
}
