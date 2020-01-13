package global.coda.hospitalmanagement.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import global.coda.hospitalmanagement.daoImpl.PatientDbDaoImpl;
import global.coda.hospitalmanagement.exception.BusinessException;
import global.coda.hospitalmanagement.exception.SystemException;
import global.coda.hospitalmanagement.model.Doctor;
import global.coda.hospitalmanagement.model.Patient;
import global.coda.hospitalmanagement.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientHelper.
 */
public class PatientHelper {

	/** The patient db. */
	PatientDbDaoImpl patientDb = new PatientDbDaoImpl();

	/** The logger. */
	private Logger LOGGER = Logger.getLogger(PatientHelper.class);

	/**
	 * Creates the patient.
	 *
	 * @param patient the patient
	 * @return the user
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the SQL exception
	 */
	public User createPatient(Patient patient) throws ClassNotFoundException, SQLException, Exception {
		try {
			if (patientDb.insert(patient)) {
				LOGGER.info("patient details entered successfully");

			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return patient;

	}

	/**
	 * Read particular patient.
	 *
	 * @param patient the patient
	 * @return the patient
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the SQL exception
	 */
	public Patient readParticularPatient(Patient patient) throws ClassNotFoundException, SQLException, Exception {
		try {
			patient = patientDb.read(patient);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

		return patient;
	}

	/**
	 * Update patient.
	 *
	 * @param patient the patient
	 * @return the boolean
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the SQL exception
	 */
	public Boolean updatePatient(Patient patient) throws ClassNotFoundException, SQLException, Exception {
		try {
			if (patientDb.update(patient)) {
				LOGGER.info("patient details updated");
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return true;
	}

	/**
	 * Read all patients.
	 *
	 * @return the list
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the SQL exception
	 */
	public List<Patient> readAllPatients() throws ClassNotFoundException, SQLException, Exception {
		List<Patient> patientList = new ArrayList<>();

		try {
			patientList = patientDb.readAll();

		} catch (SQLException e) {
			throw new SQLException(e);
		}

		return patientList;
	}

	/**
	 * Delete patient.
	 *
	 * @param patient the patient
	 * @return the boolean
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the SQL exception
	 */
	public Boolean deletePatient(Patient patient) throws ClassNotFoundException, SQLException, Exception {
		try {
			patientDb.delete(patient);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return true;
	}

	/**
	 * Read all patients masked.
	 *
	 * @return the list
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the SQL exception
	 */
	public List<Patient> readAllPatientsMasked() throws ClassNotFoundException, SQLException, Exception {
		List<Patient> patientList = new ArrayList<>();

		try {
			PatientDbDaoImpl patientDbDao = new PatientDbDaoImpl();
			patientList = patientDbDao.readAllWithMaskedDetails();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return patientList;
	}

	public Patient readParticularPatientNotClosingConnection(Patient patient)
			throws SQLException, ClassNotFoundException, Exception {
		try {
			patient = patientDb.readWithOutClosingConnection(patient);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

		return patient;
	}

	public List<Patient> readParticularDoctorPatients(Doctor doctor) throws  SystemException, BusinessException {
		// TODO Auto-generated method stub
		List<Patient> patients = new ArrayList<>();
		try {

			patients = patientDb.readParticularDoctorPatients(doctor);

		} catch (SQLException | ClassNotFoundException e) {
			throw new BusinessException(e);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		
		return patients;

	}

}
