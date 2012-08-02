package com.rplp.icc.authorization.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * Represents an organization that the {@link Person} is a member of.
 * 
 * @author oloa
 *
 */
@JsonAutoDetect
public class Organization {

	
	private String orgNr;
	
	public String getOrgNr() {
		return orgNr;
	}

	public void setOrgNo(String orgNr) {
		this.orgNr = orgNr;
	}
}
