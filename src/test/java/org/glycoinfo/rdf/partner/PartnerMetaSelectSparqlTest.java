package org.glycoinfo.rdf.partner;

import org.glycoinfo.rdf.SparqlException;
import org.glycoinfo.rdf.dao.SparqlDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

public class PartnerMetaSelectSparqlTest extends PartnerMetaSelectSparql {

	@Autowired
	SparqlDAO sparqlDAO;
	
	// Select sparql
	@Bean
	PartnerMetaSelectSparql getPartnerMetaSelectSparql() {
		PartnerMetaSelectSparql pss = new PartnerMetaSelectSparql();
		return pss ;
	}
	@Test
	public void testSelectSparql() throws SparqlException {
		logger.debug(getPartnerMetaSelectSparql().getSparql());
	}

	
	// execSparl
	@Test
	@Transactional
	public void insertSparql() throws SparqlException {
		sparqlDAO.query(getPartnerMetaSelectSparql());
	}

}
