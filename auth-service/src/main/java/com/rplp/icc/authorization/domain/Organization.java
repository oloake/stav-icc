package com.rplp.icc.authorization.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Represents an organization that the {@link Person} is a member of.
 * 
 * @author oloa
 *
 */
public class Organization {

	
	@JsonProperty
	private String orgNr;
	
	public String getOrgNr() {
		return orgNr;
	}

	public void setOrgNo(String orgNr) {
		this.orgNr = orgNr;
	}
}
