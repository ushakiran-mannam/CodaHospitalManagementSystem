package global.coda.hospitalmanagement.dao;

import java.sql.SQLException;

import global.coda.hospitalmanagement.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDbDao.
 */
public interface UserDbDao {

	/**
	 * Gets the user.
	 *
	 * @param email the email
	 * @return the user
	 * @throws SQLException           the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public User getUser(String email) throws SQLException, ClassNotFoundException,Exception;

}
