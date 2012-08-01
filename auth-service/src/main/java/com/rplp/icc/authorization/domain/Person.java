package com.rplp.icc.authorization.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Person {

	private String pnr;
	
	private List<Organization> organizations = new ArrayList<Organization>();
	
	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}
	
	public List<Organization> getOrganizations() {
		return organizations;
	}
	
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	
	public String getPnr() {
		return pnr;
	}
	
	
}
