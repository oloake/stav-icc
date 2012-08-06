package com.rplp.icc.authorization.interceptor;

import org.apache.commons.lang.StringUtils;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.interceptor.AbstractEnvelopeInterceptor;
import org.mule.management.stats.ProcessingTime;
import org.slf4j.MDC;

/**
 * Interceptor which adds properties identifying the message to the logging context so that
 * messages can be traced as they flow through Mule. 
 * 
 * Add the following to the conversion pattern in log4j.properties:
 * <pre>
 	%X{serviceName} %X{messageId} %X{correlationId}
 * </pre>
 * 
 * @author oloa
 *
 */
public class MDCLoggingInterceptor extends AbstractEnvelopeInterceptor {

	@Override
	public MuleEvent before(MuleEvent event) throws MuleException {
		
		MDC.put("messageId", event.getMessage().getUniqueId());
		if (!StringUtils.isEmpty(event.getMessage().getCorrelationId())) {
			MDC.put("correlationId", event.getMessage().getCorrelationId());
		}
		MDC.put("serviceName", event.getFlowConstruct().getName());
		
		return event;
	}

	@Override
	public MuleEvent last(MuleEvent event, ProcessingTime time, long startTime,
			boolean exceptionWasThrown) throws MuleException {
		
		MDC.clear();
		return event;
	}

	@Override
	public MuleEvent after(MuleEvent event) throws MuleException {
		return event;
	}

}
