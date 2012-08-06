package com.rplp.icc.authorization.brreg;

import no.brreg.saksys.grunndata.ws.HentRolleResponse.Melding.RolleInnehaver.Fodselsnr;
import no.brreg.saksys.grunndata.ws.HentRolleResponse.Melding.Roller.Enhet;
import no.brreg.saksys.grunndata.ws.HentRolleResponse.Melding.Roller;
import no.brreg.saksys.grunndata.ws.HentRolleResponse.Melding.Roller.Enhet.Orgnr;
import no.brreg.saksys.grunndata.ws.Rolle;
import no.brreg.saksys.grunndata.ws.HentRolleResponse.Melding;
import no.brreg.saksys.grunndata.ws.HentRolleResponse.Melding.RolleInnehaver;


/**
 * Simple mock to use in functional testing. An alternative is to use SoapUI instead
 * but this is a bit simpler for now.
 * 
 * @author oloa
 *
 */
public class MockRolleWS implements Rolle {
	
	
	@Override
	public Melding hentRolle(String pnr) {
		
		Melding melding = new Melding();
		
		RolleInnehaver rolleInnehaver = new RolleInnehaver();
		Fodselsnr fodselsnr = new Fodselsnr();
		fodselsnr.setValue(pnr);
		rolleInnehaver.setFodselsnr(fodselsnr);
		
		melding.setRolleInnehaver(rolleInnehaver);
		
		
		Roller roller = new Roller();
		Enhet enhet = new Enhet();
		Orgnr orgnr = new Orgnr();
		orgnr.setValue(999999);
		enhet.setOrgnr(orgnr);
		roller.getEnhet().add(enhet);
		
		melding.setRoller(roller);
		
		
		return melding;
	}

}
