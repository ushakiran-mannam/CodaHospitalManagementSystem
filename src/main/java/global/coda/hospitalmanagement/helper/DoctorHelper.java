package global.coda.hospitalmanagement.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import global.coda.hospitalmanagement.constant.BundleKey;
import global.coda.hospitalmanagement.daoImpl.DoctorDbDaoImpl;
import global.coda.hospitalmanagement.daoImpl.PatientDbDaoImpl;
import global.coda.hospitalmanagement.model.Doctor;
import global.coda.hospitalmanagement.model.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Class DoctorHelper.
 */
public class DoctorHelper  {
	
	/** The Constant LOCAL_MESSAGES_BUNDLE. */
	private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
			Locale.getDefault());
	
	/** The doctor db. */
	DoctorDbDaoImpl doctorDb = new DoctorDbDaoImpl();
	
	/** The logger. */
	private Logger LOGGER = Logger.getLogger(DoctorHelper.class);

	/**
	 * Creates the doctor.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public Boolean createDoctor(Doctor doctor) throws ClassNotFoundException, SQLException ,Exception{
		try {
			if (doctorDb.insert(doctor)) {
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(BundleKey.DS7));

			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return true;

	}

	/**
	 * Read particular doctor.
	 *
	 * @param doctor the doctor
	 * @return the doctor
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public Doctor readParticularDoctor(Doctor doctor) throws ClassNotFoundException, SQLException ,Exception{
		try {
			doctor = doctorDb.read(doctor);
		} catch (SQLException e) {
			throw new SQLException(e);
		} 

		return doctor;
	}

	/**
	 * Update doctor.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public Boolean updateDoctor(Doctor doctor) throws ClassNotFoundException, SQLException ,Exception{
		try {
			if (doctorDb.update(doctor)) {
				LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(BundleKey.DS7));
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return true;
	}

	/**
	 * Read all doctor.
	 *
	 * @return the list
	 * @throws Exception 
	 */
	public List<Doctor> readAllDoctor() throws ClassNotFoundException, SQLException , Exception{
		List<Doctor> doctorList = new ArrayList<>();

		try {
			doctorList = doctorDb.readAll();

		} catch (SQLException e) {
			throw new SQLException(e);
		}

		return doctorList;
	}

	/**
	 * Delete doctor.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws Exception 
	 */
	public Boolean deleteDoctor(Doctor doctor) throws ClassNotFoundException, SQLException ,Exception{
		try {
			 doctorDb.delete(doctor);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return true;
	}

	/**
	 * Read all patients.
	 *
	 * @return the list
	 * @throws Exception 
	 */
	public List<Patient> readAllPatients() throws ClassNotFoundException, SQLException ,Exception{
		List<Patient> patientList = new ArrayList<>();

		try {
			PatientDbDaoImpl patientDbDao = new PatientDbDaoImpl();
			patientList = patientDbDao.readAllWithMaskedDetails();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return patientList;
	}
	
	/**
	 * Read patient keys particular doctor.
	 *
	 * @param doctor the doctor
	 * @return the list
	 * @throws Exception 
	 */
	public List<Integer> readPatientKeysParticularDoctor(Doctor doctor) throws ClassNotFoundException, SQLException,Exception{
		List<Integer> patientKeys = new ArrayList<>();
		try {
			DoctorDbDaoImpl doctorDbDao = new DoctorDbDaoImpl();
			patientKeys = doctorDbDao.readAllPatientsParticularDoctor(doctor);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return patientKeys;
	}


}
