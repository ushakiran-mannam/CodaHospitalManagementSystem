package global.coda.hospitalmanagement.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import global.coda.hospitalmanagement.constant.BundleFile;
import global.coda.hospitalmanagement.constant.BundleKey;

// TODO: Auto-generated Javadoc
/**
 * The Class SqlConnection.
 */
public class SqlConnection {

	/** The Constant BUNDLE. */
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BundleFile.FILE);

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(SqlConnection.class);

	/** The connection. */
	private static Connection connection;

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException           the SQL exception
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		LOGGER.info("Executing getConnection function");
		final String driver = BUNDLE.getString(BundleKey.DRIVER);
		LOGGER.debug("driver used is :" + driver);
		Class.forName(driver);
		final String userName = BUNDLE.getString(BundleKey.USERNAME);
		LOGGER.debug("username is :" + userName);
		final String password = BUNDLE.getString(BundleKey.PASSWORD);
		final String dataBase = BUNDLE.getString(BundleKey.DATABASE);
		LOGGER.debug("database is :" + dataBase);
		String url = BUNDLE.getString(BundleKey.URL);
		LOGGER.debug("retrieved url is :" + url);
		url = url + "/" + dataBase;
		LOGGER.debug("cuurent url is :" + url);
		connection = DriverManager.getConnection(url, userName, password);
		LOGGER.info("Exiting getConnection function");
		return connection;

	}

	/**
	 * Close connection.
	 *
	 * @throws SQLException the SQL exception
	 */
	public static void closeConnection() throws SQLException {
		try {
			LOGGER.info("trying to close connection");
			connection.close();
			LOGGER.info("connection closed successfully");
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

	/**
	 * Roll back.
	 *
	 * @throws SQLException the SQL exception
	 */
	public static void rollBack() throws SQLException {
		try {
			LOGGER.info("trying to rollback");
			connection.rollback();
			LOGGER.info("roll back Successfull");
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

}
