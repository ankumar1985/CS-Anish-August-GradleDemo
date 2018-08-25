package test.java.com.utility.impl;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.Test;

import main.java.com.utility.impl.ConnecToHsqlDBImpl;

/**
 * 
 * @author anish kumar
 *
 */
public class InsertQueryTest {
	private static final Logger log = Logger.getLogger(InsertQueryTest.class);
	Connection con = null;
	Statement stmt = null;
	int result = 0;
	String id = "scsmbstgra";
	int timeDiff = 5;
	String type = "STARTED";
	String host = "12345";
	boolean flag = true;

	/**
	 * test method.
	 */
	@Test
	public void test() throws SQLException {
		ConnecToHsqlDBImpl ConnecToHsqlDBImpl = new ConnecToHsqlDBImpl();
		Statement statement = ConnecToHsqlDBImpl.makeHsqldatabaseconnection(con, stmt, result);
		ConnecToHsqlDBImpl.insertDataToDB(statement, id, timeDiff, type, host, flag);
		assertEquals(true, true);

	}

}
