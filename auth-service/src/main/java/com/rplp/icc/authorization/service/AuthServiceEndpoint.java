package com.rplp.icc.authorization.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JAX-RS endpoint which receives the request. 
 * 
 * @author oloa
 *
 */
@Path("/")
public class AuthServiceEndpoint {


	Logger LOG = LoggerFactory.getLogger(AuthServiceEndpoint.class);
	
	@GET
	@Produces("application/json")
	@Path("/person/{pnr}")
	public String getPerson(@PathParam("pnr") String pnr) {

		return pnr;
	}

}
