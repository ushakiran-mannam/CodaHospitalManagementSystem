package global.coda.hospitalmanagement.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import global.coda.hospitalmanagement.constant.QueryConstant;
import global.coda.hospitalmanagement.dao.UserDbDao;
import global.coda.hospitalmanagement.dbconnection.SqlConnection;
import global.coda.hospitalmanagement.model.User;
import global.coda.hospitalmanagement.dbconnection.CustomPreparedStatement;

public class UserDbDaoImpl implements UserDbDao {

	/**
	 * Gets the user.
	 *
	 * @param email the email
	 * @return the user
	 * @throws SQLException           the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	@Override
	public User getUser(String email) throws SQLException, ClassNotFoundException,Exception {
		User user = new User();
		PreparedStatement statement = CustomPreparedStatement.getPreparedStatement(QueryConstant.READ_USER);
		statement.setString(1, email);
		statement.setInt(2, 1);

		ResultSet resultSet = CustomPreparedStatement.executePreparedStatement(statement);
		while (resultSet.next()) {
			user.setUserId(resultSet.getInt(1));
			user.setUsername(resultSet.getString(2));
			user.setEmail(resultSet.getString(3));
			user.setPassword(resultSet.getString(4));
			user.setRoleId(resultSet.getInt(5));
		}
		SqlConnection.closeConnection();

		return user;
	}
}
