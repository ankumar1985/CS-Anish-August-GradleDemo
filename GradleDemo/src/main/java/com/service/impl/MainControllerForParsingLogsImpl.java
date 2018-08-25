/*
 * MainControllerForParsingLogsImpl.java
 */
package main.java.com.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import main.java.com.constants.ApplicationServerConstants;
import main.java.com.utility.impl.ConnecToHsqlDBImpl;

/**
 * This a main controller class which will fetch the data form JSON and store it
 * in the Database on proposed solution.
 * 
 * @author anish kumar
 *
 */
public class MainControllerForParsingLogsImpl {
	private static final Logger log = Logger.getLogger(MainControllerForParsingLogsImpl.class);

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws IOException, SQLException {

		BufferedReader bufferedReader = null;
		JSONParser parser = new JSONParser();
		HashMap<Integer, Object> eventLogsMap = new HashMap<Integer, Object>();
		int i = 1;
		Connection con = null;
		Statement stmt = null;
		int result = 0;
		ConnecToHsqlDBImpl ConnecToHsqlDBImpl = new ConnecToHsqlDBImpl();
		try {
			log.info(ApplicationServerConstants.MAIN_CLASS_START);
			String sCurrentLine;
			stmt = ConnecToHsqlDBImpl.makeHsqldatabaseconnection(con, stmt, result);

			bufferedReader = new BufferedReader(new FileReader(ApplicationServerConstants.FILE_PATH));
			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				Object obj;
				try {
					obj = parser.parse(sCurrentLine);
					JSONObject jsonObject = (JSONObject) obj;
					String id = (String) jsonObject.get(ApplicationServerConstants.EVENT_ID);
					String state = (String) jsonObject.get(ApplicationServerConstants.EVENT_STATE);
					String type = (String) jsonObject.get(ApplicationServerConstants.EVENT_TYPE);
					String host = (String) jsonObject.get(ApplicationServerConstants.EVENT_HOST);
					long timestamp = (long) jsonObject.get(ApplicationServerConstants.EVENT_TIMESTAMP);
					ApplicationServerData applicationServerData = new ApplicationServerData(id, state, type, host,
							timestamp);
					eventLogsMap.put(i, applicationServerData);
					if (log.isDebugEnabled()) {
						log.debug(ApplicationServerConstants.APP_SERVER_DATA + applicationServerData);
						log.debug(ApplicationServerConstants.MAP_VALUE + eventLogsMap);
					}
					++i;
				} catch (Exception ex) {
					log.warn(ApplicationServerConstants.EXCEPTION + ex);
				}

			}
			analyseTheEventsServerLogs(eventLogsMap, stmt, ConnecToHsqlDBImpl);
		} catch (IOException e) {
			log.warn("ex" + e);
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
				log.info(ApplicationServerConstants.MAIN_CLASS_END);
			} catch (IOException ex) {
				log.warn(ex);
			}
		}
	}

	/**
	 * The purpose of this method is to analyze the logs and store the data in
	 * the DB.
	 * 
	 * @param eventLogsMap
	 *            eventLogsMap.
	 * @param stmt
	 *            stmt.
	 * @param connecToHsqlDBImpl
	 * @param result
	 *            result.
	 * @throws SQLException
	 */
	public static void analyseTheEventsServerLogs(final HashMap<Integer, Object> eventLogsMap, final Statement stmt,
			ConnecToHsqlDBImpl connecToHsqlDBImpl) throws SQLException {
		log.info(ApplicationServerConstants.METHOD_END);
		log.info(ApplicationServerConstants.TOTAL_RECORDS_FOUND + eventLogsMap.size());
		for (Entry<Integer, Object> entry : eventLogsMap.entrySet()) {

			ApplicationServerData aSDataOne = (ApplicationServerData) entry.getValue();
			for (Entry<Integer, Object> entry2 : eventLogsMap.entrySet()) {
				ApplicationServerData aSDataTwo = (ApplicationServerData) entry2.getValue();
				if (aSDataOne.getId().equalsIgnoreCase(aSDataTwo.getId())
						&& aSDataOne.getState().equalsIgnoreCase(ApplicationServerConstants.EVENT_STARTED)
						&& aSDataTwo.getState().equalsIgnoreCase(ApplicationServerConstants.EVENT_FINISHED)) {
					if (aSDataTwo.getTimestamp() > aSDataOne.getTimestamp()) {
						long timeDiff = aSDataTwo.getTimestamp() - aSDataOne.getTimestamp();
						boolean flag = false;
						if (log.isDebugEnabled()) {
							log.debug(ApplicationServerConstants.EVENT_ID + aSDataOne.getId());
							log.debug(ApplicationServerConstants.EVENT_TYPE + aSDataOne.getId());
							log.debug(ApplicationServerConstants.EVENT_HOST + aSDataOne.getId());
							log.debug(ApplicationServerConstants.EVENT_TIMESTAMP + aSDataOne.getId());
						}
						if (timeDiff > 4) {

							flag = true;
							ConnecToHsqlDBImpl.insertDataToDB(stmt, aSDataOne.getId(), timeDiff, aSDataOne.getType(),
									aSDataOne.getHost(), flag);
						} else {
							ConnecToHsqlDBImpl.insertDataToDB(stmt, aSDataOne.getId(), timeDiff, aSDataOne.getType(),
									aSDataOne.getHost(), flag);

						}
						log.debug(ApplicationServerConstants.INSERT_COMPLETED);
					}

				}

			}

		}
		log.info(ApplicationServerConstants.METHOD_END);

	}

}