package org.glycoinfo.rdf.partner;

import org.apache.commons.lang.StringUtils;
import org.glycoinfo.rdf.InsertSparqlBean;

/*
 
Insert partner metadata into /partner graph by insert sparql.
  
@prefix rdfs:   <http://www.w3.org/2000/01/rdf-schema#> .
@prefix dcterms: <http://purl.org/dc/terms/> .
@prefix glytoucan:  <http://www.glytoucan.org/glyco/owl/glytoucan#> .

<http://rdf.glytoucan.org/partner/{partner_name}>
    a   glytoucan:Partner ;
    rdfs:label  "{partner_name}"@en;
    dcterms:description "{description}"@en ; 
    rdfs:seeAlso <{partner_url}>.

	@author shinmachi
 */
public class PartnerMetaInsertSparql extends InsertSparqlBean implements Partner {
	
	void init(){
		this.prefix = "\n\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "\n"
				+ "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "\n"
				+ "PREFIX glytoucan:  <http://www.glytoucan.org/glyco/owl/glytoucan#>"
				+ "\n\n" ;
	}

	public PartnerMetaInsertSparql() {
		init();
	}

	public String getInsert() {
		if (StringUtils.isNotBlank(getSparqlEntity().getValue(PartnerName)) && StringUtils.isNotBlank(getSparqlEntity().getValue(PartnerName))) {
			this.insert = "<http://rdf.glycoinfo.org/partner/" + getSparqlEntity().getValue(PartnerUriName) +"> \n"
					+ " a glytoucan:Partner ; \n"
					+ " dcterms:description \"" + getSparqlEntity().getValue(PartnerDesc) + "\"@en ; \n"
					+ " rdfs:seeAlso " + getSparqlEntity().getValue(PartnerURL) + " ; \n"
					+ " rdfs:label \""+ getSparqlEntity().getValue(PartnerName) +"\"@en .\n";
		}
		return this.insert;
	}
}
