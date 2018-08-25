/**
 * ApplicationServerConstants.java
 */
package main.java.com.constants;

/**
 * @author anish kumar
 *
 */
public class ApplicationServerConstants {
	/**
	 * 
	 */
	private ApplicationServerConstants() {
	}

	/**
	 * The constant FILE_PATH.
	 */
	public static final String FILE_PATH = "src/main/java/com/resource/custom-build-servers.JSON";
	/**
	 * The constant EVENT_ID.
	 */
	public static final String EVENT_ID = "id";
	/**
	 * The constant EVENT_STATE.
	 */
	public static final String EVENT_STATE = "state";
	/**
	 * The constant EVENT_TYPE.
	 */
	public static final String EVENT_TYPE = "type";
	/**
	 * The constant EVENT_HOST.
	 */
	public static final String EVENT_HOST = "host";
	/**
	 * The constant EVENT_TIMESTAMP.
	 */
	public static final String EVENT_TIMESTAMP = "timestamp";
	/**
	 * The constant EVENT_STARTED.
	 */
	public static final String EVENT_STARTED = "STARTED";
	/**
	 * The constant EVENT_FINISHED.
	 */
	public static final String EVENT_FINISHED = "FINISHED";
	/**
	 * The constant EVENT_INSERT_QUERY_ONE.
	 */
	public static final String EVENT_INSERT_QUERY_ONE = "INSERT INTO EVENTDB VALUES(' ";
	/**
	 * The constant EVENT_INSERT_QUERY_COMMA_ONE.
	 */
	public static final String EVENT_INSERT_QUERY_COMMA_ONE = " ' ,";
	/**
	 * The constant EVENT_INSERT_QUERY_COMMA_TWO.
	 */
	public static final String EVENT_INSERT_QUERY_COMMA_TWO = ",'";
	/**
	 * The constant EVENT_INSERT_QUERY_COMMA_THREE.
	 */
	public static final String EVENT_INSERT_QUERY_COMMA_THREE = "','";
	/**
	 * The constant EVENT_INSERT_QUERY_DOUBLE_QUOTES.
	 */
	public static final String EVENT_INSERT_QUERY_DOUBLE_QUOTES = ")";
	/**
	 * The constant HSQLDB_DRIVER.
	 */
	public static final String HSQLDB_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
	/**
	 * The constant HSQLDB_DRIVER_CONNECTION.
	 */
	public static final String HSQLDB_DRIVER_CONNECTION = "jdbc:hsqldb:hsql://localhost/";
	/**
	 * The constant HSQLDB_DRIVER_SA.
	 */
	public static final String HSQLDB_DRIVER_SA = "SA";
	/**
	 * The constant EVENTS_EMPTY.
	 */
	public static final String EVENTS_EMPTY = "";
	/**
	 * The constant EVENTS_DROP_TABLE.
	 */
	public static final String EVENTS_DROP_TABLE = "DROP TABLE eventDB";
	/**
	 * The constant EVENTS_CREATE_TABLE.
	 */
	public static final String EVENTS_CREATE_TABLE = "CREATE TABLE eventDB(Eventid varchar(50) not null,Eventduration INT not null,Type varchar(50),Host varchar(50),alert BOOLEAN DEFAULT FALSE NOT NULL)";
	/**
	 * The constant EVENTS_DB_SUCCESS.
	 */
	public static final String EVENTS_DB_SUCCESS = "HSQL DB Connection created successfully";
	/**
	 * The constant EVENTS_DB_FAILURE.
	 */
	public static final String EVENTS_DB_FAILURE = "Problem with creating connection";
	/**
	 * The constant INSERT_COMPLETED.
	 */
	public static final String INSERT_COMPLETED = "Insert Completed";
	/**
	 * The constant MAIN_CLASS_START.
	 */
	public static final String MAIN_CLASS_START = "[MainControllerForParsingLogsImpl.starts]";
	/**
	 * The constant MAIN_CLASS_END.
	 */
	public static final String MAIN_CLASS_END = "[MainControllerForParsingLogsImpl.END]";
	/**
	 * The constant APP_SERVER_DATA.
	 */
	public static final String APP_SERVER_DATA = "applicationServerData::";
	/**
	 * The constant MAP_VALUE.
	 */
	public static final String MAP_VALUE = "Map Value::";
	/**
	 * The constant METHOD_START.
	 */
	public static final String METHOD_START = "[analyseTheEventsServerLogs : STARTS]";
	/**
	 * The constant METHOD_END.
	 */
	public static final String METHOD_END = "[analyseTheEventsServerLogs : END]";
	/**
	 * The constant EXCEPTION.
	 */
	public static final String EXCEPTION = "exception";
	/**
	 * The constant HSQL_CONNECTION_START.
	 */
	public static final String HSQL_CONNECTION_START = "[makeHsqldatabaseconnection : STARTS]";
	/**
	 * The constant HSQL_EXCEPTION.
	 */
	public static final String HSQL_EXCEPTION = "HsqlException ";
	/**
	 * The constant HSQL_CONNECTION_END.
	 */
	public static final String HSQL_CONNECTION_END = "[makeHsqldatabaseconnection : END]";
	/**
	 * The constant FOR_ID.
	 */
	public static final String FOR_ID = "  for ID   ";
	/**
	 * The constant TOTAL_RECORDS_FOUND.
	 */
	public static final String TOTAL_RECORDS_FOUND = "Total records found ";
	/**
	 * The constant TABLE_EXISTS.
	 */
	public static final String TABLE_EXISTS = "Table exists";
	/**
	 * The constant TABLE_NOT_EXISTS.
	 */
	public static final String TABLE_NOT_EXISTS = "Table does not exist";

}
