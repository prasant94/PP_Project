package server;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import common.Upload;
import common.User;

public class Database {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	/**
	 *
	 */
	public Database() {
		// TODO
	}

	/**
	 *
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) {
		// TODO
		return false;
	}

	/**
	 *
	 * @param upload
	 * @return
	 */
	public boolean addUpload(Upload upload) {
		// TODO
		return false;
	}

	/**
	 *
	 * @param userId
	 * @return
	 */
	public boolean deleteUser(int userId) {
		// TODO
		return false;
	}

	/**
	 *
	 * @param uploadId
	 * @return
	 */
	public boolean deleteUpload(int uploadId) {
		// TODO
		return false;
	}

	/**
	 *
	 * @param query
	 * @return
	 */
	public String searchMedia(String query) {
		return null;
	}

	/**
	 *
	 * @param sqlQuery
	 */
	public void executeQuery(String sqlQuery) {
		// TODO
	}

	/**
	 *
	 * @return
	 */
	public ResultSet getResultSet() {
		return resultSet;
	}

	/**
	 *
	 * @return
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 *
	 * @param statement
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
