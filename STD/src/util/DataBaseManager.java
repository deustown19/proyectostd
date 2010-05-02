package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager
{

	private Connection connection;

	public enum DBType
	{
		MS_ACCESS_DSN, MS_ACCESS_FILE, SQLITE,
	};

	/**
	 * Constructor of the class. Creates the class and connects to the DataBase.
	 * 
	 * @param dbType
	 *            DBType (enum value) with the type of the database.
	 * @param dbName
	 *            String with the name of the database.
	 */
	public DataBaseManager(DBType dbType, String dbName)
	{
		this.connect(dbType, dbName);
	}

	private void connect(DBType dbType, String dbName)
	{
		switch (dbType)
		{
			case MS_ACCESS_DSN:
				this.connectAccessWithDSN(dbName);
				break;
			case MS_ACCESS_FILE:
				this.connectAccessWithFile(dbName);
				break;
			case SQLITE:
				this.connectSQLITE(dbName);
				break;
		}
	}

	private void connectAccessDB(String url)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			this.connection = DriverManager.getConnection(url, "", "");
		}
		catch (Exception ex)
		{
			System.err.println(this.getClass().getName() + ".connectAccessDB(): " + ex);
		}
	}

	private void connectAccessWithDSN(String dbName)
	{
		connectAccessDB("jdbc:odbc:" + dbName);
	}

	private void connectAccessWithFile(String dbName)
	{
		connectAccessDB("jdbc:odbc:MS Access Database;DBQ=" + dbName);
	}

	private void connectSQLITE(String dbName)
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			this.connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
		}
		catch (Exception ex)
		{
			System.err.println(this.getClass().getName() + ".connectSQLITE(): " + ex);
		}
	}

	/**
	 * Closes the connection to the database.
	 */
	public void disconnect()
	{
		try
		{
			this.connection.close();
		}
		catch (SQLException sqle)
		{
			System.err.println(this.getClass().getName() + ".disconnect(): " + sqle);
		}
	}

	/**
	 * Creates a Statement to interact with the database.
	 * 
	 * @return Statement with the Statement to interact with the database.
	 */
	public Statement getStatement()
	{
		try
		{
			return this.connection.createStatement();
		}
		catch (SQLException sqle)
		{
			System.err.println(this.getClass().getName() + ".getStatement(): " + sqle);
			return null;
		}
	}

	/**
	 * Closes and releases a Statement that has been created.
	 * 
	 * @param statement
	 *            Statement with the Statement.
	 */
	public void releaseStatement(Statement statement)
	{
		try
		{
			statement.close();
		}
		catch (SQLException sqle)
		{
			System.err.println(this.getClass().getName() + ".releaseStatement(): " + sqle);
		}
	}

	public ResultSet executeSelect(String select) throws SQLException
	{
		ResultSet rs = null;
		Statement statement = getStatement();
		rs = statement.executeQuery(select);
		releaseStatement(statement);

		return rs;
	}

	public void executeInsert(String insert) throws SQLException
	{
		Statement statement = getStatement();
		statement.executeUpdate(insert);
		releaseStatement(statement);
	}

	public Connection getConnection()
	{
		return connection;
	}
}