package org.glycoinfo.rdf.stanza;

import org.apache.commons.lang.StringUtils;
import org.glycoinfo.rdf.InsertSparqlBean;

/*
 *  Insert stanza url 
 *  <http://test.stanza.glycoinfo.org/stanza/summary/>
 *  	a glytoucan:Stanza_url;
 *  	rdfs:label "http://test.stanza.glycoinfo.org/stanza/summary/"^^xsd:string;
 *  	rdfs:seeAlso <http://test.stanza.glycoinfo.org/stanza/summary/help.html> .
 * 
 *  @author shinmachi
 */
public class StanzaURLInsertSparql extends InsertSparqlBean implements StanzaURL {

	public StanzaURLInsertSparql() {
		init();
	}

	void init(){
		this.prefix = "\n\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "\n"
				+ "PREFIX dcterms: <http://purl.org/dc/terms/>"
				+ "\n"
				+ "PREFIX glytoucan:  <http://www.glytoucan.org/glyco/owl/glytoucan#>"
				+ "\n\n" ;
	}

	public String getInsert() {
		if (StringUtils.isNotBlank(getSparqlEntity().getValue(StanzaIndexURL)) && StringUtils.isNotBlank(getSparqlEntity().getValue(StanzaIndexURL))) {
			this.insert = "<" + getSparqlEntity().getValue(StanzaIndexURL) + "> \n"
					+ " a glytoucan:Stanza_url; \n"
					+ " rdfs:label \""+ getSparqlEntity().getValue(StanzaIndexURL) +"\"^^xsd:string ;\n"
					+ " rdfs:seeAlso " + "<" + getSparqlEntity().getValue(StanzaIndexURL) + "help.html>  . \n";
		}
		return this.insert;
	}
}
