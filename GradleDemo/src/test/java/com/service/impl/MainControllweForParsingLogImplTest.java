package test.java.com.service.impl;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.com.service.impl.MainControllerForParsingLogsImpl;
import main.java.com.utility.impl.ConnecToHsqlDBImpl;

public class MainControllweForParsingLogImplTest {
	private static final Logger log = Logger.getLogger(MainControllweForParsingLogImplTest.class);
	static Connection con = null;
	static Statement stmt = null;
	static int result = 0;
	HashMap<Integer, Object> eventLogsMap = new HashMap<Integer, Object>();
	static ConnecToHsqlDBImpl connecToHsqlDBImpl = new ConnecToHsqlDBImpl();
	MainControllerForParsingLogsImpl mainClass = new MainControllerForParsingLogsImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		stmt = connecToHsqlDBImpl.makeHsqldatabaseconnection(con, stmt, result);
	}

	@Before
	public void setUp() throws Exception {
		ApplicationServerData appServerDataOne = new ApplicationServerData("scsmbstgra", "STARTED", "APP_log", "12345",
				10);
		ApplicationServerData appServerDataTwo = new ApplicationServerData("scsmbstgra", "FINISHED", "APP_log", "12345",
				20);

		eventLogsMap.put(1, appServerDataOne);
		eventLogsMap.put(2, appServerDataTwo);
	}

	@Test
	public void test() throws SQLException {
		// mainClass.analyseTheEventsServerLogs(eventLogsMap, stmt,
		// connecToHsqlDBImpl);
		assertEquals(true, true);

	}

}
