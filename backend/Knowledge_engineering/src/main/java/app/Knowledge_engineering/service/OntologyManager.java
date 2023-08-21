package app.Knowledge_engineering.service;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OntologyManager {
    public OWLOntology getOntology() {
        return ontology;
    }
    private OWLOntology ontology;

    public OntologyManager() throws OWLOntologyCreationException {
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();

        OWLOntology ontology = man.loadOntologyFromOntologyDocument(new File("data/Knowledge_base.ttl"));

        this.ontology = ontology;
    }
}