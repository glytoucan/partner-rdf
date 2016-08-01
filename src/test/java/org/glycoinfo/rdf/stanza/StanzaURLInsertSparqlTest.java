package org.glycoinfo.rdf.stanza;

import org.glycoinfo.rdf.SparqlException;
import org.glycoinfo.rdf.dao.SparqlDAO;
import org.glycoinfo.rdf.dao.SparqlEntity;
import org.glycoinfo.rdf.dao.virt.VirtSesameTransactionConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { VirtSesameTransactionConfig.class })
@Configuration
@EnableAutoConfiguration 
public class StanzaURLInsertSparqlTest extends StanzaURLInsertSparql {
	// output insert sparql
	@Bean
	StanzaURLInsertSparql getStanzaURLInsertSparql(){
		StanzaURLInsertSparql ins = new StanzaURLInsertSparql();
		SparqlEntity sparqlentity = new SparqlEntity();
		sparqlentity.setValue(StanzaURL.StanzaIndexURL, "http://test.stanza.glycoinfo.org/stanza/summary/");
		ins.setSparqlEntity(sparqlentity);
		ins.setGraph("http://rdf.glytoucan.org/external/stanza");
		return ins;
	}
	
//	@Test
//	public void testInsertSparql() throws SparqlException {
//		logger.debug(getStanzaURLInsertSparql().getSparql());
//	}
	
	@Autowired
	SparqlDAO sparqlDAO;

	// exec insert sparql as the test
	@Test
	@Transactional
	public void insertSparql() throws SparqlException {
		sparqlDAO.insert(getStanzaURLInsertSparql());
	}
	

}
