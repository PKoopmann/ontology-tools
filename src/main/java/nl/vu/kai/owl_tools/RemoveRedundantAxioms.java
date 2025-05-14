package nl.vu.kai.owl_tools;

import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.model.parameters.Imports;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

public class RemoveRedundantAxioms {

    public static String OUTPUT_FILE = "non-redundant.owl";

    public static void main(String[] args) throws OWLOntologyCreationException, FileNotFoundException, OWLOntologyStorageException {
        if(args.length!=1){
            System.out.println("Removes redundant axioms, that is, axioms entailed by the others.");
            System.out.println("Axioms are processed in arbitrary order.");
            System.out.println("This may be used to \"desaturate\" satutared ontologies, " +
                    "i.e. ontologies to which the classification result has been added");
            System.out.println();
            System.out.println("Usage:");
            System.out.println(RemoveRedundantAxioms.class.getName()+" ONTOLOGY_NAME");
            System.out.println("Stores resulting ontology in \""+OUTPUT_FILE+"\"");
            System.exit(0);
        }

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File(args[0]));

        OWLReasonerFactory reasonerFactory = new ReasonerFactory();
        OWLReasoner reasoner = reasonerFactory.createReasoner(ontology);

        Set<OWLLogicalAxiom> axioms = ontology.getLogicalAxioms(Imports.EXCLUDED);
        int count = 0;

        for(OWLLogicalAxiom axiom:axioms){
            ontology.remove(axiom);
            reasoner.flush();
            if(reasoner.isEntailed(axiom)){
                System.out.println(axiom);
                count++;
            } else
                ontology.add(axiom);
        }

        System.out.println(count+" axioms removed.");

        manager.saveOntology(ontology, new FileOutputStream(new File("non-redundant.owl")));
    }
}
