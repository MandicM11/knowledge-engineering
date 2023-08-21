package app.Knowledge_engineering.service;

import app.Knowledge_engineering.dto.MonitorRequestDTO;
import app.Knowledge_engineering.dto.MonitorResponseDTO;

import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.vocab.OWLFacet;
import org.semanticweb.owlapi.vocab.XSDVocabulary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MonitorService {
    private OntologyManager ontologyManager;
    private OWLOntologyManager manager;
    private OWLDataFactory dataFactory;
    private OWLReasonerFactory reasonerFactory;
    private OWLReasoner reasoner;
    private static String baseIRI = "http://www.semanticweb.org/pc/ontologies/2023/3/external_hardware";
    private OWLClassExpression classMonitor;
    private OWLDataProperty name;
    private OWLDataProperty resolution;
    private OWLDataProperty size;

    public MonitorService() throws OWLOntologyCreationException {
        ontologyManager = new OntologyManager();
        manager = OWLManager.createOWLOntologyManager();
        dataFactory = manager.getOWLDataFactory();
        reasonerFactory = new ReasonerFactory();
        reasoner = reasonerFactory.createReasoner(this.ontologyManager.getOntology());

        classMonitor = dataFactory.getOWLClass(IRI.create(baseIRI + "Monitor"));
        name = dataFactory.getOWLDataProperty(IRI.create(baseIRI + "monitor_has_name"));
        resolution = dataFactory.getOWLDataProperty(IRI.create(baseIRI + "monitor_has_resolution"));
        size = dataFactory.getOWLDataProperty(IRI.create(baseIRI + "monitor_has_size"));
    }
    /*
    public List<MonitorResponseDTO> getAllMonitors() {
        return getAllMonitorsDTOs(classMonitor);
    }

    private List<MonitorResponseDTO> getAllMonitorsDTOs(OWLClassExpression classMonitor) {
        Set<OWLNamedIndividual> individuals = reasoner.getInstances(classMonitor, false).getFlattened();
        List<MonitorResponseDTO> monitors = new ArrayList<>();
        for (OWLNamedIndividual individual : individuals) {
            monitors.add(setDataProperties(individual));
        }
        return monitors;
    }

    private MonitorResponseDTO setDataProperties(OWLNamedIndividual individual) {
        MonitorResponseDTO monitorResponseDTO = new MonitorResponseDTO();
        for (OWLDataPropertyAssertionAxiom assertion : ontologyManager.getOntology().getDataPropertyAssertionAxioms(individual)) {
            OWLDataProperty property = assertion.getProperty().asOWLDataProperty();
            if (name.equals(property)) {
                OWLLiteral value = assertion.getObject();
                monitorResponseDTO.setName(value.getLiteral());
            } else if (resolution.equals(property)) {
                OWLLiteral value = assertion.getObject();
                monitorResponseDTO.setResolution(value.getLiteral());
            } else if (size.equals(property)) {
                OWLLiteral value = assertion.getObject();
                monitorResponseDTO.setSize(Double.parseDouble(value.getLiteral()));
            }
        }
        return monitorResponseDTO;
    }

     */
}
