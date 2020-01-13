package global.coda.hospitalmanagement.delegate;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.helper.DoctorHelper;
import global.coda.hospitalmanagement.helper.PatientHelper;
import global.coda.hospitalmanagement.model.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientDelegate.
 */
public class PatientDelegate {
	
	/** The logger. */
	private Logger LOGGER = Logger.getLogger(DoctorHelper.class);

	/**
	 * Read all patients.
	 *
	 * @return the list
	 * @throws SystemException the system exception
	 * @throws BusinessException 
	 */
	public List<Patient> readAllPatients() throws SystemException, BusinessException {
		// TODO Auto-generated method stub

		List<Patient> patientlist;
		try {
			PatientHelper patienthelper = new PatientHelper();
			patientlist = patienthelper.readAllPatients();
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.info(e);
			throw new BusinessException(e);
		} catch (Exception e) {
			LOGGER.info(e);
			throw new SystemException(e);
		}
		return patientlist;
	}

	/**
	 * Read particular patient.
	 *
	 * @param id the id
	 * @return the patient
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	public Patient readParticularPatient(Integer id) throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		Patient patient = new Patient();
		patient.setUserId(id);
		
			PatientHelper patienthelper = new PatientHelper();
			try {
				patient = patienthelper.readParticularPatient(patient);
			} catch (ClassNotFoundException | SQLException e) {
				LOGGER.info(e);
				throw new BusinessException(e);
			} catch (Exception e) {
				LOGGER.info(e);
				throw new SystemException(e);
			}
		 
		return patient;
	}

	/**
	 * Insert patient.
	 *
	 * @param patient the patient
	 * @return the boolean
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	public Boolean insertPatient(Patient patient) throws BusinessException, SystemException {
		LOGGER.info("executing insert patient delegate");

		PatientHelper patienthelper = new PatientHelper();
		try {
			patienthelper.createPatient(patient);
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.info(e);
			throw new BusinessException(e);
		} catch (Exception e) {
			LOGGER.info(e);
			throw new SystemException(e);
		}
		LOGGER.info("exiting insert patient delegate");
		return true;

	}

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return the boolean
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	public Boolean updatePatient(Patient patient) throws BusinessException, SystemException {
		LOGGER.info("executing update patient delegate");
		PatientHelper patienthelper = new PatientHelper();
		try {
			patienthelper.updatePatient(patient);
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.info(e);
			throw new BusinessException(e);
		} catch (Exception e) {
			LOGGER.info(e);
			throw new SystemException(e);
		}
		LOGGER.info("exiting update patient delegate");
		return true;
	}

	/**
	 * Delete patient.
	 *
	 * @param patient the patient
	 * @return the boolean
	 * @throws BusinessException the business exception
	 * @throws SystemException 
	 */
	public Boolean deletePatient(Patient patient) throws BusinessException, SystemException {
		LOGGER.info("executing delete patient delegate");
		PatientHelper patienthelper = new PatientHelper();
		try {
			patienthelper.deletePatient(patient);
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.info(e);
			throw new BusinessException(e);
		} catch (Exception e) {
			LOGGER.info(e);
			throw new SystemException(e);
		}
		
		LOGGER.info("exiting delete patient delegate");
		return true;
	}

}
