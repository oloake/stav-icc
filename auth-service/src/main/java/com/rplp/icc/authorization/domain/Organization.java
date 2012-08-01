package com.rplp.icc.authorization.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Organization {

	
	private String orgNo;
	
	public String getOrgNo() {
		return orgNo;
	}
	
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
}
