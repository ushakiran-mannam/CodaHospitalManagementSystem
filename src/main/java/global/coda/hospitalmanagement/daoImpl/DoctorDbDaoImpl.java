package global.coda.hospitalmanagement.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import global.coda.hospitalmanagement.constant.QueryConstant;
import global.coda.hospitalmanagement.dao.DoctorDbDao;
import global.coda.hospitalmanagement.dbconnection.CustomPreparedStatement;
import global.coda.hospitalmanagement.dbconnection.SqlConnection;
import global.coda.hospitalmanagement.model.Doctor;

// TODO: Auto-generated Javadoc
/**
 * The Class DoctorDbDaoImpl.
 */
public class DoctorDbDaoImpl implements DoctorDbDao {

	/** The logger. */
	private Logger LOGGER = Logger.getLogger(DoctorDbDaoImpl.class);

	/**
	 * Insert.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws SQLException           the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Boolean insert(Doctor doctor) throws SQLException, ClassNotFoundException ,Exception{
		LOGGER.info("executing insert in DoctorDbdaoImpl ");
		String username = doctor.getUsername();
		String email = doctor.getEmail();
		String password = doctor.getPassword();
		int roleId = doctor.getRoleId();
		// t_doctor Contents
		String specialization = doctor.getSpecialization();

		PreparedStatement statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.INSERT_USER);

		statement.setString(1, username);
		statement.setString(2, email);
		statement.setString(3, password);
		statement.setInt(4, roleId);

		CustomPreparedStatement.executeUpdate(statement);
		LOGGER.info("after insert user");
		ResultSet privateKeys = statement.getGeneratedKeys();
		if (privateKeys.next()) {
			doctor.setUserId(privateKeys.getInt(1));
		}

		int userId = doctor.getUserId();
		LOGGER.info("before insert doctor");
		statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.INSERT_DOCTOR);

		statement.setString(1, specialization);
		statement.setInt(2, userId);
		int noOfRowsAffected = CustomPreparedStatement.executeUpdate(statement);
		if (noOfRowsAffected != 1) {
			SqlConnection.rollBack();
			LOGGER.info("rollBack called");
		}
		LOGGER.info("before closing connection");
		SqlConnection.closeConnection();

		return true;

	}

	/**
	 * Read.
	 *
	 * @param doctor the doctor
	 * @return the doctor
	 * @throws SQLException           the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Doctor read(Doctor doctor) throws SQLException, ClassNotFoundException,Exception {
		PreparedStatement statement;

		statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.READ_DOCTOR);
		statement.setInt(1, doctor.getUserId());
		statement.setInt(2, 1);
		statement.setInt(3, 1);

		ResultSet resultSet = CustomPreparedStatement.executePreparedStatement(statement);
		if (!resultSet.isBeforeFirst()) {
			throw new SQLException("data not found");
		}
		while (resultSet.next()) {
			doctor.setUserId(resultSet.getInt(1));
			doctor.setUsername(resultSet.getString(2));
			doctor.setEmail(resultSet.getString(3));
			doctor.setPassword(resultSet.getString(4));
			doctor.setRoleId(resultSet.getInt(5));
			doctor.setSpecialization(resultSet.getString(6));
		}
		SqlConnection.closeConnection();
		return doctor;

	}

	/**
	 * Read all.
	 *
	 * @return the list
	 * @throws SQLException           the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<Doctor> readAll() throws SQLException, ClassNotFoundException,Exception {

		List<Doctor> doctorList = new ArrayList<>();
		PreparedStatement statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.READ_ALL_DOCTOR);
		statement.setInt(1, 1);
		statement.setInt(2, 1);

		ResultSet resultSet = CustomPreparedStatement.executePreparedStatement(statement);
		while (resultSet.next()) {
			Doctor doctor = new Doctor();
			doctor.setUserId(resultSet.getInt(1));
			doctor.setUsername(resultSet.getString(2));
			doctor.setEmail(resultSet.getString(3));
			doctor.setPassword(resultSet.getString(4));
			doctor.setRoleId(resultSet.getInt(5));
			doctor.setSpecialization(resultSet.getString(6));
			doctorList.add(doctor);
		}
		SqlConnection.closeConnection();

		return doctorList;
	}

	/**
	 * Read all with masked details.
	 *
	 * @return the list
	 * @throws SQLException           the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Override
	public List<Doctor> readAllWithMaskedDetails() throws SQLException, ClassNotFoundException ,Exception{

		List<Doctor> doctorList = new ArrayList<>();

		PreparedStatement statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.READ_DOCTOR_MASKED_DETAILS);
		statement.setInt(1, 1);
		statement.setInt(2, 1);

		ResultSet resultSet = CustomPreparedStatement.executePreparedStatement(statement);
		while (resultSet.next()) {
			Doctor doctor = new Doctor();
			doctor.setUsername(resultSet.getString(1));

			doctor.setSpecialization(resultSet.getString(2));
			doctorList.add(doctor);
		}
		SqlConnection.closeConnection();

		return doctorList;
	}

	/**
	 * Read all patients particular doctor.
	 *
	 * @param doctor the doctor
	 * @return the list
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the SQL exception
	 */
	public List<Integer> readAllPatientsParticularDoctor(Doctor doctor) throws ClassNotFoundException, SQLException,Exception {
		int userId = doctor.getUserId();
		List<Integer> patientKeys = new ArrayList<>();
		PreparedStatement statement = CustomPreparedStatement
				.getPreparedStatement(QueryConstant.READ_PATIENT_KEYS_PARTICULAR_DOCTOR);
		statement.setInt(1, userId);
		ResultSet resultSet = CustomPreparedStatement.executePreparedStatement(statement);
		if (!resultSet.isBeforeFirst()) {
			throw new SQLException("data not found");
		}
		while (resultSet.next()) {
			patientKeys.add(resultSet.getInt(2));

		}
		SqlConnection.closeConnection();
		return patientKeys;

	}

	/**
	 * Update.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws SQLException           the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Override
	public Boolean update(Doctor doctor) throws SQLException, ClassNotFoundException ,Exception{

		String username = doctor.getUsername();
		String email = doctor.getEmail();
		String password = doctor.getPassword();
		int userId = doctor.getUserId();
		// t_patient Contents

		String specialization = doctor.getSpecialization();

		PreparedStatement statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.UPDATE_USER);
		statement.setString(1, username);
		statement.setString(2, email);
		statement.setString(3, password);
		statement.setInt(4, userId);
		statement.setInt(5, 1);
		CustomPreparedStatement.executeUpdate(statement);
		statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.UPDATE_DOCTOR);
		statement.setString(1, specialization);
		statement.setInt(2, userId);
		statement.setInt(3, 1);
		int noOfRowsAffected = CustomPreparedStatement.executeUpdate(statement);
		if (noOfRowsAffected != 1)
			SqlConnection.rollBack();

		SqlConnection.closeConnection();

		return true;
	}

	/**
	 * Delete.
	 *
	 * @param doctor the doctor
	 * @return the boolean
	 * @throws SQLException           the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Override
	public Boolean delete(Doctor doctor) throws SQLException, ClassNotFoundException,Exception {
		int userId = doctor.getUserId();
		PreparedStatement statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.DELETE_USER);
		statement.setInt(1, 0);
		statement.setInt(2, userId);
		CustomPreparedStatement.executeUpdate(statement);

		statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.DELETE_DOCTOR);
		statement.setInt(1, 0);
		statement.setInt(2, userId);
		CustomPreparedStatement.executeUpdate(statement);

		SqlConnection.closeConnection();
		return true;

	}

}
