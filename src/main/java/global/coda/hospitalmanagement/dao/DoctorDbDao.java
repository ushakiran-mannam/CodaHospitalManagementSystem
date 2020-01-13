package global.coda.hospitalmanagement.dao;

import java.sql.SQLException;
import java.util.List;

import global.coda.hospitalmanagement.model.Doctor;

// TODO: Auto-generated Javadoc
/**
 * The Interface DoctorDbDao.
 *
 * @author VC
 */
public interface DoctorDbDao {
	
	/**
	 * Insert.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws Exception 
	 */
	public Boolean insert(Doctor doctor) throws SQLException, ClassNotFoundException, Exception;

	/**
	 * Read.
	 *
	 * @param doctor the doctor
	 * @return the doctor
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Doctor read(Doctor doctor) throws SQLException, ClassNotFoundException,Exception;

	/**
	 * Read all.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<Doctor> readAll() throws SQLException, ClassNotFoundException,Exception;

	/**
	 * Read all with masked details.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<Doctor> readAllWithMaskedDetails() throws SQLException, ClassNotFoundException,Exception;

	/**
	 * Update.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Boolean update(Doctor doctor) throws SQLException, ClassNotFoundException,Exception;

	/**
	 * Delete.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Boolean delete(Doctor doctor) throws SQLException, ClassNotFoundException,Exception;
}
