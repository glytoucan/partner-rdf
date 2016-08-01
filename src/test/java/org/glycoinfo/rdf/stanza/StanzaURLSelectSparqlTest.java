package org.glycoinfo.rdf.stanza;

import org.glycoinfo.rdf.SparqlException;
import org.glycoinfo.rdf.dao.SparqlEntity;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

public class StanzaURLSelectSparqlTest extends StanzaURLSelectSparql {

	// select test
	@Bean
	StanzaURLSelectSparql getStanzaURLSelectSparql() {
		StanzaURLSelectSparql select = new StanzaURLSelectSparql();
		SparqlEntity sparqlentity = new SparqlEntity();
		select.setSparqlEntity(sparqlentity);
		return select;
	}

	@Test
	public void testSelectSparql() throws SparqlException {
		logger.debug(getStanzaURLSelectSparql().getSparql());
	}

}
