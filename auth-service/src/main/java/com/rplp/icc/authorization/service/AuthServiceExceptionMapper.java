package com.rplp.icc.authorization.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.security.access.AccessDeniedException;

public class AuthServiceExceptionMapper implements ExceptionMapper<AccessDeniedException> {
	
	public Response toResponse(AccessDeniedException exception) {
		
		
		return Response.status(Status.FORBIDDEN).build();
		
		
		
	};
	
	
	

}
