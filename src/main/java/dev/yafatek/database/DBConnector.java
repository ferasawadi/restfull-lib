package dev.yafatek.database;import java.sql.Connection;import java.sql.DriverManager;import java.sql.PreparedStatement;import java.sql.ResultSet;/** * Class to Connect to the Database. * Singleton pattern is used because the cost of the Object is heavy. */public final class DBConnector {	// SingleTon Object.	private static DBConnector dbConnector;	//return result out of the operation object.	private ResultSet resultSet;	// DB Credentials.	private String url;	private String user;	private String password;	/* static methods access, SingleTon Pattern */	private DBConnector() {	}	public static DBConnector getInstance() {		// check the init object status.		if (dbConnector == null) {			// synchronize the class			synchronized (DBConnector.class) {				dbConnector = new DBConnector();			}		}		// return the object.		return dbConnector;	}	public DBConnector init(String dbUrl, String dbUser, String dbPassword) {		if (dbUrl == null || dbUser == null || dbPassword == null)			throw new IllegalStateException("Some parameters contains Null Values, Check DB (url, username, password) parameters!");		// init the DB Objects.		url = dbUrl;		user = dbUser;		password = dbPassword;		// return the object to chaining.		return dbConnector;	}	public ResultSet getDBConnection(String query) {		if (url == null)			throw new IllegalStateException("DB parameters not initialized!, please Make sure to Call init() method first using DBConnection object to init the parameters!");		Connection connection = null;		PreparedStatement preparedStatement = null;		try {			// getting DB Driver.			Class.forName("com.mysql.cj.jdbc.Driver");			// init the Connection.			connection = DriverManager.getConnection(url, user, password);			// execute the query.			preparedStatement = connection.prepareStatement(query);			// getting the results.			resultSet = preparedStatement.executeQuery();		} catch (Exception e) {			e.getStackTrace();		}		return resultSet;	}}