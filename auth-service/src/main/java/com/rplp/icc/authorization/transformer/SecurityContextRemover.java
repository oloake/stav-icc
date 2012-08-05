package com.rplp.icc.authorization.transformer;

import java.io.NotSerializableException;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.MuleSession;
import org.mule.api.lifecycle.Callable;
import org.mule.api.security.SecurityContext;

import com.sun.jersey.spi.container.ContainerResponse;


/**
 * Due to some weirdness regarding how the {@link SecurityContext} is propagated there is a {@link NotSerializableException} for {@link ContainerResponse}.
 * For some reason this object will be part of the {@link SecurityContext} which is part of the {@link MuleSession} and when Mule tries to serialize it 
 * everything blows up. 
 * <p>
 * I suspect that it is an issue that is similar to this:
 * http://stackoverflow.com/questions/9309080/mule-why-does-vm-queue-break-using-https-basic-auth-and-spring-security-manage
 * <p>
 * So as a "workaround" I set the {@link SecurityContext} to null here which works for this case as we 
 * don't need propagation.
 * <p> 
 * TODO: Research this further and perhaps open a JIRA issue.
 * 
 * 
 * @author oloa
 *
 */
public class SecurityContextRemover implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		
		
		MuleSession session = eventContext.getSession();
		
		session.setSecurityContext(null);
		
		
		return eventContext.getMessage();
	}

}
