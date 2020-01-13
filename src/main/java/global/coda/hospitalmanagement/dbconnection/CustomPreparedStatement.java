package global.coda.hospitalmanagement.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import global.coda.hospitalmanagement.exception.SystemException;

public class CustomPreparedStatement {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(SqlConnection.class);
	/**
	 * Gets the prepared statement.
	 *
	 * @param query the query
	 * @return the prepared statement
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the SQL exception
	 */
	public static PreparedStatement getPreparedStatement(String query) throws ClassNotFoundException, SQLException {
		LOGGER.info("getting prepared statement");
		Connection connection = SqlConnection.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		LOGGER.debug("prepares statement is " + pstmt);
		LOGGER.info("Exiting getPreparedStatement");
		return pstmt;
	}

	/**
	 * Execute prepared batch statement.
	 *
	 * @param psmt the psmt
	 * @return the result set
	 * @throws SQLException    the SQL exception
	 * @throws SystemException the system exception
	 */
	public static ResultSet executePreparedBatchStatement(PreparedStatement psmt) throws SQLException, SystemException {
		try {
			LOGGER.info("Executing given batch query");
			psmt.executeBatch();
			LOGGER.info("exiting select method");

		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return psmt.getResultSet();
	}

	/**
	 * Execute prepared statement.
	 *
	 * @param psmt the psmt
	 * @return the result set
	 * @throws SQLException the SQL exception
	 */
	public static ResultSet executePreparedStatement(PreparedStatement psmt) throws SQLException {
		try {
			LOGGER.info("Executing given query");
			psmt.execute();
			LOGGER.info("exiting select method");

		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return psmt.getResultSet();
	}

	/**
	 * Execute update.
	 *
	 * @param psmt the psmt
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public static int executeUpdate(PreparedStatement psmt) throws SQLException {
		int no_of_rows_affected = 0;
		try {
			LOGGER.info("Executing given query");
			no_of_rows_affected = psmt.executeUpdate();
			LOGGER.info("exiting select method");

		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return no_of_rows_affected;
	}



}
