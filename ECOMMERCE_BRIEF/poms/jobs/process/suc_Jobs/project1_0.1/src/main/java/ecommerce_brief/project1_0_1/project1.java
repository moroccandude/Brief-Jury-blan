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

package ecommerce_brief.project1_0_1;

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
 * Job: project1 Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class project1 implements TalendJob {

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
	private final String jobName = "project1";
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

	LogCatcherUtils tLogCatcher_3 = new LogCatcherUtils();
	LogCatcherUtils tLogCatcher_4 = new LogCatcherUtils();
	LogCatcherUtils tLogCatcher_1 = new LogCatcherUtils();
	StatCatcherUtils tStatCatcher_1 = new StatCatcherUtils("_ix1QgN1JEe-nKYAnX6o4HA", "0.1");

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
					project1.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(project1.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						tLogCatcher_3.addMessage("Java Exception", currentComponent, 6,
								e.getClass().getName() + ":" + e.getMessage(), 1);
						tLogCatcher_4.addMessage("Java Exception", currentComponent, 6,
								e.getClass().getName() + ":" + e.getMessage(), 1);
						tLogCatcher_1.addMessage("Java Exception", currentComponent, 6,
								e.getClass().getName() + ":" + e.getMessage(), 1);
						tLogCatcher_3Process(globalMap);
						tLogCatcher_4Process(globalMap);
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

	public void tCreateTable_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		tCreateTable_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUniqRow_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBSCD_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tStatCatcher_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tStatCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tCreateTable_9_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tCreateTable_9_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUniqRow_8_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBSCD_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBClose_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBClose_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		try {

			if (this.execStat) {
				runStat.updateStatOnConnection("OnComponentError2", 0, "error");
			}

			errorCode = null;
			tLogCatcher_3Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		tDBConnection_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogCatcher_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUniqRow_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_11_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		try {

			if (this.execStat) {
				runStat.updateStatOnConnection("OnComponentError4", 0, "error");
			}

			errorCode = null;
			tLogCatcher_4Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogCatcher_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_8_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_12_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUniqRow_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUniqRow_6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_4_error(Exception exception, String errorComponent,
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

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogCatcher_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPostjob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tCreateTable_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "ERROR", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

		try {

			if (this.execStat) {
				runStat.updateStatOnConnection("OnSubjobError1", 0, "error");
			}

			errorCode = null;
			tStatCatcher_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tDBInput_4_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tStatCatcher_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tCreateTable_9_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBClose_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBConnection_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tLogCatcher_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tLogCatcher_4_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_8_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_5_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_4_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tLogCatcher_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPostjob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPrejob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tCreateTable_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tCreateTable_2_SUBPROCESS_STATE", 0);

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
				 * [tCreateTable_2 begin ] start
				 */

				ok_Hash.put("tCreateTable_2", false);
				start_Hash.put("tCreateTable_2", System.currentTimeMillis());

				currentComponent = "tCreateTable_2";

				int tos_count_tCreateTable_2 = 0;

				/**
				 * [tCreateTable_2 begin ] stop
				 */

				/**
				 * [tCreateTable_2 main ] start
				 */

				currentComponent = "tCreateTable_2";

				try {
					String driverClass_tCreateTable_2 = "net.sourceforge.jtds.jdbc.Driver";
					String url_tCreateTable_2 = "jdbc:jtds:sqlserver://" + "localhost" + ":" + "1433" + "//"
							+ "ecommerv2";
					String dbUser_tCreateTable_2 = "ismaill";

					String tableName_tCreateTable_2 = "Dimcustomer";
					String dbSchema_tCreateTable_2 = "dbo";
					if (dbSchema_tCreateTable_2 != null && dbSchema_tCreateTable_2.trim().length() != 0) {
						tableName_tCreateTable_2 = dbSchema_tCreateTable_2 + "].[" + tableName_tCreateTable_2;
					}
					java.lang.Class jdbcclazz_tCreateTable_2 = java.lang.Class
							.forName("net.sourceforge.jtds.jdbc.Driver");
					final String decryptedPassword_tCreateTable_2 = routines.system.PasswordEncryptUtil.decryptPassword(
							"enc:routine.encryption.key.v1:nKLco9oxDOwQayXG0F9CvJj0M4JZD32/SWod2hS6x6E=");
					java.sql.Connection conn_tCreateTable_2 = java.sql.DriverManager.getConnection(url_tCreateTable_2,
							dbUser_tCreateTable_2, decryptedPassword_tCreateTable_2);

					boolean whetherExist_tCreateTable_2 = false;
					java.sql.Statement rsTable_tCreateTable_2 = conn_tCreateTable_2.createStatement();
					try {
						rsTable_tCreateTable_2.execute("SELECT TOP 1 1 FROM [" + tableName_tCreateTable_2 + "]");
						whetherExist_tCreateTable_2 = true;
					} catch (Exception e) {
						whetherExist_tCreateTable_2 = false;
					}
					rsTable_tCreateTable_2.close();
					if (!whetherExist_tCreateTable_2) {
						java.sql.Statement stmt_tCreateTable_2 = conn_tCreateTable_2.createStatement();
						stmt_tCreateTable_2.execute("CREATE TABLE [" + tableName_tCreateTable_2
								+ "]([CustomerName] VARCHAR(250)  ,[CustomerEmail] VARCHAR(250)  ,[CustomerPhone] VARCHAR(250)  ,[CustomerSegment] VARCHAR(250)  ,[id] INT  not null ,[num_rue] VARCHAR(250)  ,[nom_rue] VARCHAR(250)  ,[type_logement] VARCHAR(250)  ,[num_logement] VARCHAR(250)  ,[code_militaire] VARCHAR(250)  ,[num_militaire] VARCHAR(250)  ,[ville] VARCHAR(250)  ,[region] VARCHAR(250)  ,[code_postal] VARCHAR(250)  ,[startDate] DATETIME  not null ,[endDate] DATETIME ,[active] BIT  not null ,primary key([id]))");

					}
					if (conn_tCreateTable_2 != null && !conn_tCreateTable_2.isClosed()) {
						conn_tCreateTable_2.close();
					}

					globalMap.put("tCreateTable_2_QUERY", "CREATE TABLE [" + tableName_tCreateTable_2
							+ "]([CustomerName] VARCHAR(250)  ,[CustomerEmail] VARCHAR(250)  ,[CustomerPhone] VARCHAR(250)  ,[CustomerSegment] VARCHAR(250)  ,[id] INT  not null ,[num_rue] VARCHAR(250)  ,[nom_rue] VARCHAR(250)  ,[type_logement] VARCHAR(250)  ,[num_logement] VARCHAR(250)  ,[code_militaire] VARCHAR(250)  ,[num_militaire] VARCHAR(250)  ,[ville] VARCHAR(250)  ,[region] VARCHAR(250)  ,[code_postal] VARCHAR(250)  ,[startDate] DATETIME  not null ,[endDate] DATETIME ,[active] BIT  not null ,primary key([id]))");
				} catch (java.lang.Exception e) {
					globalMap.put("tCreateTable_2_ERROR_MESSAGE", e.getMessage());
					throw new RuntimeException("Creating table failed", e);
				}

				tos_count_tCreateTable_2++;

				/**
				 * [tCreateTable_2 main ] stop
				 */

				/**
				 * [tCreateTable_2 process_data_begin ] start
				 */

				currentComponent = "tCreateTable_2";

				/**
				 * [tCreateTable_2 process_data_begin ] stop
				 */

				/**
				 * [tCreateTable_2 process_data_end ] start
				 */

				currentComponent = "tCreateTable_2";

				/**
				 * [tCreateTable_2 process_data_end ] stop
				 */

				/**
				 * [tCreateTable_2 end ] start
				 */

				currentComponent = "tCreateTable_2";

				ok_Hash.put("tCreateTable_2", true);
				end_Hash.put("tCreateTable_2", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk7", 0, "ok");
				}
				tDBInput_4Process(globalMap);

				/**
				 * [tCreateTable_2 end ] stop
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
				 * [tCreateTable_2 finally ] start
				 */

				currentComponent = "tCreateTable_2";

				/**
				 * [tCreateTable_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tCreateTable_2_SUBPROCESS_STATE", 1);
	}

	public static class row20Struct implements routines.system.IPersistableRow<row20Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

		public String CustomerName;

		public String getCustomerName() {
			return this.CustomerName;
		}

		public String CustomerEmail;

		public String getCustomerEmail() {
			return this.CustomerEmail;
		}

		public String CustomerPhone;

		public String getCustomerPhone() {
			return this.CustomerPhone;
		}

		public String CustomerSegment;

		public String getCustomerSegment() {
			return this.CustomerSegment;
		}

		public int id;

		public int getId() {
			return this.id;
		}

		public String num_rue;

		public String getNum_rue() {
			return this.num_rue;
		}

		public String nom_rue;

		public String getNom_rue() {
			return this.nom_rue;
		}

		public String type_logement;

		public String getType_logement() {
			return this.type_logement;
		}

		public String num_logement;

		public String getNum_logement() {
			return this.num_logement;
		}

		public String code_militaire;

		public String getCode_militaire() {
			return this.code_militaire;
		}

		public String num_militaire;

		public String getNum_militaire() {
			return this.num_militaire;
		}

		public String ville;

		public String getVille() {
			return this.ville;
		}

		public String state;

		public String getState() {
			return this.state;
		}

		public String code_postal;

		public String getCode_postal() {
			return this.code_postal;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerPhone = readString(dis);

					this.CustomerSegment = readString(dis);

					this.id = dis.readInt();

					this.num_rue = readString(dis);

					this.nom_rue = readString(dis);

					this.type_logement = readString(dis);

					this.num_logement = readString(dis);

					this.code_militaire = readString(dis);

					this.num_militaire = readString(dis);

					this.ville = readString(dis);

					this.state = readString(dis);

					this.code_postal = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerPhone = readString(dis);

					this.CustomerSegment = readString(dis);

					this.id = dis.readInt();

					this.num_rue = readString(dis);

					this.nom_rue = readString(dis);

					this.type_logement = readString(dis);

					this.num_logement = readString(dis);

					this.code_militaire = readString(dis);

					this.num_militaire = readString(dis);

					this.ville = readString(dis);

					this.state = readString(dis);

					this.code_postal = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerPhone, dos);

				// String

				writeString(this.CustomerSegment, dos);

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.num_rue, dos);

				// String

				writeString(this.nom_rue, dos);

				// String

				writeString(this.type_logement, dos);

				// String

				writeString(this.num_logement, dos);

				// String

				writeString(this.code_militaire, dos);

				// String

				writeString(this.num_militaire, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.state, dos);

				// String

				writeString(this.code_postal, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerPhone, dos);

				// String

				writeString(this.CustomerSegment, dos);

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.num_rue, dos);

				// String

				writeString(this.nom_rue, dos);

				// String

				writeString(this.type_logement, dos);

				// String

				writeString(this.num_logement, dos);

				// String

				writeString(this.code_militaire, dos);

				// String

				writeString(this.num_militaire, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.state, dos);

				// String

				writeString(this.code_postal, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CustomerName=" + CustomerName);
			sb.append(",CustomerEmail=" + CustomerEmail);
			sb.append(",CustomerPhone=" + CustomerPhone);
			sb.append(",CustomerSegment=" + CustomerSegment);
			sb.append(",id=" + String.valueOf(id));
			sb.append(",num_rue=" + num_rue);
			sb.append(",nom_rue=" + nom_rue);
			sb.append(",type_logement=" + type_logement);
			sb.append(",num_logement=" + num_logement);
			sb.append(",code_militaire=" + code_militaire);
			sb.append(",num_militaire=" + num_militaire);
			sb.append(",ville=" + ville);
			sb.append(",state=" + state);
			sb.append(",code_postal=" + code_postal);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row20Struct other) {

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

	public static class diimCustomerStruct implements routines.system.IPersistableRow<diimCustomerStruct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

		public String CustomerName;

		public String getCustomerName() {
			return this.CustomerName;
		}

		public String CustomerEmail;

		public String getCustomerEmail() {
			return this.CustomerEmail;
		}

		public String CustomerPhone;

		public String getCustomerPhone() {
			return this.CustomerPhone;
		}

		public String CustomerSegment;

		public String getCustomerSegment() {
			return this.CustomerSegment;
		}

		public int id;

		public int getId() {
			return this.id;
		}

		public String num_rue;

		public String getNum_rue() {
			return this.num_rue;
		}

		public String nom_rue;

		public String getNom_rue() {
			return this.nom_rue;
		}

		public String type_logement;

		public String getType_logement() {
			return this.type_logement;
		}

		public String num_logement;

		public String getNum_logement() {
			return this.num_logement;
		}

		public String code_militaire;

		public String getCode_militaire() {
			return this.code_militaire;
		}

		public String num_militaire;

		public String getNum_militaire() {
			return this.num_militaire;
		}

		public String ville;

		public String getVille() {
			return this.ville;
		}

		public String state;

		public String getState() {
			return this.state;
		}

		public String code_postal;

		public String getCode_postal() {
			return this.code_postal;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerPhone = readString(dis);

					this.CustomerSegment = readString(dis);

					this.id = dis.readInt();

					this.num_rue = readString(dis);

					this.nom_rue = readString(dis);

					this.type_logement = readString(dis);

					this.num_logement = readString(dis);

					this.code_militaire = readString(dis);

					this.num_militaire = readString(dis);

					this.ville = readString(dis);

					this.state = readString(dis);

					this.code_postal = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerPhone = readString(dis);

					this.CustomerSegment = readString(dis);

					this.id = dis.readInt();

					this.num_rue = readString(dis);

					this.nom_rue = readString(dis);

					this.type_logement = readString(dis);

					this.num_logement = readString(dis);

					this.code_militaire = readString(dis);

					this.num_militaire = readString(dis);

					this.ville = readString(dis);

					this.state = readString(dis);

					this.code_postal = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerPhone, dos);

				// String

				writeString(this.CustomerSegment, dos);

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.num_rue, dos);

				// String

				writeString(this.nom_rue, dos);

				// String

				writeString(this.type_logement, dos);

				// String

				writeString(this.num_logement, dos);

				// String

				writeString(this.code_militaire, dos);

				// String

				writeString(this.num_militaire, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.state, dos);

				// String

				writeString(this.code_postal, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerPhone, dos);

				// String

				writeString(this.CustomerSegment, dos);

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.num_rue, dos);

				// String

				writeString(this.nom_rue, dos);

				// String

				writeString(this.type_logement, dos);

				// String

				writeString(this.num_logement, dos);

				// String

				writeString(this.code_militaire, dos);

				// String

				writeString(this.num_militaire, dos);

				// String

				writeString(this.ville, dos);

				// String

				writeString(this.state, dos);

				// String

				writeString(this.code_postal, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CustomerName=" + CustomerName);
			sb.append(",CustomerEmail=" + CustomerEmail);
			sb.append(",CustomerPhone=" + CustomerPhone);
			sb.append(",CustomerSegment=" + CustomerSegment);
			sb.append(",id=" + String.valueOf(id));
			sb.append(",num_rue=" + num_rue);
			sb.append(",nom_rue=" + nom_rue);
			sb.append(",type_logement=" + type_logement);
			sb.append(",num_logement=" + num_logement);
			sb.append(",code_militaire=" + code_militaire);
			sb.append(",num_militaire=" + num_militaire);
			sb.append(",ville=" + ville);
			sb.append(",state=" + state);
			sb.append(",code_postal=" + code_postal);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(diimCustomerStruct other) {

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

	public static class row18Struct implements routines.system.IPersistableRow<row18Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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
		public int compareTo(row18Struct other) {

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

	public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

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

				row18Struct row18 = new row18Struct();
				diimCustomerStruct diimCustomer = new diimCustomerStruct();
				row20Struct row20 = new row20Struct();

				/**
				 * [tDBSCD_5 begin ] start
				 */

				ok_Hash.put("tDBSCD_5", false);
				start_Hash.put("tDBSCD_5", System.currentTimeMillis());

				currentComponent = "tDBSCD_5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row20");
				}

				int tos_count_tDBSCD_5 = 0;

				class SCDSK_tDBSCD_5 {
					private int hashCode;
					public boolean hashCodeDirty = true;
					int id;

					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final SCDSK_tDBSCD_5 other = (SCDSK_tDBSCD_5) obj;
						if (this.id != other.id)
							return false;

						return true;
					}

					public int hashCode() {
						if (hashCodeDirty) {
							int prime = 31;
							hashCode = prime * hashCode + id;
							hashCodeDirty = false;
						}
						return hashCode;
					}
				}

				class SCDStruct_tDBSCD_5 {
					private String code_militaire;
					private String CustomerName;
					private String nom_rue;
					private String num_militaire;
					private String region;
					private String ville;
					private String type_logement;
					private String num_logement;
					private String code_postal;
					private String CustomerPhone;
					private String CustomerSegment;
					private String num_rue;
					private String CustomerEmail;
				}

				int nb_line_update_tDBSCD_5 = 0;
				int nb_line_inserted_tDBSCD_5 = 0;
				int nb_line_rejected_tDBSCD_5 = 0;
				String tableName_tDBSCD_5 = null;
				String dbschema_tDBSCD_5 = null;
				java.sql.Connection conn_tDBSCD_5 = null;
				String dbUser_tDBSCD_5 = null;
				dbschema_tDBSCD_5 = "dbo";
				String driverClass_tDBSCD_5 = "net.sourceforge.jtds.jdbc.Driver";

				java.lang.Class.forName(driverClass_tDBSCD_5);
				String port_tDBSCD_5 = "1433";
				String dbname_tDBSCD_5 = "ecommerv2";
				String url_tDBSCD_5 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBSCD_5)) {
					url_tDBSCD_5 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBSCD_5)) {
					url_tDBSCD_5 += "//" + "ecommerv2";

				}
				url_tDBSCD_5 += ";appName=" + projectName + ";" + "";
				dbUser_tDBSCD_5 = "ismaill";

				final String decryptedPassword_tDBSCD_5 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:AYvqYvVVb4sNdEakwI5W3DTtrQO9MKuZea3O0x56zx4=");

				String dbPwd_tDBSCD_5 = decryptedPassword_tDBSCD_5;
				conn_tDBSCD_5 = java.sql.DriverManager.getConnection(url_tDBSCD_5, dbUser_tDBSCD_5, dbPwd_tDBSCD_5);

				if (dbschema_tDBSCD_5 == null || dbschema_tDBSCD_5.trim().length() == 0) {
					tableName_tDBSCD_5 = "Dimcustomer";
				} else {
					tableName_tDBSCD_5 = dbschema_tDBSCD_5 + "].[" + "Dimcustomer";
				}
				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBSCD_5 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();
				String tmpValue_tDBSCD_5 = null;
				String search_tDBSCD_5 = "SELECT [id], [code_militaire], [CustomerName], [nom_rue], [num_militaire], [region], [ville], [type_logement], [num_logement], [code_postal], [CustomerPhone], [CustomerSegment], [num_rue], [CustomerEmail] FROM ["
						+ tableName_tDBSCD_5 + "] WHERE [endDate] IS NULL";
				java.sql.Statement statement_tDBSCD_5 = conn_tDBSCD_5.createStatement();
				java.sql.ResultSet resultSet_tDBSCD_5 = statement_tDBSCD_5.executeQuery(search_tDBSCD_5);
				java.util.Map<SCDSK_tDBSCD_5, SCDStruct_tDBSCD_5> cache_tDBSCD_5 = new java.util.HashMap<SCDSK_tDBSCD_5, SCDStruct_tDBSCD_5>();
				while (resultSet_tDBSCD_5.next()) {
					SCDSK_tDBSCD_5 sk_tDBSCD_5 = new SCDSK_tDBSCD_5();
					SCDStruct_tDBSCD_5 row_tDBSCD_5 = new SCDStruct_tDBSCD_5();
					if (resultSet_tDBSCD_5.getObject(1) != null) {
						sk_tDBSCD_5.id = resultSet_tDBSCD_5.getInt(1);
					}
					if (resultSet_tDBSCD_5.getObject(2) != null) {
						row_tDBSCD_5.code_militaire = resultSet_tDBSCD_5.getString(2);
					}
					if (resultSet_tDBSCD_5.getObject(3) != null) {
						row_tDBSCD_5.CustomerName = resultSet_tDBSCD_5.getString(3);
					}
					if (resultSet_tDBSCD_5.getObject(4) != null) {
						row_tDBSCD_5.nom_rue = resultSet_tDBSCD_5.getString(4);
					}
					if (resultSet_tDBSCD_5.getObject(5) != null) {
						row_tDBSCD_5.num_militaire = resultSet_tDBSCD_5.getString(5);
					}
					if (resultSet_tDBSCD_5.getObject(6) != null) {
						row_tDBSCD_5.region = resultSet_tDBSCD_5.getString(6);
					}
					if (resultSet_tDBSCD_5.getObject(7) != null) {
						row_tDBSCD_5.ville = resultSet_tDBSCD_5.getString(7);
					}
					if (resultSet_tDBSCD_5.getObject(8) != null) {
						row_tDBSCD_5.type_logement = resultSet_tDBSCD_5.getString(8);
					}
					if (resultSet_tDBSCD_5.getObject(9) != null) {
						row_tDBSCD_5.num_logement = resultSet_tDBSCD_5.getString(9);
					}
					if (resultSet_tDBSCD_5.getObject(10) != null) {
						row_tDBSCD_5.code_postal = resultSet_tDBSCD_5.getString(10);
					}
					if (resultSet_tDBSCD_5.getObject(11) != null) {
						row_tDBSCD_5.CustomerPhone = resultSet_tDBSCD_5.getString(11);
					}
					if (resultSet_tDBSCD_5.getObject(12) != null) {
						row_tDBSCD_5.CustomerSegment = resultSet_tDBSCD_5.getString(12);
					}
					if (resultSet_tDBSCD_5.getObject(13) != null) {
						row_tDBSCD_5.num_rue = resultSet_tDBSCD_5.getString(13);
					}
					if (resultSet_tDBSCD_5.getObject(14) != null) {
						row_tDBSCD_5.CustomerEmail = resultSet_tDBSCD_5.getString(14);
					}
					cache_tDBSCD_5.put(sk_tDBSCD_5, row_tDBSCD_5);
				}
				resultSet_tDBSCD_5.close();
				statement_tDBSCD_5.close();
				String insertionSQL_tDBSCD_5 = "INSERT INTO [" + tableName_tDBSCD_5
						+ "]([id], [code_militaire], [CustomerName], [nom_rue], [num_militaire], [region], [ville], [type_logement], [num_logement], [code_postal], [CustomerPhone], [CustomerSegment], [num_rue], [CustomerEmail], [active], [startDate], [endDate]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?, ?)";
				java.sql.PreparedStatement insertionStatement_tDBSCD_5 = conn_tDBSCD_5
						.prepareStatement(insertionSQL_tDBSCD_5);
				insertionStatement_tDBSCD_5.setTimestamp(15, new java.sql.Timestamp(start_Hash.get("tDBSCD_5")));
				insertionStatement_tDBSCD_5.setNull(16, java.sql.Types.DATE);
				String updateSQLForType1_tDBSCD_5 = "UPDATE [" + tableName_tDBSCD_5
						+ "] SET [code_militaire] = ?, [CustomerName] = ?, [nom_rue] = ?, [num_militaire] = ?, [region] = ?, [ville] = ?, [type_logement] = ?, [num_logement] = ?, [code_postal] = ?, [CustomerPhone] = ?, [CustomerSegment] = ?, [num_rue] = ? WHERE [id] = ?";
				java.sql.PreparedStatement updateForType1_tDBSCD_5 = conn_tDBSCD_5
						.prepareStatement(updateSQLForType1_tDBSCD_5);
				String updateSQLForType2_tDBSCD_5 = "UPDATE [" + tableName_tDBSCD_5
						+ "] SET [endDate] = ?, [active] = 0 WHERE [id] = ? AND [endDate] IS NULL";
				java.sql.PreparedStatement updateForType2_tDBSCD_5 = conn_tDBSCD_5
						.prepareStatement(updateSQLForType2_tDBSCD_5);
				updateForType2_tDBSCD_5.setTimestamp(1, new java.sql.Timestamp(start_Hash.get("tDBSCD_5")));

				SCDSK_tDBSCD_5 lookUpKey_tDBSCD_5 = null;
				SCDStruct_tDBSCD_5 lookUpValue_tDBSCD_5 = null;

				/**
				 * [tDBSCD_5 begin ] stop
				 */

				/**
				 * [tUniqRow_5 begin ] start
				 */

				ok_Hash.put("tUniqRow_5", false);
				start_Hash.put("tUniqRow_5", System.currentTimeMillis());

				currentComponent = "tUniqRow_5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "diimCustomer");
				}

				int tos_count_tUniqRow_5 = 0;

				class KeyStruct_tUniqRow_5 {

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					int id;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + (int) this.id;

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final KeyStruct_tUniqRow_5 other = (KeyStruct_tUniqRow_5) obj;

						if (this.id != other.id)
							return false;

						return true;
					}

				}

				int nb_uniques_tUniqRow_5 = 0;
				int nb_duplicates_tUniqRow_5 = 0;
				KeyStruct_tUniqRow_5 finder_tUniqRow_5 = new KeyStruct_tUniqRow_5();
				java.util.Set<KeyStruct_tUniqRow_5> keystUniqRow_5 = new java.util.HashSet<KeyStruct_tUniqRow_5>();

				/**
				 * [tUniqRow_5 begin ] stop
				 */

				/**
				 * [tMap_8 begin ] start
				 */

				ok_Hash.put("tMap_8", false);
				start_Hash.put("tMap_8", System.currentTimeMillis());

				currentComponent = "tMap_8";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row18");
				}

				int tos_count_tMap_8 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_8__Struct {
					int id;
					String num_rue;
					String nom_rue;
					String type_logement;
					String num_logement;
					String code_militaire;
					String num_militaire;
					String ville;
					String state;
					String code_postal;
				}
				Var__tMap_8__Struct Var__tMap_8 = new Var__tMap_8__Struct();
// ###############################

// ###############################
// # Outputs initialization
				diimCustomerStruct diimCustomer_tmp = new diimCustomerStruct();
// ###############################

				/**
				 * [tMap_8 begin ] stop
				 */

				/**
				 * [tDBInput_4 begin ] start
				 */

				ok_Hash.put("tDBInput_4", false);
				start_Hash.put("tDBInput_4", System.currentTimeMillis());

				currentComponent = "tDBInput_4";

				int tos_count_tDBInput_4 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_4 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_4 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_4 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_4, talendToDBArray_tDBInput_4);
				int nb_line_tDBInput_4 = 0;
				java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = "ismaill";

				final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:azlyBvl+AZtFp2NC218B4rddoPfKRK3tcg3PHdbZo9Q=");

				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;

				String port_tDBInput_4 = "1433";
				String dbname_tDBInput_4 = "ecommerv2";
				String url_tDBInput_4 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBInput_4)) {
					url_tDBInput_4 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_4)) {
					url_tDBInput_4 += "//" + "ecommerv2";
				}
				url_tDBInput_4 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_4 = "dbo";

				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4, dbUser_tDBInput_4,
						dbPwd_tDBInput_4);

				java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

				String dbquery_tDBInput_4 = "SELECT *\nFROM	dbo.transformed";

				globalMap.put("tDBInput_4_QUERY", dbquery_tDBInput_4);
				java.sql.ResultSet rs_tDBInput_4 = null;

				try {
					rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
					java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
					int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

					String tmpContent_tDBInput_4 = null;

					while (rs_tDBInput_4.next()) {
						nb_line_tDBInput_4++;

						if (colQtyInRs_tDBInput_4 < 1) {
							row18.ProductName = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(1);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.ProductName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.ProductName = tmpContent_tDBInput_4;
								}
							} else {
								row18.ProductName = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 2) {
							row18.ProductCategory = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(2);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.ProductCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.ProductCategory = tmpContent_tDBInput_4;
								}
							} else {
								row18.ProductCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 3) {
							row18.ProductSubCategory = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(3);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.ProductSubCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.ProductSubCategory = tmpContent_tDBInput_4;
								}
							} else {
								row18.ProductSubCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 4) {
							row18.ProductPrice = null;
						} else {

							row18.ProductPrice = rs_tDBInput_4.getFloat(4);
							if (rs_tDBInput_4.wasNull()) {
								row18.ProductPrice = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 5) {
							row18.Date = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(5);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.Date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.Date = tmpContent_tDBInput_4;
								}
							} else {
								row18.Date = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 6) {
							row18.CustomerName = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(6);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.CustomerName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.CustomerName = tmpContent_tDBInput_4;
								}
							} else {
								row18.CustomerName = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 7) {
							row18.CustomerEmail = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(7);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.CustomerEmail = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.CustomerEmail = tmpContent_tDBInput_4;
								}
							} else {
								row18.CustomerEmail = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 8) {
							row18.CustomerAddress = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(8);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.CustomerAddress = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.CustomerAddress = tmpContent_tDBInput_4;
								}
							} else {
								row18.CustomerAddress = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 9) {
							row18.CustomerPhone = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(9);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.CustomerPhone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.CustomerPhone = tmpContent_tDBInput_4;
								}
							} else {
								row18.CustomerPhone = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 10) {
							row18.CustomerSegment = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(10);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.CustomerSegment = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.CustomerSegment = tmpContent_tDBInput_4;
								}
							} else {
								row18.CustomerSegment = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 11) {
							row18.SupplierName = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(11);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.SupplierName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.SupplierName = tmpContent_tDBInput_4;
								}
							} else {
								row18.SupplierName = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 12) {
							row18.SupplierLocation = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(12);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.SupplierLocation = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.SupplierLocation = tmpContent_tDBInput_4;
								}
							} else {
								row18.SupplierLocation = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 13) {
							row18.SupplierContact = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(13);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.SupplierContact = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.SupplierContact = tmpContent_tDBInput_4;
								}
							} else {
								row18.SupplierContact = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 14) {
							row18.ShipperName = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(14);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.ShipperName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.ShipperName = tmpContent_tDBInput_4;
								}
							} else {
								row18.ShipperName = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 15) {
							row18.ShippingMethod = null;
						} else {

							tmpContent_tDBInput_4 = rs_tDBInput_4.getString(15);
							if (tmpContent_tDBInput_4 != null) {
								if (talendToDBList_tDBInput_4.contains(
										rsmd_tDBInput_4.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
									row18.ShippingMethod = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
								} else {
									row18.ShippingMethod = tmpContent_tDBInput_4;
								}
							} else {
								row18.ShippingMethod = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 16) {
							row18.QuantitySold = null;
						} else {

							row18.QuantitySold = rs_tDBInput_4.getInt(16);
							if (rs_tDBInput_4.wasNull()) {
								row18.QuantitySold = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 17) {
							row18.TotalAmount = null;
						} else {

							row18.TotalAmount = rs_tDBInput_4.getFloat(17);
							if (rs_tDBInput_4.wasNull()) {
								row18.TotalAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 18) {
							row18.DiscountAmount = null;
						} else {

							row18.DiscountAmount = rs_tDBInput_4.getFloat(18);
							if (rs_tDBInput_4.wasNull()) {
								row18.DiscountAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 19) {
							row18.NetAmount = null;
						} else {

							row18.NetAmount = rs_tDBInput_4.getFloat(19);
							if (rs_tDBInput_4.wasNull()) {
								row18.NetAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 20) {
							row18.StockReceived = null;
						} else {

							row18.StockReceived = rs_tDBInput_4.getFloat(20);
							if (rs_tDBInput_4.wasNull()) {
								row18.StockReceived = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 21) {
							row18.StockSold = null;
						} else {

							row18.StockSold = rs_tDBInput_4.getFloat(21);
							if (rs_tDBInput_4.wasNull()) {
								row18.StockSold = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 22) {
							row18.StockOnHand = null;
						} else {

							row18.StockOnHand = rs_tDBInput_4.getFloat(22);
							if (rs_tDBInput_4.wasNull()) {
								row18.StockOnHand = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 23) {
							row18.id_pro = 0;
						} else {

							row18.id_pro = rs_tDBInput_4.getInt(23);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 24) {
							row18.id_shipping = 0;
						} else {

							row18.id_shipping = rs_tDBInput_4.getInt(24);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 25) {
							row18.id_supplier = 0;
						} else {

							row18.id_supplier = rs_tDBInput_4.getInt(25);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 26) {
							row18.id_costumer = 0;
						} else {

							row18.id_costumer = rs_tDBInput_4.getInt(26);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 27) {
							row18.id_date = 0;
						} else {

							row18.id_date = rs_tDBInput_4.getInt(27);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						/**
						 * [tDBInput_4 begin ] stop
						 */

						/**
						 * [tDBInput_4 main ] start
						 */

						currentComponent = "tDBInput_4";

						tos_count_tDBInput_4++;

						/**
						 * [tDBInput_4 main ] stop
						 */

						/**
						 * [tDBInput_4 process_data_begin ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_begin ] stop
						 */

						/**
						 * [tMap_8 main ] start
						 */

						currentComponent = "tMap_8";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row18"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_8 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_8 = false;
						boolean mainRowRejected_tMap_8 = false;

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_8__Struct Var = Var__tMap_8;
							Var.id = Math.abs(
									(row18.CustomerName + row18.CustomerEmail + row18.CustomerAddress).hashCode() % 1000
											+ 1);
							Var.num_rue = // Extraire les chiffres au début de l'adresse (ex: "5881" dans "5881 Shawn
											// Fords...")
									(row18.CustomerAddress.split("\\s*,\\s*").length > 0
											&& row18.CustomerAddress.split("\\s*,\\s*")[0].trim().matches("^\\d+.*"))
													? row18.CustomerAddress.split("\\s*,\\s*")[0].trim()
															.replaceAll("^(\\d+).*", "$1")
													: "";
							Var.nom_rue = // Enlever le numéro et les infos de logement (Apt, Suite, etc.)
									(row18.CustomerAddress.split("\\s*,\\s*").length > 0)
											? row18.CustomerAddress.split("\\s*,\\s*")[0].trim()
													.replaceAll("^\\d+\\s*", "") // Supprimer le numéro
													.replaceAll("\\s*(Apt|Suite|Unit|PSC|Box)\\s.*", "") // Supprimer le
																											// type de
																											// logement
											: "";
							Var.type_logement = // Détecter Apt/Suite/Unit dans AddressLine1
									(row18.CustomerAddress.split("\\s*,\\s*").length > 0
											&& row18.CustomerAddress.split("\\s*,\\s*")[0].trim()
													.matches(".*\\b(Apt|Suite|Unit|PSC|Box)\\b.*"))
															? row18.CustomerAddress.split("\\s*,\\s*")[0].trim()
																	.replaceAll(".*\\b(Apt|Suite|Unit|PSC|Box)\\b.*",
																			"$1")
															: "";
							Var.num_logement = // Extraire le numéro après Apt/Suite/Unit
									(row18.CustomerAddress.split("\\s*,\\s*").length > 0 && row18.CustomerAddress.split(
											"\\s*,\\s*")[0].trim().matches(".*\\b(Apt|Suite|Unit|PSC|Box)\\b.*\\d+.*"))
													? row18.CustomerAddress.split("\\s*,\\s*")[0].trim().replaceAll(
															".*\\b(Apt|Suite|Unit|PSC|Box)\\b\\D*(\\d+).*", "$2")
													: "";
							Var.code_militaire = // Extraire le code militaire (ex: "Box" dans "Box 7906")
									(row18.CustomerAddress.split("\\s*,\\s*").length > 1
											&& row18.CustomerAddress.split("\\s*,\\s*")[1].trim()
													.matches("^(PSC|Box|Unit).*"))
															? row18.CustomerAddress.split("\\s*,\\s*")[1].trim()
																	.split("\\s+")[0]
															: "";
							Var.num_militaire = // Extraire le numéro associé au code militaire
									(row18.CustomerAddress.split("\\s*,\\s*").length > 1
											&& row18.CustomerAddress.split("\\s*,\\s*")[1].trim()
													.matches("^(PSC|Box|Unit).*"))
															? row18.CustomerAddress.split("\\s*,\\s*")[1].trim()
																	.split("\\s+")[1]
															: "";
							Var.ville = // Ville pour adresses militaires ou standard
									(row18.CustomerAddress.split("\\s*,\\s*").length > 0
											&& row18.CustomerAddress.split(
													"\\s*,\\s*")[row18.CustomerAddress.split("\\s*,\\s*").length - 1]
															.split("\\s+").length >= 3
											&& row18.CustomerAddress.split("\\s*,\\s*")[row18.CustomerAddress
													.split("\\s*,\\s*").length
													- 1].split("\\s+")[0].matches("(?i)APO|FPO|DPO"))
															? row18.CustomerAddress
																	.split("\\s*,\\s*")[row18.CustomerAddress
																			.split("\\s*,\\s*").length - 1]
																					.split("\\s+")[0]
															: ((row18.CustomerAddress.split("\\s*,\\s*").length >= 2)
																	? row18.CustomerAddress
																			.split("\\s*,\\s*")[row18.CustomerAddress
																					.split("\\s*,\\s*").length - 2]
																							.trim()
																	: "");
							Var.state = // Code d'état (2 lettres)
									(row18.CustomerAddress.split("\\s*,\\s*").length > 0
											&& row18.CustomerAddress.split(
													"\\s*,\\s*")[row18.CustomerAddress.split("\\s*,\\s*").length - 1]
															.split("\\s+").length >= 3
											&& row18.CustomerAddress.split("\\s*,\\s*")[row18.CustomerAddress
													.split("\\s*,\\s*").length
													- 1].split("\\s+")[0].matches("(?i)APO|FPO|DPO"))
															? row18.CustomerAddress
																	.split("\\s*,\\s*")[row18.CustomerAddress
																			.split("\\s*,\\s*").length - 1]
																					.split("\\s+")[1]
															: ((row18.CustomerAddress.split("\\s*,\\s*").length > 0)
																	? row18.CustomerAddress
																			.split("\\s*,\\s*")[row18.CustomerAddress
																					.split("\\s*,\\s*").length - 1]
																							.split("\\s+")[0]
																	: "");
							Var.code_postal = // Code postal (5 chiffres)
									(row18.CustomerAddress.split("\\s*,\\s*").length > 0
											&& row18.CustomerAddress.split(
													"\\s*,\\s*")[row18.CustomerAddress.split("\\s*,\\s*").length - 1]
															.split("\\s+").length >= 3
											&& row18.CustomerAddress.split("\\s*,\\s*")[row18.CustomerAddress
													.split("\\s*,\\s*").length
													- 1].split("\\s+")[0].matches("(?i)APO|FPO|DPO"))
															? row18.CustomerAddress
																	.split("\\s*,\\s*")[row18.CustomerAddress
																			.split("\\s*,\\s*").length - 1]
																					.split("\\s+")[2]
															: ((row18.CustomerAddress.split("\\s*,\\s*").length > 0)
																	? row18.CustomerAddress
																			.split("\\s*,\\s*")[row18.CustomerAddress
																					.split("\\s*,\\s*").length - 1]
																							.split("\\s+")[1]
																	: "");// ###############################
							// ###############################
							// # Output tables

							diimCustomer = null;

// # Output table : 'diimCustomer'
							diimCustomer_tmp.CustomerName = row18.CustomerName;
							diimCustomer_tmp.CustomerEmail = row18.CustomerEmail;
							diimCustomer_tmp.CustomerPhone = row18.CustomerPhone;
							diimCustomer_tmp.CustomerSegment = row18.CustomerSegment;
							diimCustomer_tmp.id = row18.id_costumer;
							diimCustomer_tmp.num_rue = Var.num_rue;
							diimCustomer_tmp.nom_rue = Var.nom_rue;
							diimCustomer_tmp.type_logement = Var.type_logement;
							diimCustomer_tmp.num_logement = Var.num_logement;
							diimCustomer_tmp.code_militaire = Var.code_militaire;
							diimCustomer_tmp.num_militaire = Var.num_militaire;
							diimCustomer_tmp.ville = Var.ville;
							diimCustomer_tmp.state = Var.state;
							diimCustomer_tmp.code_postal = Var.code_postal;
							diimCustomer = diimCustomer_tmp;
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_8 = false;

						tos_count_tMap_8++;

						/**
						 * [tMap_8 main ] stop
						 */

						/**
						 * [tMap_8 process_data_begin ] start
						 */

						currentComponent = "tMap_8";

						/**
						 * [tMap_8 process_data_begin ] stop
						 */
// Start of branch "diimCustomer"
						if (diimCustomer != null) {

							/**
							 * [tUniqRow_5 main ] start
							 */

							currentComponent = "tUniqRow_5";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "diimCustomer"

								);
							}

							row20 = null;
							finder_tUniqRow_5.id = diimCustomer.id;
							finder_tUniqRow_5.hashCodeDirty = true;
							if (!keystUniqRow_5.contains(finder_tUniqRow_5)) {
								KeyStruct_tUniqRow_5 new_tUniqRow_5 = new KeyStruct_tUniqRow_5();

								new_tUniqRow_5.id = diimCustomer.id;

								keystUniqRow_5.add(new_tUniqRow_5);
								if (row20 == null) {

									row20 = new row20Struct();
								}
								row20.CustomerName = diimCustomer.CustomerName;
								row20.CustomerEmail = diimCustomer.CustomerEmail;
								row20.CustomerPhone = diimCustomer.CustomerPhone;
								row20.CustomerSegment = diimCustomer.CustomerSegment;
								row20.id = diimCustomer.id;
								row20.num_rue = diimCustomer.num_rue;
								row20.nom_rue = diimCustomer.nom_rue;
								row20.type_logement = diimCustomer.type_logement;
								row20.num_logement = diimCustomer.num_logement;
								row20.code_militaire = diimCustomer.code_militaire;
								row20.num_militaire = diimCustomer.num_militaire;
								row20.ville = diimCustomer.ville;
								row20.state = diimCustomer.state;
								row20.code_postal = diimCustomer.code_postal;
								nb_uniques_tUniqRow_5++;
							} else {
								nb_duplicates_tUniqRow_5++;
							}

							tos_count_tUniqRow_5++;

							/**
							 * [tUniqRow_5 main ] stop
							 */

							/**
							 * [tUniqRow_5 process_data_begin ] start
							 */

							currentComponent = "tUniqRow_5";

							/**
							 * [tUniqRow_5 process_data_begin ] stop
							 */
// Start of branch "row20"
							if (row20 != null) {

								/**
								 * [tDBSCD_5 main ] start
								 */

								currentComponent = "tDBSCD_5";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row20"

									);
								}

								try {
									lookUpKey_tDBSCD_5 = new SCDSK_tDBSCD_5();
									lookUpKey_tDBSCD_5.id = row20.id;
									lookUpKey_tDBSCD_5.hashCodeDirty = true;
									lookUpValue_tDBSCD_5 = cache_tDBSCD_5.get(lookUpKey_tDBSCD_5);
									if (lookUpValue_tDBSCD_5 == null) {
										lookUpValue_tDBSCD_5 = new SCDStruct_tDBSCD_5();

										insertionStatement_tDBSCD_5.setInt(1, row20.id);

										if (row20.code_militaire == null) {
											insertionStatement_tDBSCD_5.setNull(2, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(2, row20.code_militaire);
										}

										if (row20.CustomerName == null) {
											insertionStatement_tDBSCD_5.setNull(3, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(3, row20.CustomerName);
										}

										if (row20.nom_rue == null) {
											insertionStatement_tDBSCD_5.setNull(4, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(4, row20.nom_rue);
										}

										if (row20.num_militaire == null) {
											insertionStatement_tDBSCD_5.setNull(5, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(5, row20.num_militaire);
										}

										if (row20.state == null) {
											insertionStatement_tDBSCD_5.setNull(6, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(6, row20.state);
										}

										if (row20.ville == null) {
											insertionStatement_tDBSCD_5.setNull(7, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(7, row20.ville);
										}

										if (row20.type_logement == null) {
											insertionStatement_tDBSCD_5.setNull(8, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(8, row20.type_logement);
										}

										if (row20.num_logement == null) {
											insertionStatement_tDBSCD_5.setNull(9, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(9, row20.num_logement);
										}

										if (row20.code_postal == null) {
											insertionStatement_tDBSCD_5.setNull(10, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(10, row20.code_postal);
										}

										if (row20.CustomerPhone == null) {
											insertionStatement_tDBSCD_5.setNull(11, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(11, row20.CustomerPhone);
										}

										if (row20.CustomerSegment == null) {
											insertionStatement_tDBSCD_5.setNull(12, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(12, row20.CustomerSegment);
										}

										if (row20.num_rue == null) {
											insertionStatement_tDBSCD_5.setNull(13, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(13, row20.num_rue);
										}

										if (row20.CustomerEmail == null) {
											insertionStatement_tDBSCD_5.setNull(14, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_5.setString(14, row20.CustomerEmail);
										}

										nb_line_inserted_tDBSCD_5 += insertionStatement_tDBSCD_5.executeUpdate();
									} else {
										if ((lookUpValue_tDBSCD_5.code_militaire == null
												&& row20.code_militaire != null)
												|| (lookUpValue_tDBSCD_5.code_militaire != null
														&& !lookUpValue_tDBSCD_5.code_militaire
																.equals(row20.code_militaire))
												|| (lookUpValue_tDBSCD_5.CustomerName == null
														&& row20.CustomerName != null)
												|| (lookUpValue_tDBSCD_5.CustomerName != null
														&& !lookUpValue_tDBSCD_5.CustomerName
																.equals(row20.CustomerName))
												|| (lookUpValue_tDBSCD_5.nom_rue == null && row20.nom_rue != null)
												|| (lookUpValue_tDBSCD_5.nom_rue != null
														&& !lookUpValue_tDBSCD_5.nom_rue.equals(row20.nom_rue))
												|| (lookUpValue_tDBSCD_5.num_militaire == null
														&& row20.num_militaire != null)
												|| (lookUpValue_tDBSCD_5.num_militaire != null
														&& !lookUpValue_tDBSCD_5.num_militaire
																.equals(row20.num_militaire))
												|| (lookUpValue_tDBSCD_5.region == null && row20.state != null)
												|| (lookUpValue_tDBSCD_5.region != null
														&& !lookUpValue_tDBSCD_5.region.equals(row20.state))
												|| (lookUpValue_tDBSCD_5.ville == null && row20.ville != null)
												|| (lookUpValue_tDBSCD_5.ville != null
														&& !lookUpValue_tDBSCD_5.ville.equals(row20.ville))
												|| (lookUpValue_tDBSCD_5.type_logement == null
														&& row20.type_logement != null)
												|| (lookUpValue_tDBSCD_5.type_logement != null
														&& !lookUpValue_tDBSCD_5.type_logement
																.equals(row20.type_logement))
												|| (lookUpValue_tDBSCD_5.num_logement == null
														&& row20.num_logement != null)
												|| (lookUpValue_tDBSCD_5.num_logement != null
														&& !lookUpValue_tDBSCD_5.num_logement
																.equals(row20.num_logement))
												|| (lookUpValue_tDBSCD_5.code_postal == null
														&& row20.code_postal != null)
												|| (lookUpValue_tDBSCD_5.code_postal != null
														&& !lookUpValue_tDBSCD_5.code_postal.equals(row20.code_postal))
												|| (lookUpValue_tDBSCD_5.CustomerPhone == null
														&& row20.CustomerPhone != null)
												|| (lookUpValue_tDBSCD_5.CustomerPhone != null
														&& !lookUpValue_tDBSCD_5.CustomerPhone
																.equals(row20.CustomerPhone))
												|| (lookUpValue_tDBSCD_5.CustomerSegment == null
														&& row20.CustomerSegment != null)
												|| (lookUpValue_tDBSCD_5.CustomerSegment != null
														&& !lookUpValue_tDBSCD_5.CustomerSegment
																.equals(row20.CustomerSegment))
												|| (lookUpValue_tDBSCD_5.num_rue == null && row20.num_rue != null)
												|| (lookUpValue_tDBSCD_5.num_rue != null
														&& !lookUpValue_tDBSCD_5.num_rue.equals(row20.num_rue))) {
											if (row20.code_militaire == null) {
												updateForType1_tDBSCD_5.setNull(1, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(1, row20.code_militaire);
											}

											if (row20.CustomerName == null) {
												updateForType1_tDBSCD_5.setNull(2, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(2, row20.CustomerName);
											}

											if (row20.nom_rue == null) {
												updateForType1_tDBSCD_5.setNull(3, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(3, row20.nom_rue);
											}

											if (row20.num_militaire == null) {
												updateForType1_tDBSCD_5.setNull(4, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(4, row20.num_militaire);
											}

											if (row20.state == null) {
												updateForType1_tDBSCD_5.setNull(5, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(5, row20.state);
											}

											if (row20.ville == null) {
												updateForType1_tDBSCD_5.setNull(6, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(6, row20.ville);
											}

											if (row20.type_logement == null) {
												updateForType1_tDBSCD_5.setNull(7, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(7, row20.type_logement);
											}

											if (row20.num_logement == null) {
												updateForType1_tDBSCD_5.setNull(8, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(8, row20.num_logement);
											}

											if (row20.code_postal == null) {
												updateForType1_tDBSCD_5.setNull(9, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(9, row20.code_postal);
											}

											if (row20.CustomerPhone == null) {
												updateForType1_tDBSCD_5.setNull(10, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(10, row20.CustomerPhone);
											}

											if (row20.CustomerSegment == null) {
												updateForType1_tDBSCD_5.setNull(11, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(11, row20.CustomerSegment);
											}

											if (row20.num_rue == null) {
												updateForType1_tDBSCD_5.setNull(12, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_5.setString(12, row20.num_rue);
											}

											updateForType1_tDBSCD_5.setInt(13, row20.id);

											nb_line_update_tDBSCD_5 += updateForType1_tDBSCD_5.executeUpdate();
										}
										if ((lookUpValue_tDBSCD_5.CustomerEmail == null && row20.CustomerEmail != null)
												|| (lookUpValue_tDBSCD_5.CustomerEmail != null
														&& !lookUpValue_tDBSCD_5.CustomerEmail
																.equals(row20.CustomerEmail))) {
											updateForType2_tDBSCD_5.setInt(2, row20.id);

											nb_line_update_tDBSCD_5 += updateForType2_tDBSCD_5.executeUpdate();
											insertionStatement_tDBSCD_5.setInt(1, row20.id);

											if (row20.code_militaire == null) {
												insertionStatement_tDBSCD_5.setNull(2, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(2, row20.code_militaire);
											}

											if (row20.CustomerName == null) {
												insertionStatement_tDBSCD_5.setNull(3, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(3, row20.CustomerName);
											}

											if (row20.nom_rue == null) {
												insertionStatement_tDBSCD_5.setNull(4, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(4, row20.nom_rue);
											}

											if (row20.num_militaire == null) {
												insertionStatement_tDBSCD_5.setNull(5, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(5, row20.num_militaire);
											}

											if (row20.state == null) {
												insertionStatement_tDBSCD_5.setNull(6, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(6, row20.state);
											}

											if (row20.ville == null) {
												insertionStatement_tDBSCD_5.setNull(7, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(7, row20.ville);
											}

											if (row20.type_logement == null) {
												insertionStatement_tDBSCD_5.setNull(8, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(8, row20.type_logement);
											}

											if (row20.num_logement == null) {
												insertionStatement_tDBSCD_5.setNull(9, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(9, row20.num_logement);
											}

											if (row20.code_postal == null) {
												insertionStatement_tDBSCD_5.setNull(10, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(10, row20.code_postal);
											}

											if (row20.CustomerPhone == null) {
												insertionStatement_tDBSCD_5.setNull(11, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(11, row20.CustomerPhone);
											}

											if (row20.CustomerSegment == null) {
												insertionStatement_tDBSCD_5.setNull(12, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(12, row20.CustomerSegment);
											}

											if (row20.num_rue == null) {
												insertionStatement_tDBSCD_5.setNull(13, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(13, row20.num_rue);
											}

											if (row20.CustomerEmail == null) {
												insertionStatement_tDBSCD_5.setNull(14, java.sql.Types.VARCHAR);
											} else {
												insertionStatement_tDBSCD_5.setString(14, row20.CustomerEmail);
											}

											nb_line_inserted_tDBSCD_5 += insertionStatement_tDBSCD_5.executeUpdate();
										}
									}

								} catch (java.lang.Exception e) {// catch
									globalMap.put("tDBSCD_5_ERROR_MESSAGE", e.getMessage());

									System.err.print(e.getMessage());
								} // end catch

								lookUpValue_tDBSCD_5.code_militaire = row20.code_militaire;
								lookUpValue_tDBSCD_5.CustomerName = row20.CustomerName;
								lookUpValue_tDBSCD_5.nom_rue = row20.nom_rue;
								lookUpValue_tDBSCD_5.num_militaire = row20.num_militaire;
								lookUpValue_tDBSCD_5.region = row20.state;
								lookUpValue_tDBSCD_5.ville = row20.ville;
								lookUpValue_tDBSCD_5.type_logement = row20.type_logement;
								lookUpValue_tDBSCD_5.num_logement = row20.num_logement;
								lookUpValue_tDBSCD_5.code_postal = row20.code_postal;
								lookUpValue_tDBSCD_5.CustomerPhone = row20.CustomerPhone;
								lookUpValue_tDBSCD_5.CustomerSegment = row20.CustomerSegment;
								lookUpValue_tDBSCD_5.num_rue = row20.num_rue;
								lookUpValue_tDBSCD_5.CustomerEmail = row20.CustomerEmail;
								cache_tDBSCD_5.put(lookUpKey_tDBSCD_5, lookUpValue_tDBSCD_5);

								tos_count_tDBSCD_5++;

								/**
								 * [tDBSCD_5 main ] stop
								 */

								/**
								 * [tDBSCD_5 process_data_begin ] start
								 */

								currentComponent = "tDBSCD_5";

								/**
								 * [tDBSCD_5 process_data_begin ] stop
								 */

								/**
								 * [tDBSCD_5 process_data_end ] start
								 */

								currentComponent = "tDBSCD_5";

								/**
								 * [tDBSCD_5 process_data_end ] stop
								 */

							} // End of branch "row20"

							/**
							 * [tUniqRow_5 process_data_end ] start
							 */

							currentComponent = "tUniqRow_5";

							/**
							 * [tUniqRow_5 process_data_end ] stop
							 */

						} // End of branch "diimCustomer"

						/**
						 * [tMap_8 process_data_end ] start
						 */

						currentComponent = "tMap_8";

						/**
						 * [tMap_8 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 process_data_end ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 end ] start
						 */

						currentComponent = "tDBInput_4";

					}
				} finally {
					if (rs_tDBInput_4 != null) {
						rs_tDBInput_4.close();
					}
					if (stmt_tDBInput_4 != null) {
						stmt_tDBInput_4.close();
					}
					if (conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {

						conn_tDBInput_4.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_4_NB_LINE", nb_line_tDBInput_4);

				ok_Hash.put("tDBInput_4", true);
				end_Hash.put("tDBInput_4", System.currentTimeMillis());

				/**
				 * [tDBInput_4 end ] stop
				 */

				/**
				 * [tMap_8 end ] start
				 */

				currentComponent = "tMap_8";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row18");
				}

				ok_Hash.put("tMap_8", true);
				end_Hash.put("tMap_8", System.currentTimeMillis());

				/**
				 * [tMap_8 end ] stop
				 */

				/**
				 * [tUniqRow_5 end ] start
				 */

				currentComponent = "tUniqRow_5";

				globalMap.put("tUniqRow_5_NB_UNIQUES", nb_uniques_tUniqRow_5);
				globalMap.put("tUniqRow_5_NB_DUPLICATES", nb_duplicates_tUniqRow_5);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "diimCustomer");
				}

				ok_Hash.put("tUniqRow_5", true);
				end_Hash.put("tUniqRow_5", System.currentTimeMillis());

				/**
				 * [tUniqRow_5 end ] stop
				 */

				/**
				 * [tDBSCD_5 end ] start
				 */

				currentComponent = "tDBSCD_5";

				insertionStatement_tDBSCD_5.close();
				updateForType1_tDBSCD_5.close();
				updateForType2_tDBSCD_5.close();

				if (conn_tDBSCD_5 != null && !conn_tDBSCD_5.isClosed()) {
					conn_tDBSCD_5.close();
				}

				globalMap.put("tDBSCD_5_NB_LINE_UPDATED", nb_line_update_tDBSCD_5);
				globalMap.put("tDBSCD_5_NB_LINE_INSERTED", nb_line_inserted_tDBSCD_5);
				globalMap.put("tDBSCD_5_NB_LINE_REJECTED", nb_line_rejected_tDBSCD_5);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row20");
				}

				ok_Hash.put("tDBSCD_5", true);
				end_Hash.put("tDBSCD_5", System.currentTimeMillis());

				/**
				 * [tDBSCD_5 end ] stop
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
				 * [tDBInput_4 finally ] start
				 */

				currentComponent = "tDBInput_4";

				/**
				 * [tDBInput_4 finally ] stop
				 */

				/**
				 * [tMap_8 finally ] start
				 */

				currentComponent = "tMap_8";

				/**
				 * [tMap_8 finally ] stop
				 */

				/**
				 * [tUniqRow_5 finally ] start
				 */

				currentComponent = "tUniqRow_5";

				/**
				 * [tUniqRow_5 finally ] stop
				 */

				/**
				 * [tDBSCD_5 finally ] start
				 */

				currentComponent = "tDBSCD_5";

				/**
				 * [tDBSCD_5 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}

	public void tStatCatcher_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tStatCatcher_1_SUBPROCESS_STATE", 0);

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
				 * [tStatCatcher_1 begin ] start
				 */

				ok_Hash.put("tStatCatcher_1", false);
				start_Hash.put("tStatCatcher_1", System.currentTimeMillis());

				currentComponent = "tStatCatcher_1";

				int tos_count_tStatCatcher_1 = 0;

				for (StatCatcherUtils.StatCatcherMessage scm : tStatCatcher_1.getMessages()) {

					/**
					 * [tStatCatcher_1 begin ] stop
					 */

					/**
					 * [tStatCatcher_1 main ] start
					 */

					currentComponent = "tStatCatcher_1";

					tos_count_tStatCatcher_1++;

					/**
					 * [tStatCatcher_1 main ] stop
					 */

					/**
					 * [tStatCatcher_1 process_data_begin ] start
					 */

					currentComponent = "tStatCatcher_1";

					/**
					 * [tStatCatcher_1 process_data_begin ] stop
					 */

					/**
					 * [tStatCatcher_1 process_data_end ] start
					 */

					currentComponent = "tStatCatcher_1";

					/**
					 * [tStatCatcher_1 process_data_end ] stop
					 */

					/**
					 * [tStatCatcher_1 end ] start
					 */

					currentComponent = "tStatCatcher_1";

				}

				ok_Hash.put("tStatCatcher_1", true);
				end_Hash.put("tStatCatcher_1", System.currentTimeMillis());

				/**
				 * [tStatCatcher_1 end ] stop
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
				 * [tStatCatcher_1 finally ] start
				 */

				currentComponent = "tStatCatcher_1";

				/**
				 * [tStatCatcher_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tStatCatcher_1_SUBPROCESS_STATE", 1);
	}

	public void tCreateTable_9Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tCreateTable_9_SUBPROCESS_STATE", 0);

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
				 * [tCreateTable_9 begin ] start
				 */

				ok_Hash.put("tCreateTable_9", false);
				start_Hash.put("tCreateTable_9", System.currentTimeMillis());

				currentComponent = "tCreateTable_9";

				int tos_count_tCreateTable_9 = 0;

				/**
				 * [tCreateTable_9 begin ] stop
				 */

				/**
				 * [tCreateTable_9 main ] start
				 */

				currentComponent = "tCreateTable_9";

				try {
					String driverClass_tCreateTable_9 = "net.sourceforge.jtds.jdbc.Driver";
					String url_tCreateTable_9 = "jdbc:jtds:sqlserver://" + "localhost" + ":" + "1433" + "//"
							+ "ecommerv2";
					String dbUser_tCreateTable_9 = "ismaill";

					String tableName_tCreateTable_9 = "Dimproduct";
					String dbSchema_tCreateTable_9 = "dbo";
					if (dbSchema_tCreateTable_9 != null && dbSchema_tCreateTable_9.trim().length() != 0) {
						tableName_tCreateTable_9 = dbSchema_tCreateTable_9 + "].[" + tableName_tCreateTable_9;
					}
					java.lang.Class jdbcclazz_tCreateTable_9 = java.lang.Class
							.forName("net.sourceforge.jtds.jdbc.Driver");
					final String decryptedPassword_tCreateTable_9 = routines.system.PasswordEncryptUtil.decryptPassword(
							"enc:routine.encryption.key.v1:wgbWue/WN2xAinsMYQz/w4PwYqxjD2J8H/FqLKNJ7qg=");
					java.sql.Connection conn_tCreateTable_9 = java.sql.DriverManager.getConnection(url_tCreateTable_9,
							dbUser_tCreateTable_9, decryptedPassword_tCreateTable_9);

					boolean whetherExist_tCreateTable_9 = false;
					java.sql.Statement rsTable_tCreateTable_9 = conn_tCreateTable_9.createStatement();
					try {
						rsTable_tCreateTable_9.execute("SELECT TOP 1 1 FROM [" + tableName_tCreateTable_9 + "]");
						whetherExist_tCreateTable_9 = true;
					} catch (Exception e) {
						whetherExist_tCreateTable_9 = false;
					}
					rsTable_tCreateTable_9.close();
					if (!whetherExist_tCreateTable_9) {
						java.sql.Statement stmt_tCreateTable_9 = conn_tCreateTable_9.createStatement();
						stmt_tCreateTable_9.execute("CREATE TABLE [" + tableName_tCreateTable_9
								+ "]([ProductName] VARCHAR(29)  ,[ProductCategory] VARCHAR(29)  ,[ProductSubCategory] VARCHAR(29)  ,[ProductPrice] REAL ,[id] INT ,[previous_ProductPrice] REAL ,[key] INT  not null ,primary key([key]))");

					}
					if (conn_tCreateTable_9 != null && !conn_tCreateTable_9.isClosed()) {
						conn_tCreateTable_9.close();
					}

					globalMap.put("tCreateTable_9_QUERY", "CREATE TABLE [" + tableName_tCreateTable_9
							+ "]([ProductName] VARCHAR(29)  ,[ProductCategory] VARCHAR(29)  ,[ProductSubCategory] VARCHAR(29)  ,[ProductPrice] REAL ,[id] INT ,[previous_ProductPrice] REAL ,[key] INT  not null ,primary key([key]))");
				} catch (java.lang.Exception e) {
					globalMap.put("tCreateTable_9_ERROR_MESSAGE", e.getMessage());
					throw new RuntimeException("Creating table failed", e);
				}

				tos_count_tCreateTable_9++;

				/**
				 * [tCreateTable_9 main ] stop
				 */

				/**
				 * [tCreateTable_9 process_data_begin ] start
				 */

				currentComponent = "tCreateTable_9";

				/**
				 * [tCreateTable_9 process_data_begin ] stop
				 */

				/**
				 * [tCreateTable_9 process_data_end ] start
				 */

				currentComponent = "tCreateTable_9";

				/**
				 * [tCreateTable_9 process_data_end ] stop
				 */

				/**
				 * [tCreateTable_9 end ] start
				 */

				currentComponent = "tCreateTable_9";

				ok_Hash.put("tCreateTable_9", true);
				end_Hash.put("tCreateTable_9", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk6", 0, "ok");
				}
				tDBInput_3Process(globalMap);

				/**
				 * [tCreateTable_9 end ] stop
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
				 * [tCreateTable_9 finally ] start
				 */

				currentComponent = "tCreateTable_9";

				/**
				 * [tCreateTable_9 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tCreateTable_9_SUBPROCESS_STATE", 1);
	}

	public static class row19Struct implements routines.system.IPersistableRow<row19Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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

		public int id;

		public int getId() {
			return this.id;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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

					this.id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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

					this.id = dis.readInt();

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

				// int

				dos.writeInt(this.id);

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

				// int

				dos.writeInt(this.id);

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
			sb.append(",id=" + String.valueOf(id));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row19Struct other) {

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

	public static class dimproducttStruct implements routines.system.IPersistableRow<dimproducttStruct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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

		public int id;

		public int getId() {
			return this.id;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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

					this.id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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

					this.id = dis.readInt();

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

				// int

				dos.writeInt(this.id);

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

				// int

				dos.writeInt(this.id);

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
			sb.append(",id=" + String.valueOf(id));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(dimproducttStruct other) {

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

	public static class row17Struct implements routines.system.IPersistableRow<row17Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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
		public int compareTo(row17Struct other) {

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

	public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

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

				row17Struct row17 = new row17Struct();
				dimproducttStruct dimproductt = new dimproducttStruct();
				row19Struct row19 = new row19Struct();

				/**
				 * [tDBSCD_1 begin ] start
				 */

				ok_Hash.put("tDBSCD_1", false);
				start_Hash.put("tDBSCD_1", System.currentTimeMillis());

				currentComponent = "tDBSCD_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row19");
				}

				int tos_count_tDBSCD_1 = 0;

				class SCDSK_tDBSCD_1 {
					private int hashCode;
					public boolean hashCodeDirty = true;
					int id;

					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final SCDSK_tDBSCD_1 other = (SCDSK_tDBSCD_1) obj;
						if (this.id != other.id)
							return false;

						return true;
					}

					public int hashCode() {
						if (hashCodeDirty) {
							int prime = 31;
							hashCode = prime * hashCode + id;
							hashCodeDirty = false;
						}
						return hashCode;
					}
				}

				class SCDStruct_tDBSCD_1 {
					private String ProductCategory;
					private String ProductSubCategory;
					private String ProductName;
					private Float ProductPrice;
					private Float previous_ProductPrice;
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
						.decryptPassword("enc:routine.encryption.key.v1:84jtkfc0BIwu6o60nbS7KkKTIVWLb2LotADDU/Kz4XY=");

				String dbPwd_tDBSCD_1 = decryptedPassword_tDBSCD_1;
				conn_tDBSCD_1 = java.sql.DriverManager.getConnection(url_tDBSCD_1, dbUser_tDBSCD_1, dbPwd_tDBSCD_1);

				if (dbschema_tDBSCD_1 == null || dbschema_tDBSCD_1.trim().length() == 0) {
					tableName_tDBSCD_1 = "Dimproduct";
				} else {
					tableName_tDBSCD_1 = dbschema_tDBSCD_1 + "].[" + "Dimproduct";
				}
				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBSCD_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();
				String tmpValue_tDBSCD_1 = null;
				String search_tDBSCD_1 = "SELECT [id], [ProductCategory], [ProductSubCategory], [ProductName], [ProductPrice], [previous_ProductPrice] FROM ["
						+ tableName_tDBSCD_1 + "]";
				java.sql.Statement statement_tDBSCD_1 = conn_tDBSCD_1.createStatement();
				java.sql.ResultSet resultSet_tDBSCD_1 = statement_tDBSCD_1.executeQuery(search_tDBSCD_1);
				java.util.Map<SCDSK_tDBSCD_1, SCDStruct_tDBSCD_1> cache_tDBSCD_1 = new java.util.HashMap<SCDSK_tDBSCD_1, SCDStruct_tDBSCD_1>();
				while (resultSet_tDBSCD_1.next()) {
					SCDSK_tDBSCD_1 sk_tDBSCD_1 = new SCDSK_tDBSCD_1();
					SCDStruct_tDBSCD_1 row_tDBSCD_1 = new SCDStruct_tDBSCD_1();
					if (resultSet_tDBSCD_1.getObject(1) != null) {
						sk_tDBSCD_1.id = resultSet_tDBSCD_1.getInt(1);
					}
					if (resultSet_tDBSCD_1.getObject(2) != null) {
						row_tDBSCD_1.ProductCategory = resultSet_tDBSCD_1.getString(2);
					}
					if (resultSet_tDBSCD_1.getObject(3) != null) {
						row_tDBSCD_1.ProductSubCategory = resultSet_tDBSCD_1.getString(3);
					}
					if (resultSet_tDBSCD_1.getObject(4) != null) {
						row_tDBSCD_1.ProductName = resultSet_tDBSCD_1.getString(4);
					}
					if (resultSet_tDBSCD_1.getObject(5) != null) {
						row_tDBSCD_1.ProductPrice = resultSet_tDBSCD_1.getFloat(5);
					}
					if (resultSet_tDBSCD_1.getObject(6) != null) {
						row_tDBSCD_1.previous_ProductPrice = resultSet_tDBSCD_1.getFloat(6);
					}
					cache_tDBSCD_1.put(sk_tDBSCD_1, row_tDBSCD_1);
				}
				resultSet_tDBSCD_1.close();
				statement_tDBSCD_1.close();
				int nextSurrogateKey_tDBSCD_1 = 1;
				if (cache_tDBSCD_1.size() > 0) {
					String tmpQuery_tDBSCD_1 = "SELECT MAX([key]) FROM [" + tableName_tDBSCD_1 + "]";
					java.sql.Statement tmpStmt_tDBSCD_1 = conn_tDBSCD_1.createStatement();
					java.sql.ResultSet tmpRS_tDBSCD_1 = tmpStmt_tDBSCD_1.executeQuery(tmpQuery_tDBSCD_1);
					if (tmpRS_tDBSCD_1.next() && tmpRS_tDBSCD_1.getObject(1) != null) {
						nextSurrogateKey_tDBSCD_1 = tmpRS_tDBSCD_1.getInt(1) + 1;
					}
					tmpRS_tDBSCD_1.close();
					tmpStmt_tDBSCD_1.close();
				}
				String insertionSQL_tDBSCD_1 = "INSERT INTO [" + tableName_tDBSCD_1
						+ "]([key], [id], [ProductCategory], [ProductSubCategory], [ProductName], [ProductPrice]) VALUES(?, ?, ?, ?, ?, ?)";
				java.sql.PreparedStatement insertionStatement_tDBSCD_1 = conn_tDBSCD_1
						.prepareStatement(insertionSQL_tDBSCD_1);
				String updateSQLForType1_tDBSCD_1 = "UPDATE [" + tableName_tDBSCD_1
						+ "] SET [ProductSubCategory] = ?, [ProductName] = ? WHERE [id] = ?";
				java.sql.PreparedStatement updateForType1_tDBSCD_1 = conn_tDBSCD_1
						.prepareStatement(updateSQLForType1_tDBSCD_1);
				String updateSQLForType3_tDBSCD_1 = "UPDATE [" + tableName_tDBSCD_1
						+ "] SET [ProductPrice] = ?, [previous_ProductPrice] = ? WHERE [id] = ?";
				java.sql.PreparedStatement updateForType3_tDBSCD_1 = conn_tDBSCD_1
						.prepareStatement(updateSQLForType3_tDBSCD_1);

				SCDSK_tDBSCD_1 lookUpKey_tDBSCD_1 = null;
				SCDStruct_tDBSCD_1 lookUpValue_tDBSCD_1 = null;

				/**
				 * [tDBSCD_1 begin ] stop
				 */

				/**
				 * [tUniqRow_8 begin ] start
				 */

				ok_Hash.put("tUniqRow_8", false);
				start_Hash.put("tUniqRow_8", System.currentTimeMillis());

				currentComponent = "tUniqRow_8";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "dimproductt");
				}

				int tos_count_tUniqRow_8 = 0;

				class KeyStruct_tUniqRow_8 {

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					String ProductName;
					String ProductCategory;
					String ProductSubCategory;
					Float ProductPrice;
					int id;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + ((this.ProductName == null) ? 0 : this.ProductName.hashCode());

							result = prime * result
									+ ((this.ProductCategory == null) ? 0 : this.ProductCategory.hashCode());

							result = prime * result
									+ ((this.ProductSubCategory == null) ? 0 : this.ProductSubCategory.hashCode());

							result = prime * result + ((this.ProductPrice == null) ? 0 : this.ProductPrice.hashCode());

							result = prime * result + (int) this.id;

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final KeyStruct_tUniqRow_8 other = (KeyStruct_tUniqRow_8) obj;

						if (this.ProductName == null) {
							if (other.ProductName != null)
								return false;

						} else if (!this.ProductName.equals(other.ProductName))

							return false;

						if (this.ProductCategory == null) {
							if (other.ProductCategory != null)
								return false;

						} else if (!this.ProductCategory.equals(other.ProductCategory))

							return false;

						if (this.ProductSubCategory == null) {
							if (other.ProductSubCategory != null)
								return false;

						} else if (!this.ProductSubCategory.equals(other.ProductSubCategory))

							return false;

						if (this.ProductPrice == null) {
							if (other.ProductPrice != null)
								return false;

						} else if (!this.ProductPrice.equals(other.ProductPrice))

							return false;

						if (this.id != other.id)
							return false;

						return true;
					}

				}

				int nb_uniques_tUniqRow_8 = 0;
				int nb_duplicates_tUniqRow_8 = 0;
				KeyStruct_tUniqRow_8 finder_tUniqRow_8 = new KeyStruct_tUniqRow_8();
				java.util.Set<KeyStruct_tUniqRow_8> keystUniqRow_8 = new java.util.HashSet<KeyStruct_tUniqRow_8>();

				/**
				 * [tUniqRow_8 begin ] stop
				 */

				/**
				 * [tMap_7 begin ] start
				 */

				ok_Hash.put("tMap_7", false);
				start_Hash.put("tMap_7", System.currentTimeMillis());

				currentComponent = "tMap_7";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row17");
				}

				int tos_count_tMap_7 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_7__Struct {
				}
				Var__tMap_7__Struct Var__tMap_7 = new Var__tMap_7__Struct();
// ###############################

// ###############################
// # Outputs initialization
				dimproducttStruct dimproductt_tmp = new dimproducttStruct();
// ###############################

				/**
				 * [tMap_7 begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				int tos_count_tDBInput_3 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_3 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_3 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_3 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_3, talendToDBArray_tDBInput_3);
				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "ismaill";

				final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:rlyazqeTIom4nO6+4YsN0Ew/SDe22smE4YJGlRouyvs=");

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String port_tDBInput_3 = "1433";
				String dbname_tDBInput_3 = "ecommerv2";
				String url_tDBInput_3 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBInput_3)) {
					url_tDBInput_3 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_3)) {
					url_tDBInput_3 += "//" + "ecommerv2";
				}
				url_tDBInput_3 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_3 = "dbo";

				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3, dbUser_tDBInput_3,
						dbPwd_tDBInput_3);

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

				String dbquery_tDBInput_3 = "select * from transformed";

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);
				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							row17.ProductName = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(1);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.ProductName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.ProductName = tmpContent_tDBInput_3;
								}
							} else {
								row17.ProductName = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row17.ProductCategory = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(2);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.ProductCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.ProductCategory = tmpContent_tDBInput_3;
								}
							} else {
								row17.ProductCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							row17.ProductSubCategory = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.ProductSubCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.ProductSubCategory = tmpContent_tDBInput_3;
								}
							} else {
								row17.ProductSubCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							row17.ProductPrice = null;
						} else {

							row17.ProductPrice = rs_tDBInput_3.getFloat(4);
							if (rs_tDBInput_3.wasNull()) {
								row17.ProductPrice = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							row17.Date = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(5);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.Date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.Date = tmpContent_tDBInput_3;
								}
							} else {
								row17.Date = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							row17.CustomerName = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(6);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.CustomerName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.CustomerName = tmpContent_tDBInput_3;
								}
							} else {
								row17.CustomerName = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 7) {
							row17.CustomerEmail = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(7);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.CustomerEmail = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.CustomerEmail = tmpContent_tDBInput_3;
								}
							} else {
								row17.CustomerEmail = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 8) {
							row17.CustomerAddress = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(8);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.CustomerAddress = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.CustomerAddress = tmpContent_tDBInput_3;
								}
							} else {
								row17.CustomerAddress = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 9) {
							row17.CustomerPhone = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(9);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.CustomerPhone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.CustomerPhone = tmpContent_tDBInput_3;
								}
							} else {
								row17.CustomerPhone = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 10) {
							row17.CustomerSegment = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(10);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.CustomerSegment = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.CustomerSegment = tmpContent_tDBInput_3;
								}
							} else {
								row17.CustomerSegment = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 11) {
							row17.SupplierName = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(11);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.SupplierName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.SupplierName = tmpContent_tDBInput_3;
								}
							} else {
								row17.SupplierName = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 12) {
							row17.SupplierLocation = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(12);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.SupplierLocation = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.SupplierLocation = tmpContent_tDBInput_3;
								}
							} else {
								row17.SupplierLocation = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 13) {
							row17.SupplierContact = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(13);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.SupplierContact = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.SupplierContact = tmpContent_tDBInput_3;
								}
							} else {
								row17.SupplierContact = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 14) {
							row17.ShipperName = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(14);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.ShipperName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.ShipperName = tmpContent_tDBInput_3;
								}
							} else {
								row17.ShipperName = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 15) {
							row17.ShippingMethod = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(15);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
									row17.ShippingMethod = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row17.ShippingMethod = tmpContent_tDBInput_3;
								}
							} else {
								row17.ShippingMethod = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 16) {
							row17.QuantitySold = null;
						} else {

							row17.QuantitySold = rs_tDBInput_3.getInt(16);
							if (rs_tDBInput_3.wasNull()) {
								row17.QuantitySold = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 17) {
							row17.TotalAmount = null;
						} else {

							row17.TotalAmount = rs_tDBInput_3.getFloat(17);
							if (rs_tDBInput_3.wasNull()) {
								row17.TotalAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 18) {
							row17.DiscountAmount = null;
						} else {

							row17.DiscountAmount = rs_tDBInput_3.getFloat(18);
							if (rs_tDBInput_3.wasNull()) {
								row17.DiscountAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 19) {
							row17.NetAmount = null;
						} else {

							row17.NetAmount = rs_tDBInput_3.getFloat(19);
							if (rs_tDBInput_3.wasNull()) {
								row17.NetAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 20) {
							row17.StockReceived = null;
						} else {

							row17.StockReceived = rs_tDBInput_3.getFloat(20);
							if (rs_tDBInput_3.wasNull()) {
								row17.StockReceived = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 21) {
							row17.StockSold = null;
						} else {

							row17.StockSold = rs_tDBInput_3.getFloat(21);
							if (rs_tDBInput_3.wasNull()) {
								row17.StockSold = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 22) {
							row17.StockOnHand = null;
						} else {

							row17.StockOnHand = rs_tDBInput_3.getFloat(22);
							if (rs_tDBInput_3.wasNull()) {
								row17.StockOnHand = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 23) {
							row17.id_pro = 0;
						} else {

							row17.id_pro = rs_tDBInput_3.getInt(23);
							if (rs_tDBInput_3.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_3 < 24) {
							row17.id_shipping = 0;
						} else {

							row17.id_shipping = rs_tDBInput_3.getInt(24);
							if (rs_tDBInput_3.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_3 < 25) {
							row17.id_supplier = 0;
						} else {

							row17.id_supplier = rs_tDBInput_3.getInt(25);
							if (rs_tDBInput_3.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_3 < 26) {
							row17.id_costumer = 0;
						} else {

							row17.id_costumer = rs_tDBInput_3.getInt(26);
							if (rs_tDBInput_3.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_3 < 27) {
							row17.id_date = 0;
						} else {

							row17.id_date = rs_tDBInput_3.getInt(27);
							if (rs_tDBInput_3.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						currentComponent = "tDBInput_3";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tMap_7 main ] start
						 */

						currentComponent = "tMap_7";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row17"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_7 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_7 = false;
						boolean mainRowRejected_tMap_7 = false;

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_7__Struct Var = Var__tMap_7;// ###############################
							// ###############################
							// # Output tables

							dimproductt = null;

// # Output table : 'dimproductt'
							dimproductt_tmp.ProductName = row17.ProductName;
							dimproductt_tmp.ProductCategory = row17.ProductCategory;
							dimproductt_tmp.ProductSubCategory = row17.ProductSubCategory;
							dimproductt_tmp.ProductPrice = row17.ProductPrice;
							dimproductt_tmp.id = row17.id_pro;
							dimproductt = dimproductt_tmp;
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_7 = false;

						tos_count_tMap_7++;

						/**
						 * [tMap_7 main ] stop
						 */

						/**
						 * [tMap_7 process_data_begin ] start
						 */

						currentComponent = "tMap_7";

						/**
						 * [tMap_7 process_data_begin ] stop
						 */
// Start of branch "dimproductt"
						if (dimproductt != null) {

							/**
							 * [tUniqRow_8 main ] start
							 */

							currentComponent = "tUniqRow_8";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "dimproductt"

								);
							}

							row19 = null;
							if (dimproductt.ProductName == null) {
								finder_tUniqRow_8.ProductName = null;
							} else {
								finder_tUniqRow_8.ProductName = dimproductt.ProductName.toLowerCase();
							}
							if (dimproductt.ProductCategory == null) {
								finder_tUniqRow_8.ProductCategory = null;
							} else {
								finder_tUniqRow_8.ProductCategory = dimproductt.ProductCategory.toLowerCase();
							}
							if (dimproductt.ProductSubCategory == null) {
								finder_tUniqRow_8.ProductSubCategory = null;
							} else {
								finder_tUniqRow_8.ProductSubCategory = dimproductt.ProductSubCategory.toLowerCase();
							}
							finder_tUniqRow_8.ProductPrice = dimproductt.ProductPrice;
							finder_tUniqRow_8.id = dimproductt.id;
							finder_tUniqRow_8.hashCodeDirty = true;
							if (!keystUniqRow_8.contains(finder_tUniqRow_8)) {
								KeyStruct_tUniqRow_8 new_tUniqRow_8 = new KeyStruct_tUniqRow_8();

								if (dimproductt.ProductName == null) {
									new_tUniqRow_8.ProductName = null;
								} else {
									new_tUniqRow_8.ProductName = dimproductt.ProductName.toLowerCase();
								}
								if (dimproductt.ProductCategory == null) {
									new_tUniqRow_8.ProductCategory = null;
								} else {
									new_tUniqRow_8.ProductCategory = dimproductt.ProductCategory.toLowerCase();
								}
								if (dimproductt.ProductSubCategory == null) {
									new_tUniqRow_8.ProductSubCategory = null;
								} else {
									new_tUniqRow_8.ProductSubCategory = dimproductt.ProductSubCategory.toLowerCase();
								}
								new_tUniqRow_8.ProductPrice = dimproductt.ProductPrice;
								new_tUniqRow_8.id = dimproductt.id;

								keystUniqRow_8.add(new_tUniqRow_8);
								if (row19 == null) {

									row19 = new row19Struct();
								}
								row19.ProductName = dimproductt.ProductName;
								row19.ProductCategory = dimproductt.ProductCategory;
								row19.ProductSubCategory = dimproductt.ProductSubCategory;
								row19.ProductPrice = dimproductt.ProductPrice;
								row19.id = dimproductt.id;
								nb_uniques_tUniqRow_8++;
							} else {
								nb_duplicates_tUniqRow_8++;
							}

							tos_count_tUniqRow_8++;

							/**
							 * [tUniqRow_8 main ] stop
							 */

							/**
							 * [tUniqRow_8 process_data_begin ] start
							 */

							currentComponent = "tUniqRow_8";

							/**
							 * [tUniqRow_8 process_data_begin ] stop
							 */
// Start of branch "row19"
							if (row19 != null) {

								/**
								 * [tDBSCD_1 main ] start
								 */

								currentComponent = "tDBSCD_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row19"

									);
								}

								try {
									lookUpKey_tDBSCD_1 = new SCDSK_tDBSCD_1();
									lookUpKey_tDBSCD_1.id = row19.id;
									lookUpKey_tDBSCD_1.hashCodeDirty = true;
									lookUpValue_tDBSCD_1 = cache_tDBSCD_1.get(lookUpKey_tDBSCD_1);
									if (lookUpValue_tDBSCD_1 == null) {
										lookUpValue_tDBSCD_1 = new SCDStruct_tDBSCD_1();

										insertionStatement_tDBSCD_1.setInt(1, nextSurrogateKey_tDBSCD_1);

										nextSurrogateKey_tDBSCD_1++;
										insertionStatement_tDBSCD_1.setInt(2, row19.id);

										if (row19.ProductCategory == null) {
											insertionStatement_tDBSCD_1.setNull(3, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(3, row19.ProductCategory);
										}

										if (row19.ProductSubCategory == null) {
											insertionStatement_tDBSCD_1.setNull(4, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(4, row19.ProductSubCategory);
										}

										if (row19.ProductName == null) {
											insertionStatement_tDBSCD_1.setNull(5, java.sql.Types.VARCHAR);
										} else {
											insertionStatement_tDBSCD_1.setString(5, row19.ProductName);
										}

										if (row19.ProductPrice == null) {
											insertionStatement_tDBSCD_1.setNull(6, java.sql.Types.FLOAT);
										} else {
											insertionStatement_tDBSCD_1.setFloat(6, row19.ProductPrice);
										}

										nb_line_inserted_tDBSCD_1 += insertionStatement_tDBSCD_1.executeUpdate();
									} else {
										if ((lookUpValue_tDBSCD_1.ProductSubCategory == null
												&& row19.ProductSubCategory != null)
												|| (lookUpValue_tDBSCD_1.ProductSubCategory != null
														&& !lookUpValue_tDBSCD_1.ProductSubCategory
																.equals(row19.ProductSubCategory))
												|| (lookUpValue_tDBSCD_1.ProductName == null
														&& row19.ProductName != null)
												|| (lookUpValue_tDBSCD_1.ProductName != null
														&& !lookUpValue_tDBSCD_1.ProductName
																.equals(row19.ProductName))) {
											if (row19.ProductSubCategory == null) {
												updateForType1_tDBSCD_1.setNull(1, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(1, row19.ProductSubCategory);
											}

											if (row19.ProductName == null) {
												updateForType1_tDBSCD_1.setNull(2, java.sql.Types.VARCHAR);
											} else {
												updateForType1_tDBSCD_1.setString(2, row19.ProductName);
											}

											updateForType1_tDBSCD_1.setInt(3, row19.id);

											nb_line_update_tDBSCD_1 += updateForType1_tDBSCD_1.executeUpdate();
										}
										if ((lookUpValue_tDBSCD_1.ProductPrice == null && row19.ProductPrice != null)
												|| (lookUpValue_tDBSCD_1.ProductPrice != null
														&& !lookUpValue_tDBSCD_1.ProductPrice
																.equals(row19.ProductPrice))) {
											if (row19.ProductPrice == null) {
												updateForType3_tDBSCD_1.setNull(1, java.sql.Types.FLOAT);
											} else {
												updateForType3_tDBSCD_1.setFloat(1, row19.ProductPrice);
											}

											if (lookUpValue_tDBSCD_1.ProductPrice == null) {
												updateForType3_tDBSCD_1.setNull(2, java.sql.Types.FLOAT);
											} else {
												updateForType3_tDBSCD_1.setFloat(2, lookUpValue_tDBSCD_1.ProductPrice);
											}

											updateForType3_tDBSCD_1.setInt(3, row19.id);

											nb_line_update_tDBSCD_1 += updateForType3_tDBSCD_1.executeUpdate();
										}
									}

								} catch (java.lang.Exception e) {// catch
									globalMap.put("tDBSCD_1_ERROR_MESSAGE", e.getMessage());

									System.err.print(e.getMessage());
								} // end catch

								lookUpValue_tDBSCD_1.ProductSubCategory = row19.ProductSubCategory;
								lookUpValue_tDBSCD_1.ProductName = row19.ProductName;
								lookUpValue_tDBSCD_1.ProductPrice = row19.ProductPrice;
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

							} // End of branch "row19"

							/**
							 * [tUniqRow_8 process_data_end ] start
							 */

							currentComponent = "tUniqRow_8";

							/**
							 * [tUniqRow_8 process_data_end ] stop
							 */

						} // End of branch "dimproductt"

						/**
						 * [tMap_7 process_data_end ] start
						 */

						currentComponent = "tMap_7";

						/**
						 * [tMap_7 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
					if (conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {

						conn_tDBInput_3.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tMap_7 end ] start
				 */

				currentComponent = "tMap_7";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row17");
				}

				ok_Hash.put("tMap_7", true);
				end_Hash.put("tMap_7", System.currentTimeMillis());

				/**
				 * [tMap_7 end ] stop
				 */

				/**
				 * [tUniqRow_8 end ] start
				 */

				currentComponent = "tUniqRow_8";

				globalMap.put("tUniqRow_8_NB_UNIQUES", nb_uniques_tUniqRow_8);
				globalMap.put("tUniqRow_8_NB_DUPLICATES", nb_duplicates_tUniqRow_8);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "dimproductt");
				}

				ok_Hash.put("tUniqRow_8", true);
				end_Hash.put("tUniqRow_8", System.currentTimeMillis());

				/**
				 * [tUniqRow_8 end ] stop
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
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row19");
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
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tMap_7 finally ] start
				 */

				currentComponent = "tMap_7";

				/**
				 * [tMap_7 finally ] stop
				 */

				/**
				 * [tUniqRow_8 finally ] start
				 */

				currentComponent = "tUniqRow_8";

				/**
				 * [tUniqRow_8 finally ] stop
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

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}

	public void tDBClose_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBClose_1_SUBPROCESS_STATE", 0);

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
				 * [tDBClose_1 begin ] start
				 */

				ok_Hash.put("tDBClose_1", false);
				start_Hash.put("tDBClose_1", System.currentTimeMillis());

				currentComponent = "tDBClose_1";

				int tos_count_tDBClose_1 = 0;

				/**
				 * [tDBClose_1 begin ] stop
				 */

				/**
				 * [tDBClose_1 main ] start
				 */

				currentComponent = "tDBClose_1";

				java.sql.Connection conn_tDBClose_1 = (java.sql.Connection) globalMap.get("conn_tDBConnection_2");
				if (conn_tDBClose_1 != null && !conn_tDBClose_1.isClosed()) {
					conn_tDBClose_1.close();
				}

				tos_count_tDBClose_1++;

				/**
				 * [tDBClose_1 main ] stop
				 */

				/**
				 * [tDBClose_1 process_data_begin ] start
				 */

				currentComponent = "tDBClose_1";

				/**
				 * [tDBClose_1 process_data_begin ] stop
				 */

				/**
				 * [tDBClose_1 process_data_end ] start
				 */

				currentComponent = "tDBClose_1";

				/**
				 * [tDBClose_1 process_data_end ] stop
				 */

				/**
				 * [tDBClose_1 end ] start
				 */

				currentComponent = "tDBClose_1";

				ok_Hash.put("tDBClose_1", true);
				end_Hash.put("tDBClose_1", System.currentTimeMillis());

				/**
				 * [tDBClose_1 end ] stop
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
				 * [tDBClose_1 finally ] start
				 */

				currentComponent = "tDBClose_1";

				/**
				 * [tDBClose_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBClose_1_SUBPROCESS_STATE", 1);
	}

	public void tDBConnection_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 0);

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
				 * [tDBConnection_2 begin ] start
				 */

				ok_Hash.put("tDBConnection_2", false);
				start_Hash.put("tDBConnection_2", System.currentTimeMillis());

				currentComponent = "tDBConnection_2";

				int tos_count_tDBConnection_2 = 0;

				String url_tDBConnection_2 = "jdbc:jtds:sqlserver://" + "localhost";
				String port_tDBConnection_2 = "1433";
				String dbname_tDBConnection_2 = "ecommerv2";
				if (!"".equals(port_tDBConnection_2)) {
					url_tDBConnection_2 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBConnection_2)) {

					url_tDBConnection_2 += "//" + "ecommerv2";
				}

				url_tDBConnection_2 += ";appName=" + projectName + ";" + "";
				String dbUser_tDBConnection_2 = "ismaill";

				final String decryptedPassword_tDBConnection_2 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:M2xeF6agIJwRvzvakA2EH8qcXpPH9/4QJZB1BrgHfeo=");
				String dbPwd_tDBConnection_2 = decryptedPassword_tDBConnection_2;

				java.sql.Connection conn_tDBConnection_2 = null;

				String driverClass_tDBConnection_2 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBConnection_2 = java.lang.Class.forName(driverClass_tDBConnection_2);
				globalMap.put("driverClass_tDBConnection_2", driverClass_tDBConnection_2);

				conn_tDBConnection_2 = java.sql.DriverManager.getConnection(url_tDBConnection_2, dbUser_tDBConnection_2,
						dbPwd_tDBConnection_2);

				globalMap.put("conn_tDBConnection_2", conn_tDBConnection_2);
				if (null != conn_tDBConnection_2) {

					conn_tDBConnection_2.setAutoCommit(false);
				}

				globalMap.put("dbschema_tDBConnection_2", "dbo");

				globalMap.put("db_tDBConnection_2", "ecommerv2");

				globalMap.put("shareIdentitySetting_tDBConnection_2", false);

				globalMap.put("driver_tDBConnection_2", "JTDS");

				/**
				 * [tDBConnection_2 begin ] stop
				 */

				/**
				 * [tDBConnection_2 main ] start
				 */

				currentComponent = "tDBConnection_2";

				tos_count_tDBConnection_2++;

				/**
				 * [tDBConnection_2 main ] stop
				 */

				/**
				 * [tDBConnection_2 process_data_begin ] start
				 */

				currentComponent = "tDBConnection_2";

				/**
				 * [tDBConnection_2 process_data_begin ] stop
				 */

				/**
				 * [tDBConnection_2 process_data_end ] start
				 */

				currentComponent = "tDBConnection_2";

				/**
				 * [tDBConnection_2 process_data_end ] stop
				 */

				/**
				 * [tDBConnection_2 end ] start
				 */

				currentComponent = "tDBConnection_2";

				ok_Hash.put("tDBConnection_2", true);
				end_Hash.put("tDBConnection_2", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tDBInput_1Process(globalMap);

				/**
				 * [tDBConnection_2 end ] stop
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
				 * [tDBConnection_2 finally ] start
				 */

				currentComponent = "tDBConnection_2";

				/**
				 * [tDBConnection_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 1);
	}

	public void tLogCatcher_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tLogCatcher_3_SUBPROCESS_STATE", 0);

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
				 * [tLogCatcher_3 begin ] start
				 */

				ok_Hash.put("tLogCatcher_3", false);
				start_Hash.put("tLogCatcher_3", System.currentTimeMillis());

				currentComponent = "tLogCatcher_3";

				int tos_count_tLogCatcher_3 = 0;

				try {
					for (LogCatcherUtils.LogCatcherMessage lcm : tLogCatcher_3.getMessages()) {

						/**
						 * [tLogCatcher_3 begin ] stop
						 */

						/**
						 * [tLogCatcher_3 main ] start
						 */

						currentComponent = "tLogCatcher_3";

						tos_count_tLogCatcher_3++;

						/**
						 * [tLogCatcher_3 main ] stop
						 */

						/**
						 * [tLogCatcher_3 process_data_begin ] start
						 */

						currentComponent = "tLogCatcher_3";

						/**
						 * [tLogCatcher_3 process_data_begin ] stop
						 */

						/**
						 * [tLogCatcher_3 process_data_end ] start
						 */

						currentComponent = "tLogCatcher_3";

						/**
						 * [tLogCatcher_3 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_3 end ] start
						 */

						currentComponent = "tLogCatcher_3";

					}
				} catch (Exception e_tLogCatcher_3) {
					globalMap.put("tLogCatcher_3_ERROR_MESSAGE", e_tLogCatcher_3.getMessage());
					logIgnoredError(String.format(
							"tLogCatcher_3 - tLogCatcher failed to process log message(s) due to internal error: %s",
							e_tLogCatcher_3), e_tLogCatcher_3);
				}

				ok_Hash.put("tLogCatcher_3", true);
				end_Hash.put("tLogCatcher_3", System.currentTimeMillis());

				/**
				 * [tLogCatcher_3 end ] stop
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
				 * [tLogCatcher_3 finally ] start
				 */

				currentComponent = "tLogCatcher_3";

				/**
				 * [tLogCatcher_3 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tLogCatcher_3_SUBPROCESS_STATE", 1);
	}

	public static class row27Struct implements routines.system.IPersistableRow<row27Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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
		public int compareTo(row27Struct other) {

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

	public static class out7Struct implements routines.system.IPersistableRow<out7Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

		public String Date;

		public String getDate() {
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

		public Float ProductPrice;

		public Float getProductPrice() {
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readString(dis);

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ProductPrice = null;
					} else {
						this.ProductPrice = dis.readFloat();
					}

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readString(dis);

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ProductPrice = null;
					} else {
						this.ProductPrice = dis.readFloat();
					}

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

				// String

				writeString(this.Date, dos);

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

				// String

				writeString(this.Date, dos);

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
			sb.append("Date=" + Date);
			sb.append(",ProductName=" + ProductName);
			sb.append(",ProductCategory=" + ProductCategory);
			sb.append(",ProductSubCategory=" + ProductSubCategory);
			sb.append(",ProductPrice=" + String.valueOf(ProductPrice));
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
		public int compareTo(out7Struct other) {

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

	public static class out4Struct implements routines.system.IPersistableRow<out4Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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

		public Float ProductPrice;

		public Float getProductPrice() {
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readDate(dis);

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ProductPrice = null;
					} else {
						this.ProductPrice = dis.readFloat();
					}

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readDate(dis);

					this.ProductName = readString(dis);

					this.ProductCategory = readString(dis);

					this.ProductSubCategory = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ProductPrice = null;
					} else {
						this.ProductPrice = dis.readFloat();
					}

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

				// Float

				if (this.ProductPrice == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.ProductPrice);
				}

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

				// Float

				if (this.ProductPrice == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.ProductPrice);
				}

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
			sb.append(",ProductPrice=" + String.valueOf(ProductPrice));
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
		public int compareTo(out4Struct other) {

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

	public static class row16Struct implements routines.system.IPersistableRow<row16Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

		public String Date;

		public String getDate() {
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readString(dis);

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readString(dis);

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

				// String

				writeString(this.Date, dos);

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

				// String

				writeString(this.Date, dos);

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
			sb.append("Date=" + Date);
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
		public int compareTo(row16Struct other) {

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

	public static class row15Struct implements routines.system.IPersistableRow<row15Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

		public String Date;

		public String getDate() {
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readString(dis);

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readString(dis);

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

				// String

				writeString(this.Date, dos);

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

				// String

				writeString(this.Date, dos);

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
			sb.append("Date=" + Date);
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
		public int compareTo(row15Struct other) {

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

				row15Struct row15 = new row15Struct();
				row16Struct row16 = new row16Struct();
				out4Struct out4 = new out4Struct();
				out7Struct out7 = new out7Struct();
				row27Struct row27 = new row27Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row27");
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
						.decryptPassword("enc:routine.encryption.key.v1:HptEIBk7CnM2Piir2DnUgb1PvXVmNP5djJfL3xsULGI=");

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
					tableName_tDBOutput_1 = "transformed";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "transformed";
				}
				int count_tDBOutput_1 = 0;

				try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					stmtDrop_tDBOutput_1.execute("DROP TABLE [" + tableName_tDBOutput_1 + "]");
				}
				try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1
							+ "]([ProductName] VARCHAR(18)  ,[ProductCategory] VARCHAR(15)  ,[ProductSubCategory] VARCHAR(15)  ,[ProductPrice] REAL ,[Date] VARCHAR(10)  ,[CustomerName] VARCHAR(250)  ,[CustomerEmail] VARCHAR(250)  ,[CustomerAddress] VARCHAR(250)  ,[CustomerPhone] VARCHAR(250)  ,[CustomerSegment] VARCHAR(17)  ,[SupplierName] VARCHAR(250)  ,[SupplierLocation] VARCHAR(250)  ,[SupplierContact] VARCHAR(250)  ,[ShipperName] VARCHAR(23)  ,[ShippingMethod] VARCHAR(21)  ,[QuantitySold] INT ,[TotalAmount] REAL ,[DiscountAmount] REAL ,[NetAmount] REAL ,[StockReceived] REAL ,[StockSold] REAL ,[StockOnHand] REAL ,[id_product] INT  not null ,[id_shipping] INT  not null ,[id_supplier] INT  not null ,[id_costumer] INT  not null ,[id_date] INT  not null )");
				}
				String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1
						+ "] ([ProductName],[ProductCategory],[ProductSubCategory],[ProductPrice],[Date],[CustomerName],[CustomerEmail],[CustomerAddress],[CustomerPhone],[CustomerSegment],[SupplierName],[SupplierLocation],[SupplierContact],[ShipperName],[ShippingMethod],[QuantitySold],[TotalAmount],[DiscountAmount],[NetAmount],[StockReceived],[StockSold],[StockOnHand],[id_product],[id_shipping],[id_supplier],[id_costumer],[id_date]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_6 begin ] start
				 */

				ok_Hash.put("tMap_6", false);
				start_Hash.put("tMap_6", System.currentTimeMillis());

				currentComponent = "tMap_6";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out7");
				}

				int tos_count_tMap_6 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_6__Struct {
					int id_pro;
					int id_shipping;
					int id_supplier;
					int id_costumer;
					int id_date;
				}
				Var__tMap_6__Struct Var__tMap_6 = new Var__tMap_6__Struct();
// ###############################

// ###############################
// # Outputs initialization
				row27Struct row27_tmp = new row27Struct();
// ###############################

				/**
				 * [tMap_6 begin ] stop
				 */

				/**
				 * [tMap_11 begin ] start
				 */

				ok_Hash.put("tMap_11", false);
				start_Hash.put("tMap_11", System.currentTimeMillis());

				currentComponent = "tMap_11";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out4");
				}

				int tos_count_tMap_11 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_11__Struct {
				}
				Var__tMap_11__Struct Var__tMap_11 = new Var__tMap_11__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out7Struct out7_tmp = new out7Struct();
// ###############################

				/**
				 * [tMap_11 begin ] stop
				 */

				/**
				 * [tMap_5 begin ] start
				 */

				ok_Hash.put("tMap_5", false);
				start_Hash.put("tMap_5", System.currentTimeMillis());

				currentComponent = "tMap_5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row16");
				}

				int tos_count_tMap_5 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_5__Struct {
				}
				Var__tMap_5__Struct Var__tMap_5 = new Var__tMap_5__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out4Struct out4_tmp = new out4Struct();
// ###############################

				/**
				 * [tMap_5 begin ] stop
				 */

				/**
				 * [tUniqRow_3 begin ] start
				 */

				ok_Hash.put("tUniqRow_3", false);
				start_Hash.put("tUniqRow_3", System.currentTimeMillis());

				currentComponent = "tUniqRow_3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row15");
				}

				int tos_count_tUniqRow_3 = 0;

				class KeyStruct_tUniqRow_3 {

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					String Date;
					String ProductName;
					String ProductCategory;
					String ProductSubCategory;
					String ProductPrice;
					String CustomerName;
					String CustomerEmail;
					String CustomerAddress;
					String CustomerPhone;
					String CustomerSegment;
					String SupplierName;
					String SupplierLocation;
					String SupplierContact;
					String ShipperName;
					String ShippingMethod;
					String QuantitySold;
					String TotalAmount;
					String DiscountAmount;
					Float NetAmount;
					Float StockReceived;
					Float StockSold;
					Float StockOnHand;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + ((this.Date == null) ? 0 : this.Date.hashCode());

							result = prime * result + ((this.ProductName == null) ? 0 : this.ProductName.hashCode());

							result = prime * result
									+ ((this.ProductCategory == null) ? 0 : this.ProductCategory.hashCode());

							result = prime * result
									+ ((this.ProductSubCategory == null) ? 0 : this.ProductSubCategory.hashCode());

							result = prime * result + ((this.ProductPrice == null) ? 0 : this.ProductPrice.hashCode());

							result = prime * result + ((this.CustomerName == null) ? 0 : this.CustomerName.hashCode());

							result = prime * result
									+ ((this.CustomerEmail == null) ? 0 : this.CustomerEmail.hashCode());

							result = prime * result
									+ ((this.CustomerAddress == null) ? 0 : this.CustomerAddress.hashCode());

							result = prime * result
									+ ((this.CustomerPhone == null) ? 0 : this.CustomerPhone.hashCode());

							result = prime * result
									+ ((this.CustomerSegment == null) ? 0 : this.CustomerSegment.hashCode());

							result = prime * result + ((this.SupplierName == null) ? 0 : this.SupplierName.hashCode());

							result = prime * result
									+ ((this.SupplierLocation == null) ? 0 : this.SupplierLocation.hashCode());

							result = prime * result
									+ ((this.SupplierContact == null) ? 0 : this.SupplierContact.hashCode());

							result = prime * result + ((this.ShipperName == null) ? 0 : this.ShipperName.hashCode());

							result = prime * result
									+ ((this.ShippingMethod == null) ? 0 : this.ShippingMethod.hashCode());

							result = prime * result + ((this.QuantitySold == null) ? 0 : this.QuantitySold.hashCode());

							result = prime * result + ((this.TotalAmount == null) ? 0 : this.TotalAmount.hashCode());

							result = prime * result
									+ ((this.DiscountAmount == null) ? 0 : this.DiscountAmount.hashCode());

							result = prime * result + ((this.NetAmount == null) ? 0 : this.NetAmount.hashCode());

							result = prime * result
									+ ((this.StockReceived == null) ? 0 : this.StockReceived.hashCode());

							result = prime * result + ((this.StockSold == null) ? 0 : this.StockSold.hashCode());

							result = prime * result + ((this.StockOnHand == null) ? 0 : this.StockOnHand.hashCode());

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final KeyStruct_tUniqRow_3 other = (KeyStruct_tUniqRow_3) obj;

						if (this.Date == null) {
							if (other.Date != null)
								return false;

						} else if (!this.Date.equals(other.Date))

							return false;

						if (this.ProductName == null) {
							if (other.ProductName != null)
								return false;

						} else if (!this.ProductName.equals(other.ProductName))

							return false;

						if (this.ProductCategory == null) {
							if (other.ProductCategory != null)
								return false;

						} else if (!this.ProductCategory.equals(other.ProductCategory))

							return false;

						if (this.ProductSubCategory == null) {
							if (other.ProductSubCategory != null)
								return false;

						} else if (!this.ProductSubCategory.equals(other.ProductSubCategory))

							return false;

						if (this.ProductPrice == null) {
							if (other.ProductPrice != null)
								return false;

						} else if (!this.ProductPrice.equals(other.ProductPrice))

							return false;

						if (this.CustomerName == null) {
							if (other.CustomerName != null)
								return false;

						} else if (!this.CustomerName.equals(other.CustomerName))

							return false;

						if (this.CustomerEmail == null) {
							if (other.CustomerEmail != null)
								return false;

						} else if (!this.CustomerEmail.equals(other.CustomerEmail))

							return false;

						if (this.CustomerAddress == null) {
							if (other.CustomerAddress != null)
								return false;

						} else if (!this.CustomerAddress.equals(other.CustomerAddress))

							return false;

						if (this.CustomerPhone == null) {
							if (other.CustomerPhone != null)
								return false;

						} else if (!this.CustomerPhone.equals(other.CustomerPhone))

							return false;

						if (this.CustomerSegment == null) {
							if (other.CustomerSegment != null)
								return false;

						} else if (!this.CustomerSegment.equals(other.CustomerSegment))

							return false;

						if (this.SupplierName == null) {
							if (other.SupplierName != null)
								return false;

						} else if (!this.SupplierName.equals(other.SupplierName))

							return false;

						if (this.SupplierLocation == null) {
							if (other.SupplierLocation != null)
								return false;

						} else if (!this.SupplierLocation.equals(other.SupplierLocation))

							return false;

						if (this.SupplierContact == null) {
							if (other.SupplierContact != null)
								return false;

						} else if (!this.SupplierContact.equals(other.SupplierContact))

							return false;

						if (this.ShipperName == null) {
							if (other.ShipperName != null)
								return false;

						} else if (!this.ShipperName.equals(other.ShipperName))

							return false;

						if (this.ShippingMethod == null) {
							if (other.ShippingMethod != null)
								return false;

						} else if (!this.ShippingMethod.equals(other.ShippingMethod))

							return false;

						if (this.QuantitySold == null) {
							if (other.QuantitySold != null)
								return false;

						} else if (!this.QuantitySold.equals(other.QuantitySold))

							return false;

						if (this.TotalAmount == null) {
							if (other.TotalAmount != null)
								return false;

						} else if (!this.TotalAmount.equals(other.TotalAmount))

							return false;

						if (this.DiscountAmount == null) {
							if (other.DiscountAmount != null)
								return false;

						} else if (!this.DiscountAmount.equals(other.DiscountAmount))

							return false;

						if (this.NetAmount == null) {
							if (other.NetAmount != null)
								return false;

						} else if (!this.NetAmount.equals(other.NetAmount))

							return false;

						if (this.StockReceived == null) {
							if (other.StockReceived != null)
								return false;

						} else if (!this.StockReceived.equals(other.StockReceived))

							return false;

						if (this.StockSold == null) {
							if (other.StockSold != null)
								return false;

						} else if (!this.StockSold.equals(other.StockSold))

							return false;

						if (this.StockOnHand == null) {
							if (other.StockOnHand != null)
								return false;

						} else if (!this.StockOnHand.equals(other.StockOnHand))

							return false;

						return true;
					}

				}

				int nb_uniques_tUniqRow_3 = 0;
				int nb_duplicates_tUniqRow_3 = 0;
				KeyStruct_tUniqRow_3 finder_tUniqRow_3 = new KeyStruct_tUniqRow_3();
				java.util.Set<KeyStruct_tUniqRow_3> keystUniqRow_3 = new java.util.HashSet<KeyStruct_tUniqRow_3>();

				/**
				 * [tUniqRow_3 begin ] stop
				 */

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
						.decryptPassword("enc:routine.encryption.key.v1:XN/AmQ7Rft/5Gsq1C33HWiQQcOFsWFN5I4SSKco1GsI=");

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

						if (colQtyInRs_tDBInput_1 < 1) {
							row15.Date = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.Date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.Date = tmpContent_tDBInput_1;
								}
							} else {
								row15.Date = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row15.ProductName = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.ProductName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.ProductName = tmpContent_tDBInput_1;
								}
							} else {
								row15.ProductName = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row15.ProductCategory = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.ProductCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.ProductCategory = tmpContent_tDBInput_1;
								}
							} else {
								row15.ProductCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row15.ProductSubCategory = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.ProductSubCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.ProductSubCategory = tmpContent_tDBInput_1;
								}
							} else {
								row15.ProductSubCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row15.ProductPrice = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.ProductPrice = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.ProductPrice = tmpContent_tDBInput_1;
								}
							} else {
								row15.ProductPrice = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row15.CustomerName = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.CustomerName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.CustomerName = tmpContent_tDBInput_1;
								}
							} else {
								row15.CustomerName = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row15.CustomerEmail = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.CustomerEmail = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.CustomerEmail = tmpContent_tDBInput_1;
								}
							} else {
								row15.CustomerEmail = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							row15.CustomerAddress = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.CustomerAddress = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.CustomerAddress = tmpContent_tDBInput_1;
								}
							} else {
								row15.CustomerAddress = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							row15.CustomerPhone = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(9);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.CustomerPhone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.CustomerPhone = tmpContent_tDBInput_1;
								}
							} else {
								row15.CustomerPhone = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 10) {
							row15.CustomerSegment = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(10);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.CustomerSegment = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.CustomerSegment = tmpContent_tDBInput_1;
								}
							} else {
								row15.CustomerSegment = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 11) {
							row15.SupplierName = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.SupplierName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.SupplierName = tmpContent_tDBInput_1;
								}
							} else {
								row15.SupplierName = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 12) {
							row15.SupplierLocation = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(12);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.SupplierLocation = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.SupplierLocation = tmpContent_tDBInput_1;
								}
							} else {
								row15.SupplierLocation = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 13) {
							row15.SupplierContact = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(13);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.SupplierContact = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.SupplierContact = tmpContent_tDBInput_1;
								}
							} else {
								row15.SupplierContact = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 14) {
							row15.ShipperName = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(14);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.ShipperName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.ShipperName = tmpContent_tDBInput_1;
								}
							} else {
								row15.ShipperName = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 15) {
							row15.ShippingMethod = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(15);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.ShippingMethod = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.ShippingMethod = tmpContent_tDBInput_1;
								}
							} else {
								row15.ShippingMethod = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 16) {
							row15.QuantitySold = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(16);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(16).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.QuantitySold = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.QuantitySold = tmpContent_tDBInput_1;
								}
							} else {
								row15.QuantitySold = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 17) {
							row15.TotalAmount = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(17);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(17).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.TotalAmount = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.TotalAmount = tmpContent_tDBInput_1;
								}
							} else {
								row15.TotalAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 18) {
							row15.DiscountAmount = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(18);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(18).toUpperCase(java.util.Locale.ENGLISH))) {
									row15.DiscountAmount = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row15.DiscountAmount = tmpContent_tDBInput_1;
								}
							} else {
								row15.DiscountAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 19) {
							row15.NetAmount = null;
						} else {

							row15.NetAmount = rs_tDBInput_1.getFloat(19);
							if (rs_tDBInput_1.wasNull()) {
								row15.NetAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 20) {
							row15.StockReceived = null;
						} else {

							row15.StockReceived = rs_tDBInput_1.getFloat(20);
							if (rs_tDBInput_1.wasNull()) {
								row15.StockReceived = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 21) {
							row15.StockSold = null;
						} else {

							row15.StockSold = rs_tDBInput_1.getFloat(21);
							if (rs_tDBInput_1.wasNull()) {
								row15.StockSold = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 22) {
							row15.StockOnHand = null;
						} else {

							row15.StockOnHand = rs_tDBInput_1.getFloat(22);
							if (rs_tDBInput_1.wasNull()) {
								row15.StockOnHand = null;
							}
						}

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
						 * [tUniqRow_3 main ] start
						 */

						currentComponent = "tUniqRow_3";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row15"

							);
						}

						row16 = null;
						if (row15.Date == null) {
							finder_tUniqRow_3.Date = null;
						} else {
							finder_tUniqRow_3.Date = row15.Date.toLowerCase();
						}
						if (row15.ProductName == null) {
							finder_tUniqRow_3.ProductName = null;
						} else {
							finder_tUniqRow_3.ProductName = row15.ProductName.toLowerCase();
						}
						if (row15.ProductCategory == null) {
							finder_tUniqRow_3.ProductCategory = null;
						} else {
							finder_tUniqRow_3.ProductCategory = row15.ProductCategory.toLowerCase();
						}
						if (row15.ProductSubCategory == null) {
							finder_tUniqRow_3.ProductSubCategory = null;
						} else {
							finder_tUniqRow_3.ProductSubCategory = row15.ProductSubCategory.toLowerCase();
						}
						if (row15.ProductPrice == null) {
							finder_tUniqRow_3.ProductPrice = null;
						} else {
							finder_tUniqRow_3.ProductPrice = row15.ProductPrice.toLowerCase();
						}
						if (row15.CustomerName == null) {
							finder_tUniqRow_3.CustomerName = null;
						} else {
							finder_tUniqRow_3.CustomerName = row15.CustomerName.toLowerCase();
						}
						if (row15.CustomerEmail == null) {
							finder_tUniqRow_3.CustomerEmail = null;
						} else {
							finder_tUniqRow_3.CustomerEmail = row15.CustomerEmail.toLowerCase();
						}
						if (row15.CustomerAddress == null) {
							finder_tUniqRow_3.CustomerAddress = null;
						} else {
							finder_tUniqRow_3.CustomerAddress = row15.CustomerAddress.toLowerCase();
						}
						if (row15.CustomerPhone == null) {
							finder_tUniqRow_3.CustomerPhone = null;
						} else {
							finder_tUniqRow_3.CustomerPhone = row15.CustomerPhone.toLowerCase();
						}
						if (row15.CustomerSegment == null) {
							finder_tUniqRow_3.CustomerSegment = null;
						} else {
							finder_tUniqRow_3.CustomerSegment = row15.CustomerSegment.toLowerCase();
						}
						if (row15.SupplierName == null) {
							finder_tUniqRow_3.SupplierName = null;
						} else {
							finder_tUniqRow_3.SupplierName = row15.SupplierName.toLowerCase();
						}
						if (row15.SupplierLocation == null) {
							finder_tUniqRow_3.SupplierLocation = null;
						} else {
							finder_tUniqRow_3.SupplierLocation = row15.SupplierLocation.toLowerCase();
						}
						if (row15.SupplierContact == null) {
							finder_tUniqRow_3.SupplierContact = null;
						} else {
							finder_tUniqRow_3.SupplierContact = row15.SupplierContact.toLowerCase();
						}
						if (row15.ShipperName == null) {
							finder_tUniqRow_3.ShipperName = null;
						} else {
							finder_tUniqRow_3.ShipperName = row15.ShipperName.toLowerCase();
						}
						if (row15.ShippingMethod == null) {
							finder_tUniqRow_3.ShippingMethod = null;
						} else {
							finder_tUniqRow_3.ShippingMethod = row15.ShippingMethod.toLowerCase();
						}
						if (row15.QuantitySold == null) {
							finder_tUniqRow_3.QuantitySold = null;
						} else {
							finder_tUniqRow_3.QuantitySold = row15.QuantitySold.toLowerCase();
						}
						if (row15.TotalAmount == null) {
							finder_tUniqRow_3.TotalAmount = null;
						} else {
							finder_tUniqRow_3.TotalAmount = row15.TotalAmount.toLowerCase();
						}
						if (row15.DiscountAmount == null) {
							finder_tUniqRow_3.DiscountAmount = null;
						} else {
							finder_tUniqRow_3.DiscountAmount = row15.DiscountAmount.toLowerCase();
						}
						finder_tUniqRow_3.NetAmount = row15.NetAmount;
						finder_tUniqRow_3.StockReceived = row15.StockReceived;
						finder_tUniqRow_3.StockSold = row15.StockSold;
						finder_tUniqRow_3.StockOnHand = row15.StockOnHand;
						finder_tUniqRow_3.hashCodeDirty = true;
						if (!keystUniqRow_3.contains(finder_tUniqRow_3)) {
							KeyStruct_tUniqRow_3 new_tUniqRow_3 = new KeyStruct_tUniqRow_3();

							if (row15.Date == null) {
								new_tUniqRow_3.Date = null;
							} else {
								new_tUniqRow_3.Date = row15.Date.toLowerCase();
							}
							if (row15.ProductName == null) {
								new_tUniqRow_3.ProductName = null;
							} else {
								new_tUniqRow_3.ProductName = row15.ProductName.toLowerCase();
							}
							if (row15.ProductCategory == null) {
								new_tUniqRow_3.ProductCategory = null;
							} else {
								new_tUniqRow_3.ProductCategory = row15.ProductCategory.toLowerCase();
							}
							if (row15.ProductSubCategory == null) {
								new_tUniqRow_3.ProductSubCategory = null;
							} else {
								new_tUniqRow_3.ProductSubCategory = row15.ProductSubCategory.toLowerCase();
							}
							if (row15.ProductPrice == null) {
								new_tUniqRow_3.ProductPrice = null;
							} else {
								new_tUniqRow_3.ProductPrice = row15.ProductPrice.toLowerCase();
							}
							if (row15.CustomerName == null) {
								new_tUniqRow_3.CustomerName = null;
							} else {
								new_tUniqRow_3.CustomerName = row15.CustomerName.toLowerCase();
							}
							if (row15.CustomerEmail == null) {
								new_tUniqRow_3.CustomerEmail = null;
							} else {
								new_tUniqRow_3.CustomerEmail = row15.CustomerEmail.toLowerCase();
							}
							if (row15.CustomerAddress == null) {
								new_tUniqRow_3.CustomerAddress = null;
							} else {
								new_tUniqRow_3.CustomerAddress = row15.CustomerAddress.toLowerCase();
							}
							if (row15.CustomerPhone == null) {
								new_tUniqRow_3.CustomerPhone = null;
							} else {
								new_tUniqRow_3.CustomerPhone = row15.CustomerPhone.toLowerCase();
							}
							if (row15.CustomerSegment == null) {
								new_tUniqRow_3.CustomerSegment = null;
							} else {
								new_tUniqRow_3.CustomerSegment = row15.CustomerSegment.toLowerCase();
							}
							if (row15.SupplierName == null) {
								new_tUniqRow_3.SupplierName = null;
							} else {
								new_tUniqRow_3.SupplierName = row15.SupplierName.toLowerCase();
							}
							if (row15.SupplierLocation == null) {
								new_tUniqRow_3.SupplierLocation = null;
							} else {
								new_tUniqRow_3.SupplierLocation = row15.SupplierLocation.toLowerCase();
							}
							if (row15.SupplierContact == null) {
								new_tUniqRow_3.SupplierContact = null;
							} else {
								new_tUniqRow_3.SupplierContact = row15.SupplierContact.toLowerCase();
							}
							if (row15.ShipperName == null) {
								new_tUniqRow_3.ShipperName = null;
							} else {
								new_tUniqRow_3.ShipperName = row15.ShipperName.toLowerCase();
							}
							if (row15.ShippingMethod == null) {
								new_tUniqRow_3.ShippingMethod = null;
							} else {
								new_tUniqRow_3.ShippingMethod = row15.ShippingMethod.toLowerCase();
							}
							if (row15.QuantitySold == null) {
								new_tUniqRow_3.QuantitySold = null;
							} else {
								new_tUniqRow_3.QuantitySold = row15.QuantitySold.toLowerCase();
							}
							if (row15.TotalAmount == null) {
								new_tUniqRow_3.TotalAmount = null;
							} else {
								new_tUniqRow_3.TotalAmount = row15.TotalAmount.toLowerCase();
							}
							if (row15.DiscountAmount == null) {
								new_tUniqRow_3.DiscountAmount = null;
							} else {
								new_tUniqRow_3.DiscountAmount = row15.DiscountAmount.toLowerCase();
							}
							new_tUniqRow_3.NetAmount = row15.NetAmount;
							new_tUniqRow_3.StockReceived = row15.StockReceived;
							new_tUniqRow_3.StockSold = row15.StockSold;
							new_tUniqRow_3.StockOnHand = row15.StockOnHand;

							keystUniqRow_3.add(new_tUniqRow_3);
							if (row16 == null) {

								row16 = new row16Struct();
							}
							row16.Date = row15.Date;
							row16.ProductName = row15.ProductName;
							row16.ProductCategory = row15.ProductCategory;
							row16.ProductSubCategory = row15.ProductSubCategory;
							row16.ProductPrice = row15.ProductPrice;
							row16.CustomerName = row15.CustomerName;
							row16.CustomerEmail = row15.CustomerEmail;
							row16.CustomerAddress = row15.CustomerAddress;
							row16.CustomerPhone = row15.CustomerPhone;
							row16.CustomerSegment = row15.CustomerSegment;
							row16.SupplierName = row15.SupplierName;
							row16.SupplierLocation = row15.SupplierLocation;
							row16.SupplierContact = row15.SupplierContact;
							row16.ShipperName = row15.ShipperName;
							row16.ShippingMethod = row15.ShippingMethod;
							row16.QuantitySold = row15.QuantitySold;
							row16.TotalAmount = row15.TotalAmount;
							row16.DiscountAmount = row15.DiscountAmount;
							row16.NetAmount = row15.NetAmount;
							row16.StockReceived = row15.StockReceived;
							row16.StockSold = row15.StockSold;
							row16.StockOnHand = row15.StockOnHand;
							nb_uniques_tUniqRow_3++;
						} else {
							nb_duplicates_tUniqRow_3++;
						}

						tos_count_tUniqRow_3++;

						/**
						 * [tUniqRow_3 main ] stop
						 */

						/**
						 * [tUniqRow_3 process_data_begin ] start
						 */

						currentComponent = "tUniqRow_3";

						/**
						 * [tUniqRow_3 process_data_begin ] stop
						 */
// Start of branch "row16"
						if (row16 != null) {

							/**
							 * [tMap_5 main ] start
							 */

							currentComponent = "tMap_5";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row16"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_5 = false;
							boolean mainRowRejected_tMap_5 = false;

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_5__Struct Var = Var__tMap_5;// ###############################
								// ###############################
								// # Output tables

								out4 = null;

// # Output table : 'out4'
								out4_tmp.Date = TalendDate
										.parseDate(StringHandling.LEFT(row16.Date, 4).matches("\\d{4}") ? "yyyy-MM-dd"
												: (row16.Date.substring(2, 3).equals("-") ? "MM-dd-yyyy"
														: "dd-MM-yyyy"),
												row16.Date);
								out4_tmp.ProductName = row16.ProductName;
								out4_tmp.ProductCategory = (row16.ProductSubCategory.equals("Headphones")
										? "Electronics"
										: (row16.ProductSubCategory.equals("Mobile") ? "Electronics"
												: (row16.ProductSubCategory.equals("Camera") ? "Electronics"
														: (row16.ProductSubCategory.equals("Academic") ? "Books"
																: (row16.ProductSubCategory.equals("Fiction") ? "Books"
																		: (row16.ProductSubCategory
																				.equals("Non-fiction")
																						? "Books"
																						: (row16.ProductSubCategory
																								.equals("Shirt")
																										? "Clothing"
																										: (row16.ProductSubCategory
																												.equals("Educational")
																														? "Toys"
																														: (row16.ProductSubCategory
																																.equals("Dolls")
																																		? "Toys"
																																		: (row16.ProductSubCategory
																																				.equals("Action Figures")
																																						? "Toys"
																																						: (row16.ProductSubCategory
																																								.equals("Gardening Tools")
																																										? "Home & Garden"
																																										: (row16.ProductSubCategory
																																												.equals("Decor")
																																														? "Home & Garden"
																																														: (row16.ProductSubCategory
																																																.equals("Furniture")
																																																		? "Home & Garden"
																																																		: "Other")))))))))))));
								out4_tmp.ProductSubCategory = row16.ProductSubCategory;
								out4_tmp.ProductPrice = Float.valueOf(row16.TotalAmount)
										/ Integer.valueOf(row16.QuantitySold);
								out4_tmp.CustomerName = row16.CustomerName;
								out4_tmp.CustomerEmail = row16.CustomerEmail;
								out4_tmp.CustomerAddress = row16.CustomerAddress;
								out4_tmp.CustomerPhone = row16.CustomerPhone;
								out4_tmp.CustomerSegment = row16.CustomerSegment;
								out4_tmp.SupplierName = row16.SupplierName;
								out4_tmp.SupplierLocation = row16.SupplierLocation;
								out4_tmp.SupplierContact = row16.SupplierContact;
								out4_tmp.ShipperName = row16.ShipperName;
								out4_tmp.ShippingMethod = row16.ShippingMethod;
								out4_tmp.QuantitySold = row16.QuantitySold;
								out4_tmp.TotalAmount = row16.TotalAmount;
								out4_tmp.DiscountAmount = row16.DiscountAmount;
								out4_tmp.NetAmount = row16.NetAmount;
								out4_tmp.StockReceived = row16.StockReceived;
								out4_tmp.StockSold = row16.StockSold;
								out4_tmp.StockOnHand = row16.StockOnHand;
								out4 = out4_tmp;
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_5 = false;

							tos_count_tMap_5++;

							/**
							 * [tMap_5 main ] stop
							 */

							/**
							 * [tMap_5 process_data_begin ] start
							 */

							currentComponent = "tMap_5";

							/**
							 * [tMap_5 process_data_begin ] stop
							 */
// Start of branch "out4"
							if (out4 != null) {

								/**
								 * [tMap_11 main ] start
								 */

								currentComponent = "tMap_11";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "out4"

									);
								}

								boolean hasCasePrimitiveKeyWithNull_tMap_11 = false;

								// ###############################
								// # Input tables (lookups)
								boolean rejectedInnerJoin_tMap_11 = false;
								boolean mainRowRejected_tMap_11 = false;

								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_11__Struct Var = Var__tMap_11;// ###############################
									// ###############################
									// # Output tables

									out7 = null;

// # Output table : 'out7'
									out7_tmp.Date = TalendDate.formatDate("yyyy-MM-dd", out4.Date);
									out7_tmp.ProductName = (out4.ProductCategory.equals("Electronics")
											&& out4.ProductSubCategory.equals("Headphones")
											&& out4.ProductName.equals("NonExistentProduct")
											&& (out4.ProductPrice > (185.942954 - 69.430179)
													&& out4.ProductPrice < (185.942954 + 69.430179)))
															? "Kristine"
															: (out4.ProductCategory.equals("Electronics")
																	&& out4.ProductSubCategory.equals("Headphones")
																	&& out4.ProductName.equals("NonExistentProduct")
																	&& (out4.ProductPrice > (377.444337 - 140.092750)
																			&& out4.ProductPrice < (377.444337
																					+ 140.092750)))
																							? "Shawn"
																							: (out4.ProductCategory
																									.equals("Electronics")
																									&& out4.ProductSubCategory
																											.equals("Headphones")
																									&& out4.ProductName
																											.equals("NonExistentProduct")
																									&& (out4.ProductPrice > (523.756141
																											- 204.923598)
																											&& out4.ProductPrice < (523.756141
																													+ 204.923598)))
																															? "Justin"
																															: (out4.ProductCategory
																																	.equals("Electronics")
																																	&& out4.ProductSubCategory
																																			.equals("Headphones")
																																	&& out4.ProductName
																																			.equals("NonExistentProduct")
																																	&& (out4.ProductPrice > (500.691539
																																			- 210.346327)
																																			&& out4.ProductPrice < (500.691539
																																					+ 210.346327)))
																																							? "Pamela"
																																							: (out4.ProductCategory
																																									.equals("Electronics")
																																									&& out4.ProductSubCategory
																																											.equals("Headphones")
																																									&& out4.ProductName
																																											.equals("NonExistentProduct")
																																									&& (out4.ProductPrice > (722.857148
																																											- 255.970663)
																																											&& out4.ProductPrice < (722.857148
																																													+ 255.970663)))
																																															? "Cynthia"
																																															: (out4.ProductCategory
																																																	.equals("Books")
																																																	&& out4.ProductSubCategory
																																																			.equals("Fiction")
																																																	&& out4.ProductPrice < 365.528403)
																																																			? "Martha"
																																																			: (out4.ProductCategory
																																																					.equals("Books")
																																																					&& out4.ProductSubCategory
																																																							.equals("Fiction")
																																																					&& out4.ProductPrice > 365.528403)
																																																							? "Jamie"
																																																							: (out4.ProductCategory
																																																									.equals("Books")
																																																									&& out4.ProductSubCategory
																																																											.equals("Academic")
																																																									&& (out4.ProductPrice > (551.970143
																																																											- 218.841416)
																																																											&& out4.ProductPrice < (551.970143
																																																													+ 218.841416)))
																																																															? "Anthony"
																																																															: (out4.ProductCategory
																																																																	.equals("Books")
																																																																	&& out4.ProductSubCategory
																																																																			.equals("Academic")
																																																																	&& (out4.ProductPrice > (786.051051
																																																																			- 286.436536)
																																																																			&& out4.ProductPrice < (786.051051
																																																																					+ 286.436536)))
																																																																							? "Fred"
																																																																							: (out4.ProductCategory
																																																																									.equals("Books")
																																																																									&& out4.ProductSubCategory
																																																																											.equals("Non-fiction"))
																																																																													? "Katie"
																																																																													: (out4.ProductCategory
																																																																															.equals("Toys")
																																																																															&& out4.ProductSubCategory
																																																																																	.equals("Educational"))
																																																																																			? "Wanda"
																																																																																			: (out4.ProductCategory
																																																																																					.equals("Toys")
																																																																																					&& out4.ProductSubCategory
																																																																																							.equals("Action Figures"))
																																																																																									? "Angela"
																																																																																									: (out4.ProductCategory
																																																																																											.equals("Toys")
																																																																																											&& out4.ProductSubCategory
																																																																																													.equals("Dolls"))
																																																																																															? "Michael"
																																																																																															: (out4.ProductCategory
																																																																																																	.equals("Home & Garden")
																																																																																																	&& out4.ProductSubCategory
																																																																																																			.equals("Decor"))
																																																																																																					? "Amy"
																																																																																																					: (out4.ProductCategory
																																																																																																							.equals("Home & Garden")
																																																																																																							&& out4.ProductSubCategory
																																																																																																									.equals("Gardening Tools"))
																																																																																																											? "Shannon"
																																																																																																											: (out4.ProductCategory
																																																																																																													.equals("Home & Garden")
																																																																																																													&& out4.ProductSubCategory
																																																																																																															.equals("Furniture"))
																																																																																																																	? "Tammy"
																																																																																																																	: (out4.ProductCategory
																																																																																																																			.equals("Clothing")
																																																																																																																			&& out4.ProductSubCategory
																																																																																																																					.equals("Shirt")
																																																																																																																			&& (out4.ProductPrice > (656.128275
																																																																																																																					- 260.997343)
																																																																																																																					&& out4.ProductPrice < (656.128275
																																																																																																																							+ 260.997343)))
																																																																																																																									? "Elizabeth"
																																																																																																																									: "Marvin";
									;
									out7_tmp.ProductCategory = out4.ProductCategory;
									out7_tmp.ProductSubCategory = out4.ProductSubCategory;
									out7_tmp.ProductPrice = out4.ProductPrice;
									out7_tmp.CustomerName = out4.CustomerName;
									out7_tmp.CustomerEmail = out4.CustomerEmail;
									out7_tmp.CustomerAddress = out4.CustomerAddress;
									out7_tmp.CustomerPhone = out4.CustomerPhone.replace("x", "-");
									out7_tmp.CustomerSegment = out4.CustomerSegment;
									out7_tmp.SupplierName = out4.SupplierName;
									out7_tmp.SupplierLocation = out4.SupplierLocation;
									out7_tmp.SupplierContact = out4.SupplierContact;
									out7_tmp.ShipperName = out4.ShipperName;
									out7_tmp.ShippingMethod = out4.ShippingMethod;
									out7_tmp.QuantitySold = out4.QuantitySold;
									out7_tmp.TotalAmount = out4.TotalAmount;
									out7_tmp.DiscountAmount = out4.DiscountAmount;
									out7_tmp.NetAmount = out4.NetAmount;
									out7_tmp.StockReceived = out4.StockReceived;
									out7_tmp.StockSold = out4.StockSold;
									out7_tmp.StockOnHand = out4.StockOnHand;
									out7 = out7_tmp;
// ###############################

								} // end of Var scope

								rejectedInnerJoin_tMap_11 = false;

								tos_count_tMap_11++;

								/**
								 * [tMap_11 main ] stop
								 */

								/**
								 * [tMap_11 process_data_begin ] start
								 */

								currentComponent = "tMap_11";

								/**
								 * [tMap_11 process_data_begin ] stop
								 */
// Start of branch "out7"
								if (out7 != null) {

									/**
									 * [tMap_6 main ] start
									 */

									currentComponent = "tMap_6";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "out7"

										);
									}

									boolean hasCasePrimitiveKeyWithNull_tMap_6 = false;

									// ###############################
									// # Input tables (lookups)
									boolean rejectedInnerJoin_tMap_6 = false;
									boolean mainRowRejected_tMap_6 = false;

									// ###############################
									{ // start of Var scope

										// ###############################
										// # Vars tables

										Var__tMap_6__Struct Var = Var__tMap_6;
										Var.id_pro = Math
												.abs((out7.ProductName + out7.ProductCategory + out7.ProductSubCategory
														+ String.valueOf(out7.ProductPrice)).hashCode() % 10000);
										Var.id_shipping = Math.abs((out7.ShipperName + out7.ShippingMethod).hashCode())
												% 10000 + 1;
										Var.id_supplier = Math
												.abs((out7.SupplierName + out7.SupplierContact + out7.SupplierLocation)
														.hashCode() % 10000 + 1);
										Var.id_costumer = Math
												.abs(((out7.CustomerEmail != null && !out7.CustomerEmail.isEmpty()
														? out7.CustomerEmail.substring(0,
																Math.min(3, out7.CustomerEmail.length()))
														: "0000") +

														(out7.CustomerName != null && !out7.CustomerName.isEmpty()
																? out7.CustomerName.substring(0,
																		Math.min(3, out7.CustomerName.length()))
																: "0000")
														+

														(out7.CustomerAddress != null && !out7.CustomerAddress.isEmpty()
																? out7.CustomerAddress.substring(0,
																		Math.min(3, out7.CustomerAddress.length()))
																: "0000")
														+ ((out7.CustomerPhone != null && !out7.CustomerPhone.isEmpty()
																? out7.CustomerPhone.substring(0,
																		Math.min(3, out7.CustomerPhone.length()))
																: "0000"))

												).hashCode()) % 100000 + 1;
										Var.id_date = Math.abs(out7.Date.hashCode() % 10000 + 1);// ###############################
										// ###############################
										// # Output tables

										row27 = null;

// # Output table : 'row27'
										row27_tmp.ProductName = out7.ProductName;
										row27_tmp.ProductCategory = out7.ProductCategory;
										row27_tmp.ProductSubCategory = out7.ProductSubCategory;
										row27_tmp.ProductPrice = out7.ProductPrice;
										row27_tmp.Date = out7.Date;
										row27_tmp.CustomerName = out7.CustomerName;
										row27_tmp.CustomerEmail = out7.CustomerEmail;
										row27_tmp.CustomerAddress = out7.CustomerAddress;
										row27_tmp.CustomerPhone = out7.CustomerPhone;
										row27_tmp.CustomerSegment = out7.CustomerSegment;
										row27_tmp.SupplierName = out7.SupplierName;
										row27_tmp.SupplierLocation = out7.SupplierLocation;
										row27_tmp.SupplierContact = out7.SupplierContact;
										row27_tmp.ShipperName = out7.ShipperName;
										row27_tmp.ShippingMethod = out7.ShippingMethod;
										row27_tmp.QuantitySold = Integer.valueOf(out7.QuantitySold);
										row27_tmp.TotalAmount = Float.valueOf(out7.TotalAmount);
										row27_tmp.DiscountAmount = Float.valueOf(out7.DiscountAmount);
										row27_tmp.NetAmount = out7.NetAmount;
										row27_tmp.StockReceived = out7.StockReceived;
										row27_tmp.StockSold = out7.StockSold;
										row27_tmp.StockOnHand = out7.StockOnHand;
										row27_tmp.id_pro = Var.id_pro;
										row27_tmp.id_shipping = Var.id_shipping;
										row27_tmp.id_supplier = Var.id_supplier;
										row27_tmp.id_costumer = Var.id_costumer;
										row27_tmp.id_date = Var.id_date;
										row27 = row27_tmp;
// ###############################

									} // end of Var scope

									rejectedInnerJoin_tMap_6 = false;

									tos_count_tMap_6++;

									/**
									 * [tMap_6 main ] stop
									 */

									/**
									 * [tMap_6 process_data_begin ] start
									 */

									currentComponent = "tMap_6";

									/**
									 * [tMap_6 process_data_begin ] stop
									 */
// Start of branch "row27"
									if (row27 != null) {

										/**
										 * [tDBOutput_1 main ] start
										 */

										currentComponent = "tDBOutput_1";

										if (execStat) {
											runStat.updateStatOnConnection(iterateId, 1, 1

													, "row27"

											);
										}

										whetherReject_tDBOutput_1 = false;
										if (row27.ProductName == null) {
											pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(1, row27.ProductName);
										}

										if (row27.ProductCategory == null) {
											pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(2, row27.ProductCategory);
										}

										if (row27.ProductSubCategory == null) {
											pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(3, row27.ProductSubCategory);
										}

										if (row27.ProductPrice == null) {
											pstmt_tDBOutput_1.setNull(4, java.sql.Types.FLOAT);
										} else {
											pstmt_tDBOutput_1.setFloat(4, row27.ProductPrice);
										}

										if (row27.Date == null) {
											pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(5, row27.Date);
										}

										if (row27.CustomerName == null) {
											pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(6, row27.CustomerName);
										}

										if (row27.CustomerEmail == null) {
											pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(7, row27.CustomerEmail);
										}

										if (row27.CustomerAddress == null) {
											pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(8, row27.CustomerAddress);
										}

										if (row27.CustomerPhone == null) {
											pstmt_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(9, row27.CustomerPhone);
										}

										if (row27.CustomerSegment == null) {
											pstmt_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(10, row27.CustomerSegment);
										}

										if (row27.SupplierName == null) {
											pstmt_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(11, row27.SupplierName);
										}

										if (row27.SupplierLocation == null) {
											pstmt_tDBOutput_1.setNull(12, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(12, row27.SupplierLocation);
										}

										if (row27.SupplierContact == null) {
											pstmt_tDBOutput_1.setNull(13, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(13, row27.SupplierContact);
										}

										if (row27.ShipperName == null) {
											pstmt_tDBOutput_1.setNull(14, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(14, row27.ShipperName);
										}

										if (row27.ShippingMethod == null) {
											pstmt_tDBOutput_1.setNull(15, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(15, row27.ShippingMethod);
										}

										if (row27.QuantitySold == null) {
											pstmt_tDBOutput_1.setNull(16, java.sql.Types.INTEGER);
										} else {
											pstmt_tDBOutput_1.setInt(16, row27.QuantitySold);
										}

										if (row27.TotalAmount == null) {
											pstmt_tDBOutput_1.setNull(17, java.sql.Types.FLOAT);
										} else {
											pstmt_tDBOutput_1.setFloat(17, row27.TotalAmount);
										}

										if (row27.DiscountAmount == null) {
											pstmt_tDBOutput_1.setNull(18, java.sql.Types.FLOAT);
										} else {
											pstmt_tDBOutput_1.setFloat(18, row27.DiscountAmount);
										}

										if (row27.NetAmount == null) {
											pstmt_tDBOutput_1.setNull(19, java.sql.Types.FLOAT);
										} else {
											pstmt_tDBOutput_1.setFloat(19, row27.NetAmount);
										}

										if (row27.StockReceived == null) {
											pstmt_tDBOutput_1.setNull(20, java.sql.Types.FLOAT);
										} else {
											pstmt_tDBOutput_1.setFloat(20, row27.StockReceived);
										}

										if (row27.StockSold == null) {
											pstmt_tDBOutput_1.setNull(21, java.sql.Types.FLOAT);
										} else {
											pstmt_tDBOutput_1.setFloat(21, row27.StockSold);
										}

										if (row27.StockOnHand == null) {
											pstmt_tDBOutput_1.setNull(22, java.sql.Types.FLOAT);
										} else {
											pstmt_tDBOutput_1.setFloat(22, row27.StockOnHand);
										}

										pstmt_tDBOutput_1.setInt(23, row27.id_pro);

										pstmt_tDBOutput_1.setInt(24, row27.id_shipping);

										pstmt_tDBOutput_1.setInt(25, row27.id_supplier);

										pstmt_tDBOutput_1.setInt(26, row27.id_costumer);

										pstmt_tDBOutput_1.setInt(27, row27.id_date);

										pstmt_tDBOutput_1.addBatch();
										nb_line_tDBOutput_1++;

										batchSizeCounter_tDBOutput_1++;

										if (!whetherReject_tDBOutput_1) {
										}
										////////// batch execute by batch size///////
										class LimitBytesHelper_tDBOutput_1 {
											public int limitBytePart1(int counter,
													java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
												try {

													for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
														if (countEach_tDBOutput_1 == -2
																|| countEach_tDBOutput_1 == -3) {
															break;
														}
														counter += countEach_tDBOutput_1;
													}

												} catch (java.sql.BatchUpdateException e) {
													globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

													throw (e);

												}
												return counter;
											}

											public int limitBytePart2(int counter,
													java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
												try {

													for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
														if (countEach_tDBOutput_1 == -2
																|| countEach_tDBOutput_1 == -3) {
															break;
														}
														counter += countEach_tDBOutput_1;
													}

												} catch (java.sql.BatchUpdateException e) {
													globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

													throw (e);

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

									} // End of branch "row27"

									/**
									 * [tMap_6 process_data_end ] start
									 */

									currentComponent = "tMap_6";

									/**
									 * [tMap_6 process_data_end ] stop
									 */

								} // End of branch "out7"

								/**
								 * [tMap_11 process_data_end ] start
								 */

								currentComponent = "tMap_11";

								/**
								 * [tMap_11 process_data_end ] stop
								 */

							} // End of branch "out4"

							/**
							 * [tMap_5 process_data_end ] start
							 */

							currentComponent = "tMap_5";

							/**
							 * [tMap_5 process_data_end ] stop
							 */

						} // End of branch "row16"

						/**
						 * [tUniqRow_3 process_data_end ] start
						 */

						currentComponent = "tUniqRow_3";

						/**
						 * [tUniqRow_3 process_data_end ] stop
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

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tUniqRow_3 end ] start
				 */

				currentComponent = "tUniqRow_3";

				globalMap.put("tUniqRow_3_NB_UNIQUES", nb_uniques_tUniqRow_3);
				globalMap.put("tUniqRow_3_NB_DUPLICATES", nb_duplicates_tUniqRow_3);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row15");
				}

				ok_Hash.put("tUniqRow_3", true);
				end_Hash.put("tUniqRow_3", System.currentTimeMillis());

				/**
				 * [tUniqRow_3 end ] stop
				 */

				/**
				 * [tMap_5 end ] start
				 */

				currentComponent = "tMap_5";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row16");
				}

				ok_Hash.put("tMap_5", true);
				end_Hash.put("tMap_5", System.currentTimeMillis());

				/**
				 * [tMap_5 end ] stop
				 */

				/**
				 * [tMap_11 end ] start
				 */

				currentComponent = "tMap_11";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out4");
				}

				ok_Hash.put("tMap_11", true);
				end_Hash.put("tMap_11", System.currentTimeMillis());

				/**
				 * [tMap_11 end ] stop
				 */

				/**
				 * [tMap_6 end ] start
				 */

				currentComponent = "tMap_6";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out7");
				}

				ok_Hash.put("tMap_6", true);
				end_Hash.put("tMap_6", System.currentTimeMillis());

				/**
				 * [tMap_6 end ] stop
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

					throw (e);

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
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row27");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk15", 0, "ok");
				}
				tDBInput_8Process(globalMap);
				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk11", 0, "ok");
				}
				tDBInput_5Process(globalMap);
				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk10", 0, "ok");
				}
				tCreateTable_9Process(globalMap);

				/**
				 * [tDBOutput_1 end ] stop
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

				/**
				 * [tUniqRow_3 finally ] start
				 */

				currentComponent = "tUniqRow_3";

				/**
				 * [tUniqRow_3 finally ] stop
				 */

				/**
				 * [tMap_5 finally ] start
				 */

				currentComponent = "tMap_5";

				/**
				 * [tMap_5 finally ] stop
				 */

				/**
				 * [tMap_11 finally ] start
				 */

				currentComponent = "tMap_11";

				/**
				 * [tMap_11 finally ] stop
				 */

				/**
				 * [tMap_6 finally ] start
				 */

				currentComponent = "tMap_6";

				/**
				 * [tMap_6 finally ] stop
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

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public void tLogCatcher_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tLogCatcher_4_SUBPROCESS_STATE", 0);

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
				 * [tLogCatcher_4 begin ] start
				 */

				ok_Hash.put("tLogCatcher_4", false);
				start_Hash.put("tLogCatcher_4", System.currentTimeMillis());

				currentComponent = "tLogCatcher_4";

				int tos_count_tLogCatcher_4 = 0;

				try {
					for (LogCatcherUtils.LogCatcherMessage lcm : tLogCatcher_4.getMessages()) {

						/**
						 * [tLogCatcher_4 begin ] stop
						 */

						/**
						 * [tLogCatcher_4 main ] start
						 */

						currentComponent = "tLogCatcher_4";

						tos_count_tLogCatcher_4++;

						/**
						 * [tLogCatcher_4 main ] stop
						 */

						/**
						 * [tLogCatcher_4 process_data_begin ] start
						 */

						currentComponent = "tLogCatcher_4";

						/**
						 * [tLogCatcher_4 process_data_begin ] stop
						 */

						/**
						 * [tLogCatcher_4 process_data_end ] start
						 */

						currentComponent = "tLogCatcher_4";

						/**
						 * [tLogCatcher_4 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_4 end ] start
						 */

						currentComponent = "tLogCatcher_4";

					}
				} catch (Exception e_tLogCatcher_4) {
					globalMap.put("tLogCatcher_4_ERROR_MESSAGE", e_tLogCatcher_4.getMessage());
					logIgnoredError(String.format(
							"tLogCatcher_4 - tLogCatcher failed to process log message(s) due to internal error: %s",
							e_tLogCatcher_4), e_tLogCatcher_4);
				}

				ok_Hash.put("tLogCatcher_4", true);
				end_Hash.put("tLogCatcher_4", System.currentTimeMillis());

				/**
				 * [tLogCatcher_4 end ] stop
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
				 * [tLogCatcher_4 finally ] start
				 */

				currentComponent = "tLogCatcher_4";

				/**
				 * [tLogCatcher_4 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tLogCatcher_4_SUBPROCESS_STATE", 1);
	}

	public static class row25Struct implements routines.system.IPersistableRow<row25Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

		public String ShipperName;

		public String getShipperName() {
			return this.ShipperName;
		}

		public String ShippingMethod;

		public String getShippingMethod() {
			return this.ShippingMethod;
		}

		public int id_shipping;

		public int getId_shipping() {
			return this.id_shipping;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.ShipperName = readString(dis);

					this.ShippingMethod = readString(dis);

					this.id_shipping = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.ShipperName = readString(dis);

					this.ShippingMethod = readString(dis);

					this.id_shipping = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.ShipperName, dos);

				// String

				writeString(this.ShippingMethod, dos);

				// int

				dos.writeInt(this.id_shipping);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.ShipperName, dos);

				// String

				writeString(this.ShippingMethod, dos);

				// int

				dos.writeInt(this.id_shipping);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ShipperName=" + ShipperName);
			sb.append(",ShippingMethod=" + ShippingMethod);
			sb.append(",id_shipping=" + String.valueOf(id_shipping));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row25Struct other) {

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

	public static class out5Struct implements routines.system.IPersistableRow<out5Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

		public String ShipperName;

		public String getShipperName() {
			return this.ShipperName;
		}

		public String ShippingMethod;

		public String getShippingMethod() {
			return this.ShippingMethod;
		}

		public int id_shipping;

		public int getId_shipping() {
			return this.id_shipping;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.ShipperName = readString(dis);

					this.ShippingMethod = readString(dis);

					this.id_shipping = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.ShipperName = readString(dis);

					this.ShippingMethod = readString(dis);

					this.id_shipping = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.ShipperName, dos);

				// String

				writeString(this.ShippingMethod, dos);

				// int

				dos.writeInt(this.id_shipping);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.ShipperName, dos);

				// String

				writeString(this.ShippingMethod, dos);

				// int

				dos.writeInt(this.id_shipping);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ShipperName=" + ShipperName);
			sb.append(",ShippingMethod=" + ShippingMethod);
			sb.append(",id_shipping=" + String.valueOf(id_shipping));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out5Struct other) {

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

	public static class row24Struct implements routines.system.IPersistableRow<row24Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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
		public int compareTo(row24Struct other) {

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

	public void tDBInput_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 0);

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

				row24Struct row24 = new row24Struct();
				out5Struct out5 = new out5Struct();
				row25Struct row25 = new row25Struct();

				/**
				 * [tDBOutput_7 begin ] start
				 */

				ok_Hash.put("tDBOutput_7", false);
				start_Hash.put("tDBOutput_7", System.currentTimeMillis());

				currentComponent = "tDBOutput_7";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row25");
				}

				int tos_count_tDBOutput_7 = 0;

				int nb_line_tDBOutput_7 = 0;
				int nb_line_update_tDBOutput_7 = 0;
				int nb_line_inserted_tDBOutput_7 = 0;
				int nb_line_deleted_tDBOutput_7 = 0;
				int nb_line_rejected_tDBOutput_7 = 0;

				int deletedCount_tDBOutput_7 = 0;
				int updatedCount_tDBOutput_7 = 0;
				int insertedCount_tDBOutput_7 = 0;
				int rowsToCommitCount_tDBOutput_7 = 0;
				int rejectedCount_tDBOutput_7 = 0;
				String dbschema_tDBOutput_7 = null;
				String tableName_tDBOutput_7 = null;
				boolean whetherReject_tDBOutput_7 = false;

				java.util.Calendar calendar_tDBOutput_7 = java.util.Calendar.getInstance();
				long year1_tDBOutput_7 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_7 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_7 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_7;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_7 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_7 = null;
				String dbUser_tDBOutput_7 = null;
				dbschema_tDBOutput_7 = "dbo";
				String driverClass_tDBOutput_7 = "net.sourceforge.jtds.jdbc.Driver";

				java.lang.Class.forName(driverClass_tDBOutput_7);
				String port_tDBOutput_7 = "1433";
				String dbname_tDBOutput_7 = "ecommerv2";
				String url_tDBOutput_7 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBOutput_7)) {
					url_tDBOutput_7 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_7)) {
					url_tDBOutput_7 += "//" + "ecommerv2";

				}
				url_tDBOutput_7 += ";appName=" + projectName + ";" + "";
				dbUser_tDBOutput_7 = "ismaill";

				final String decryptedPassword_tDBOutput_7 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:Z1ujp3hvvn9AHgpz+sv5bDrPiDIt9uZT4SMNDFburRQ=");

				String dbPwd_tDBOutput_7 = decryptedPassword_tDBOutput_7;
				conn_tDBOutput_7 = java.sql.DriverManager.getConnection(url_tDBOutput_7, dbUser_tDBOutput_7,
						dbPwd_tDBOutput_7);

				resourceMap.put("conn_tDBOutput_7", conn_tDBOutput_7);

				conn_tDBOutput_7.setAutoCommit(false);
				int commitEvery_tDBOutput_7 = 10000;
				int commitCounter_tDBOutput_7 = 0;

				int batchSize_tDBOutput_7 = 10000;
				int batchSizeCounter_tDBOutput_7 = 0;

				if (dbschema_tDBOutput_7 == null || dbschema_tDBOutput_7.trim().length() == 0) {
					tableName_tDBOutput_7 = "DimShipping";
				} else {
					tableName_tDBOutput_7 = dbschema_tDBOutput_7 + "].[" + "DimShipping";
				}
				int count_tDBOutput_7 = 0;

				try (java.sql.Statement stmtDrop_tDBOutput_7 = conn_tDBOutput_7.createStatement()) {
					stmtDrop_tDBOutput_7.execute("DROP TABLE [" + tableName_tDBOutput_7 + "]");
				}
				try (java.sql.Statement stmtCreate_tDBOutput_7 = conn_tDBOutput_7.createStatement()) {
					stmtCreate_tDBOutput_7.execute("CREATE TABLE [" + tableName_tDBOutput_7
							+ "]([ShipperName] VARCHAR(250)  ,[ShippingMethod] VARCHAR(250)  ,[id_shipping] INT  not null )");
				}
				String insert_tDBOutput_7 = "INSERT INTO [" + tableName_tDBOutput_7
						+ "] ([ShipperName],[ShippingMethod],[id_shipping]) VALUES (?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_7 = conn_tDBOutput_7.prepareStatement(insert_tDBOutput_7);
				resourceMap.put("pstmt_tDBOutput_7", pstmt_tDBOutput_7);

				/**
				 * [tDBOutput_7 begin ] stop
				 */

				/**
				 * [tUniqRow_4 begin ] start
				 */

				ok_Hash.put("tUniqRow_4", false);
				start_Hash.put("tUniqRow_4", System.currentTimeMillis());

				currentComponent = "tUniqRow_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out5");
				}

				int tos_count_tUniqRow_4 = 0;

				class KeyStruct_tUniqRow_4 {

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					int id_shipping;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + (int) this.id_shipping;

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final KeyStruct_tUniqRow_4 other = (KeyStruct_tUniqRow_4) obj;

						if (this.id_shipping != other.id_shipping)
							return false;

						return true;
					}

				}

				int nb_uniques_tUniqRow_4 = 0;
				int nb_duplicates_tUniqRow_4 = 0;
				KeyStruct_tUniqRow_4 finder_tUniqRow_4 = new KeyStruct_tUniqRow_4();
				java.util.Set<KeyStruct_tUniqRow_4> keystUniqRow_4 = new java.util.HashSet<KeyStruct_tUniqRow_4>();

				/**
				 * [tUniqRow_4 begin ] stop
				 */

				/**
				 * [tMap_12 begin ] start
				 */

				ok_Hash.put("tMap_12", false);
				start_Hash.put("tMap_12", System.currentTimeMillis());

				currentComponent = "tMap_12";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row24");
				}

				int tos_count_tMap_12 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_12__Struct {
				}
				Var__tMap_12__Struct Var__tMap_12 = new Var__tMap_12__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out5Struct out5_tmp = new out5Struct();
// ###############################

				/**
				 * [tMap_12 begin ] stop
				 */

				/**
				 * [tDBInput_8 begin ] start
				 */

				ok_Hash.put("tDBInput_8", false);
				start_Hash.put("tDBInput_8", System.currentTimeMillis());

				currentComponent = "tDBInput_8";

				int tos_count_tDBInput_8 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_8 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_8 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_8 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_8, talendToDBArray_tDBInput_8);
				int nb_line_tDBInput_8 = 0;
				java.sql.Connection conn_tDBInput_8 = null;
				String driverClass_tDBInput_8 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_8 = java.lang.Class.forName(driverClass_tDBInput_8);
				String dbUser_tDBInput_8 = "ismaill";

				final String decryptedPassword_tDBInput_8 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:FhnAuvnFIVBuupV4HIqWa0k/t7Uz7qCxJMmv5FCe+NE=");

				String dbPwd_tDBInput_8 = decryptedPassword_tDBInput_8;

				String port_tDBInput_8 = "1433";
				String dbname_tDBInput_8 = "ecommerv2";
				String url_tDBInput_8 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBInput_8)) {
					url_tDBInput_8 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_8)) {
					url_tDBInput_8 += "//" + "ecommerv2";
				}
				url_tDBInput_8 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_8 = "dbo";

				conn_tDBInput_8 = java.sql.DriverManager.getConnection(url_tDBInput_8, dbUser_tDBInput_8,
						dbPwd_tDBInput_8);

				java.sql.Statement stmt_tDBInput_8 = conn_tDBInput_8.createStatement();

				String dbquery_tDBInput_8 = "select * from transformed";

				globalMap.put("tDBInput_8_QUERY", dbquery_tDBInput_8);
				java.sql.ResultSet rs_tDBInput_8 = null;

				try {
					rs_tDBInput_8 = stmt_tDBInput_8.executeQuery(dbquery_tDBInput_8);
					java.sql.ResultSetMetaData rsmd_tDBInput_8 = rs_tDBInput_8.getMetaData();
					int colQtyInRs_tDBInput_8 = rsmd_tDBInput_8.getColumnCount();

					String tmpContent_tDBInput_8 = null;

					while (rs_tDBInput_8.next()) {
						nb_line_tDBInput_8++;

						if (colQtyInRs_tDBInput_8 < 1) {
							row24.ProductName = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(1);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.ProductName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.ProductName = tmpContent_tDBInput_8;
								}
							} else {
								row24.ProductName = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 2) {
							row24.ProductCategory = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(2);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.ProductCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.ProductCategory = tmpContent_tDBInput_8;
								}
							} else {
								row24.ProductCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 3) {
							row24.ProductSubCategory = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(3);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.ProductSubCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.ProductSubCategory = tmpContent_tDBInput_8;
								}
							} else {
								row24.ProductSubCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 4) {
							row24.ProductPrice = null;
						} else {

							row24.ProductPrice = rs_tDBInput_8.getFloat(4);
							if (rs_tDBInput_8.wasNull()) {
								row24.ProductPrice = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 5) {
							row24.Date = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(5);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.Date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.Date = tmpContent_tDBInput_8;
								}
							} else {
								row24.Date = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 6) {
							row24.CustomerName = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(6);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.CustomerName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.CustomerName = tmpContent_tDBInput_8;
								}
							} else {
								row24.CustomerName = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 7) {
							row24.CustomerEmail = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(7);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.CustomerEmail = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.CustomerEmail = tmpContent_tDBInput_8;
								}
							} else {
								row24.CustomerEmail = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 8) {
							row24.CustomerAddress = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(8);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.CustomerAddress = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.CustomerAddress = tmpContent_tDBInput_8;
								}
							} else {
								row24.CustomerAddress = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 9) {
							row24.CustomerPhone = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(9);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.CustomerPhone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.CustomerPhone = tmpContent_tDBInput_8;
								}
							} else {
								row24.CustomerPhone = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 10) {
							row24.CustomerSegment = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(10);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.CustomerSegment = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.CustomerSegment = tmpContent_tDBInput_8;
								}
							} else {
								row24.CustomerSegment = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 11) {
							row24.SupplierName = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(11);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.SupplierName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.SupplierName = tmpContent_tDBInput_8;
								}
							} else {
								row24.SupplierName = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 12) {
							row24.SupplierLocation = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(12);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.SupplierLocation = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.SupplierLocation = tmpContent_tDBInput_8;
								}
							} else {
								row24.SupplierLocation = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 13) {
							row24.SupplierContact = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(13);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.SupplierContact = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.SupplierContact = tmpContent_tDBInput_8;
								}
							} else {
								row24.SupplierContact = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 14) {
							row24.ShipperName = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(14);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.ShipperName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.ShipperName = tmpContent_tDBInput_8;
								}
							} else {
								row24.ShipperName = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 15) {
							row24.ShippingMethod = null;
						} else {

							tmpContent_tDBInput_8 = rs_tDBInput_8.getString(15);
							if (tmpContent_tDBInput_8 != null) {
								if (talendToDBList_tDBInput_8.contains(
										rsmd_tDBInput_8.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
									row24.ShippingMethod = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
								} else {
									row24.ShippingMethod = tmpContent_tDBInput_8;
								}
							} else {
								row24.ShippingMethod = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 16) {
							row24.QuantitySold = null;
						} else {

							row24.QuantitySold = rs_tDBInput_8.getInt(16);
							if (rs_tDBInput_8.wasNull()) {
								row24.QuantitySold = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 17) {
							row24.TotalAmount = null;
						} else {

							row24.TotalAmount = rs_tDBInput_8.getFloat(17);
							if (rs_tDBInput_8.wasNull()) {
								row24.TotalAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 18) {
							row24.DiscountAmount = null;
						} else {

							row24.DiscountAmount = rs_tDBInput_8.getFloat(18);
							if (rs_tDBInput_8.wasNull()) {
								row24.DiscountAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 19) {
							row24.NetAmount = null;
						} else {

							row24.NetAmount = rs_tDBInput_8.getFloat(19);
							if (rs_tDBInput_8.wasNull()) {
								row24.NetAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 20) {
							row24.StockReceived = null;
						} else {

							row24.StockReceived = rs_tDBInput_8.getFloat(20);
							if (rs_tDBInput_8.wasNull()) {
								row24.StockReceived = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 21) {
							row24.StockSold = null;
						} else {

							row24.StockSold = rs_tDBInput_8.getFloat(21);
							if (rs_tDBInput_8.wasNull()) {
								row24.StockSold = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 22) {
							row24.StockOnHand = null;
						} else {

							row24.StockOnHand = rs_tDBInput_8.getFloat(22);
							if (rs_tDBInput_8.wasNull()) {
								row24.StockOnHand = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 23) {
							row24.id_pro = 0;
						} else {

							row24.id_pro = rs_tDBInput_8.getInt(23);
							if (rs_tDBInput_8.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_8 < 24) {
							row24.id_shipping = 0;
						} else {

							row24.id_shipping = rs_tDBInput_8.getInt(24);
							if (rs_tDBInput_8.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_8 < 25) {
							row24.id_supplier = 0;
						} else {

							row24.id_supplier = rs_tDBInput_8.getInt(25);
							if (rs_tDBInput_8.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_8 < 26) {
							row24.id_costumer = 0;
						} else {

							row24.id_costumer = rs_tDBInput_8.getInt(26);
							if (rs_tDBInput_8.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_8 < 27) {
							row24.id_date = 0;
						} else {

							row24.id_date = rs_tDBInput_8.getInt(27);
							if (rs_tDBInput_8.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						/**
						 * [tDBInput_8 begin ] stop
						 */

						/**
						 * [tDBInput_8 main ] start
						 */

						currentComponent = "tDBInput_8";

						tos_count_tDBInput_8++;

						/**
						 * [tDBInput_8 main ] stop
						 */

						/**
						 * [tDBInput_8 process_data_begin ] start
						 */

						currentComponent = "tDBInput_8";

						/**
						 * [tDBInput_8 process_data_begin ] stop
						 */

						/**
						 * [tMap_12 main ] start
						 */

						currentComponent = "tMap_12";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row24"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_12 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_12 = false;
						boolean mainRowRejected_tMap_12 = false;

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_12__Struct Var = Var__tMap_12;// ###############################
							// ###############################
							// # Output tables

							out5 = null;

// # Output table : 'out5'
							out5_tmp.ShipperName = row24.ShipperName;
							out5_tmp.ShippingMethod = row24.ShippingMethod;
							out5_tmp.id_shipping = row24.id_shipping;
							out5 = out5_tmp;
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_12 = false;

						tos_count_tMap_12++;

						/**
						 * [tMap_12 main ] stop
						 */

						/**
						 * [tMap_12 process_data_begin ] start
						 */

						currentComponent = "tMap_12";

						/**
						 * [tMap_12 process_data_begin ] stop
						 */
// Start of branch "out5"
						if (out5 != null) {

							/**
							 * [tUniqRow_4 main ] start
							 */

							currentComponent = "tUniqRow_4";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "out5"

								);
							}

							row25 = null;
							finder_tUniqRow_4.id_shipping = out5.id_shipping;
							finder_tUniqRow_4.hashCodeDirty = true;
							if (!keystUniqRow_4.contains(finder_tUniqRow_4)) {
								KeyStruct_tUniqRow_4 new_tUniqRow_4 = new KeyStruct_tUniqRow_4();

								new_tUniqRow_4.id_shipping = out5.id_shipping;

								keystUniqRow_4.add(new_tUniqRow_4);
								if (row25 == null) {

									row25 = new row25Struct();
								}
								row25.ShipperName = out5.ShipperName;
								row25.ShippingMethod = out5.ShippingMethod;
								row25.id_shipping = out5.id_shipping;
								nb_uniques_tUniqRow_4++;
							} else {
								nb_duplicates_tUniqRow_4++;
							}

							tos_count_tUniqRow_4++;

							/**
							 * [tUniqRow_4 main ] stop
							 */

							/**
							 * [tUniqRow_4 process_data_begin ] start
							 */

							currentComponent = "tUniqRow_4";

							/**
							 * [tUniqRow_4 process_data_begin ] stop
							 */
// Start of branch "row25"
							if (row25 != null) {

								/**
								 * [tDBOutput_7 main ] start
								 */

								currentComponent = "tDBOutput_7";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row25"

									);
								}

								whetherReject_tDBOutput_7 = false;
								if (row25.ShipperName == null) {
									pstmt_tDBOutput_7.setNull(1, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_7.setString(1, row25.ShipperName);
								}

								if (row25.ShippingMethod == null) {
									pstmt_tDBOutput_7.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_7.setString(2, row25.ShippingMethod);
								}

								pstmt_tDBOutput_7.setInt(3, row25.id_shipping);

								pstmt_tDBOutput_7.addBatch();
								nb_line_tDBOutput_7++;

								batchSizeCounter_tDBOutput_7++;

								////////// batch execute by batch size///////
								class LimitBytesHelper_tDBOutput_7 {
									public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_7)
											throws Exception {
										try {

											for (int countEach_tDBOutput_7 : pstmt_tDBOutput_7.executeBatch()) {
												if (countEach_tDBOutput_7 == -2 || countEach_tDBOutput_7 == -3) {
													break;
												}
												counter += countEach_tDBOutput_7;
											}

										} catch (java.sql.BatchUpdateException e) {
											globalMap.put("tDBOutput_7_ERROR_MESSAGE", e.getMessage());

											int countSum_tDBOutput_7 = 0;
											for (int countEach_tDBOutput_7 : e.getUpdateCounts()) {
												counter += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
											}

											System.err.println(e.getMessage());

										}
										return counter;
									}

									public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_7)
											throws Exception {
										try {

											for (int countEach_tDBOutput_7 : pstmt_tDBOutput_7.executeBatch()) {
												if (countEach_tDBOutput_7 == -2 || countEach_tDBOutput_7 == -3) {
													break;
												}
												counter += countEach_tDBOutput_7;
											}

										} catch (java.sql.BatchUpdateException e) {
											globalMap.put("tDBOutput_7_ERROR_MESSAGE", e.getMessage());

											for (int countEach_tDBOutput_7 : e.getUpdateCounts()) {
												counter += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
											}

											System.err.println(e.getMessage());

										}
										return counter;
									}
								}
								if ((batchSize_tDBOutput_7 > 0)
										&& (batchSize_tDBOutput_7 <= batchSizeCounter_tDBOutput_7)) {

									insertedCount_tDBOutput_7 = new LimitBytesHelper_tDBOutput_7()
											.limitBytePart1(insertedCount_tDBOutput_7, pstmt_tDBOutput_7);
									rowsToCommitCount_tDBOutput_7 = insertedCount_tDBOutput_7;

									batchSizeCounter_tDBOutput_7 = 0;
								}

								//////////// commit every////////////

								commitCounter_tDBOutput_7++;
								if (commitEvery_tDBOutput_7 <= commitCounter_tDBOutput_7) {
									if ((batchSize_tDBOutput_7 > 0) && (batchSizeCounter_tDBOutput_7 > 0)) {

										insertedCount_tDBOutput_7 = new LimitBytesHelper_tDBOutput_7()
												.limitBytePart1(insertedCount_tDBOutput_7, pstmt_tDBOutput_7);

										batchSizeCounter_tDBOutput_7 = 0;
									}
									if (rowsToCommitCount_tDBOutput_7 != 0) {

									}
									conn_tDBOutput_7.commit();
									if (rowsToCommitCount_tDBOutput_7 != 0) {

										rowsToCommitCount_tDBOutput_7 = 0;
									}
									commitCounter_tDBOutput_7 = 0;
								}

								tos_count_tDBOutput_7++;

								/**
								 * [tDBOutput_7 main ] stop
								 */

								/**
								 * [tDBOutput_7 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_7";

								/**
								 * [tDBOutput_7 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_7 process_data_end ] start
								 */

								currentComponent = "tDBOutput_7";

								/**
								 * [tDBOutput_7 process_data_end ] stop
								 */

							} // End of branch "row25"

							/**
							 * [tUniqRow_4 process_data_end ] start
							 */

							currentComponent = "tUniqRow_4";

							/**
							 * [tUniqRow_4 process_data_end ] stop
							 */

						} // End of branch "out5"

						/**
						 * [tMap_12 process_data_end ] start
						 */

						currentComponent = "tMap_12";

						/**
						 * [tMap_12 process_data_end ] stop
						 */

						/**
						 * [tDBInput_8 process_data_end ] start
						 */

						currentComponent = "tDBInput_8";

						/**
						 * [tDBInput_8 process_data_end ] stop
						 */

						/**
						 * [tDBInput_8 end ] start
						 */

						currentComponent = "tDBInput_8";

					}
				} finally {
					if (rs_tDBInput_8 != null) {
						rs_tDBInput_8.close();
					}
					if (stmt_tDBInput_8 != null) {
						stmt_tDBInput_8.close();
					}
					if (conn_tDBInput_8 != null && !conn_tDBInput_8.isClosed()) {

						conn_tDBInput_8.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_8_NB_LINE", nb_line_tDBInput_8);

				ok_Hash.put("tDBInput_8", true);
				end_Hash.put("tDBInput_8", System.currentTimeMillis());

				/**
				 * [tDBInput_8 end ] stop
				 */

				/**
				 * [tMap_12 end ] start
				 */

				currentComponent = "tMap_12";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row24");
				}

				ok_Hash.put("tMap_12", true);
				end_Hash.put("tMap_12", System.currentTimeMillis());

				/**
				 * [tMap_12 end ] stop
				 */

				/**
				 * [tUniqRow_4 end ] start
				 */

				currentComponent = "tUniqRow_4";

				globalMap.put("tUniqRow_4_NB_UNIQUES", nb_uniques_tUniqRow_4);
				globalMap.put("tUniqRow_4_NB_DUPLICATES", nb_duplicates_tUniqRow_4);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out5");
				}

				ok_Hash.put("tUniqRow_4", true);
				end_Hash.put("tUniqRow_4", System.currentTimeMillis());

				/**
				 * [tUniqRow_4 end ] stop
				 */

				/**
				 * [tDBOutput_7 end ] start
				 */

				currentComponent = "tDBOutput_7";

				try {
					int countSum_tDBOutput_7 = 0;
					if (pstmt_tDBOutput_7 != null && batchSizeCounter_tDBOutput_7 > 0) {

						for (int countEach_tDBOutput_7 : pstmt_tDBOutput_7.executeBatch()) {
							if (countEach_tDBOutput_7 == -2 || countEach_tDBOutput_7 == -3) {
								break;
							}
							countSum_tDBOutput_7 += countEach_tDBOutput_7;
						}
						rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;

					}

					insertedCount_tDBOutput_7 += countSum_tDBOutput_7;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_7_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_7 = 0;
					for (int countEach_tDBOutput_7 : e.getUpdateCounts()) {
						countSum_tDBOutput_7 += (countEach_tDBOutput_7 < 0 ? 0 : countEach_tDBOutput_7);
					}
					rowsToCommitCount_tDBOutput_7 += countSum_tDBOutput_7;

					insertedCount_tDBOutput_7 += countSum_tDBOutput_7;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_7 != null) {

					pstmt_tDBOutput_7.close();
					resourceMap.remove("pstmt_tDBOutput_7");

				}
				resourceMap.put("statementClosed_tDBOutput_7", true);
				if (rowsToCommitCount_tDBOutput_7 != 0) {

				}
				conn_tDBOutput_7.commit();
				if (rowsToCommitCount_tDBOutput_7 != 0) {

					rowsToCommitCount_tDBOutput_7 = 0;
				}
				commitCounter_tDBOutput_7 = 0;
				conn_tDBOutput_7.close();
				resourceMap.put("finish_tDBOutput_7", true);

				nb_line_deleted_tDBOutput_7 = nb_line_deleted_tDBOutput_7 + deletedCount_tDBOutput_7;
				nb_line_update_tDBOutput_7 = nb_line_update_tDBOutput_7 + updatedCount_tDBOutput_7;
				nb_line_inserted_tDBOutput_7 = nb_line_inserted_tDBOutput_7 + insertedCount_tDBOutput_7;
				nb_line_rejected_tDBOutput_7 = nb_line_rejected_tDBOutput_7 + rejectedCount_tDBOutput_7;

				globalMap.put("tDBOutput_7_NB_LINE", nb_line_tDBOutput_7);
				globalMap.put("tDBOutput_7_NB_LINE_UPDATED", nb_line_update_tDBOutput_7);
				globalMap.put("tDBOutput_7_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_7);
				globalMap.put("tDBOutput_7_NB_LINE_DELETED", nb_line_deleted_tDBOutput_7);
				globalMap.put("tDBOutput_7_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_7);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row25");
				}

				ok_Hash.put("tDBOutput_7", true);
				end_Hash.put("tDBOutput_7", System.currentTimeMillis());

				/**
				 * [tDBOutput_7 end ] stop
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
				 * [tDBInput_8 finally ] start
				 */

				currentComponent = "tDBInput_8";

				/**
				 * [tDBInput_8 finally ] stop
				 */

				/**
				 * [tMap_12 finally ] start
				 */

				currentComponent = "tMap_12";

				/**
				 * [tMap_12 finally ] stop
				 */

				/**
				 * [tUniqRow_4 finally ] start
				 */

				currentComponent = "tUniqRow_4";

				/**
				 * [tUniqRow_4 finally ] stop
				 */

				/**
				 * [tDBOutput_7 finally ] start
				 */

				currentComponent = "tDBOutput_7";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_7") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_7 = null;
						if ((pstmtToClose_tDBOutput_7 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_7")) != null) {
							pstmtToClose_tDBOutput_7.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_7") == null) {
						java.sql.Connection ctn_tDBOutput_7 = null;
						if ((ctn_tDBOutput_7 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_7")) != null) {
							try {
								ctn_tDBOutput_7.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_7) {
								String errorMessage_tDBOutput_7 = "failed to close the connection in tDBOutput_7 :"
										+ sqlEx_tDBOutput_7.getMessage();
								System.err.println(errorMessage_tDBOutput_7);
							}
						}
					}
				}

				/**
				 * [tDBOutput_7 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 1);
	}

	public static class row23Struct implements routines.system.IPersistableRow<row23Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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

		public Integer id;

		public Integer getId() {
			return this.id;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.SupplierName = readString(dis);

					this.SupplierLocation = readString(dis);

					this.SupplierContact = readString(dis);

					this.id = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.SupplierName = readString(dis);

					this.SupplierLocation = readString(dis);

					this.SupplierContact = readString(dis);

					this.id = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.SupplierName, dos);

				// String

				writeString(this.SupplierLocation, dos);

				// String

				writeString(this.SupplierContact, dos);

				// Integer

				writeInteger(this.id, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.SupplierName, dos);

				// String

				writeString(this.SupplierLocation, dos);

				// String

				writeString(this.SupplierContact, dos);

				// Integer

				writeInteger(this.id, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("SupplierName=" + SupplierName);
			sb.append(",SupplierLocation=" + SupplierLocation);
			sb.append(",SupplierContact=" + SupplierContact);
			sb.append(",id=" + String.valueOf(id));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row23Struct other) {

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

	public static class DiimSupplierStruct implements routines.system.IPersistableRow<DiimSupplierStruct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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

		public Integer id;

		public Integer getId() {
			return this.id;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.SupplierName = readString(dis);

					this.SupplierLocation = readString(dis);

					this.SupplierContact = readString(dis);

					this.id = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.SupplierName = readString(dis);

					this.SupplierLocation = readString(dis);

					this.SupplierContact = readString(dis);

					this.id = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.SupplierName, dos);

				// String

				writeString(this.SupplierLocation, dos);

				// String

				writeString(this.SupplierContact, dos);

				// Integer

				writeInteger(this.id, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.SupplierName, dos);

				// String

				writeString(this.SupplierLocation, dos);

				// String

				writeString(this.SupplierContact, dos);

				// Integer

				writeInteger(this.id, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("SupplierName=" + SupplierName);
			sb.append(",SupplierLocation=" + SupplierLocation);
			sb.append(",SupplierContact=" + SupplierContact);
			sb.append(",id=" + String.valueOf(id));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(DiimSupplierStruct other) {

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

	public static class row21Struct implements routines.system.IPersistableRow<row21Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

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
		public int compareTo(row21Struct other) {

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

	public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

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

				row21Struct row21 = new row21Struct();
				DiimSupplierStruct DiimSupplier = new DiimSupplierStruct();
				row23Struct row23 = new row23Struct();

				/**
				 * [tDBOutput_3 begin ] start
				 */

				ok_Hash.put("tDBOutput_3", false);
				start_Hash.put("tDBOutput_3", System.currentTimeMillis());

				currentComponent = "tDBOutput_3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row23");
				}

				int tos_count_tDBOutput_3 = 0;

				int nb_line_tDBOutput_3 = 0;
				int nb_line_update_tDBOutput_3 = 0;
				int nb_line_inserted_tDBOutput_3 = 0;
				int nb_line_deleted_tDBOutput_3 = 0;
				int nb_line_rejected_tDBOutput_3 = 0;

				int deletedCount_tDBOutput_3 = 0;
				int updatedCount_tDBOutput_3 = 0;
				int insertedCount_tDBOutput_3 = 0;
				int rowsToCommitCount_tDBOutput_3 = 0;
				int rejectedCount_tDBOutput_3 = 0;
				String dbschema_tDBOutput_3 = null;
				String tableName_tDBOutput_3 = null;
				boolean whetherReject_tDBOutput_3 = false;

				java.util.Calendar calendar_tDBOutput_3 = java.util.Calendar.getInstance();
				long year1_tDBOutput_3 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_3 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_3 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_3;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_3 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_3 = null;
				String dbUser_tDBOutput_3 = null;
				dbschema_tDBOutput_3 = "dbo";
				String driverClass_tDBOutput_3 = "net.sourceforge.jtds.jdbc.Driver";

				java.lang.Class.forName(driverClass_tDBOutput_3);
				String port_tDBOutput_3 = "1433";
				String dbname_tDBOutput_3 = "ecommerv2";
				String url_tDBOutput_3 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBOutput_3)) {
					url_tDBOutput_3 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_3)) {
					url_tDBOutput_3 += "//" + "ecommerv2";

				}
				url_tDBOutput_3 += ";appName=" + projectName + ";" + "";
				dbUser_tDBOutput_3 = "ismaill";

				final String decryptedPassword_tDBOutput_3 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:stZA4YtOoTW1LOIzC3xin02EXVtzIEuVGp0XXvQfbKI=");

				String dbPwd_tDBOutput_3 = decryptedPassword_tDBOutput_3;
				conn_tDBOutput_3 = java.sql.DriverManager.getConnection(url_tDBOutput_3, dbUser_tDBOutput_3,
						dbPwd_tDBOutput_3);

				resourceMap.put("conn_tDBOutput_3", conn_tDBOutput_3);

				conn_tDBOutput_3.setAutoCommit(false);
				int commitEvery_tDBOutput_3 = 10000;
				int commitCounter_tDBOutput_3 = 0;

				int batchSize_tDBOutput_3 = 10000;
				int batchSizeCounter_tDBOutput_3 = 0;

				if (dbschema_tDBOutput_3 == null || dbschema_tDBOutput_3.trim().length() == 0) {
					tableName_tDBOutput_3 = "dimSupplier";
				} else {
					tableName_tDBOutput_3 = dbschema_tDBOutput_3 + "].[" + "dimSupplier";
				}
				int count_tDBOutput_3 = 0;

				boolean whetherExist_tDBOutput_3 = false;
				try (java.sql.Statement isExistStmt_tDBOutput_3 = conn_tDBOutput_3.createStatement()) {
					try {
						isExistStmt_tDBOutput_3.execute("SELECT TOP 1 1 FROM [" + tableName_tDBOutput_3 + "]");
						whetherExist_tDBOutput_3 = true;
					} catch (java.lang.Exception e) {
						globalMap.put("tDBOutput_3_ERROR_MESSAGE", e.getMessage());
						whetherExist_tDBOutput_3 = false;
					}
				}
				if (!whetherExist_tDBOutput_3) {
					try (java.sql.Statement stmtCreate_tDBOutput_3 = conn_tDBOutput_3.createStatement()) {
						stmtCreate_tDBOutput_3.execute("CREATE TABLE [" + tableName_tDBOutput_3
								+ "]([SupplierName] VARCHAR(500)  ,[SupplierLocation] VARCHAR(250)  ,[SupplierContact] VARCHAR(250)  ,[id] INT )");
					}
				}
				String insert_tDBOutput_3 = "INSERT INTO [" + tableName_tDBOutput_3
						+ "] ([SupplierName],[SupplierLocation],[SupplierContact],[id]) VALUES (?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(insert_tDBOutput_3);
				resourceMap.put("pstmt_tDBOutput_3", pstmt_tDBOutput_3);

				/**
				 * [tDBOutput_3 begin ] stop
				 */

				/**
				 * [tUniqRow_6 begin ] start
				 */

				ok_Hash.put("tUniqRow_6", false);
				start_Hash.put("tUniqRow_6", System.currentTimeMillis());

				currentComponent = "tUniqRow_6";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "DiimSupplier");
				}

				int tos_count_tUniqRow_6 = 0;

				class KeyStruct_tUniqRow_6 {

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					Integer id;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final KeyStruct_tUniqRow_6 other = (KeyStruct_tUniqRow_6) obj;

						if (this.id == null) {
							if (other.id != null)
								return false;

						} else if (!this.id.equals(other.id))

							return false;

						return true;
					}

				}

				int nb_uniques_tUniqRow_6 = 0;
				int nb_duplicates_tUniqRow_6 = 0;
				KeyStruct_tUniqRow_6 finder_tUniqRow_6 = new KeyStruct_tUniqRow_6();
				java.util.Set<KeyStruct_tUniqRow_6> keystUniqRow_6 = new java.util.HashSet<KeyStruct_tUniqRow_6>();

				/**
				 * [tUniqRow_6 begin ] stop
				 */

				/**
				 * [tMap_9 begin ] start
				 */

				ok_Hash.put("tMap_9", false);
				start_Hash.put("tMap_9", System.currentTimeMillis());

				currentComponent = "tMap_9";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row21");
				}

				int tos_count_tMap_9 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_9__Struct {
				}
				Var__tMap_9__Struct Var__tMap_9 = new Var__tMap_9__Struct();
// ###############################

// ###############################
// # Outputs initialization
				DiimSupplierStruct DiimSupplier_tmp = new DiimSupplierStruct();
// ###############################

				/**
				 * [tMap_9 begin ] stop
				 */

				/**
				 * [tDBInput_5 begin ] start
				 */

				ok_Hash.put("tDBInput_5", false);
				start_Hash.put("tDBInput_5", System.currentTimeMillis());

				currentComponent = "tDBInput_5";

				int tos_count_tDBInput_5 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_5 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_5 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_5 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_5, talendToDBArray_tDBInput_5);
				int nb_line_tDBInput_5 = 0;
				java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = "ismaill";

				final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:8oEPCDzmDsAoGUmD9WHsrVTAArn7AFhS59Nh0WWUl2k=");

				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;

				String port_tDBInput_5 = "1433";
				String dbname_tDBInput_5 = "ecommerv2";
				String url_tDBInput_5 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBInput_5)) {
					url_tDBInput_5 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_5)) {
					url_tDBInput_5 += "//" + "ecommerv2";
				}
				url_tDBInput_5 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_5 = "dbo";

				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5, dbUser_tDBInput_5,
						dbPwd_tDBInput_5);

				java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

				String dbquery_tDBInput_5 = "select * from transformed";

				globalMap.put("tDBInput_5_QUERY", dbquery_tDBInput_5);
				java.sql.ResultSet rs_tDBInput_5 = null;

				try {
					rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
					java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
					int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

					String tmpContent_tDBInput_5 = null;

					while (rs_tDBInput_5.next()) {
						nb_line_tDBInput_5++;

						if (colQtyInRs_tDBInput_5 < 1) {
							row21.ProductName = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(1);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.ProductName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.ProductName = tmpContent_tDBInput_5;
								}
							} else {
								row21.ProductName = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 2) {
							row21.ProductCategory = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(2);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.ProductCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.ProductCategory = tmpContent_tDBInput_5;
								}
							} else {
								row21.ProductCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 3) {
							row21.ProductSubCategory = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(3);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.ProductSubCategory = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.ProductSubCategory = tmpContent_tDBInput_5;
								}
							} else {
								row21.ProductSubCategory = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 4) {
							row21.ProductPrice = null;
						} else {

							row21.ProductPrice = rs_tDBInput_5.getFloat(4);
							if (rs_tDBInput_5.wasNull()) {
								row21.ProductPrice = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 5) {
							row21.Date = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(5);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.Date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.Date = tmpContent_tDBInput_5;
								}
							} else {
								row21.Date = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 6) {
							row21.CustomerName = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(6);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.CustomerName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.CustomerName = tmpContent_tDBInput_5;
								}
							} else {
								row21.CustomerName = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 7) {
							row21.CustomerEmail = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(7);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.CustomerEmail = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.CustomerEmail = tmpContent_tDBInput_5;
								}
							} else {
								row21.CustomerEmail = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 8) {
							row21.CustomerAddress = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(8);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.CustomerAddress = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.CustomerAddress = tmpContent_tDBInput_5;
								}
							} else {
								row21.CustomerAddress = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 9) {
							row21.CustomerPhone = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(9);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.CustomerPhone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.CustomerPhone = tmpContent_tDBInput_5;
								}
							} else {
								row21.CustomerPhone = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 10) {
							row21.CustomerSegment = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(10);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.CustomerSegment = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.CustomerSegment = tmpContent_tDBInput_5;
								}
							} else {
								row21.CustomerSegment = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 11) {
							row21.SupplierName = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(11);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.SupplierName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.SupplierName = tmpContent_tDBInput_5;
								}
							} else {
								row21.SupplierName = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 12) {
							row21.SupplierLocation = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(12);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.SupplierLocation = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.SupplierLocation = tmpContent_tDBInput_5;
								}
							} else {
								row21.SupplierLocation = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 13) {
							row21.SupplierContact = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(13);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.SupplierContact = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.SupplierContact = tmpContent_tDBInput_5;
								}
							} else {
								row21.SupplierContact = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 14) {
							row21.ShipperName = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(14);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.ShipperName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.ShipperName = tmpContent_tDBInput_5;
								}
							} else {
								row21.ShipperName = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 15) {
							row21.ShippingMethod = null;
						} else {

							tmpContent_tDBInput_5 = rs_tDBInput_5.getString(15);
							if (tmpContent_tDBInput_5 != null) {
								if (talendToDBList_tDBInput_5.contains(
										rsmd_tDBInput_5.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
									row21.ShippingMethod = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
								} else {
									row21.ShippingMethod = tmpContent_tDBInput_5;
								}
							} else {
								row21.ShippingMethod = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 16) {
							row21.QuantitySold = null;
						} else {

							row21.QuantitySold = rs_tDBInput_5.getInt(16);
							if (rs_tDBInput_5.wasNull()) {
								row21.QuantitySold = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 17) {
							row21.TotalAmount = null;
						} else {

							row21.TotalAmount = rs_tDBInput_5.getFloat(17);
							if (rs_tDBInput_5.wasNull()) {
								row21.TotalAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 18) {
							row21.DiscountAmount = null;
						} else {

							row21.DiscountAmount = rs_tDBInput_5.getFloat(18);
							if (rs_tDBInput_5.wasNull()) {
								row21.DiscountAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 19) {
							row21.NetAmount = null;
						} else {

							row21.NetAmount = rs_tDBInput_5.getFloat(19);
							if (rs_tDBInput_5.wasNull()) {
								row21.NetAmount = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 20) {
							row21.StockReceived = null;
						} else {

							row21.StockReceived = rs_tDBInput_5.getFloat(20);
							if (rs_tDBInput_5.wasNull()) {
								row21.StockReceived = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 21) {
							row21.StockSold = null;
						} else {

							row21.StockSold = rs_tDBInput_5.getFloat(21);
							if (rs_tDBInput_5.wasNull()) {
								row21.StockSold = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 22) {
							row21.StockOnHand = null;
						} else {

							row21.StockOnHand = rs_tDBInput_5.getFloat(22);
							if (rs_tDBInput_5.wasNull()) {
								row21.StockOnHand = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 23) {
							row21.id_pro = 0;
						} else {

							row21.id_pro = rs_tDBInput_5.getInt(23);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_5 < 24) {
							row21.id_shipping = 0;
						} else {

							row21.id_shipping = rs_tDBInput_5.getInt(24);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_5 < 25) {
							row21.id_supplier = 0;
						} else {

							row21.id_supplier = rs_tDBInput_5.getInt(25);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_5 < 26) {
							row21.id_costumer = 0;
						} else {

							row21.id_costumer = rs_tDBInput_5.getInt(26);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_5 < 27) {
							row21.id_date = 0;
						} else {

							row21.id_date = rs_tDBInput_5.getInt(27);
							if (rs_tDBInput_5.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						/**
						 * [tDBInput_5 begin ] stop
						 */

						/**
						 * [tDBInput_5 main ] start
						 */

						currentComponent = "tDBInput_5";

						tos_count_tDBInput_5++;

						/**
						 * [tDBInput_5 main ] stop
						 */

						/**
						 * [tDBInput_5 process_data_begin ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_begin ] stop
						 */

						/**
						 * [tMap_9 main ] start
						 */

						currentComponent = "tMap_9";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row21"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_9 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_9 = false;
						boolean mainRowRejected_tMap_9 = false;

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_9__Struct Var = Var__tMap_9;// ###############################
							// ###############################
							// # Output tables

							DiimSupplier = null;

// # Output table : 'DiimSupplier'
							DiimSupplier_tmp.SupplierName = row21.SupplierName;
							DiimSupplier_tmp.SupplierLocation = row21.SupplierLocation;
							DiimSupplier_tmp.SupplierContact = row21.SupplierContact != null
									? row21.SupplierContact.replace("x", "-")
									: row21.SupplierContact;
							DiimSupplier_tmp.id = row21.id_supplier;
							DiimSupplier = DiimSupplier_tmp;
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_9 = false;

						tos_count_tMap_9++;

						/**
						 * [tMap_9 main ] stop
						 */

						/**
						 * [tMap_9 process_data_begin ] start
						 */

						currentComponent = "tMap_9";

						/**
						 * [tMap_9 process_data_begin ] stop
						 */
// Start of branch "DiimSupplier"
						if (DiimSupplier != null) {

							/**
							 * [tUniqRow_6 main ] start
							 */

							currentComponent = "tUniqRow_6";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "DiimSupplier"

								);
							}

							row23 = null;
							finder_tUniqRow_6.id = DiimSupplier.id;
							finder_tUniqRow_6.hashCodeDirty = true;
							if (!keystUniqRow_6.contains(finder_tUniqRow_6)) {
								KeyStruct_tUniqRow_6 new_tUniqRow_6 = new KeyStruct_tUniqRow_6();

								new_tUniqRow_6.id = DiimSupplier.id;

								keystUniqRow_6.add(new_tUniqRow_6);
								if (row23 == null) {

									row23 = new row23Struct();
								}
								row23.SupplierName = DiimSupplier.SupplierName;
								row23.SupplierLocation = DiimSupplier.SupplierLocation;
								row23.SupplierContact = DiimSupplier.SupplierContact;
								row23.id = DiimSupplier.id;
								nb_uniques_tUniqRow_6++;
							} else {
								nb_duplicates_tUniqRow_6++;
							}

							tos_count_tUniqRow_6++;

							/**
							 * [tUniqRow_6 main ] stop
							 */

							/**
							 * [tUniqRow_6 process_data_begin ] start
							 */

							currentComponent = "tUniqRow_6";

							/**
							 * [tUniqRow_6 process_data_begin ] stop
							 */
// Start of branch "row23"
							if (row23 != null) {

								/**
								 * [tDBOutput_3 main ] start
								 */

								currentComponent = "tDBOutput_3";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row23"

									);
								}

								whetherReject_tDBOutput_3 = false;
								if (row23.SupplierName == null) {
									pstmt_tDBOutput_3.setNull(1, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(1, row23.SupplierName);
								}

								if (row23.SupplierLocation == null) {
									pstmt_tDBOutput_3.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(2, row23.SupplierLocation);
								}

								if (row23.SupplierContact == null) {
									pstmt_tDBOutput_3.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(3, row23.SupplierContact);
								}

								if (row23.id == null) {
									pstmt_tDBOutput_3.setNull(4, java.sql.Types.INTEGER);
								} else {
									pstmt_tDBOutput_3.setInt(4, row23.id);
								}

								pstmt_tDBOutput_3.addBatch();
								nb_line_tDBOutput_3++;

								batchSizeCounter_tDBOutput_3++;

								////////// batch execute by batch size///////
								class LimitBytesHelper_tDBOutput_3 {
									public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_3)
											throws Exception {
										try {

											for (int countEach_tDBOutput_3 : pstmt_tDBOutput_3.executeBatch()) {
												if (countEach_tDBOutput_3 == -2 || countEach_tDBOutput_3 == -3) {
													break;
												}
												counter += countEach_tDBOutput_3;
											}

										} catch (java.sql.BatchUpdateException e) {
											globalMap.put("tDBOutput_3_ERROR_MESSAGE", e.getMessage());

											int countSum_tDBOutput_3 = 0;
											for (int countEach_tDBOutput_3 : e.getUpdateCounts()) {
												counter += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
											}

											System.err.println(e.getMessage());

										}
										return counter;
									}

									public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_3)
											throws Exception {
										try {

											for (int countEach_tDBOutput_3 : pstmt_tDBOutput_3.executeBatch()) {
												if (countEach_tDBOutput_3 == -2 || countEach_tDBOutput_3 == -3) {
													break;
												}
												counter += countEach_tDBOutput_3;
											}

										} catch (java.sql.BatchUpdateException e) {
											globalMap.put("tDBOutput_3_ERROR_MESSAGE", e.getMessage());

											for (int countEach_tDBOutput_3 : e.getUpdateCounts()) {
												counter += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
											}

											System.err.println(e.getMessage());

										}
										return counter;
									}
								}
								if ((batchSize_tDBOutput_3 > 0)
										&& (batchSize_tDBOutput_3 <= batchSizeCounter_tDBOutput_3)) {

									insertedCount_tDBOutput_3 = new LimitBytesHelper_tDBOutput_3()
											.limitBytePart1(insertedCount_tDBOutput_3, pstmt_tDBOutput_3);
									rowsToCommitCount_tDBOutput_3 = insertedCount_tDBOutput_3;

									batchSizeCounter_tDBOutput_3 = 0;
								}

								//////////// commit every////////////

								commitCounter_tDBOutput_3++;
								if (commitEvery_tDBOutput_3 <= commitCounter_tDBOutput_3) {
									if ((batchSize_tDBOutput_3 > 0) && (batchSizeCounter_tDBOutput_3 > 0)) {

										insertedCount_tDBOutput_3 = new LimitBytesHelper_tDBOutput_3()
												.limitBytePart1(insertedCount_tDBOutput_3, pstmt_tDBOutput_3);

										batchSizeCounter_tDBOutput_3 = 0;
									}
									if (rowsToCommitCount_tDBOutput_3 != 0) {

									}
									conn_tDBOutput_3.commit();
									if (rowsToCommitCount_tDBOutput_3 != 0) {

										rowsToCommitCount_tDBOutput_3 = 0;
									}
									commitCounter_tDBOutput_3 = 0;
								}

								tos_count_tDBOutput_3++;

								/**
								 * [tDBOutput_3 main ] stop
								 */

								/**
								 * [tDBOutput_3 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_3";

								/**
								 * [tDBOutput_3 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_3 process_data_end ] start
								 */

								currentComponent = "tDBOutput_3";

								/**
								 * [tDBOutput_3 process_data_end ] stop
								 */

							} // End of branch "row23"

							/**
							 * [tUniqRow_6 process_data_end ] start
							 */

							currentComponent = "tUniqRow_6";

							/**
							 * [tUniqRow_6 process_data_end ] stop
							 */

						} // End of branch "DiimSupplier"

						/**
						 * [tMap_9 process_data_end ] start
						 */

						currentComponent = "tMap_9";

						/**
						 * [tMap_9 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 process_data_end ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 end ] start
						 */

						currentComponent = "tDBInput_5";

					}
				} finally {
					if (rs_tDBInput_5 != null) {
						rs_tDBInput_5.close();
					}
					if (stmt_tDBInput_5 != null) {
						stmt_tDBInput_5.close();
					}
					if (conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {

						conn_tDBInput_5.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_5_NB_LINE", nb_line_tDBInput_5);

				ok_Hash.put("tDBInput_5", true);
				end_Hash.put("tDBInput_5", System.currentTimeMillis());

				/**
				 * [tDBInput_5 end ] stop
				 */

				/**
				 * [tMap_9 end ] start
				 */

				currentComponent = "tMap_9";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row21");
				}

				ok_Hash.put("tMap_9", true);
				end_Hash.put("tMap_9", System.currentTimeMillis());

				/**
				 * [tMap_9 end ] stop
				 */

				/**
				 * [tUniqRow_6 end ] start
				 */

				currentComponent = "tUniqRow_6";

				globalMap.put("tUniqRow_6_NB_UNIQUES", nb_uniques_tUniqRow_6);
				globalMap.put("tUniqRow_6_NB_DUPLICATES", nb_duplicates_tUniqRow_6);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "DiimSupplier");
				}

				ok_Hash.put("tUniqRow_6", true);
				end_Hash.put("tUniqRow_6", System.currentTimeMillis());

				/**
				 * [tUniqRow_6 end ] stop
				 */

				/**
				 * [tDBOutput_3 end ] start
				 */

				currentComponent = "tDBOutput_3";

				try {
					int countSum_tDBOutput_3 = 0;
					if (pstmt_tDBOutput_3 != null && batchSizeCounter_tDBOutput_3 > 0) {

						for (int countEach_tDBOutput_3 : pstmt_tDBOutput_3.executeBatch()) {
							if (countEach_tDBOutput_3 == -2 || countEach_tDBOutput_3 == -3) {
								break;
							}
							countSum_tDBOutput_3 += countEach_tDBOutput_3;
						}
						rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;

					}

					insertedCount_tDBOutput_3 += countSum_tDBOutput_3;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_3_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_3 = 0;
					for (int countEach_tDBOutput_3 : e.getUpdateCounts()) {
						countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
					}
					rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;

					insertedCount_tDBOutput_3 += countSum_tDBOutput_3;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_3 != null) {

					pstmt_tDBOutput_3.close();
					resourceMap.remove("pstmt_tDBOutput_3");

				}
				resourceMap.put("statementClosed_tDBOutput_3", true);
				if (rowsToCommitCount_tDBOutput_3 != 0) {

				}
				conn_tDBOutput_3.commit();
				if (rowsToCommitCount_tDBOutput_3 != 0) {

					rowsToCommitCount_tDBOutput_3 = 0;
				}
				commitCounter_tDBOutput_3 = 0;
				conn_tDBOutput_3.close();
				resourceMap.put("finish_tDBOutput_3", true);

				nb_line_deleted_tDBOutput_3 = nb_line_deleted_tDBOutput_3 + deletedCount_tDBOutput_3;
				nb_line_update_tDBOutput_3 = nb_line_update_tDBOutput_3 + updatedCount_tDBOutput_3;
				nb_line_inserted_tDBOutput_3 = nb_line_inserted_tDBOutput_3 + insertedCount_tDBOutput_3;
				nb_line_rejected_tDBOutput_3 = nb_line_rejected_tDBOutput_3 + rejectedCount_tDBOutput_3;

				globalMap.put("tDBOutput_3_NB_LINE", nb_line_tDBOutput_3);
				globalMap.put("tDBOutput_3_NB_LINE_UPDATED", nb_line_update_tDBOutput_3);
				globalMap.put("tDBOutput_3_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_3);
				globalMap.put("tDBOutput_3_NB_LINE_DELETED", nb_line_deleted_tDBOutput_3);
				globalMap.put("tDBOutput_3_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_3);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row23");
				}

				ok_Hash.put("tDBOutput_3", true);
				end_Hash.put("tDBOutput_3", System.currentTimeMillis());

				/**
				 * [tDBOutput_3 end ] stop
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
				 * [tDBInput_5 finally ] start
				 */

				currentComponent = "tDBInput_5";

				/**
				 * [tDBInput_5 finally ] stop
				 */

				/**
				 * [tMap_9 finally ] start
				 */

				currentComponent = "tMap_9";

				/**
				 * [tMap_9 finally ] stop
				 */

				/**
				 * [tUniqRow_6 finally ] start
				 */

				currentComponent = "tUniqRow_6";

				/**
				 * [tUniqRow_6 finally ] stop
				 */

				/**
				 * [tDBOutput_3 finally ] start
				 */

				currentComponent = "tDBOutput_3";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_3") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_3 = null;
						if ((pstmtToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_3")) != null) {
							pstmtToClose_tDBOutput_3.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_3") == null) {
						java.sql.Connection ctn_tDBOutput_3 = null;
						if ((ctn_tDBOutput_3 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_3")) != null) {
							try {
								ctn_tDBOutput_3.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_3) {
								String errorMessage_tDBOutput_3 = "failed to close the connection in tDBOutput_3 :"
										+ sqlEx_tDBOutput_3.getMessage();
								System.err.println(errorMessage_tDBOutput_3);
							}
						}
					}
				}

				/**
				 * [tDBOutput_3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_project1 = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[0];

		public String Date;

		public String getDate() {
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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
				if (length > commonByteArray_ECOMMERCE_BRIEF_project1.length) {
					if (length < 1024 && commonByteArray_ECOMMERCE_BRIEF_project1.length == 0) {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[1024];
					} else {
						commonByteArray_ECOMMERCE_BRIEF_project1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length);
				strReturn = new String(commonByteArray_ECOMMERCE_BRIEF_project1, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readString(dis);

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_project1) {

				try {

					int length = 0;

					this.Date = readString(dis);

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

				// String

				writeString(this.Date, dos);

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

				// String

				writeString(this.Date, dos);

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
			sb.append("Date=" + Date);
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
		public int compareTo(row4Struct other) {

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

	public void tFileInputDelimited_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 0);

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

				row4Struct row4 = new row4Struct();

				/**
				 * [tDBOutput_4 begin ] start
				 */

				ok_Hash.put("tDBOutput_4", false);
				start_Hash.put("tDBOutput_4", System.currentTimeMillis());

				currentComponent = "tDBOutput_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tDBOutput_4 = 0;

				int nb_line_tDBOutput_4 = 0;
				int nb_line_update_tDBOutput_4 = 0;
				int nb_line_inserted_tDBOutput_4 = 0;
				int nb_line_deleted_tDBOutput_4 = 0;
				int nb_line_rejected_tDBOutput_4 = 0;

				int deletedCount_tDBOutput_4 = 0;
				int updatedCount_tDBOutput_4 = 0;
				int insertedCount_tDBOutput_4 = 0;
				int rowsToCommitCount_tDBOutput_4 = 0;
				int rejectedCount_tDBOutput_4 = 0;
				String dbschema_tDBOutput_4 = null;
				String tableName_tDBOutput_4 = null;
				boolean whetherReject_tDBOutput_4 = false;

				java.util.Calendar calendar_tDBOutput_4 = java.util.Calendar.getInstance();
				long year1_tDBOutput_4 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_4 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_4 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_4;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_4 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_4 = null;
				String dbUser_tDBOutput_4 = null;
				dbschema_tDBOutput_4 = "dbo";
				String driverClass_tDBOutput_4 = "net.sourceforge.jtds.jdbc.Driver";

				java.lang.Class.forName(driverClass_tDBOutput_4);
				String port_tDBOutput_4 = "1433";
				String dbname_tDBOutput_4 = "ecommerv2";
				String url_tDBOutput_4 = "jdbc:jtds:sqlserver://" + "localhost";
				if (!"".equals(port_tDBOutput_4)) {
					url_tDBOutput_4 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_4)) {
					url_tDBOutput_4 += "//" + "ecommerv2";

				}
				url_tDBOutput_4 += ";appName=" + projectName + ";" + "";
				dbUser_tDBOutput_4 = "ismaill";

				final String decryptedPassword_tDBOutput_4 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:rvF/UnSXeQqcrw+dOFmICoAu3DCDUO8fnH7eZzb40AU=");

				String dbPwd_tDBOutput_4 = decryptedPassword_tDBOutput_4;
				conn_tDBOutput_4 = java.sql.DriverManager.getConnection(url_tDBOutput_4, dbUser_tDBOutput_4,
						dbPwd_tDBOutput_4);

				resourceMap.put("conn_tDBOutput_4", conn_tDBOutput_4);

				conn_tDBOutput_4.setAutoCommit(false);
				int commitEvery_tDBOutput_4 = 10000;
				int commitCounter_tDBOutput_4 = 0;

				int batchSize_tDBOutput_4 = 10000;
				int batchSizeCounter_tDBOutput_4 = 0;

				if (dbschema_tDBOutput_4 == null || dbschema_tDBOutput_4.trim().length() == 0) {
					tableName_tDBOutput_4 = "ROW";
				} else {
					tableName_tDBOutput_4 = dbschema_tDBOutput_4 + "].[" + "ROW";
				}
				int count_tDBOutput_4 = 0;

				boolean whetherExist_tDBOutput_4 = false;
				try (java.sql.Statement isExistStmt_tDBOutput_4 = conn_tDBOutput_4.createStatement()) {
					try {
						isExistStmt_tDBOutput_4.execute("SELECT TOP 1 1 FROM [" + tableName_tDBOutput_4 + "]");
						whetherExist_tDBOutput_4 = true;
					} catch (java.lang.Exception e) {
						globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());
						whetherExist_tDBOutput_4 = false;
					}
				}
				if (!whetherExist_tDBOutput_4) {
					try (java.sql.Statement stmtCreate_tDBOutput_4 = conn_tDBOutput_4.createStatement()) {
						stmtCreate_tDBOutput_4.execute("CREATE TABLE [" + tableName_tDBOutput_4
								+ "]([Date] VARCHAR(250)  ,[ProductName] VARCHAR(250)  ,[ProductCategory] VARCHAR(250)  ,[ProductSubCategory] VARCHAR(250)  ,[ProductPrice] VARCHAR(250)  ,[CustomerName] VARCHAR(250)  ,[CustomerEmail] VARCHAR(250)  ,[CustomerAddress] VARCHAR(250)  ,[CustomerPhone] VARCHAR(250)  ,[CustomerSegment] VARCHAR(250)  ,[SupplierName] VARCHAR(250)  ,[SupplierLocation] VARCHAR(250)  ,[SupplierContact] VARCHAR(250)  ,[ShipperName] VARCHAR(250)  ,[ShippingMethod] VARCHAR(250)  ,[QuantitySold] VARCHAR(21)  ,[TotalAmount] VARCHAR(250)  ,[DiscountAmount] VARCHAR(250)  ,[NetAmount] REAL ,[StockReceived] REAL ,[StockSold] REAL ,[StockOnHand] REAL )");
					}
				}
				String insert_tDBOutput_4 = "INSERT INTO [" + tableName_tDBOutput_4
						+ "] ([Date],[ProductName],[ProductCategory],[ProductSubCategory],[ProductPrice],[CustomerName],[CustomerEmail],[CustomerAddress],[CustomerPhone],[CustomerSegment],[SupplierName],[SupplierLocation],[SupplierContact],[ShipperName],[ShippingMethod],[QuantitySold],[TotalAmount],[DiscountAmount],[NetAmount],[StockReceived],[StockSold],[StockOnHand]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(insert_tDBOutput_4);
				resourceMap.put("pstmt_tDBOutput_4", pstmt_tDBOutput_4);

				/**
				 * [tDBOutput_4 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_4 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_4", false);
				start_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_4";

				int tos_count_tFileInputDelimited_4 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_4 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_4 = 0;
				int footer_tFileInputDelimited_4 = 0;
				int totalLinetFileInputDelimited_4 = 0;
				int limittFileInputDelimited_4 = -1;
				int lastLinetFileInputDelimited_4 = -1;

				char fieldSeparator_tFileInputDelimited_4[] = null;

				// support passing value (property: Field Separator) by 'context.fs' or
				// 'globalMap.get("fs")'.
				if (((String) ",").length() > 0) {
					fieldSeparator_tFileInputDelimited_4 = ((String) ",").toCharArray();
				} else {
					throw new IllegalArgumentException("Field Separator must be assigned a char.");
				}

				char rowSeparator_tFileInputDelimited_4[] = null;

				// support passing value (property: Row Separator) by 'context.rs' or
				// 'globalMap.get("rs")'.
				if (((String) "\n").length() > 0) {
					rowSeparator_tFileInputDelimited_4 = ((String) "\n").toCharArray();
				} else {
					throw new IllegalArgumentException("Row Separator must be assigned a char.");
				}

				Object filename_tFileInputDelimited_4 = /** Start field tFileInputDelimited_4:FILENAME */
						"C:/Users/YouCode/Desktop/optimize e-Commerce data/data/ecommerce_data.csv"/**
																									 * End field
																									 * tFileInputDelimited_4:FILENAME
																									 */
				;
				com.talend.csv.CSVReader csvReadertFileInputDelimited_4 = null;

				try {

					String[] rowtFileInputDelimited_4 = null;
					int currentLinetFileInputDelimited_4 = 0;
					int outputLinetFileInputDelimited_4 = 0;
					try {// TD110 begin
						if (filename_tFileInputDelimited_4 instanceof java.io.InputStream) {

							int footer_value_tFileInputDelimited_4 = 0;
							if (footer_value_tFileInputDelimited_4 > 0) {
								throw new java.lang.Exception(
										"When the input source is a stream,footer shouldn't be bigger than 0.");
							}

							csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
									(java.io.InputStream) filename_tFileInputDelimited_4,
									fieldSeparator_tFileInputDelimited_4[0], "UTF-8");
						} else {
							csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
									String.valueOf(filename_tFileInputDelimited_4),
									fieldSeparator_tFileInputDelimited_4[0], "UTF-8");
						}

						csvReadertFileInputDelimited_4.setTrimWhitespace(false);
						if ((rowSeparator_tFileInputDelimited_4[0] != '\n')
								&& (rowSeparator_tFileInputDelimited_4[0] != '\r'))
							csvReadertFileInputDelimited_4.setLineEnd("" + rowSeparator_tFileInputDelimited_4[0]);

						csvReadertFileInputDelimited_4.setQuoteChar('\"');

						csvReadertFileInputDelimited_4.setEscapeChar(csvReadertFileInputDelimited_4.getQuoteChar());

						if (footer_tFileInputDelimited_4 > 0) {
							for (totalLinetFileInputDelimited_4 = 0; totalLinetFileInputDelimited_4 < 1; totalLinetFileInputDelimited_4++) {
								csvReadertFileInputDelimited_4.readNext();
							}
							csvReadertFileInputDelimited_4.setSkipEmptyRecords(false);
							while (csvReadertFileInputDelimited_4.readNext()) {

								totalLinetFileInputDelimited_4++;

							}
							int lastLineTemptFileInputDelimited_4 = totalLinetFileInputDelimited_4
									- footer_tFileInputDelimited_4 < 0 ? 0
											: totalLinetFileInputDelimited_4 - footer_tFileInputDelimited_4;
							if (lastLinetFileInputDelimited_4 > 0) {
								lastLinetFileInputDelimited_4 = lastLinetFileInputDelimited_4 < lastLineTemptFileInputDelimited_4
										? lastLinetFileInputDelimited_4
										: lastLineTemptFileInputDelimited_4;
							} else {
								lastLinetFileInputDelimited_4 = lastLineTemptFileInputDelimited_4;
							}

							csvReadertFileInputDelimited_4.close();
							if (filename_tFileInputDelimited_4 instanceof java.io.InputStream) {
								csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
										(java.io.InputStream) filename_tFileInputDelimited_4,
										fieldSeparator_tFileInputDelimited_4[0], "UTF-8");
							} else {
								csvReadertFileInputDelimited_4 = new com.talend.csv.CSVReader(
										String.valueOf(filename_tFileInputDelimited_4),
										fieldSeparator_tFileInputDelimited_4[0], "UTF-8");
							}
							csvReadertFileInputDelimited_4.setTrimWhitespace(false);
							if ((rowSeparator_tFileInputDelimited_4[0] != '\n')
									&& (rowSeparator_tFileInputDelimited_4[0] != '\r'))
								csvReadertFileInputDelimited_4.setLineEnd("" + rowSeparator_tFileInputDelimited_4[0]);

							csvReadertFileInputDelimited_4.setQuoteChar('\"');

							csvReadertFileInputDelimited_4.setEscapeChar(csvReadertFileInputDelimited_4.getQuoteChar());

						}

						if (limittFileInputDelimited_4 != 0) {
							for (currentLinetFileInputDelimited_4 = 0; currentLinetFileInputDelimited_4 < 1; currentLinetFileInputDelimited_4++) {
								csvReadertFileInputDelimited_4.readNext();
							}
						}
						csvReadertFileInputDelimited_4.setSkipEmptyRecords(false);

					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					} // TD110 end

					while (limittFileInputDelimited_4 != 0 && csvReadertFileInputDelimited_4 != null
							&& csvReadertFileInputDelimited_4.readNext()) {
						rowstate_tFileInputDelimited_4.reset();

						rowtFileInputDelimited_4 = csvReadertFileInputDelimited_4.getValues();

						currentLinetFileInputDelimited_4++;

						if (lastLinetFileInputDelimited_4 > -1
								&& currentLinetFileInputDelimited_4 > lastLinetFileInputDelimited_4) {
							break;
						}
						outputLinetFileInputDelimited_4++;
						if (limittFileInputDelimited_4 > 0
								&& outputLinetFileInputDelimited_4 > limittFileInputDelimited_4) {
							break;
						}

						row4 = null;

						boolean whetherReject_tFileInputDelimited_4 = false;
						row4 = new row4Struct();
						try {

							char fieldSeparator_tFileInputDelimited_4_ListType[] = null;
							// support passing value (property: Field Separator) by 'context.fs' or
							// 'globalMap.get("fs")'.
							if (((String) ",").length() > 0) {
								fieldSeparator_tFileInputDelimited_4_ListType = ((String) ",").toCharArray();
							} else {
								throw new IllegalArgumentException("Field Separator must be assigned a char.");
							}
							if (rowtFileInputDelimited_4.length == 1 && ("\015").equals(rowtFileInputDelimited_4[0])) {// empty
																														// line
																														// when
																														// row
																														// separator
																														// is
																														// '\n'

								row4.Date = null;

								row4.ProductName = null;

								row4.ProductCategory = null;

								row4.ProductSubCategory = null;

								row4.ProductPrice = null;

								row4.CustomerName = null;

								row4.CustomerEmail = null;

								row4.CustomerAddress = null;

								row4.CustomerPhone = null;

								row4.CustomerSegment = null;

								row4.SupplierName = null;

								row4.SupplierLocation = null;

								row4.SupplierContact = null;

								row4.ShipperName = null;

								row4.ShippingMethod = null;

								row4.QuantitySold = null;

								row4.TotalAmount = null;

								row4.DiscountAmount = null;

								row4.NetAmount = null;

								row4.StockReceived = null;

								row4.StockSold = null;

								row4.StockOnHand = null;

							} else {

								int columnIndexWithD_tFileInputDelimited_4 = 0; // Column Index

								columnIndexWithD_tFileInputDelimited_4 = 0;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.Date = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.Date = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 1;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.ProductName = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.ProductName = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 2;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.ProductCategory = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.ProductCategory = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 3;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.ProductSubCategory = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.ProductSubCategory = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 4;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.ProductPrice = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.ProductPrice = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 5;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.CustomerName = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.CustomerName = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 6;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.CustomerEmail = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.CustomerEmail = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 7;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.CustomerAddress = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.CustomerAddress = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 8;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.CustomerPhone = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.CustomerPhone = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 9;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.CustomerSegment = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.CustomerSegment = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 10;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.SupplierName = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.SupplierName = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 11;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.SupplierLocation = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.SupplierLocation = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 12;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.SupplierContact = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.SupplierContact = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 13;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.ShipperName = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.ShipperName = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 14;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.ShippingMethod = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.ShippingMethod = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 15;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.QuantitySold = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.QuantitySold = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 16;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.TotalAmount = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.TotalAmount = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 17;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									row4.DiscountAmount = rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4];

								} else {

									row4.DiscountAmount = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 18;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									if (rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4].length() > 0) {
										try {

											row4.NetAmount = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4]);

										} catch (java.lang.Exception ex_tFileInputDelimited_4) {
											globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",
													ex_tFileInputDelimited_4.getMessage());
											rowstate_tFileInputDelimited_4.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"NetAmount", "row4",
															rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4],
															ex_tFileInputDelimited_4),
													ex_tFileInputDelimited_4));
										}
									} else {

										row4.NetAmount = null;

									}

								} else {

									row4.NetAmount = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 19;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									if (rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4].length() > 0) {
										try {

											row4.StockReceived = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4]);

										} catch (java.lang.Exception ex_tFileInputDelimited_4) {
											globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",
													ex_tFileInputDelimited_4.getMessage());
											rowstate_tFileInputDelimited_4.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"StockReceived", "row4",
															rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4],
															ex_tFileInputDelimited_4),
													ex_tFileInputDelimited_4));
										}
									} else {

										row4.StockReceived = null;

									}

								} else {

									row4.StockReceived = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 20;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									if (rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4].length() > 0) {
										try {

											row4.StockSold = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4]);

										} catch (java.lang.Exception ex_tFileInputDelimited_4) {
											globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",
													ex_tFileInputDelimited_4.getMessage());
											rowstate_tFileInputDelimited_4.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"StockSold", "row4",
															rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4],
															ex_tFileInputDelimited_4),
													ex_tFileInputDelimited_4));
										}
									} else {

										row4.StockSold = null;

									}

								} else {

									row4.StockSold = null;

								}

								columnIndexWithD_tFileInputDelimited_4 = 21;

								if (columnIndexWithD_tFileInputDelimited_4 < rowtFileInputDelimited_4.length) {

									if (rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4].length() > 0) {
										try {

											row4.StockOnHand = ParserUtils.parseTo_Float(
													rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4]);

										} catch (java.lang.Exception ex_tFileInputDelimited_4) {
											globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",
													ex_tFileInputDelimited_4.getMessage());
											rowstate_tFileInputDelimited_4.setException(new RuntimeException(String
													.format("Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"StockOnHand", "row4",
															rowtFileInputDelimited_4[columnIndexWithD_tFileInputDelimited_4],
															ex_tFileInputDelimited_4),
													ex_tFileInputDelimited_4));
										}
									} else {

										row4.StockOnHand = null;

									}

								} else {

									row4.StockOnHand = null;

								}

							}

							if (rowstate_tFileInputDelimited_4.getException() != null) {
								throw rowstate_tFileInputDelimited_4.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_4 = true;

							System.err.println(e.getMessage());
							row4 = null;

							globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());

						}

						/**
						 * [tFileInputDelimited_4 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_4 main ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						tos_count_tFileInputDelimited_4++;

						/**
						 * [tFileInputDelimited_4 main ] stop
						 */

						/**
						 * [tFileInputDelimited_4 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						/**
						 * [tFileInputDelimited_4 process_data_begin ] stop
						 */
// Start of branch "row4"
						if (row4 != null) {

							/**
							 * [tDBOutput_4 main ] start
							 */

							currentComponent = "tDBOutput_4";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row4"

								);
							}

							whetherReject_tDBOutput_4 = false;
							if (row4.Date == null) {
								pstmt_tDBOutput_4.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(1, row4.Date);
							}

							if (row4.ProductName == null) {
								pstmt_tDBOutput_4.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(2, row4.ProductName);
							}

							if (row4.ProductCategory == null) {
								pstmt_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(3, row4.ProductCategory);
							}

							if (row4.ProductSubCategory == null) {
								pstmt_tDBOutput_4.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(4, row4.ProductSubCategory);
							}

							if (row4.ProductPrice == null) {
								pstmt_tDBOutput_4.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(5, row4.ProductPrice);
							}

							if (row4.CustomerName == null) {
								pstmt_tDBOutput_4.setNull(6, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(6, row4.CustomerName);
							}

							if (row4.CustomerEmail == null) {
								pstmt_tDBOutput_4.setNull(7, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(7, row4.CustomerEmail);
							}

							if (row4.CustomerAddress == null) {
								pstmt_tDBOutput_4.setNull(8, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(8, row4.CustomerAddress);
							}

							if (row4.CustomerPhone == null) {
								pstmt_tDBOutput_4.setNull(9, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(9, row4.CustomerPhone);
							}

							if (row4.CustomerSegment == null) {
								pstmt_tDBOutput_4.setNull(10, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(10, row4.CustomerSegment);
							}

							if (row4.SupplierName == null) {
								pstmt_tDBOutput_4.setNull(11, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(11, row4.SupplierName);
							}

							if (row4.SupplierLocation == null) {
								pstmt_tDBOutput_4.setNull(12, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(12, row4.SupplierLocation);
							}

							if (row4.SupplierContact == null) {
								pstmt_tDBOutput_4.setNull(13, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(13, row4.SupplierContact);
							}

							if (row4.ShipperName == null) {
								pstmt_tDBOutput_4.setNull(14, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(14, row4.ShipperName);
							}

							if (row4.ShippingMethod == null) {
								pstmt_tDBOutput_4.setNull(15, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(15, row4.ShippingMethod);
							}

							if (row4.QuantitySold == null) {
								pstmt_tDBOutput_4.setNull(16, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(16, row4.QuantitySold);
							}

							if (row4.TotalAmount == null) {
								pstmt_tDBOutput_4.setNull(17, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(17, row4.TotalAmount);
							}

							if (row4.DiscountAmount == null) {
								pstmt_tDBOutput_4.setNull(18, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_4.setString(18, row4.DiscountAmount);
							}

							if (row4.NetAmount == null) {
								pstmt_tDBOutput_4.setNull(19, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_4.setFloat(19, row4.NetAmount);
							}

							if (row4.StockReceived == null) {
								pstmt_tDBOutput_4.setNull(20, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_4.setFloat(20, row4.StockReceived);
							}

							if (row4.StockSold == null) {
								pstmt_tDBOutput_4.setNull(21, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_4.setFloat(21, row4.StockSold);
							}

							if (row4.StockOnHand == null) {
								pstmt_tDBOutput_4.setNull(22, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_4.setFloat(22, row4.StockOnHand);
							}

							pstmt_tDBOutput_4.addBatch();
							nb_line_tDBOutput_4++;

							batchSizeCounter_tDBOutput_4++;

							if (!whetherReject_tDBOutput_4) {
							}
							////////// batch execute by batch size///////
							class LimitBytesHelper_tDBOutput_4 {
								public int limitBytePart1(int counter, java.sql.PreparedStatement pstmt_tDBOutput_4)
										throws Exception {
									try {

										for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
											if (countEach_tDBOutput_4 == -2 || countEach_tDBOutput_4 == -3) {
												break;
											}
											counter += countEach_tDBOutput_4;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());

										int countSum_tDBOutput_4 = 0;
										for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}

								public int limitBytePart2(int counter, java.sql.PreparedStatement pstmt_tDBOutput_4)
										throws Exception {
									try {

										for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
											if (countEach_tDBOutput_4 == -2 || countEach_tDBOutput_4 == -3) {
												break;
											}
											counter += countEach_tDBOutput_4;
										}

									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());

										for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
											counter += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
										}

										System.err.println(e.getMessage());

									}
									return counter;
								}
							}
							if ((batchSize_tDBOutput_4 > 0)
									&& (batchSize_tDBOutput_4 <= batchSizeCounter_tDBOutput_4)) {

								insertedCount_tDBOutput_4 = new LimitBytesHelper_tDBOutput_4()
										.limitBytePart1(insertedCount_tDBOutput_4, pstmt_tDBOutput_4);
								rowsToCommitCount_tDBOutput_4 = insertedCount_tDBOutput_4;

								batchSizeCounter_tDBOutput_4 = 0;
							}

							//////////// commit every////////////

							commitCounter_tDBOutput_4++;
							if (commitEvery_tDBOutput_4 <= commitCounter_tDBOutput_4) {
								if ((batchSize_tDBOutput_4 > 0) && (batchSizeCounter_tDBOutput_4 > 0)) {

									insertedCount_tDBOutput_4 = new LimitBytesHelper_tDBOutput_4()
											.limitBytePart1(insertedCount_tDBOutput_4, pstmt_tDBOutput_4);

									batchSizeCounter_tDBOutput_4 = 0;
								}
								if (rowsToCommitCount_tDBOutput_4 != 0) {

								}
								conn_tDBOutput_4.commit();
								if (rowsToCommitCount_tDBOutput_4 != 0) {

									rowsToCommitCount_tDBOutput_4 = 0;
								}
								commitCounter_tDBOutput_4 = 0;
							}

							tos_count_tDBOutput_4++;

							/**
							 * [tDBOutput_4 main ] stop
							 */

							/**
							 * [tDBOutput_4 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_4";

							/**
							 * [tDBOutput_4 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_4 process_data_end ] start
							 */

							currentComponent = "tDBOutput_4";

							/**
							 * [tDBOutput_4 process_data_end ] stop
							 */

						} // End of branch "row4"

						/**
						 * [tFileInputDelimited_4 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						/**
						 * [tFileInputDelimited_4 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_4 end ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						nb_line_tFileInputDelimited_4++;
					}

				} finally {
					if (!(filename_tFileInputDelimited_4 instanceof java.io.InputStream)) {
						if (csvReadertFileInputDelimited_4 != null) {
							csvReadertFileInputDelimited_4.close();
						}
					}
					if (csvReadertFileInputDelimited_4 != null) {
						globalMap.put("tFileInputDelimited_4_NB_LINE", nb_line_tFileInputDelimited_4);
					}

				}

				ok_Hash.put("tFileInputDelimited_4", true);
				end_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_4 end ] stop
				 */

				/**
				 * [tDBOutput_4 end ] start
				 */

				currentComponent = "tDBOutput_4";

				try {
					int countSum_tDBOutput_4 = 0;
					if (pstmt_tDBOutput_4 != null && batchSizeCounter_tDBOutput_4 > 0) {

						for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
							if (countEach_tDBOutput_4 == -2 || countEach_tDBOutput_4 == -3) {
								break;
							}
							countSum_tDBOutput_4 += countEach_tDBOutput_4;
						}
						rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;

					}

					insertedCount_tDBOutput_4 += countSum_tDBOutput_4;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_4 = 0;
					for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
						countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
					}
					rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;

					insertedCount_tDBOutput_4 += countSum_tDBOutput_4;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_4 != null) {

					pstmt_tDBOutput_4.close();
					resourceMap.remove("pstmt_tDBOutput_4");

				}
				resourceMap.put("statementClosed_tDBOutput_4", true);
				if (rowsToCommitCount_tDBOutput_4 != 0) {

				}
				conn_tDBOutput_4.commit();
				if (rowsToCommitCount_tDBOutput_4 != 0) {

					rowsToCommitCount_tDBOutput_4 = 0;
				}
				commitCounter_tDBOutput_4 = 0;
				conn_tDBOutput_4.close();
				resourceMap.put("finish_tDBOutput_4", true);

				nb_line_deleted_tDBOutput_4 = nb_line_deleted_tDBOutput_4 + deletedCount_tDBOutput_4;
				nb_line_update_tDBOutput_4 = nb_line_update_tDBOutput_4 + updatedCount_tDBOutput_4;
				nb_line_inserted_tDBOutput_4 = nb_line_inserted_tDBOutput_4 + insertedCount_tDBOutput_4;
				nb_line_rejected_tDBOutput_4 = nb_line_rejected_tDBOutput_4 + rejectedCount_tDBOutput_4;

				globalMap.put("tDBOutput_4_NB_LINE", nb_line_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_UPDATED", nb_line_update_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_DELETED", nb_line_deleted_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_4);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tDBOutput_4", true);
				end_Hash.put("tDBOutput_4", System.currentTimeMillis());

				/**
				 * [tDBOutput_4 end ] stop
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
				 * [tFileInputDelimited_4 finally ] start
				 */

				currentComponent = "tFileInputDelimited_4";

				/**
				 * [tFileInputDelimited_4 finally ] stop
				 */

				/**
				 * [tDBOutput_4 finally ] start
				 */

				currentComponent = "tDBOutput_4";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_4") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_4 = null;
						if ((pstmtToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_4")) != null) {
							pstmtToClose_tDBOutput_4.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_4") == null) {
						java.sql.Connection ctn_tDBOutput_4 = null;
						if ((ctn_tDBOutput_4 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_4")) != null) {
							try {
								ctn_tDBOutput_4.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_4) {
								String errorMessage_tDBOutput_4 = "failed to close the connection in tDBOutput_4 :"
										+ sqlEx_tDBOutput_4.getMessage();
								System.err.println(errorMessage_tDBOutput_4);
							}
						}
					}
				}

				/**
				 * [tDBOutput_4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 1);
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

	public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

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
				 * [tPostjob_1 begin ] start
				 */

				ok_Hash.put("tPostjob_1", false);
				start_Hash.put("tPostjob_1", System.currentTimeMillis());

				currentComponent = "tPostjob_1";

				int tos_count_tPostjob_1 = 0;

				/**
				 * [tPostjob_1 begin ] stop
				 */

				/**
				 * [tPostjob_1 main ] start
				 */

				currentComponent = "tPostjob_1";

				tos_count_tPostjob_1++;

				/**
				 * [tPostjob_1 main ] stop
				 */

				/**
				 * [tPostjob_1 process_data_begin ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_begin ] stop
				 */

				/**
				 * [tPostjob_1 process_data_end ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_end ] stop
				 */

				/**
				 * [tPostjob_1 end ] start
				 */

				currentComponent = "tPostjob_1";

				ok_Hash.put("tPostjob_1", true);
				end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBClose_1Process(globalMap);

				/**
				 * [tPostjob_1 end ] stop
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
				 * [tPostjob_1 finally ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
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
					runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tDBConnection_2Process(globalMap);

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
		final project1 project1Class = new project1();

		int exitCode = project1Class.runJobInTOS(args);

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
			java.io.InputStream inContext = project1.class.getClassLoader()
					.getResourceAsStream("ecommerce_brief/project1_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = project1.class.getClassLoader()
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
		tStatCatcher_1.addMessage("begin");

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

		try {
			tStatCatcher_1Process(globalMap);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tCreateTable_2Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tCreateTable_2) {
			globalMap.put("tCreateTable_2_SUBPROCESS_STATE", -1);

			e_tCreateTable_2.printStackTrace();

		}
		try {
			errorCode = null;
			tFileInputDelimited_4Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_4) {
			globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_4.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		try {
			errorCode = null;
			tPostjob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPostjob_1) {
			globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

			e_tPostjob_1.printStackTrace();

		}

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : project1");
		}
		tStatCatcher_1.addMessage(status == "" ? "end" : status, (end - startTime));
		try {
			tStatCatcher_1Process(globalMap);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
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
			obj_conn = globalMap.remove("conn_tDBConnection_2");
			if (null != obj_conn) {
				((java.sql.Connection) obj_conn).close();
			}
		} catch (java.lang.Exception e) {
		}
	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
		connections.put("conn_tDBConnection_2", globalMap.get("conn_tDBConnection_2"));

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
 * 617972 characters generated by Talend Open Studio for Data Integration on the
 * 3 février 2025, 18:24:39 UTC+01:00
 ************************************************************************************************/