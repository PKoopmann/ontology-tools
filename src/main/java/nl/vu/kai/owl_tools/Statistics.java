package nl.vu.kai.owl_tools;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.parameters.Imports;

import java.io.File;

public class Statistics {
    public static void main(String[] args) throws OWLOntologyCreationException {
        if(args.length!=1){
            System.out.println("Usage:");
            System.out.println(Statistics.class.getName()+" ONTOLOGY_NAME");
            System.exit(0);
        }

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        OWLO

        OWLOntology ontology = manager.loadOntology(IRI.create(new File(args[0])));

        System.out.println("Including imports");
        System.out.println("FileName LogicalAxioms TBoxAxioms ABoxAxioms RBoxAxioms Individuals Classes ObjectProperties DataProperties");
        System.out.println(args[0]+" "+
                ontology.logicalAxioms(Imports.INCLUDED).count()+" "+
                ontology.tboxAxioms(Imports.INCLUDED).count()+" "+
                ontology.aboxAxioms(Imports.INCLUDED).count()+" "+
                ontology.rboxAxioms(Imports.INCLUDED).count()+" "+
                ontology.individualsInSignature().count()+" "+
                ontology.classesInSignature(Imports.INCLUDED).count()+" "+
                ontology.objectPropertiesInSignature(Imports.INCLUDED).count()+" "+
                ontology.dataPropertiesInSignature(Imports.INCLUDED).count()
                );
    }
}
