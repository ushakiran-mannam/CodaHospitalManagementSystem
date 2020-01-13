/*
 * 
 */
package global.coda.hospitalmanagement.config;

import org.glassfish.jersey.server.ResourceConfig;

import global.coda.hospitalmanagement.service.DoctorService;
import global.coda.hospitalmanagement.service.PatientService;


/**
 * @author VC
 *
 */
public class JerseyConfig extends ResourceConfig {

	/**
	 * Instantiates a new jersey config.
	 */
	public JerseyConfig() {
	
        register(DoctorService.class);
        register(PatientService.class);
	}
}
