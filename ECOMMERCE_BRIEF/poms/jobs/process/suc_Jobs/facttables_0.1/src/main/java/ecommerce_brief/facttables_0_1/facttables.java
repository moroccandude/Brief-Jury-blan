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

package ecommerce_brief.facttables_0_1;

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
 * Job: facttables Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class facttables implements TalendJob {

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
	private final String jobName = "facttables";
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

	LogCatcherUtils tLogCatcher_1 = new LogCatcherUtils();

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
					facttables.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(facttables.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						tLogCatcher_1.addMessage("Java Exception", currentComponent, 6,
								e.getClass().getName() + ":" + e.getMessage(), 1);
						tLogCatcher_1Process(globalMap);
					}
				} catch (TalendException e) {
					// do nothing

				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBConnection_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		try {

			if (this.execStat) {
				runStat.updateStatOnConnection("OnComponentError1", 0, "error");
			}

			errorCode = null;
			tLogCatcher_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogCatcher_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
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

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSleep_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tSleep_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRunJob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tLogCatcher_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tSleep_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRunJob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPrejob_1_onSubJobError(Exception exception, String errorComponent,
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
						.decryptPassword("enc:routine.encryption.key.v1:BwhtJu/wFIhBhiByIw33atT54nrzhmzZiBBx8uFH6Fw=");
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
					runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tDBInput_2Process(globalMap);

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

	public void tLogCatcher_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 0);

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
				 * [tLogCatcher_1 begin ] start
				 */

				ok_Hash.put("tLogCatcher_1", false);
				start_Hash.put("tLogCatcher_1", System.currentTimeMillis());

				currentComponent = "tLogCatcher_1";

				int tos_count_tLogCatcher_1 = 0;

				try {
					for (LogCatcherUtils.LogCatcherMessage lcm : tLogCatcher_1.getMessages()) {

						/**
						 * [tLogCatcher_1 begin ] stop
						 */

						/**
						 * [tLogCatcher_1 main ] start
						 */

						currentComponent = "tLogCatcher_1";

						tos_count_tLogCatcher_1++;

						/**
						 * [tLogCatcher_1 main ] stop
						 */

						/**
						 * [tLogCatcher_1 process_data_begin ] start
						 */

						currentComponent = "tLogCatcher_1";

						/**
						 * [tLogCatcher_1 process_data_begin ] stop
						 */

						/**
						 * [tLogCatcher_1 process_data_end ] start
						 */

						currentComponent = "tLogCatcher_1";

						/**
						 * [tLogCatcher_1 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_1 end ] start
						 */

						currentComponent = "tLogCatcher_1";

					}
				} catch (Exception e_tLogCatcher_1) {
					globalMap.put("tLogCatcher_1_ERROR_MESSAGE", e_tLogCatcher_1.getMessage());
					logIgnoredError(String.format(
							"tLogCatcher_1 - tLogCatcher failed to process log message(s) due to internal error: %s",
							e_tLogCatcher_1), e_tLogCatcher_1);
				}

				ok_Hash.put("tLogCatcher_1", true);
				end_Hash.put("tLogCatcher_1", System.currentTimeMillis());

				/**
				 * [tLogCatcher_1 end ] stop
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
				 * [tLogCatcher_1 finally ] start
				 */

				currentComponent = "tLogCatcher_1";

				/**
				 * [tLogCatcher_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 1);
	}

	public static class factsallesStruct implements routines.system.IPersistableRow<factsallesStruct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_facttables = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_facttables = new byte[0];

		public Integer QuantitySold;

		public Integer getQuantitySold() {
			return this.QuantitySold;
		}

		public Float TotalAmount;

		public Float getTotalAmount() {
			return this.TotalAmount;
		}

		public Float DiscountAmount;

		public Float getDiscountAmount() {
			return this.DiscountAmount;
		}

		public Float NetAmount;

		public Float getNetAmount() {
			return this.NetAmount;
		}

		public int id_pro;

		public int getId_pro() {
			return this.id_pro;
		}

		public int id_shipping;

		public int getId_shipping() {
			return this.id_shipping;
		}

		public int id_costumer;

		public int getId_costumer() {
			return this.id_costumer;
		}

		public int id_date;

		public int getId_date() {
			return this.id_date;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_facttables) {

				try {

					int length = 0;

					this.QuantitySold = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.TotalAmount = null;
					} else {
						this.TotalAmount = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.DiscountAmount = null;
					} else {
						this.DiscountAmount = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.NetAmount = null;
					} else {
						this.NetAmount = dis.readFloat();
					}

					this.id_pro = dis.readInt();

					this.id_shipping = dis.readInt();

					this.id_costumer = dis.readInt();

					this.id_date = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_facttables) {

				try {

					int length = 0;

					this.QuantitySold = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.TotalAmount = null;
					} else {
						this.TotalAmount = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.DiscountAmount = null;
					} else {
						this.DiscountAmount = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.NetAmount = null;
					} else {
						this.NetAmount = dis.readFloat();
					}

					this.id_pro = dis.readInt();

					this.id_shipping = dis.readInt();

					this.id_costumer = dis.readInt();

					this.id_date = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.QuantitySold, dos);

				// Float

				if (this.TotalAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.TotalAmount);
				}

				// Float

				if (this.DiscountAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.DiscountAmount);
				}

				// Float

				if (this.NetAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.NetAmount);
				}

				// int

				dos.writeInt(this.id_pro);

				// int

				dos.writeInt(this.id_shipping);

				// int

				dos.writeInt(this.id_costumer);

				// int

				dos.writeInt(this.id_date);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.QuantitySold, dos);

				// Float

				if (this.TotalAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.TotalAmount);
				}

				// Float

				if (this.DiscountAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.DiscountAmount);
				}

				// Float

				if (this.NetAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.NetAmount);
				}

				// int

				dos.writeInt(this.id_pro);

				// int

				dos.writeInt(this.id_shipping);

				// int

				dos.writeInt(this.id_costumer);

				// int

				dos.writeInt(this.id_date);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("QuantitySold=" + String.valueOf(QuantitySold));
			sb.append(",TotalAmount=" + String.valueOf(TotalAmount));
			sb.append(",DiscountAmount=" + String.valueOf(DiscountAmount));
			sb.append(",NetAmount=" + String.valueOf(NetAmount));
			sb.append(",id_pro=" + String.valueOf(id_pro));
			sb.append(",id_shipping=" + String.valueOf(id_shipping));
			sb.append(",id_costumer=" + String.valueOf(id_costumer));
			sb.append(",id_date=" + String.valueOf(id_date));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(factsallesStruct other) {

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

	public static class factinventoryStruct implements routines.system.IPersistableRow<factinventoryStruct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_facttables = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_facttables = new byte[0];

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

		public int id_supplier;

		public int getId_supplier() {
			return this.id_supplier;
		}

		public int id_date;

		public int getId_date() {
			return this.id_date;
		}

		public int id_pro;

		public int getId_pro() {
			return this.id_pro;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_facttables) {

				try {

					int length = 0;

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

					this.id_supplier = dis.readInt();

					this.id_date = dis.readInt();

					this.id_pro = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_facttables) {

				try {

					int length = 0;

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

					this.id_supplier = dis.readInt();

					this.id_date = dis.readInt();

					this.id_pro = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

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

				// int

				dos.writeInt(this.id_supplier);

				// int

				dos.writeInt(this.id_date);

				// int

				dos.writeInt(this.id_pro);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

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

				// int

				dos.writeInt(this.id_supplier);

				// int

				dos.writeInt(this.id_date);

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
			sb.append("StockReceived=" + String.valueOf(StockReceived));
			sb.append(",StockSold=" + String.valueOf(StockSold));
			sb.append(",StockOnHand=" + String.valueOf(StockOnHand));
			sb.append(",id_supplier=" + String.valueOf(id_supplier));
			sb.append(",id_date=" + String.valueOf(id_date));
			sb.append(",id_pro=" + String.valueOf(id_pro));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(factinventoryStruct other) {

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
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_facttables = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_facttables = new byte[0];

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

		public Float ProductPrice;

		public Float getProductPrice() {
			return this.ProductPrice;
		}

		public String Date;

		public String getDate() {
			return this.Date;
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

		public Integer QuantitySold;

		public Integer getQuantitySold() {
			return this.QuantitySold;
		}

		public Float TotalAmount;

		public Float getTotalAmount() {
			return this.TotalAmount;
		}

		public Float DiscountAmount;

		public Float getDiscountAmount() {
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

		public int id_pro;

		public int getId_pro() {
			return this.id_pro;
		}

		public int id_shipping;

		public int getId_shipping() {
			return this.id_shipping;
		}

		public int id_supplier;

		public int getId_supplier() {
			return this.id_supplier;
		}

		public int id_costumer;

		public int getId_costumer() {
			return this.id_costumer;
		}

		public int id_date;

		public int getId_date() {
			return this.id_date;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_facttables.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_facttables.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_facttables = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_facttables = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_facttables, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_facttables, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_facttables.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_facttables.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_facttables = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_facttables = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_facttables, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_facttables, 0, length, utf8Charset);
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

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_facttables) {

				try {

					int length = 0;

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ProductPrice = null;
					} else {
						this.ProductPrice = dis.readFloat();
					}

					this.Date = readString(dis);

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

					this.QuantitySold = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.TotalAmount = null;
					} else {
						this.TotalAmount = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.DiscountAmount = null;
					} else {
						this.DiscountAmount = dis.readFloat();
					}

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

					this.id_pro = dis.readInt();

					this.id_shipping = dis.readInt();

					this.id_supplier = dis.readInt();

					this.id_costumer = dis.readInt();

					this.id_date = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_facttables) {

				try {

					int length = 0;

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ProductPrice = null;
					} else {
						this.ProductPrice = dis.readFloat();
					}

					this.Date = readString(dis);

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

					this.QuantitySold = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.TotalAmount = null;
					} else {
						this.TotalAmount = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.DiscountAmount = null;
					} else {
						this.DiscountAmount = dis.readFloat();
					}

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

					this.id_pro = dis.readInt();

					this.id_shipping = dis.readInt();

					this.id_supplier = dis.readInt();

					this.id_costumer = dis.readInt();

					this.id_date = dis.readInt();

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

				// Float

				if (this.ProductPrice == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.ProductPrice);
				}

				// String

				writeString(this.Date, dos);

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

				// Integer

				writeInteger(this.QuantitySold, dos);

				// Float

				if (this.TotalAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.TotalAmount);
				}

				// Float

				if (this.DiscountAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.DiscountAmount);
				}

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

				// int

				dos.writeInt(this.id_pro);

				// int

				dos.writeInt(this.id_shipping);

				// int

				dos.writeInt(this.id_supplier);

				// int

				dos.writeInt(this.id_costumer);

				// int

				dos.writeInt(this.id_date);

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

				// Float

				if (this.ProductPrice == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.ProductPrice);
				}

				// String

				writeString(this.Date, dos);

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

				// Integer

				writeInteger(this.QuantitySold, dos);

				// Float

				if (this.TotalAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.TotalAmount);
				}

				// Float

				if (this.DiscountAmount == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.DiscountAmount);
				}

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

				// int

				dos.writeInt(this.id_pro);

				// int

				dos.writeInt(this.id_shipping);

				// int

				dos.writeInt(this.id_supplier);

				// int

				dos.writeInt(this.id_costumer);

				// int

				dos.writeInt(this.id_date);

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
			sb.append(",ProductPrice=" + String.valueOf(ProductPrice));
			sb.append(",Date=" + Date);
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
			sb.append(",QuantitySold=" + String.valueOf(QuantitySold));
			sb.append(",TotalAmount=" + String.valueOf(TotalAmount));
			sb.append(",DiscountAmount=" + String.valueOf(DiscountAmount));
			sb.append(",NetAmount=" + String.valueOf(NetAmount));
			sb.append(",StockReceived=" + String.valueOf(StockReceived));
			sb.append(",StockSold=" + String.valueOf(StockSold));
			sb.append(",StockOnHand=" + String.valueOf(StockOnHand));
			sb.append(",id_pro=" + String.valueOf(id_pro));
			sb.append(",id_shipping=" + String.valueOf(id_shipping));
			sb.append(",id_supplier=" + String.valueOf(id_supplier));
			sb.append(",id_costumer=" + String.valueOf(id_costumer));
			sb.append(",id_date=" + String.valueOf(id_date));
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
				factsallesStruct factsalles = new factsallesStruct();
				factinventoryStruct factinventory = new factinventoryStruct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "factsalles");
				}

				int tos_count_tDBOutput_1 = 0;

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;
				String dbschema_tDBOutput_1 = null;
				String tableName_tDBOutput_1 = null;
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				long year1_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_1;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_1 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_1 = null;
				String dbUser_tDBOutput_1 = null;
				dbschema_tDBOutput_1 = "dbo";
				String driverClass_tDBOutput_1 = "net.sourceforge.jtds.jdbc.Driver";

				java.lang.Class.forName(driverClass_tDBOutput_1);
				String port_tDBOutput_1 = "1433";
				String dbname_tDBOutput_1 = "ecommerv2";
				String url_tDBOutput_1 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBOutput_1)) {
					url_tDBOutput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_1)) {
					url_tDBOutput_1 += "//" + "ecommerv2";

				}
				url_tDBOutput_1 += ";appName=" + projectName + ";" + "";
				dbUser_tDBOutput_1 = "ismaill";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:RAygiNCgQiT9Rxw7hjRx2gK9V7z1JNkJCEjutlCYq8M=");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				int batchSize_tDBOutput_1 = 10000;
				int batchSizeCounter_tDBOutput_1 = 0;

				if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = "factSalles";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "factSalles";
				}
				int count_tDBOutput_1 = 0;

				boolean whetherExist_tDBOutput_1 = false;
				try (java.sql.Statement isExistStmt_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					try {
						isExistStmt_tDBOutput_1.execute("SELECT TOP 1 1 FROM [" + tableName_tDBOutput_1 + "]");
						whetherExist_tDBOutput_1 = true;
					} catch (java.lang.Exception e) {
						globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
						whetherExist_tDBOutput_1 = false;
					}
				}
				if (!whetherExist_tDBOutput_1) {
					try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
						stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1
								+ "]([QuantitySold] INT ,[TotalAmount] REAL ,[DiscountAmount] REAL ,[NetAmount] REAL ,[id_product] INT  not null ,[id_shipping] INT  not null ,[id_costumer] INT  not null ,[id_date] INT  not null )");
					}
				}
				String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1
						+ "] ([QuantitySold],[TotalAmount],[DiscountAmount],[NetAmount],[id_product],[id_shipping],[id_costumer],[id_date]) VALUES (?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tDBOutput_2 begin ] start
				 */

				ok_Hash.put("tDBOutput_2", false);
				start_Hash.put("tDBOutput_2", System.currentTimeMillis());

				currentComponent = "tDBOutput_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "factinventory");
				}

				int tos_count_tDBOutput_2 = 0;

				int nb_line_tDBOutput_2 = 0;
				int nb_line_update_tDBOutput_2 = 0;
				int nb_line_inserted_tDBOutput_2 = 0;
				int nb_line_deleted_tDBOutput_2 = 0;
				int nb_line_rejected_tDBOutput_2 = 0;

				int deletedCount_tDBOutput_2 = 0;
				int updatedCount_tDBOutput_2 = 0;
				int insertedCount_tDBOutput_2 = 0;
				int rowsToCommitCount_tDBOutput_2 = 0;
				int rejectedCount_tDBOutput_2 = 0;
				String dbschema_tDBOutput_2 = null;
				String tableName_tDBOutput_2 = null;
				boolean whetherReject_tDBOutput_2 = false;

				java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
				long year1_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_2;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_2 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_2 = null;
				String dbUser_tDBOutput_2 = null;
				dbschema_tDBOutput_2 = "dbo";
				String driverClass_tDBOutput_2 = "net.sourceforge.jtds.jdbc.Driver";

				java.lang.Class.forName(driverClass_tDBOutput_2);
				String port_tDBOutput_2 = "1433";
				String dbname_tDBOutput_2 = "ecommerv2";
				String url_tDBOutput_2 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBOutput_2)) {
					url_tDBOutput_2 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_2)) {
					url_tDBOutput_2 += "//" + "ecommerv2";

				}
				url_tDBOutput_2 += ";appName=" + projectName + ";" + "";
				dbUser_tDBOutput_2 = "ismaill";

				final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:kfmi9g8Q5/vT14Y7nXzoMzkJi45VS9rLS7tT8XJdOzM=");

				String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
				conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2,
						dbPwd_tDBOutput_2);

				resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);

				conn_tDBOutput_2.setAutoCommit(false);
				int commitEvery_tDBOutput_2 = 10000;
				int commitCounter_tDBOutput_2 = 0;

				int batchSize_tDBOutput_2 = 10000;
				int batchSizeCounter_tDBOutput_2 = 0;

				if (dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
					tableName_tDBOutput_2 = "factinventory";
				} else {
					tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "].[" + "factinventory";
				}
				int count_tDBOutput_2 = 0;

				boolean whetherExist_tDBOutput_2 = false;
				try (java.sql.Statement isExistStmt_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
					try {
						isExistStmt_tDBOutput_2.execute("SELECT TOP 1 1 FROM [" + tableName_tDBOutput_2 + "]");
						whetherExist_tDBOutput_2 = true;
					} catch (java.lang.Exception e) {
						globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
						whetherExist_tDBOutput_2 = false;
					}
				}
				if (!whetherExist_tDBOutput_2) {
					try (java.sql.Statement stmtCreate_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
						stmtCreate_tDBOutput_2.execute("CREATE TABLE [" + tableName_tDBOutput_2
								+ "]([StockReceived] REAL ,[StockSold] REAL ,[StockOnHand] REAL ,[id_supplier] INT  not null ,[id_date] INT  not null ,[id_product] INT  not null )");
					}
				}
				String insert_tDBOutput_2 = "INSERT INTO [" + tableName_tDBOutput_2
						+ "] ([StockReceived],[StockSold],[StockOnHand],[id_supplier],[id_date],[id_product]) VALUES (?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
				resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

				/**
				 * [tDBOutput_2 begin ] stop
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
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				factsallesStruct factsalles_tmp = new factsallesStruct();
				factinventoryStruct factinventory_tmp = new factinventoryStruct();
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
						.decryptPassword("enc:routine.encryption.key.v1:1Kdx0wjDZYEQS1XMuhaD92xfdRxR0TXZEhZdVDdgERs=");

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

				String dbquery_tDBInput_2 = "select * from transformed";

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
							row1.ProductName = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(1);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.ProductName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.ProductName = tmpContent_tDBInput_2;
								}
							} else {
								row1.ProductName = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row1.ProductCategory = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.ProductCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.ProductCategory = tmpContent_tDBInput_2;
								}
							} else {
								row1.ProductCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row1.ProductSubCategory = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.ProductSubCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.ProductSubCategory = tmpContent_tDBInput_2;
								}
							} else {
								row1.ProductSubCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 4) {
							row1.ProductPrice = null;
						} else {

							row1.ProductPrice = rs_tDBInput_2.getFloat(4);
							if (rs_tDBInput_2.wasNull()) {
								row1.ProductPrice = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 5) {
							row1.Date = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.Date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.Date = tmpContent_tDBInput_2;
								}
							} else {
								row1.Date = null;
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

							row1.QuantitySold = rs_tDBInput_2.getInt(16);
							if (rs_tDBInput_2.wasNull()) {
								row1.QuantitySold = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 17) {
							row1.TotalAmount = null;
						} else {

							row1.TotalAmount = rs_tDBInput_2.getFloat(17);
							if (rs_tDBInput_2.wasNull()) {
								row1.TotalAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 18) {
							row1.DiscountAmount = null;
						} else {

							row1.DiscountAmount = rs_tDBInput_2.getFloat(18);
							if (rs_tDBInput_2.wasNull()) {
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
						if (colQtyInRs_tDBInput_2 < 23) {
							row1.id_pro = 0;
						} else {

							row1.id_pro = rs_tDBInput_2.getInt(23);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 24) {
							row1.id_shipping = 0;
						} else {

							row1.id_shipping = rs_tDBInput_2.getInt(24);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 25) {
							row1.id_supplier = 0;
						} else {

							row1.id_supplier = rs_tDBInput_2.getInt(25);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 26) {
							row1.id_costumer = 0;
						} else {

							row1.id_costumer = rs_tDBInput_2.getInt(26);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 27) {
							row1.id_date = 0;
						} else {

							row1.id_date = rs_tDBInput_2.getInt(27);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
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

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							factsalles = null;
							factinventory = null;

// # Output table : 'factsalles'
							factsalles_tmp.QuantitySold = row1.QuantitySold;
							factsalles_tmp.TotalAmount = row1.TotalAmount;
							factsalles_tmp.DiscountAmount = row1.DiscountAmount;
							factsalles_tmp.NetAmount = row1.NetAmount;
							factsalles_tmp.id_pro = row1.id_pro;
							factsalles_tmp.id_shipping = row1.id_shipping;
							factsalles_tmp.id_costumer = row1.id_costumer;
							factsalles_tmp.id_date = row1.id_date;
							factsalles = factsalles_tmp;

// # Output table : 'factinventory'
							factinventory_tmp.StockReceived = row1.StockReceived;
							factinventory_tmp.StockSold = row1.StockSold;
							factinventory_tmp.StockOnHand = row1.StockOnHand;
							factinventory_tmp.id_supplier = row1.id_supplier;
							factinventory_tmp.id_date = row1.id_date;
							factinventory_tmp.id_pro = row1.id_pro;
							factinventory = factinventory_tmp;
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
// Start of branch "factsalles"
						if (factsalles != null) {

							/**
							 * [tDBOutput_1 main ] start
							 */

							currentComponent = "tDBOutput_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "factsalles"

								);
							}

							whetherReject_tDBOutput_1 = false;
							if (factsalles.QuantitySold == null) {
								pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_1.setInt(1, factsalles.QuantitySold);
							}

							if (factsalles.TotalAmount == null) {
								pstmt_tDBOutput_1.setNull(2, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_1.setFloat(2, factsalles.TotalAmount);
							}

							if (factsalles.DiscountAmount == null) {
								pstmt_tDBOutput_1.setNull(3, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_1.setFloat(3, factsalles.DiscountAmount);
							}

							if (factsalles.NetAmount == null) {
								pstmt_tDBOutput_1.setNull(4, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_1.setFloat(4, factsalles.NetAmount);
							}

							pstmt_tDBOutput_1.setInt(5, factsalles.id_pro);

							pstmt_tDBOutput_1.setInt(6, factsalles.id_shipping);

							pstmt_tDBOutput_1.setInt(7, factsalles.id_costumer);

							pstmt_tDBOutput_1.setInt(8, factsalles.id_date);

							pstmt_tDBOutput_1.addBatch();
							nb_line_tDBOutput_1++;

							batchSizeCounter_tDBOutput_1++;

							if (!whetherReject_tDBOutput_1) {
							}
							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_1 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_1)
										throws Exception {
									try {

										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
												break;
											}
											counter += countEach_tDBOutput_1;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_1 = 0;
										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_1)
										throws Exception {
									try {

										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
												break;
											}
											counter += countEach_tDBOutput_1;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_1 > 0)
									&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {

								insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
										.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);
								rowsToCommitCount_tDBOutput_1 = insertedCount_tDBOutput_1;

								batchSizeCounter_tDBOutput_1 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_1++;
							if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
								if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {

									insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
											.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);

									batchSizeCounter_tDBOutput_1 = 0;
								}
								if (rowsToCommitCount_tDBOutput_1 != 0) {

								}
								conn_tDBOutput_1.commit();
								if (rowsToCommitCount_tDBOutput_1 != 0) {

									rowsToCommitCount_tDBOutput_1 = 0;
								}
								commitCounter_tDBOutput_1 = 0;
							}

							tos_count_tDBOutput_1++;

							/**
							 * [tDBOutput_1 main ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_end ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_end ] stop
							 */

						} // End of branch "factsalles"

// Start of branch "factinventory"
						if (factinventory != null) {

							/**
							 * [tDBOutput_2 main ] start
							 */

							currentComponent = "tDBOutput_2";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "factinventory"

								);
							}

							whetherReject_tDBOutput_2 = false;
							if (factinventory.StockReceived == null) {
								pstmt_tDBOutput_2.setNull(1, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_2.setFloat(1, factinventory.StockReceived);
							}

							if (factinventory.StockSold == null) {
								pstmt_tDBOutput_2.setNull(2, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_2.setFloat(2, factinventory.StockSold);
							}

							if (factinventory.StockOnHand == null) {
								pstmt_tDBOutput_2.setNull(3, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_2.setFloat(3, factinventory.StockOnHand);
							}

							pstmt_tDBOutput_2.setInt(4, factinventory.id_supplier);

							pstmt_tDBOutput_2.setInt(5, factinventory.id_date);

							pstmt_tDBOutput_2.setInt(6, factinventory.id_pro);

							pstmt_tDBOutput_2.addBatch();
							nb_line_tDBOutput_2++;

							batchSizeCounter_tDBOutput_2++;

							if (!whetherReject_tDBOutput_2) {
							}
							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_2 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_2)
										throws Exception {
									try {

										for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
											if (countEach_tDBOutput_2 == -2 || countEach_tDBOutput_2 == -3) {
												break;
											}
											counter += countEach_tDBOutput_2;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_2 = 0;
										for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_2)
										throws Exception {
									try {

										for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
											if (countEach_tDBOutput_2 == -2 || countEach_tDBOutput_2 == -3) {
												break;
											}
											counter += countEach_tDBOutput_2;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_2 > 0)
									&& (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2)) {

								insertedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2()
										.limitBytePart1(insertedCount_tDBOutput_2, pstmt_tDBOutput_2);
								rowsToCommitCount_tDBOutput_2 = insertedCount_tDBOutput_2;

								batchSizeCounter_tDBOutput_2 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_2++;
							if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {
								if ((batchSize_tDBOutput_2 > 0) && (batchSizeCounter_tDBOutput_2 > 0)) {

									insertedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2()
											.limitBytePart1(insertedCount_tDBOutput_2, pstmt_tDBOutput_2);

									batchSizeCounter_tDBOutput_2 = 0;
								}
								if (rowsToCommitCount_tDBOutput_2 != 0) {

								}
								conn_tDBOutput_2.commit();
								if (rowsToCommitCount_tDBOutput_2 != 0) {

									rowsToCommitCount_tDBOutput_2 = 0;
								}
								commitCounter_tDBOutput_2 = 0;
							}

							tos_count_tDBOutput_2++;

							/**
							 * [tDBOutput_2 main ] stop
							 */

							/**
							 * [tDBOutput_2 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_2";

							/**
							 * [tDBOutput_2 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_2 process_data_end ] start
							 */

							currentComponent = "tDBOutput_2";

							/**
							 * [tDBOutput_2 process_data_end ] stop
							 */

						} // End of branch "factinventory"

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
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					int countSum_tDBOutput_1 = 0;
					if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {

						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							countSum_tDBOutput_1 += countEach_tDBOutput_1;
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					}

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");

				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (rowsToCommitCount_tDBOutput_1 != 0) {

				}
				conn_tDBOutput_1.commit();
				if (rowsToCommitCount_tDBOutput_1 != 0) {

					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;
				conn_tDBOutput_1.close();
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "factsalles");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tSleep_2Process(globalMap);

				/**
				 * [tDBOutput_1 end ] stop
				 */

				/**
				 * [tDBOutput_2 end ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					int countSum_tDBOutput_2 = 0;
					if (pstmt_tDBOutput_2 != null && batchSizeCounter_tDBOutput_2 > 0) {

						for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
							if (countEach_tDBOutput_2 == -2 || countEach_tDBOutput_2 == -3) {
								break;
							}
							countSum_tDBOutput_2 += countEach_tDBOutput_2;
						}
						rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

					}

					insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_2 = 0;
					for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

					insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_2 != null) {

					pstmt_tDBOutput_2.close();
					resourceMap.remove("pstmt_tDBOutput_2");

				}
				resourceMap.put("statementClosed_tDBOutput_2", true);
				if (rowsToCommitCount_tDBOutput_2 != 0) {

				}
				conn_tDBOutput_2.commit();
				if (rowsToCommitCount_tDBOutput_2 != 0) {

					rowsToCommitCount_tDBOutput_2 = 0;
				}
				commitCounter_tDBOutput_2 = 0;
				conn_tDBOutput_2.close();
				resourceMap.put("finish_tDBOutput_2", true);

				nb_line_deleted_tDBOutput_2 = nb_line_deleted_tDBOutput_2 + deletedCount_tDBOutput_2;
				nb_line_update_tDBOutput_2 = nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
				nb_line_inserted_tDBOutput_2 = nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
				nb_line_rejected_tDBOutput_2 = nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;

				globalMap.put("tDBOutput_2_NB_LINE", nb_line_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_UPDATED", nb_line_update_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_DELETED", nb_line_deleted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "factinventory");
				}

				ok_Hash.put("tDBOutput_2", true);
				end_Hash.put("tDBOutput_2", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tSleep_2Process(globalMap);

				/**
				 * [tDBOutput_2 end ] stop
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
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								ctn_tDBOutput_1.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

				/**
				 * [tDBOutput_2 finally ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
						if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_2")) != null) {
							pstmtToClose_tDBOutput_2.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_2") == null) {
						java.sql.Connection ctn_tDBOutput_2 = null;
						if ((ctn_tDBOutput_2 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_2")) != null) {
							try {
								ctn_tDBOutput_2.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_2) {
								String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :"
										+ sqlEx_tDBOutput_2.getMessage();
								System.err.println(errorMessage_tDBOutput_2);
							}
						}
					}
				}

				/**
				 * [tDBOutput_2 finally ] stop
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

	public void tSleep_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tSleep_2_SUBPROCESS_STATE", 0);

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
				 * [tSleep_2 begin ] start
				 */

				ok_Hash.put("tSleep_2", false);
				start_Hash.put("tSleep_2", System.currentTimeMillis());

				currentComponent = "tSleep_2";

				int tos_count_tSleep_2 = 0;

				/**
				 * [tSleep_2 begin ] stop
				 */

				/**
				 * [tSleep_2 main ] start
				 */

				currentComponent = "tSleep_2";

				Thread.sleep((6) * 1000);

				tos_count_tSleep_2++;

				/**
				 * [tSleep_2 main ] stop
				 */

				/**
				 * [tSleep_2 process_data_begin ] start
				 */

				currentComponent = "tSleep_2";

				/**
				 * [tSleep_2 process_data_begin ] stop
				 */

				/**
				 * [tSleep_2 process_data_end ] start
				 */

				currentComponent = "tSleep_2";

				/**
				 * [tSleep_2 process_data_end ] stop
				 */

				/**
				 * [tSleep_2 end ] start
				 */

				currentComponent = "tSleep_2";

				ok_Hash.put("tSleep_2", true);
				end_Hash.put("tSleep_2", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk5", 0, "ok");
				}
				tRunJob_1Process(globalMap);

				/**
				 * [tSleep_2 end ] stop
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
				 * [tSleep_2 finally ] start
				 */

				currentComponent = "tSleep_2";

				/**
				 * [tSleep_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tSleep_2_SUBPROCESS_STATE", 1);
	}

	public void tRunJob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 0);

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
				 * [tRunJob_1 begin ] start
				 */

				ok_Hash.put("tRunJob_1", false);
				start_Hash.put("tRunJob_1", System.currentTimeMillis());

				currentComponent = "tRunJob_1";

				int tos_count_tRunJob_1 = 0;

				/**
				 * [tRunJob_1 begin ] stop
				 */

				/**
				 * [tRunJob_1 main ] start
				 */

				currentComponent = "tRunJob_1";

				java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();

				paraList_tRunJob_1.add("--father_pid=" + pid);

				paraList_tRunJob_1.add("--root_pid=" + rootPid);

				paraList_tRunJob_1.add("--father_node=tRunJob_1");

				paraList_tRunJob_1.add("--context=Default");

				if (enableLogStash) {
					paraList_tRunJob_1.add("--audit.enabled=" + enableLogStash);
				}

				// for feature:10589

				paraList_tRunJob_1.add("--stat_port=" + portStats);

				if (resuming_logs_dir_path != null) {
					paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
				}
				String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
				String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
				if ("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null) {
					paraList_tRunJob_1.add("--resuming_checkpoint_path="
							+ ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
				}
				paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");

				java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

				Object obj_tRunJob_1 = null;

				ecommerce_brief.scd_0_1.scd childJob_tRunJob_1 = new ecommerce_brief.scd_0_1.scd();
				// pass DataSources
				java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_1 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
						.get(KEY_DB_DATASOURCES);
				if (null != talendDataSources_tRunJob_1) {
					java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_1 = new java.util.HashMap<String, javax.sql.DataSource>();
					for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_1 : talendDataSources_tRunJob_1
							.entrySet()) {
						dataSources_tRunJob_1.put(talendDataSourceEntry_tRunJob_1.getKey(),
								talendDataSourceEntry_tRunJob_1.getValue().getRawDataSource());
					}
					childJob_tRunJob_1.setDataSources(dataSources_tRunJob_1);
				}

				childJob_tRunJob_1.parentContextMap = parentContextMap_tRunJob_1;

				String[][] childReturn_tRunJob_1 = childJob_tRunJob_1
						.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));

				if (childJob_tRunJob_1.getErrorCode() == null) {
					globalMap.put("tRunJob_1_CHILD_RETURN_CODE",
							childJob_tRunJob_1.getStatus() != null && ("failure").equals(childJob_tRunJob_1.getStatus())
									? 1
									: 0);
				} else {
					globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getErrorCode());
				}
				if (childJob_tRunJob_1.getExceptionStackTrace() != null) {
					globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_1.getExceptionStackTrace());
				}

				tos_count_tRunJob_1++;

				/**
				 * [tRunJob_1 main ] stop
				 */

				/**
				 * [tRunJob_1 process_data_begin ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 process_data_begin ] stop
				 */

				/**
				 * [tRunJob_1 process_data_end ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 process_data_end ] stop
				 */

				/**
				 * [tRunJob_1 end ] start
				 */

				currentComponent = "tRunJob_1";

				ok_Hash.put("tRunJob_1", true);
				end_Hash.put("tRunJob_1", System.currentTimeMillis());

				/**
				 * [tRunJob_1 end ] stop
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
				 * [tRunJob_1 finally ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 1);
	}

	public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

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
				 * [tPrejob_1 begin ] start
				 */

				ok_Hash.put("tPrejob_1", false);
				start_Hash.put("tPrejob_1", System.currentTimeMillis());

				currentComponent = "tPrejob_1";

				int tos_count_tPrejob_1 = 0;

				/**
				 * [tPrejob_1 begin ] stop
				 */

				/**
				 * [tPrejob_1 main ] start
				 */

				currentComponent = "tPrejob_1";

				tos_count_tPrejob_1++;

				/**
				 * [tPrejob_1 main ] stop
				 */

				/**
				 * [tPrejob_1 process_data_begin ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_begin ] stop
				 */

				/**
				 * [tPrejob_1 process_data_end ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_end ] stop
				 */

				/**
				 * [tPrejob_1 end ] start
				 */

				currentComponent = "tPrejob_1";

				ok_Hash.put("tPrejob_1", true);
				end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBConnection_1Process(globalMap);

				/**
				 * [tPrejob_1 end ] stop
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
				 * [tPrejob_1 finally ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
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
		final facttables facttablesClass = new facttables();

		int exitCode = facttablesClass.runJobInTOS(args);

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
			java.io.InputStream inContext = facttables.class.getClassLoader()
					.getResourceAsStream("ecommerce_brief/facttables_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = facttables.class.getClassLoader()
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

		try {
			errorCode = null;
			tPrejob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPrejob_1) {
			globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

			e_tPrejob_1.printStackTrace();

		}

		this.globalResumeTicket = false;// to run others jobs

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : facttables");
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
 * 135598 characters generated by Talend Open Studio for Data Integration on the
 * 5 février 2025, 10:28:50 UTC+01:00
 ************************************************************************************************/