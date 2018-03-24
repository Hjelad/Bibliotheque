package classes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import classes.Personne;
import classes.Personnes;
public class Test {

    private static final String PERSONNE_XML = "./personne.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        ArrayList<Personne> listePersonne = new ArrayList<Personne>();

        // create personne
        Personne p1 = new Personne();
        p1.setNom("Leze");
        p1.setPrenom("Gerard");
        p1.setMail("gege@leze.fr");
        p1.setMotDePasse("foo");
        p1.setAdmin(true);
        listePersonne.add(p1);

        Personne p2 = new Personne();
        p2.setNom("Twist");
        p2.setPrenom("Killian");
        p2.setMail("kiki@twist.fr");
        p2.setMotDePasse("bar");
        p2.setAdmin(false);
        listePersonne.add(p2);

        // create bookstore, assigning book
        Personnes pers = new Personnes();
        pers.setListPersonne(listePersonne);

        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Personnes.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(pers, System.out);

        // Write to File
        m.marshal(pers, new File(PERSONNE_XML));

        // get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Personnes pers2 = (Personnes) um.unmarshal(new FileReader(
                PERSONNE_XML));
        ArrayList<Personne> list = pers2.getListsPersonne();
        for (Personne per : list) {
            System.out.println("Personne: " + per.getNom() + "  "
                    + per.getPrenom());
        }
    }
}