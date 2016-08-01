package org.glycoinfo.rdf.stanza;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glycoinfo.rdf.SparqlException;
import org.glycoinfo.rdf.dao.SparqlDAO;
import org.glycoinfo.rdf.dao.SparqlEntity;
import org.glycoinfo.rdf.dao.virt.VirtSesameTransactionConfig;
import org.glycoinfo.rdf.partner.PartnerMetaInsertSparqlTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/*
 * Test the insert of stanza url
 * @author shinmachi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { VirtSesameTransactionConfig.class, StanzaURLInsertSparqlTest.class})
@Configuration
@EnableAutoConfiguration 
public class StanzaURLInsertSparqlTest {
	

	// Output insert sparql
	@Bean
	StanzaURLInsertSparql getStanzaURLInsertSparql(){
		StanzaURLInsertSparql ins = new StanzaURLInsertSparql();
		SparqlEntity sparqlentity = new SparqlEntity();
		sparqlentity.setValue(StanzaURL.StanzaIndexURL, "http://test.stanza.glycoinfo.org/stanza/summary/");
		ins.setSparqlEntity(sparqlentity);
		ins.setGraph("http://rdf.glytoucan.org/external/stanza");
		return ins;
	}

	// Select sparql
	@Bean
	StanzaURLSelectSparql getStanzaURLSelectSparql() {
		StanzaURLSelectSparql sss = new StanzaURLSelectSparql();
		return sss;
	}
	
	
	@Autowired
	SparqlDAO sparqlDAO;

	// Exec insert sparql and confirm the insert as the test
	@Test
	@Transactional
	public void insertSparql() throws SparqlException {
		sparqlDAO.insert(getStanzaURLInsertSparql());
		sparqlDAO.query(getStanzaURLSelectSparql());
	}

	/*
	private static final Log logger = LogFactory.getLog(StanzaURLInsertSparqlTest.class);

	@Test
	public void testInsertSparql() throws SparqlException {
		String test = getStanzaURLInsertSparql().getSparql();
		System.out.println(test);
		logger.debug(getStanzaURLInsertSparql().getSparql());
	}
	*/

	

}
