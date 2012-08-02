package com.rplp.icc.authorization.transformer;

import no.brreg.saksys.grunndata.ws.HentRolleResponse.Melding;
import no.brreg.saksys.grunndata.ws.HentRolleResponse.Melding.Roller.Enhet;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rplp.icc.authorization.domain.Organization;
import com.rplp.icc.authorization.domain.Person;

/**
 * 
 * Transformer for converting the response from Brönnöysund to a domain object.
 * We are only interested in the organizations that the person is a member of.
 * 
 * @author oloa
 *
 */
public class MeldingToPerson extends AbstractTransformer {
	
	private static Logger LOG = LoggerFactory.getLogger(MeldingToPerson.class);
	
	public MeldingToPerson()
    {
        super();
        this.registerSourceType(DataTypeFactory.create(Melding.class));
        this.setReturnDataType(DataTypeFactory.create(Person.class));
    }
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		
		Melding melding = (Melding)src;
		
		Person person = new Person();
		person.setPnr(melding.getRolleInnehaver().getFodselsnr().getValue());

		for (Enhet enhet : melding.getRoller().getEnhet()) {
			Organization organization = new Organization();
			organization.setOrgNo(String.valueOf(enhet.getOrgnr().getValue()));
			person.getOrganizations().add(organization);
		}
		
		return person;
	}

}
