/**
 * ConnecToHsqlDBImpl.java
 */
package main.java.com.utility.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.hsqldb.HsqlException;

import main.java.com.constants.ApplicationServerConstants;

/**
 * This class will connect to to the HSQL DB.
 * 
 * @author anish kumar
 *
 */

public class ConnecToHsqlDBImpl {
	private static final Logger log = Logger.getLogger(ConnecToHsqlDBImpl.class);

	public Statement makeHsqldatabaseconnection(Connection con, Statement stmt, int result) {
		log.info(ApplicationServerConstants.HSQL_CONNECTION_START);
		try {

			Class.forName(ApplicationServerConstants.HSQLDB_DRIVER);

			con = DriverManager.getConnection(ApplicationServerConstants.HSQLDB_DRIVER_CONNECTION,
					ApplicationServerConstants.HSQLDB_DRIVER_SA, ApplicationServerConstants.EVENTS_EMPTY);
			stmt = con.createStatement();

			DatabaseMetaData dbm = con.getMetaData();
			ResultSet rs = dbm.getTables(null, null, "EVENTDB", null);
			if (rs.next()) {
				log.info(ApplicationServerConstants.TABLE_EXISTS);
				result = stmt.executeUpdate(ApplicationServerConstants.EVENTS_DROP_TABLE);
				result = stmt.executeUpdate(ApplicationServerConstants.EVENTS_CREATE_TABLE);

			} else {
				log.info(ApplicationServerConstants.TABLE_NOT_EXISTS);
				result = stmt.executeUpdate(ApplicationServerConstants.EVENTS_CREATE_TABLE);

			}
			log.info(ApplicationServerConstants.EVENTS_DB_SUCCESS);
			con.commit();

			if (con != null) {
				if (log.isDebugEnabled()) {
					log.debug(ApplicationServerConstants.EVENTS_DB_SUCCESS);
				}

			}

		} catch (HsqlException ex) {
			log.warn(ApplicationServerConstants.HSQL_EXCEPTION + ex);

		} catch (Exception ex) {
			log.warn(ApplicationServerConstants.EXCEPTION + ex);

		}
		log.info(ApplicationServerConstants.HSQL_CONNECTION_START);
		return stmt;

	}

	/**
	 * Insert Query statement.
	 * 
	 * @param stmt
	 * @param id
	 * @param timeDiff
	 * @param type
	 * @param host
	 * @param flag
	 * @throws SQLException
	 */
	public static void insertDataToDB(Statement stmt, String id, long timeDiff, String type, String host, boolean flag)
			throws SQLException {
		stmt.executeUpdate(ApplicationServerConstants.EVENT_INSERT_QUERY_ONE + id
				+ ApplicationServerConstants.EVENT_INSERT_QUERY_COMMA_ONE + timeDiff
				+ ApplicationServerConstants.EVENT_INSERT_QUERY_COMMA_TWO + type
				+ ApplicationServerConstants.EVENT_INSERT_QUERY_COMMA_THREE + host
				+ ApplicationServerConstants.EVENT_INSERT_QUERY_COMMA_ONE + flag
				+ ApplicationServerConstants.EVENT_INSERT_QUERY_DOUBLE_QUOTES);
		log.info(ApplicationServerConstants.INSERT_COMPLETED + ApplicationServerConstants.FOR_ID + id);

	}

}
