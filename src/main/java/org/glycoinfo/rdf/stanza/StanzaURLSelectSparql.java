package org.glycoinfo.rdf.stanza;

import org.glycoinfo.rdf.SelectSparqlBean;
import org.glycoinfo.rdf.SparqlException;

/*
 *  Select sparql for retrieving a stanza url
 *  @author shinmachi
 */
public class StanzaURLSelectSparql extends SelectSparqlBean implements StanzaURL {
	
	public StanzaURLSelectSparql(String sparql) {
		super(sparql);
	}
	
	public StanzaURLSelectSparql() {
		super();
		this.prefix = "\n\n"
			+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
			+ "\n"
			+ "PREFIX dcterms: <http://purl.org/dc/terms/>"
			+ "\n"
			+ "PREFIX glytoucan:  <http://www.glytoucan.org/glyco/owl/glytoucan#>"
			+ "\n" ;

//		this.select = "DISTINCT ?stanza_url \n";
		this.select = "DISTINCT ?stanza_url \n";

//		this.from = "FROM <http://test>"
//				+ "\n";
	}
	
	@Override
	public String getWhere() throws SparqlException {
		String where = "\n" 
				+ "?stanza_url a glytoucan:Stanza_url ."
//				+ "?stanza_url a glytoucan:Stanza_url ."
				+ "\n";
		return where;
	}

}