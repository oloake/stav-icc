package com.rplp.icc.authorization.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.module.jersey.MuleResponseWriter;
import org.mule.transformer.AbstractMessageTransformer;

import com.sun.jersey.spi.container.ContainerResponse;

/**
 * 
 * This transformation seems necessary so that we can determine if there was an authorization exception thrown
 * since then the response will be null and we can check for this later in the flow. Otherwise the response
 * will always be of the type {@link MuleResponseWriter} and there is no way to determine if the invocation should 
 * proceed or not. 
 * <p>
 * Not sure if this is the standard way of handling this, perhaps an exception handler in the flow would be better
 * but this works. 
 * 
 * @see http://www.mulesoft.org/documentation/display/MULE3USER/Jersey+Module+Reference
 * 
 * @author oloa
 *
 */
public class JerseyResponseToString extends AbstractMessageTransformer {

	
	
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		ContainerResponse cr = (ContainerResponse) message.getInvocationProperty("jersey_response");
		String messageString = (String) cr.getResponse().getEntity();
		message.setPayload(messageString);
		
		return message;
	}
	
}
