/**
 * 
 */
package test.java.com.utility.impl;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.Test;

import main.java.com.utility.impl.ConnecToHsqlDBImpl;

/**
 * @author anish kumar
 *
 */
public class ConnectToHqlDBImpltest {
	private static final Logger log = Logger.getLogger(ConnectToHqlDBImpltest.class);
	Connection con = null;
	Statement stmt = null;
	int result = 0;
/**
 * test method.
 */
	@Test
	public void test() {
		boolean flag = false;
		ConnecToHsqlDBImpl ConnecToHsqlDBImpl = new ConnecToHsqlDBImpl();
		Statement statement = ConnecToHsqlDBImpl.makeHsqldatabaseconnection(con, stmt, result);
		if (statement != null) {
			flag = true;
		}

		assertEquals(true, flag);

	}

}
