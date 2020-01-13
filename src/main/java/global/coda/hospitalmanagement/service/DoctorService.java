package global.coda.hospitalmanagement.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;

import global.coda.hospitalmanagement.delegate.DoctorDelegate;
import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.model.CustomResponse;
import global.coda.hospitalmanagement.model.Doctor;
import global.coda.hospitalmanagement.model.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Class DoctorService.
 */
@Path("/services/doctors")
public class DoctorService {
	
	/**
	 * Gets the all doctors.
	 *
	 * @return the all doctors
	 * @throws SystemException the system exception
	 */
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<List<Doctor>> getAllDoctors() throws SystemException {
		BasicConfigurator.configure();
		CustomResponse<List<Doctor>> response = new CustomResponse<>();
		DoctorDelegate doctordelegate = new DoctorDelegate();
		List<Doctor> doctorList = doctordelegate.readAllDoctor();
		response.setStatus(200);
		response.setData(doctorList);
		return response;
	}

	/**
	 * Gets the particular doctor.
	 *
	 * @param id the id
	 * @return the particular doctor
	 * @throws BusinessException the business exception
	 */
	@POST
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<Doctor> getParticularDoctor(@PathParam("id") Integer id) throws BusinessException {
		BasicConfigurator.configure();
		CustomResponse<Doctor> response = new CustomResponse<>();
		DoctorDelegate doctordelegate = new DoctorDelegate();
		Doctor doctor = doctordelegate.readParticularDoctor(id);
		response.setStatus(200);
		response.setData(doctor);
		return response;
	}

	/**
	 * Creates the doctor.
	 *
	 * @param username the username
	 * @param email the email
	 * @param password the password
	 * @param specialization the specialization
	 * @return the custom response
	 * @throws BusinessException the business exception
	 * @throws SystemException the system exception
	 */
	@POST
	@Path("/createdoctor")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<String> createDoctor(@FormParam("username") String username, @FormParam("email") String email,
			@FormParam("password") String password, @FormParam("specialization") String specialization)
			throws BusinessException, SystemException {
		BasicConfigurator.configure();
		CustomResponse<String> response = new CustomResponse<>();
		DoctorDelegate doctordelegate = new DoctorDelegate();
		doctordelegate.insertDoctor(username, email, password, specialization);
		response.setStatus(200);
		response.setData("inserted succesfully");
		return response;
	}

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return the custom response
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	@PUT
	@Path("/updatedoctor")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<String> updateDoctor(Doctor doctor) throws BusinessException, SystemException {
		BasicConfigurator.configure();
		CustomResponse<String> response = new CustomResponse<>();
		DoctorDelegate doctordelegate = new DoctorDelegate();
		doctordelegate.updateDoctor(doctor);
		response.setStatus(200);
		response.setData("updated succesfully");
		return response;
	}

	/**
	 * Delete doctor.
	 *
	 * @param doctor the doctor
	 * @return the custom response
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	@DELETE
	@Path("/deletedoctor")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<Doctor> deleteDoctor(Doctor doctor) throws BusinessException, SystemException {
		BasicConfigurator.configure();
		CustomResponse<Doctor> response = new CustomResponse<>();
		DoctorDelegate doctordelegate = new DoctorDelegate();
		doctordelegate.deleteDoctor(doctor);
		response.setStatus(200);
		response.setData(doctor);
		return response;
	}

	/**
	 * Gets the particular doctor patients.
	 *
	 * @param id the id
	 * @return the particular doctor patients
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	@POST
	@Path("/{id}/patients")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomResponse<List<Patient>> getParticularDoctorPatients(@PathParam("id") Integer id)
			throws BusinessException, SystemException {
		BasicConfigurator.configure();
		CustomResponse<List<Patient>> response = new CustomResponse<>();
		DoctorDelegate doctordelegate = new DoctorDelegate();
		List<Patient> patientlist = doctordelegate.readParticularDoctorPatients(id);
		response.setStatus(200);
		response.setData(patientlist);
		return response;
	}
}
