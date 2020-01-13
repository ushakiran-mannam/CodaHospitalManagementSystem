package global.coda.hospitalmanagement.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;

import global.coda.hospitalmanagement.delegate.PatientDelegate;
import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.model.CustomResponse;
import global.coda.hospitalmanagement.model.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientService.
 */
@Path("/services/patient")
public class PatientService {
	
	/**
	 * Gets the all patients.
	 *
	 * @return the all patients
	 * @throws SystemException the system exception
	 * @throws BusinessException 
	 */
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<List<Patient>> getAllPatients() throws SystemException, BusinessException {
		BasicConfigurator.configure();
		CustomResponse<List<Patient>> response = new CustomResponse<>();
		PatientDelegate patientdelegate = new PatientDelegate();
		List<Patient> patientList = patientdelegate.readAllPatients();
		response.setStatus(200);
		response.setData(patientList);
		return response;
	}

	/**
	 * Gets the particular patient.
	 *
	 * @param id the id
	 * @return the particular patient
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	@POST
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<Patient> getParticularPatient(@PathParam("id") Integer id) throws BusinessException, SystemException {
		BasicConfigurator.configure();
		CustomResponse<Patient> response = new CustomResponse<>();
		PatientDelegate patientdelegate = new PatientDelegate();
		Patient patient = patientdelegate.readParticularPatient(id);
		response.setStatus(200);
		response.setData(patient);
		return response;
	}

	/**
	 * Creates the patient.
	 *
	 * @param patient the patient
	 * @return the custom response
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	@POST
	@Path("/createpatient")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<String> createPatient(Patient patient) throws BusinessException, SystemException {
		BasicConfigurator.configure();
		CustomResponse<String> response = new CustomResponse<>();
		PatientDelegate patientdelegate = new PatientDelegate();
		patientdelegate.insertPatient(patient);
		response.setStatus(200);
		response.setData("inserted succesfully");
		return response;
	}

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return the custom response
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	@PUT
	@Path("/updatepatient")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<String> updatePatient(Patient patient) throws BusinessException, SystemException {
		BasicConfigurator.configure();
		CustomResponse<String> response = new CustomResponse<>();
		PatientDelegate patientdelegate = new PatientDelegate();
		patientdelegate.updatePatient(patient);
		response.setStatus(200);
		response.setData("updated succesfully");
		return response;
	}

	/**
	 * Delete patient.
	 *
	 * @param patient the patient
	 * @return the custom response
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	@DELETE
	@Path("/deletepatient")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<Patient> deletePatient(Patient patient) throws BusinessException, SystemException {
		BasicConfigurator.configure();
		CustomResponse<Patient> response = new CustomResponse<>();
		PatientDelegate patientdelegate = new PatientDelegate();
		patientdelegate.deletePatient(patient);
		response.setStatus(200);
		response.setData(patient);
		return response;
	}

}
