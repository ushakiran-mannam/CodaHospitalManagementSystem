package global.coda.hospitalmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import global.coda.hospitalmanagement.model.Patient;
import global.coda.hospitalmanagement.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface PatientDbDao.
 */
public interface PatientDbDao {
	
	/**
	 * Insert.
	 *
	 * @param patient the patient
	 * @return the boolean
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Boolean insert(Patient patient) throws SQLException, ClassNotFoundException,Exception;

	/**
	 * Read.
	 *
	 * @param patient the patient
	 * @return the user
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public User read(Patient patient) throws SQLException, ClassNotFoundException,Exception;

	/**
	 * Read all.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<Patient> readAll() throws SQLException, ClassNotFoundException,Exception;

	/**
	 * Update.
	 *
	 * @param patient the patient
	 * @return the boolean
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Boolean update(Patient patient) throws SQLException, ClassNotFoundException,Exception;

	/**
	 * Delete.
	 *
	 * @param patient the patient
	 * @return the boolean
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Boolean delete(Patient patient) throws SQLException, ClassNotFoundException,Exception;

	/**
	 * Read all with masked details.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<Patient> readAllWithMaskedDetails() throws SQLException, ClassNotFoundException,Exception;
}
