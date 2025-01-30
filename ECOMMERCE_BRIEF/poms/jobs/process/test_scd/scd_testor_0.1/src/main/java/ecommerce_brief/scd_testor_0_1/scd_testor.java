// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package ecommerce_brief.scd_testor_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: scd_testor Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class scd_testor implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "scd_testor";
	private final String projectName = "ECOMMERCE_BRIEF";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					scd_testor.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(scd_testor.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBConnection_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tCreateTable_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tCreateTable_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBSCD_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tCreateTable_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDBConnection_1 begin ] start
				 */

				ok_Hash.put("tDBConnection_1", false);
				start_Hash.put("tDBConnection_1", System.currentTimeMillis());

				currentComponent = "tDBConnection_1";

				int tos_count_tDBConnection_1 = 0;

				String url_tDBConnection_1 = "jdbc:jtds:sqlserver://" + "localhost";
				String port_tDBConnection_1 = "1433";
				String dbname_tDBConnection_1 = "ecommerv2";
				if (!"".equals(port_tDBConnection_1)) {
					url_tDBConnection_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBConnection_1)) {

					url_tDBConnection_1 += "//" + "ecommerv2";
				}

				url_tDBConnection_1 += ";appName=" + projectName + ";" + "";
				String dbUser_tDBConnection_1 = "ismaill";

				final String decryptedPassword_tDBConnection_1 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:4dQ/rLNw7LYuNwzy1YnBQo5ZV6zDYcObivei6wShKjg=");
				String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;

				java.sql.Connection conn_tDBConnection_1 = null;

				String driverClass_tDBConnection_1 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
				globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);

				conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1, dbUser_tDBConnection_1,
						dbPwd_tDBConnection_1);

				globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
				if (null != conn_tDBConnection_1) {

					conn_tDBConnection_1.setAutoCommit(false);
				}

				globalMap.put("dbschema_tDBConnection_1", "dbo");

				globalMap.put("db_tDBConnection_1", "ecommerv2");

				globalMap.put("shareIdentitySetting_tDBConnection_1", false);

				globalMap.put("driver_tDBConnection_1", "JTDS");

				/**
				 * [tDBConnection_1 begin ] stop
				 */

				/**
				 * [tDBConnection_1 main ] start
				 */

				currentComponent = "tDBConnection_1";

				tos_count_tDBConnection_1++;

				/**
				 * [tDBConnection_1 main ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_begin ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 process_data_begin ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_end ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 process_data_end ] stop
				 */

				/**
				 * [tDBConnection_1 end ] start
				 */

				currentComponent = "tDBConnection_1";

				ok_Hash.put("tDBConnection_1", true);
				end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBInput_1Process(globalMap);

				/**
				 * [tDBConnection_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBConnection_1 finally ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_1 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1);
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "ismaill";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:JEu54wr+Epo8+koQx681NP4KEulGsnj4bpgCf57HdPw=");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String port_tDBInput_1 = "1433";
				String dbname_tDBInput_1 = "ecommerv2";
				String url_tDBInput_1 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBInput_1)) {
					url_tDBInput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_1)) {
					url_tDBInput_1 += "//" + "ecommerv2";
				}
				url_tDBInput_1 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_1 = "dbo";

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "select * from ROW";

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tCreateTable_1Process(globalMap);

				/**
				 * [tDBInput_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public void tCreateTable_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tCreateTable_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tCreateTable_1 begin ] start
				 */

				ok_Hash.put("tCreateTable_1", false);
				start_Hash.put("tCreateTable_1", System.currentTimeMillis());

				currentComponent = "tCreateTable_1";

				int tos_count_tCreateTable_1 = 0;

				/**
				 * [tCreateTable_1 begin ] stop
				 */

				/**
				 * [tCreateTable_1 main ] start
				 */

				currentComponent = "tCreateTable_1";

				try {
					String tableName_tCreateTable_1 = "Dimproductt";
					String dbSchema_tCreateTable_1 = (String) globalMap.get("dbschema_tDBConnection_1");
					if (dbSchema_tCreateTable_1 != null && dbSchema_tCreateTable_1.trim().length() != 0) {
						tableName_tCreateTable_1 = dbSchema_tCreateTable_1 + "].[" + tableName_tCreateTable_1;
					}
					java.sql.Connection conn_tCreateTable_1 = (java.sql.Connection) globalMap
							.get("conn_tDBConnection_1");
					java.sql.Statement stmt_tCreateTable_1 = conn_tCreateTable_1.createStatement();
					stmt_tCreateTable_1.execute("CREATE TABLE [" + tableName_tCreateTable_1
							+ "]([ProductName] VARCHAR(29)  ,[ProductCategory] VARCHAR(29)  ,[ProductSubCategory] VARCHAR(29)  ,[ProductPrice] FLOAT(29)  ,[id] INT ,[previous_Price] VARCHAR(29)  ,[key] INT )");

					globalMap.put("tCreateTable_1_QUERY", "CREATE TABLE [" + tableName_tCreateTable_1
							+ "]([ProductName] VARCHAR(29)  ,[ProductCategory] VARCHAR(29)  ,[ProductSubCategory] VARCHAR(29)  ,[ProductPrice] FLOAT(29)  ,[id] INT ,[previous_Price] VARCHAR(29)  ,[key] INT )");
				} catch (java.lang.Exception e) {
					globalMap.put("tCreateTable_1_ERROR_MESSAGE", e.getMessage());
					throw new RuntimeException("Creating table failed", e);
				}

				tos_count_tCreateTable_1++;

				/**
				 * [tCreateTable_1 main ] stop
				 */

				/**
				 * [tCreateTable_1 process_data_begin ] start
				 */

				currentComponent = "tCreateTable_1";

				/**
				 * [tCreateTable_1 process_data_begin ] stop
				 */

				/**
				 * [tCreateTable_1 process_data_end ] start
				 */

				currentComponent = "tCreateTable_1";

				/**
				 * [tCreateTable_1 process_data_end ] stop
				 */

				/**
				 * [tCreateTable_1 end ] start
				 */

				currentComponent = "tCreateTable_1";

				ok_Hash.put("tCreateTable_1", true);
				end_Hash.put("tCreateTable_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tDBInput_2Process(globalMap);

				/**
				 * [tCreateTable_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tCreateTable_1 finally ] start
				 */

				currentComponent = "tCreateTable_1";

				/**
				 * [tCreateTable_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tCreateTable_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[0];

		public String ProductName;

		public String getProductName() {
			return this.ProductName;
		}

		public String ProductCategory;

		public String getProductCategory() {
			return this.ProductCategory;
		}

		public String ProductSubCategory;

		public String getProductSubCategory() {
			return this.ProductSubCategory;
		}

		public String ProductPrice;

		public String getProductPrice() {
			return this.ProductPrice;
		}

		public int id_pro;

		public int getId_pro() {
			return this.id_pro;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_scd_testor.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_scd_testor.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_scd_testor.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_scd_testor.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

				try {

					int length = 0;

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					this.ProductPrice = readString(dis);

					this.id_pro = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

				try {

					int length = 0;

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					this.ProductPrice = readString(dis);

					this.id_pro = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.ProductName, dos);

				// String

				writeString(this.ProductCategory, dos);

				// String

				writeString(this.ProductSubCategory, dos);

				// String

				writeString(this.ProductPrice, dos);

				// int

				dos.writeInt(this.id_pro);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.ProductName, dos);

				// String

				writeString(this.ProductCategory, dos);

				// String

				writeString(this.ProductSubCategory, dos);

				// String

				writeString(this.ProductPrice, dos);

				// int

				dos.writeInt(this.id_pro);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ProductName=" + ProductName);
			sb.append(",ProductCategory=" + ProductCategory);
			sb.append(",ProductSubCategory=" + ProductSubCategory);
			sb.append(",ProductPrice=" + ProductPrice);
			sb.append(",id_pro=" + String.valueOf(id_pro));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[0];

		public String ProductName;

		public String getProductName() {
			return this.ProductName;
		}

		public String ProductCategory;

		public String getProductCategory() {
			return this.ProductCategory;
		}

		public String ProductSubCategory;

		public String getProductSubCategory() {
			return this.ProductSubCategory;
		}

		public String ProductPrice;

		public String getProductPrice() {
			return this.ProductPrice;
		}

		public int id_pro;

		public int getId_pro() {
			return this.id_pro;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_scd_testor.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_scd_testor.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_scd_testor.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_scd_testor.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

				try {

					int length = 0;

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					this.ProductPrice = readString(dis);

					this.id_pro = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

				try {

					int length = 0;

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					this.ProductPrice = readString(dis);

					this.id_pro = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.ProductName, dos);

				// String

				writeString(this.ProductCategory, dos);

				// String

				writeString(this.ProductSubCategory, dos);

				// String

				writeString(this.ProductPrice, dos);

				// int

				dos.writeInt(this.id_pro);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.ProductName, dos);

				// String

				writeString(this.ProductCategory, dos);

				// String

				writeString(this.ProductSubCategory, dos);

				// String

				writeString(this.ProductPrice, dos);

				// int

				dos.writeInt(this.id_pro);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ProductName=" + ProductName);
			sb.append(",ProductCategory=" + ProductCategory);
			sb.append(",ProductSubCategory=" + ProductSubCategory);
			sb.append(",ProductPrice=" + ProductPrice);
			sb.append(",id_pro=" + String.valueOf(id_pro));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[0];

		public java.util.Date Date;

		public java.util.Date getDate() {
			return this.Date;
		}

		public String ProductName;

		public String getProductName() {
			return this.ProductName;
		}

		public String ProductCategory;

		public String getProductCategory() {
			return this.ProductCategory;
		}

		public String ProductSubCategory;

		public String getProductSubCategory() {
			return this.ProductSubCategory;
		}

		public String ProductPrice;

		public String getProductPrice() {
			return this.ProductPrice;
		}

		public String CustomerName;

		public String getCustomerName() {
			return this.CustomerName;
		}

		public String CustomerEmail;

		public String getCustomerEmail() {
			return this.CustomerEmail;
		}

		public String CustomerAddress;

		public String getCustomerAddress() {
			return this.CustomerAddress;
		}

		public String CustomerPhone;

		public String getCustomerPhone() {
			return this.CustomerPhone;
		}

		public String CustomerSegment;

		public String getCustomerSegment() {
			return this.CustomerSegment;
		}

		public String SupplierName;

		public String getSupplierName() {
			return this.SupplierName;
		}

		public String SupplierLocation;

		public String getSupplierLocation() {
			return this.SupplierLocation;
		}

		public String SupplierContact;

		public String getSupplierContact() {
			return this.SupplierContact;
		}

		public String ShipperName;

		public String getShipperName() {
			return this.ShipperName;
		}

		public String ShippingMethod;

		public String getShippingMethod() {
			return this.ShippingMethod;
		}

		public String QuantitySold;

		public String getQuantitySold() {
			return this.QuantitySold;
		}

		public String TotalAmount;

		public String getTotalAmount() {
			return this.TotalAmount;
		}

		public String DiscountAmount;

		public String getDiscountAmount() {
			return this.DiscountAmount;
		}

		public Float NetAmount;

		public Float getNetAmount() {
			return this.NetAmount;
		}

		public Float StockReceived;

		public Float getStockReceived() {
			return this.StockReceived;
		}

		public Float StockSold;

		public Float getStockSold() {
			return this.StockSold;
		}

		public Float StockOnHand;

		public Float getStockOnHand() {
			return this.StockOnHand;
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_scd_testor.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_scd_testor.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_scd_testor.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_scd_testor.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_scd_testor, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

				try {

					int length = 0;

					this.Date = readDate(dis);

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					this.ProductPrice = readString(dis);

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerAddress = readString(dis);

					this.CustomerPhone = readString(dis);

					this.CustomerSegment = readString(dis);

					this.SupplierName = readString(dis);

					this.SupplierLocation = readString(dis);

					this.SupplierContact = readString(dis);

					this.ShipperName = readString(dis);

					this.ShippingMethod = readString(dis);

					this.QuantitySold = readString(dis);

					this.TotalAmount = readString(dis);

					this.DiscountAmount = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.NetAmount = null;
					} else {
						this.NetAmount = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.StockReceived = null;
					} else {
						this.StockReceived = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.StockSold = null;
					} else {
						this.StockSold = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.StockOnHand = null;
					} else {
						this.StockOnHand = dis.readFloat();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

				try {

					int length = 0;

					this.Date = readDate(dis);

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					this.ProductPrice = readString(dis);

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerAddress = readString(dis);

					this.CustomerPhone = readString(dis);

					this.CustomerSegment = readString(dis);

					this.SupplierName = readString(dis);

					this.SupplierLocation = readString(dis);

					this.SupplierContact = readString(dis);

					this.ShipperName = readString(dis);

					this.ShippingMethod = readString(dis);

					this.QuantitySold = readString(dis);

					this.TotalAmount = readString(dis);

					this.DiscountAmount = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.NetAmount = null;
					} else {
						this.NetAmount = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.StockReceived = null;
					} else {
						this.StockReceived = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.StockSold = null;
					} else {
						this.StockSold = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.StockOnHand = null;
					} else {
						this.StockOnHand = dis.readFloat();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.ProductName, dos);

				// String

				writeString(this.ProductCategory, dos);

				// String

				writeString(this.ProductSubCategory, dos);

				// String

				writeString(this.ProductPrice, dos);

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerAddress, dos);

				// String

				writeString(this.CustomerPhone, dos);

				// String

				writeString(this.CustomerSegment, dos);

				// String

				writeString(this.SupplierName, dos);

				// String

				writeString(this.SupplierLocation, dos);

				// String

				writeString(this.SupplierContact, dos);

				// String

				writeString(this.ShipperName, dos);

				// String

				writeString(this.ShippingMethod, dos);

				// String

				writeString(this.QuantitySold, dos);

				// String

				writeString(this.TotalAmount, dos);

				// String

				writeString(this.DiscountAmount, dos);

				// Float

				if (this.NetAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.NetAmount);
				}

				// Float

				if (this.StockReceived == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.StockReceived);
				}

				// Float

				if (this.StockSold == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.StockSold);
				}

				// Float

				if (this.StockOnHand == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.StockOnHand);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.ProductName, dos);

				// String

				writeString(this.ProductCategory, dos);

				// String

				writeString(this.ProductSubCategory, dos);

				// String

				writeString(this.ProductPrice, dos);

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerAddress, dos);

				// String

				writeString(this.CustomerPhone, dos);

				// String

				writeString(this.CustomerSegment, dos);

				// String

				writeString(this.SupplierName, dos);

				// String

				writeString(this.SupplierLocation, dos);

				// String

				writeString(this.SupplierContact, dos);

				// String

				writeString(this.ShipperName, dos);

				// String

				writeString(this.ShippingMethod, dos);

				// String

				writeString(this.QuantitySold, dos);

				// String

				writeString(this.TotalAmount, dos);

				// String

				writeString(this.DiscountAmount, dos);

				// Float

				if (this.NetAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.NetAmount);
				}

				// Float

				if (this.StockReceived == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.StockReceived);
				}

				// Float

				if (this.StockSold == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.StockSold);
				}

				// Float

				if (this.StockOnHand == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.StockOnHand);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Date=" + String.valueOf(Date));
			sb.append(",ProductName=" + ProductName);
			sb.append(",ProductCategory=" + ProductCategory);
			sb.append(",ProductSubCategory=" + ProductSubCategory);
			sb.append(",ProductPrice=" + ProductPrice);
			sb.append(",CustomerName=" + CustomerName);
			sb.append(",CustomerEmail=" + CustomerEmail);
			sb.append(",CustomerAddress=" + CustomerAddress);
			sb.append(",CustomerPhone=" + CustomerPhone);
			sb.append(",CustomerSegment=" + CustomerSegment);
			sb.append(",SupplierName=" + SupplierName);
			sb.append(",SupplierLocation=" + SupplierLocation);
			sb.append(",SupplierContact=" + SupplierContact);
			sb.append(",ShipperName=" + ShipperName);
			sb.append(",ShippingMethod=" + ShippingMethod);
			sb.append(",QuantitySold=" + QuantitySold);
			sb.append(",TotalAmount=" + TotalAmount);
			sb.append(",DiscountAmount=" + DiscountAmount);
			sb.append(",NetAmount=" + String.valueOf(NetAmount));
			sb.append(",StockReceived=" + String.valueOf(StockReceived));
			sb.append(",StockSold=" + String.valueOf(StockSold));
			sb.append(",StockOnHand=" + String.valueOf(StockOnHand));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();
				out1Struct out1 = new out1Struct();
				out1Struct row2 = out1;

				/**
				 * [tDBSCD_1 begin ] start
				 */

				ok_Hash.put("tDBSCD_1", false);
				start_Hash.put("tDBSCD_1", System.currentTimeMillis());

				currentComponent = "tDBSCD_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tDBSCD_1 = 0;

				class SCDSK_tDBSCD_1 {
					private int hashCode;
					public boolean hashCodeDirty = true;
					int id_pro;

					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final SCDSK_tDBSCD_1 other = (SCDSK_tDBSCD_1) obj;
						if (this.id_pro != other.id_pro)
							return false;

						return true;
					}

					public int hashCode() {
						if (hashCodeDirty) {
							int prime = 31;
							hashCode = prime * hashCode + id_pro;
							hashCodeDirty = false;
						}
						return hashCode;
					}
				}

				class SCDStruct_tDBSCD_1 {
					private String ProductName;
					private String ProductSubCategory;
					private String ProductCategory;
					private String ProductPrice;
					private String previous_Price;
				}

				int nb_line_update_tDBSCD_1 = 0;
				int nb_line_inserted_tDBSCD_1 = 0;
				int nb_line_rejected_tDBSCD_1 = 0;
				String tableName_tDBSCD_1 = null;
				String dbschema_tDBSCD_1 = null;
				java.sql.Connection conn_tDBSCD_1 = null;
				String dbUser_tDBSCD_1 = null;
				dbschema_tDBSCD_1 = "dbo";
				String driverClass_tDBSCD_1 = "net.sourceforge.jtds.jdbc.Driver";

				java.lang.Class.forName(driverClass_tDBSCD_1);
				String port_tDBSCD_1 = "1433";
				String dbname_tDBSCD_1 = "ecommerv2";
				String url_tDBSCD_1 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBSCD_1)) {
					url_tDBSCD_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBSCD_1)) {
					url_tDBSCD_1 += "//" + "ecommerv2";

				}
				url_tDBSCD_1 += ";appName=" + projectName + ";" + "";
				dbUser_tDBSCD_1 = "ismaill";

				final String decryptedPassword_tDBSCD_1 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:y2SHX8HY25eUiOtjFKWQc2NpUNSMrq3HrRjB9dDJd6k=");

				String dbPwd_tDBSCD_1 = decryptedPassword_tDBSCD_1;
				conn_tDBSCD_1 = java.sql.DriverManager.getConnection(url_tDBSCD_1, dbUser_tDBSCD_1, dbPwd_tDBSCD_1);

				if (dbschema_tDBSCD_1 == null || dbschema_tDBSCD_1.trim().length() == 0) {
					tableName_tDBSCD_1 = "Dimproductt";
				} else {
					tableName_tDBSCD_1 = dbschema_tDBSCD_1 + "].[" + "Dimproductt";
				}
				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBSCD_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();
				String tmpValue_tDBSCD_1 = null;
				String search_tDBSCD_1 = "SELECT [id_pro], [ProductName], [ProductSubCategory], [ProductCategory], [ProductPrice], [previous_Price] FROM ["
						+ tableName_tDBSCD_1 + "]";
				java.sql.Statement statement_tDBSCD_1 = conn_tDBSCD_1.createStatement();
				java.sql.ResultSet resultSet_tDBSCD_1 = statement_tDBSCD_1.executeQuery(search_tDBSCD_1);
				java.util.Map<SCDSK_tDBSCD_1, SCDStruct_tDBSCD_1> cache_tDBSCD_1 = new java.util.HashMap<SCDSK_tDBSCD_1, SCDStruct_tDBSCD_1>();
				while (resultSet_tDBSCD_1.next()) {
					SCDSK_tDBSCD_1 sk_tDBSCD_1 = new SCDSK_tDBSCD_1();
					SCDStruct_tDBSCD_1 row_tDBSCD_1 = new SCDStruct_tDBSCD_1();
					if (resultSet_tDBSCD_1.getObject(1) != null) {
						sk_tDBSCD_1.id_pro = resultSet_tDBSCD_1.getInt(1);
					}
					if (resultSet_tDBSCD_1.getObject(2) != null) {
						row_tDBSCD_1.ProductName = resultSet_tDBSCD_1.getString(2);
					}
					if (resultSet_tDBSCD_1.getObject(3) != null) {
						row_tDBSCD_1.ProductSubCategory = resultSet_tDBSCD_1.getString(3);
					}
					if (resultSet_tDBSCD_1.getObject(4) != null) {
						row_tDBSCD_1.ProductCategory = resultSet_tDBSCD_1.getString(4);
					}
					if (resultSet_tDBSCD_1.getObject(5) != null) {
						row_tDBSCD_1.ProductPrice = resultSet_tDBSCD_1.getString(5);
					}
					if (resultSet_tDBSCD_1.getObject(6) != null) {
						row_tDBSCD_1.previous_Price = resultSet_tDBSCD_1.getString(6);
					}
					cache_tDBSCD_1.put(sk_tDBSCD_1, row_tDBSCD_1);
				}
				resultSet_tDBSCD_1.close();
				statement_tDBSCD_1.close();
				String insertionSQL_tDBSCD_1 = "INSERT INTO [" + tableName_tDBSCD_1
						+ "]([id_pro], [ProductName], [ProductSubCategory], [ProductCategory], [ProductPrice]) VALUES(?, ?, ?, ?, ?)";
				java.sql.PreparedStatement insertionStatement_tDBSCD_1 = conn_tDBSCD_1
						.prepareStatement(insertionSQL_tDBSCD_1);
				String updateSQLForType1_tDBSCD_1 = "UPDATE [" + tableName_tDBSCD_1
						+ "] SET [ProductCategory] = ? WHERE [id_pro] = ?";
				java.sql.PreparedStatement updateForType1_tDBSCD_1 = conn_tDBSCD_1
						.prepareStatement(updateSQLForType1_tDBSCD_1);
				String updateSQLForType3_tDBSCD_1 = "UPDATE [" + tableName_tDBSCD_1
						+ "] SET [ProductPrice] = ?, [previous_Price] = ? WHERE [id_pro] = ?";
				java.sql.PreparedStatement updateForType3_tDBSCD_1 = conn_tDBSCD_1
						.prepareStatement(updateSQLForType3_tDBSCD_1);

				SCDSK_tDBSCD_1 lookUpKey_tDBSCD_1 = null;
				SCDStruct_tDBSCD_1 lookUpValue_tDBSCD_1 = null;

				/**
				 * [tDBSCD_1 begin ] stop
				 */

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out1");
				}

				int tos_count_tLogRow_1 = 0;

				///////////////////////

				class Util_tLogRow_1 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[5];

					public void addRow(String[] row) {

						for (int i = 0; i < 5; i++) {
							if (row[i] != null) {
								colLengths[i] = Math.max(colLengths[i], row[i].length());
							}
						}
						list.add(row);
					}

					public void setTableName(String name) {

						this.name = name;
					}

					public StringBuilder format() {

						StringBuilder sb = new StringBuilder();

						sb.append(print(des_top));

						int totals = 0;
						for (int i = 0; i < colLengths.length; i++) {
							totals = totals + colLengths[i];
						}

						// name
						sb.append("|");
						int k = 0;
						for (k = 0; k < (totals + 4 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 4 - name.length() - k; i++) {
							sb.append(' ');
						}
						sb.append("|\n");

						// head and rows
						sb.append(print(des_head));
						for (int i = 0; i < list.size(); i++) {

							String[] row = list.get(i);

							java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());

							StringBuilder sbformat = new StringBuilder();
							sbformat.append("|%1$-");
							sbformat.append(colLengths[0]);
							sbformat.append("s");

							sbformat.append("|%2$-");
							sbformat.append(colLengths[1]);
							sbformat.append("s");

							sbformat.append("|%3$-");
							sbformat.append(colLengths[2]);
							sbformat.append("s");

							sbformat.append("|%4$-");
							sbformat.append(colLengths[3]);
							sbformat.append("s");

							sbformat.append("|%5$-");
							sbformat.append(colLengths[4]);
							sbformat.append("s");

							sbformat.append("|\n");

							formatter.format(sbformat.toString(), (Object[]) row);

							sb.append(formatter.toString());
							if (i == 0)
								sb.append(print(des_head)); // print the head
						}

						// end
						sb.append(print(des_bottom));
						return sb;
					}

					private StringBuilder print(String[] fillChars) {
						StringBuilder sb = new StringBuilder();
						// first column
						sb.append(fillChars[0]);
						for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						// last column
						for (int i = 0; i < colLengths[4] - fillChars[1].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[1]);
						sb.append("\n");
						return sb;
					}

					public boolean isTableEmpty() {
						if (list.size() > 1)
							return false;
						return true;
					}
				}
				Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
				util_tLogRow_1.setTableName("tLogRow_1");
				util_tLogRow_1.addRow(new String[] { "ProductName", "ProductCategory", "ProductSubCategory",
						"ProductPrice", "id_pro", });
				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
					int id_pro;
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out1Struct out1_tmp = new out1Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_2 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_2 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_2 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_2, talendToDBArray_tDBInput_2);
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "ismaill";

				final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:+H39vUSiAVsgBlWIqyph8QNu93JsdWmJGMSqY/gaIk8=");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String port_tDBInput_2 = "1433";
				String dbname_tDBInput_2 = "ecommerv2";
				String url_tDBInput_2 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBInput_2)) {
					url_tDBInput_2 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_2)) {
					url_tDBInput_2 += "//" + "ecommerv2";
				}
				url_tDBInput_2 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_2 = "dbo";

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "select * from ROW";

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row1.Date = null;
						} else {

							row1.Date = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 1);

						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row1.ProductName = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.ProductName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.ProductName = tmpContent_tDBInput_2;
								}
							} else {
								row1.ProductName = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row1.ProductCategory = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.ProductCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.ProductCategory = tmpContent_tDBInput_2;
								}
							} else {
								row1.ProductCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 4) {
							row1.ProductSubCategory = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.ProductSubCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.ProductSubCategory = tmpContent_tDBInput_2;
								}
							} else {
								row1.ProductSubCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 5) {
							row1.ProductPrice = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.ProductPrice = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.ProductPrice = tmpContent_tDBInput_2;
								}
							} else {
								row1.ProductPrice = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 6) {
							row1.CustomerName = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(6);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.CustomerName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.CustomerName = tmpContent_tDBInput_2;
								}
							} else {
								row1.CustomerName = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 7) {
							row1.CustomerEmail = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(7);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.CustomerEmail = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.CustomerEmail = tmpContent_tDBInput_2;
								}
							} else {
								row1.CustomerEmail = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 8) {
							row1.CustomerAddress = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(8);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.CustomerAddress = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.CustomerAddress = tmpContent_tDBInput_2;
								}
							} else {
								row1.CustomerAddress = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 9) {
							row1.CustomerPhone = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(9);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.CustomerPhone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.CustomerPhone = tmpContent_tDBInput_2;
								}
							} else {
								row1.CustomerPhone = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 10) {
							row1.CustomerSegment = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(10);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.CustomerSegment = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.CustomerSegment = tmpContent_tDBInput_2;
								}
							} else {
								row1.CustomerSegment = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 11) {
							row1.SupplierName = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(11);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.SupplierName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.SupplierName = tmpContent_tDBInput_2;
								}
							} else {
								row1.SupplierName = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 12) {
							row1.SupplierLocation = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(12);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.SupplierLocation = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.SupplierLocation = tmpContent_tDBInput_2;
								}
							} else {
								row1.SupplierLocation = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 13) {
							row1.SupplierContact = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(13);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.SupplierContact = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.SupplierContact = tmpContent_tDBInput_2;
								}
							} else {
								row1.SupplierContact = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 14) {
							row1.ShipperName = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(14);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.ShipperName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.ShipperName = tmpContent_tDBInput_2;
								}
							} else {
								row1.ShipperName = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 15) {
							row1.ShippingMethod = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(15);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.ShippingMethod = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.ShippingMethod = tmpContent_tDBInput_2;
								}
							} else {
								row1.ShippingMethod = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 16) {
							row1.QuantitySold = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(16);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(16).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.QuantitySold = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.QuantitySold = tmpContent_tDBInput_2;
								}
							} else {
								row1.QuantitySold = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 17) {
							row1.TotalAmount = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(17);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(17).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.TotalAmount = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.TotalAmount = tmpContent_tDBInput_2;
								}
							} else {
								row1.TotalAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 18) {
							row1.DiscountAmount = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(18);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(18).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.DiscountAmount = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.DiscountAmount = tmpContent_tDBInput_2;
								}
							} else {
								row1.DiscountAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 19) {
							row1.NetAmount = null;
						} else {

							row1.NetAmount = rs_tDBInput_2.getFloat(19);
							if (rs_tDBInput_2.wasNull()) {
								row1.NetAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 20) {
							row1.StockReceived = null;
						} else {

							row1.StockReceived = rs_tDBInput_2.getFloat(20);
							if (rs_tDBInput_2.wasNull()) {
								row1.StockReceived = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 21) {
							row1.StockSold = null;
						} else {

							row1.StockSold = rs_tDBInput_2.getFloat(21);
							if (rs_tDBInput_2.wasNull()) {
								row1.StockSold = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 22) {
							row1.StockOnHand = null;
						} else {

							row1.StockOnHand = rs_tDBInput_2.getFloat(22);
							if (rs_tDBInput_2.wasNull()) {
								row1.StockOnHand = null;
							}
						}

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;
							Var.id_pro = Math.abs(Integer.valueOf(
									(out1.ProductName + out1.ProductSubCategory + out1.ProductSubCategory).hashCode()
											% 1000)
									+ 1);// ###############################
							// ###############################
							// # Output tables

							out1 = null;

// # Output table : 'out1'
							out1_tmp.ProductName = row1.ProductName;
							out1_tmp.ProductCategory = row1.ProductCategory;
							out1_tmp.ProductSubCategory = row1.ProductSubCategory;
							out1_tmp.ProductPrice = row1.ProductPrice;
							out1_tmp.id_pro = Var.id_pro;
							out1 = out1_tmp;
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
// Start of branch "out1"
						if (out1 != null) {

							/**
							 * [tLogRow_1 main ] start
							 */

							currentComponent = "tLogRow_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "out1"

								);
							}

///////////////////////		

							String[] row_tLogRow_1 = new String[5];

							if (out1.ProductName != null) { //
								row_tLogRow_1[0] = String.valueOf(out1.ProductName);

							} //

							if (out1.ProductCategory != null) { //
								row_tLogRow_1[1] = String.valueOf(out1.ProductCategory);

							} //

							if (out1.ProductSubCategory != null) { //
								row_tLogRow_1[2] = String.valueOf(out1.ProductSubCategory);

							} //

							if (out1.ProductPrice != null) { //
								row_tLogRow_1[3] = String.valueOf(out1.ProductPrice);

							} //

							row_tLogRow_1[4] = String.valueOf(out1.id_pro);

							util_tLogRow_1.addRow(row_tLogRow_1);
							nb_line_tLogRow_1++;
//////

//////                    

///////////////////////    			

							row2 = out1;

							tos_count_tLogRow_1++;

							/**
							 * [tLogRow_1 main ] stop
							 */

							/**
							 * [tLogRow_1 process_data_begin ] start
							 */

							currentComponent = "tLogRow_1";

							/**
							 * [tLogRow_1 process_data_begin ] stop
							 */

							/**
							 * [tDBSCD_1 main ] start
							 */

							currentComponent = "tDBSCD_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row2"

								);
							}

							try {
								lookUpKey_tDBSCD_1 = new SCDSK_tDBSCD_1();
								lookUpKey_tDBSCD_1.id_pro = row2.id_pro;
								lookUpKey_tDBSCD_1.hashCodeDirty = true;
								lookUpValue_tDBSCD_1 = cache_tDBSCD_1.get(lookUpKey_tDBSCD_1);
								if (lookUpValue_tDBSCD_1 == null) {
									lookUpValue_tDBSCD_1 = new SCDStruct_tDBSCD_1();

									insertionStatement_tDBSCD_1.setInt(1, row2.id_pro);

									if (row2.ProductName == null) {
										insertionStatement_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
									} else {
										insertionStatement_tDBSCD_1.setString(2, row2.ProductName);
									}

									if (row2.ProductSubCategory == null) {
										insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.VARCHAR);
									} else {
										insertionStatement_tDBSCD_1.setString(3, row2.ProductSubCategory);
									}

									if (row2.ProductCategory == null) {
										insertionStatement_tDBSCD_1.setNull(4, java.sql.Types.VARCHAR);
									} else {
										insertionStatement_tDBSCD_1.setString(4, row2.ProductCategory);
									}

									if (row2.ProductPrice == null) {
										insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.VARCHAR);
									} else {
										insertionStatement_tDBSCD_1.setString(5, row2.ProductPrice);
									}

									nb_line_inserted_tDBSCD_1 += insertionStatement_tDBSCD_1.executeUpdate();
								} else {
									if ((lookUpValue_tDBSCD_1.ProductCategory == null && row2.ProductCategory != null)
											|| (lookUpValue_tDBSCD_1.ProductCategory != null
													&& !lookUpValue_tDBSCD_1.ProductCategory
															.equals(row2.ProductCategory))) {
										if (row2.ProductCategory == null) {
											updateForType1_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
										} else {
											updateForType1_tDBSCD_1.setString(1, row2.ProductCategory);
										}

										updateForType1_tDBSCD_1.setInt(2, row2.id_pro);

										nb_line_update_tDBSCD_1 += updateForType1_tDBSCD_1.executeUpdate();
									}
									if ((lookUpValue_tDBSCD_1.ProductPrice == null && row2.ProductPrice != null)
											|| (lookUpValue_tDBSCD_1.ProductPrice != null
													&& !lookUpValue_tDBSCD_1.ProductPrice.equals(row2.ProductPrice))) {
										if (row2.ProductPrice == null) {
											updateForType3_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
										} else {
											updateForType3_tDBSCD_1.setString(1, row2.ProductPrice);
										}

										if (lookUpValue_tDBSCD_1.ProductPrice == null) {
											updateForType3_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
										} else {
											updateForType3_tDBSCD_1.setString(2, lookUpValue_tDBSCD_1.ProductPrice);
										}

										updateForType3_tDBSCD_1.setInt(3, row2.id_pro);

										nb_line_update_tDBSCD_1 += updateForType3_tDBSCD_1.executeUpdate();
									}
								}

							} catch (java.lang.Exception e) {// catch
								globalMap.put("tDBSCD_1_ERROR_MESSAGE", e.getMessage());

								System.err.print(e.getMessage());
							} // end catch

							lookUpValue_tDBSCD_1.ProductCategory = row2.ProductCategory;
							lookUpValue_tDBSCD_1.ProductPrice = row2.ProductPrice;
							cache_tDBSCD_1.put(lookUpKey_tDBSCD_1, lookUpValue_tDBSCD_1);

							tos_count_tDBSCD_1++;

							/**
							 * [tDBSCD_1 main ] stop
							 */

							/**
							 * [tDBSCD_1 process_data_begin ] start
							 */

							currentComponent = "tDBSCD_1";

							/**
							 * [tDBSCD_1 process_data_begin ] stop
							 */

							/**
							 * [tDBSCD_1 process_data_end ] start
							 */

							currentComponent = "tDBSCD_1";

							/**
							 * [tDBSCD_1 process_data_end ] stop
							 */

							/**
							 * [tLogRow_1 process_data_end ] start
							 */

							currentComponent = "tLogRow_1";

							/**
							 * [tLogRow_1 process_data_end ] stop
							 */

						} // End of branch "out1"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

//////

				java.io.PrintStream consoleOut_tLogRow_1 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
				}

				consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
				consoleOut_tLogRow_1.flush();
//////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);

///////////////////////    			

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out1");
				}

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
				 */

				/**
				 * [tDBSCD_1 end ] start
				 */

				currentComponent = "tDBSCD_1";

				insertionStatement_tDBSCD_1.close();
				updateForType1_tDBSCD_1.close();
				updateForType3_tDBSCD_1.close();

				if (conn_tDBSCD_1 != null && !conn_tDBSCD_1.isClosed()) {
					conn_tDBSCD_1.close();
				}

				globalMap.put("tDBSCD_1_NB_LINE_UPDATED", nb_line_update_tDBSCD_1);
				globalMap.put("tDBSCD_1_NB_LINE_INSERTED", nb_line_inserted_tDBSCD_1);
				globalMap.put("tDBSCD_1_NB_LINE_REJECTED", nb_line_rejected_tDBSCD_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tDBSCD_1", true);
				end_Hash.put("tDBSCD_1", System.currentTimeMillis());

				/**
				 * [tDBSCD_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

				/**
				 * [tDBSCD_1 finally ] start
				 */

				currentComponent = "tDBSCD_1";

				/**
				 * [tDBSCD_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final scd_testor scd_testorClass = new scd_testor();

		int exitCode = scd_testorClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = scd_testor.class.getClassLoader()
					.getResourceAsStream("ecommerce_brief/scd_testor_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = scd_testor.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBConnection_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBConnection_1) {
			globalMap.put("tDBConnection_1_SUBPROCESS_STATE", -1);

			e_tDBConnection_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : scd_testor");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {
		closeSqlDbConnections();

	}

	private void closeSqlDbConnections() {
		try {
			Object obj_conn;
			obj_conn = globalMap.remove("conn_tDBConnection_1");
			if (null != obj_conn) {
				((java.sql.Connection) obj_conn).close();
			}
		} catch (java.lang.Exception e) {
		}
	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
		connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 113416 characters generated by Talend Open Studio for Data Integration on the
 * 30 janvier 2025, 12:30:48 UTC+01:00
 ************************************************************************************************/