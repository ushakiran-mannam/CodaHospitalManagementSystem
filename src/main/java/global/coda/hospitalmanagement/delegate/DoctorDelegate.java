package global.coda.hospitalmanagement.delegate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.helper.DoctorHelper;
import global.coda.hospitalmanagement.helper.PatientHelper;
import global.coda.hospitalmanagement.model.Doctor;
import global.coda.hospitalmanagement.model.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Class DoctorDelegate.
 */
public class DoctorDelegate {

	/** The logger. */
	private Logger LOGGER = Logger.getLogger(DoctorHelper.class);

	/**
	 * Read all doctor.
	 *
	 * @return the list
	 * @throws SystemException the system exception
	 */
	public List<Doctor> readAllDoctor() throws SystemException {
		// TODO Auto-generated method stub

		List<Doctor> doctorlist;
		try {
			DoctorHelper doctorhelper = new DoctorHelper();
			doctorlist = doctorhelper.readAllDoctor();
		} catch (Exception e) {
			LOGGER.info(e);
			throw new SystemException(e);
		}
		return doctorlist;
	}

	/**
	 * Read particular doctor.
	 *
	 * @param id the id
	 * @return the doctor
	 * @throws BusinessException the business exception
	 */
	public Doctor readParticularDoctor(Integer id) throws BusinessException {
		// TODO Auto-generated method stub

		Doctor doctor = new Doctor();
		doctor.setUserId(id);
		try {
			DoctorHelper doctorhelper = new DoctorHelper();
			doctor = doctorhelper.readParticularDoctor(doctor);
		} catch (Exception e) {
			LOGGER.info(e);
			throw new BusinessException(e);
		} 
		return doctor;
	}

	/**
	 * Insert doctor.
	 *
	 * @param username       the username
	 * @param email          the email
	 * @param password       the password
	 * @param specialization the specialization
	 * @return the boolean
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	public Boolean insertDoctor(String username, String email, String password, String specialization)
			throws BusinessException, SystemException {
		LOGGER.info("executing insert doctor delegate");
		Doctor doctor = new Doctor();
		doctor.setUsername(username);
		doctor.setEmail(email);
		doctor.setPassword(password);
		doctor.setRoleId(2);
		doctor.setSpecialization(specialization);
		DoctorHelper doctorhelper = new DoctorHelper();
		try {
			doctorhelper.createDoctor(doctor);
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.info(e);
			throw new BusinessException(e);
		} catch (Exception e)
		{
			LOGGER.info(e);
			throw new SystemException(e);
		}
		LOGGER.info("exiting insert doctor delegate");
		return true;

	}

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	public Boolean updateDoctor(Doctor doctor) throws BusinessException, SystemException {
		LOGGER.info("executing update doctor delegate");
		DoctorHelper doctorhelper = new DoctorHelper();
		try {
			doctorhelper.updateDoctor(doctor);
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.info(e);
			throw new BusinessException(e);
		} catch (Exception e)
		{
			LOGGER.info(e);
			throw new SystemException(e);
		}
		LOGGER.info("exiting update doctor delegate");
		return true;
	}

	/**
	 * Delete doctor.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	public Boolean deleteDoctor(Doctor doctor) throws BusinessException, SystemException {
		LOGGER.info("executing delete doctor delegate");
		DoctorHelper doctorhelper = new DoctorHelper();
		try {
			doctorhelper.deleteDoctor(doctor);
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.info(e);
			throw new BusinessException(e);
		} catch (Exception e)
		{
			LOGGER.info(e);
			throw new SystemException(e);
		}
		LOGGER.info("exiting delete doctor delegate");
		return true;
	}

	/**
	 * Read particular doctor patients.
	 *
	 * @param id the id
	 * @return the list
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 * @throws ClassNotFoundException 
	 */
	public List<Patient> readParticularDoctorPatients(Integer id) throws BusinessException, SystemException {
		LOGGER.info("executing read particular patients of doctor delegate");
		List<Patient> patients = new ArrayList<>();
		PatientHelper patienthelper = new PatientHelper();
		Doctor doctor = new Doctor();
		doctor.setUserId(id);
		patients = patienthelper.readParticularDoctorPatients(doctor);
//		List<Integer> patientKeys = new ArrayList<>();
//		List<Patient> patients = new ArrayList<>();
//		DoctorHelper doctorhelper = new DoctorHelper();
//		Doctor doctor = new Doctor();
//		doctor.setUserId(id);
//		try {
//			patientKeys = doctorhelper.readPatientKeysParticularDoctor(doctor);
//		} catch (ClassNotFoundException | SQLException e) {
//			LOGGER.info(e);
//			throw new BusinessException(e);
//		}catch (Exception e)
//		{
//			LOGGER.info(e);
//			throw new SystemException(e);
//		}
//		PatientHelper patienthelper = new PatientHelper();
//		Patient patient = new Patient();
//		for (int patientId : patientKeys) {
//
//			patient.setUserId(patientId);
//			try {
//				patient = patienthelper.readParticularPatientNotClosingConnection(patient);
//			} catch (ClassNotFoundException | SQLException  e) {
//				LOGGER.info(e);
//				throw new BusinessException(e);
//			} catch (Exception e)
//			{
//				LOGGER.info(e);
//				throw new SystemException(e);
//			}
//			patients.add(patient);
//		}
//		
//
		return patients;
	}
}
