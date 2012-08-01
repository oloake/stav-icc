package com.rplp.icc.authorization.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class AuthServiceEndpoint {

	@GET
	@Produces("text/plain")
	@Path("/person/{pnr}")
	public String greet(@PathParam("pnr") String input) {

		return "1 2 3";
	}

}
