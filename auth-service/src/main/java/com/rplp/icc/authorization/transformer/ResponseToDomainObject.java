package com.rplp.icc.authorization.transformer;

import java.util.Arrays;

import org.mule.api.transformer.DataType;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import com.rplp.icc.authorization.domain.Organization;
import com.rplp.icc.authorization.domain.Person;

public class ResponseToDomainObject extends AbstractTransformer {
	
	public ResponseToDomainObject()
    {
        super();
        this.registerSourceType(DataType.STRING_DATA_TYPE);
        this.setReturnDataType(DataTypeFactory.create(Person.class));
    }

	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		
		Person p = new Person();
		p.setPnr("123");
		
		Organization org = new Organization();
		org.setOrgNo("111");
		
		Organization org2 = new Organization();
		org2.setOrgNo("222");
		
		p.setOrganizations(Arrays.asList(org, org2));
		
		
		return p;
	}

}
