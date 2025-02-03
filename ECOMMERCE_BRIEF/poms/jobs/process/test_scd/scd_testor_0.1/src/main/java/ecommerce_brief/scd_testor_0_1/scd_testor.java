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

	public void tUniqRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

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
					String tableName_tCreateTable_1 = "Dimproduct";
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

		public Float ProductPrice;

		public Float getProductPrice() {
			return this.ProductPrice;
		}

		public java.util.Date Date;

		public java.util.Date getDate() {
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

		public String CustomerZipCode;

		public String getCustomerZipCode() {
			return this.CustomerZipCode;
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

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

					this.Date = readDate(dis);

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerAddress = readString(dis);

					this.CustomerZipCode = readString(dis);

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

					length = dis.readByte();
					if (length == -1) {
						this.ProductPrice = null;
					} else {
						this.ProductPrice = dis.readFloat();
					}

					this.Date = readDate(dis);

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerAddress = readString(dis);

					this.CustomerZipCode = readString(dis);

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

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerAddress, dos);

				// String

				writeString(this.CustomerZipCode, dos);

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

				// java.util.Date

				writeDate(this.Date, dos);

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerAddress, dos);

				// String

				writeString(this.CustomerZipCode, dos);

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
			sb.append(",Date=" + String.valueOf(Date));
			sb.append(",CustomerName=" + CustomerName);
			sb.append(",CustomerEmail=" + CustomerEmail);
			sb.append(",CustomerAddress=" + CustomerAddress);
			sb.append(",CustomerZipCode=" + CustomerZipCode);
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

	public static class out2Struct implements routines.system.IPersistableRow<out2Struct> {
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

		public Double ProductPrice;

		public Double getProductPrice() {
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

		public String CustomerZipCode;

		public String getCustomerZipCode() {
			return this.CustomerZipCode;
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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

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
						this.ProductPrice = dis.readDouble();
					}

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerAddress = readString(dis);

					this.CustomerZipCode = readString(dis);

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

					length = dis.readByte();
					if (length == -1) {
						this.ProductPrice = null;
					} else {
						this.ProductPrice = dis.readDouble();
					}

					this.CustomerName = readString(dis);

					this.CustomerEmail = readString(dis);

					this.CustomerAddress = readString(dis);

					this.CustomerZipCode = readString(dis);

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

				// Double

				if (this.ProductPrice == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ProductPrice);
				}

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerAddress, dos);

				// String

				writeString(this.CustomerZipCode, dos);

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

				// Double

				if (this.ProductPrice == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ProductPrice);
				}

				// String

				writeString(this.CustomerName, dos);

				// String

				writeString(this.CustomerEmail, dos);

				// String

				writeString(this.CustomerAddress, dos);

				// String

				writeString(this.CustomerZipCode, dos);

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
			sb.append(",CustomerZipCode=" + CustomerZipCode);
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
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out2Struct other) {

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

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor = new byte[0];
		static byte[] commonByteArray_ECOMMERCE_BRIEF_scd_testor = new byte[0];

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

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
		public int compareTo(row3Struct other) {

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

			synchronized (commonByteArrayLock_ECOMMERCE_BRIEF_scd_testor) {

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
				row3Struct row3 = new row3Struct();
				out2Struct out2 = new out2Struct();
				out1Struct out1 = new out1Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out1");
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
						.decryptPassword("enc:routine.encryption.key.v1:9xWQLb35vT4loWDeWl5aI0wGR5Sct7Gki70d08MMwJQ=");

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
					tableName_tDBOutput_1 = "tranformed";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "tranformed";
				}
				int count_tDBOutput_1 = 0;

				try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					stmtDrop_tDBOutput_1.execute("DROP TABLE [" + tableName_tDBOutput_1 + "]");
				}
				try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1
							+ "]([ProductName] VARCHAR(250)  ,[ProductCategory] VARCHAR(15)  ,[ProductSubCategory] VARCHAR(15)  ,[ProductPrice] REAL ,[Date] DATETIME ,[CustomerName] VARCHAR(250)  ,[CustomerEmail] VARCHAR(250)  ,[CustomerAddress] VARCHAR(250)  ,[CustomerZipCode] VARCHAR(250)  ,[CustomerPhone] VARCHAR(250)  ,[CustomerSegment] VARCHAR(250)  ,[SupplierName] VARCHAR(500)  ,[SupplierLocation] VARCHAR(250)  ,[SupplierContact] VARCHAR(250)  ,[ShipperName] VARCHAR(250)  ,[ShippingMethod] VARCHAR(250)  ,[QuantitySold] INT ,[TotalAmount] REAL ,[DiscountAmount] REAL ,[NetAmount] REAL ,[StockReceived] REAL ,[StockSold] REAL ,[StockOnHand] REAL )");
				}
				String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1
						+ "] ([ProductName],[ProductCategory],[ProductSubCategory],[ProductPrice],[Date],[CustomerName],[CustomerEmail],[CustomerAddress],[CustomerZipCode],[CustomerPhone],[CustomerSegment],[SupplierName],[SupplierLocation],[SupplierContact],[ShipperName],[ShippingMethod],[QuantitySold],[TotalAmount],[DiscountAmount],[NetAmount],[StockReceived],[StockSold],[StockOnHand]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out2");
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
				 * [tMap_2 begin ] start
				 */

				ok_Hash.put("tMap_2", false);
				start_Hash.put("tMap_2", System.currentTimeMillis());

				currentComponent = "tMap_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tMap_2 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out2Struct out2_tmp = new out2Struct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tUniqRow_1 begin ] start
				 */

				ok_Hash.put("tUniqRow_1", false);
				start_Hash.put("tUniqRow_1", System.currentTimeMillis());

				currentComponent = "tUniqRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tUniqRow_1 = 0;

				class KeyStruct_tUniqRow_1 {

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
						final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;

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

				int nb_uniques_tUniqRow_1 = 0;
				int nb_duplicates_tUniqRow_1 = 0;
				KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
				java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>();

				/**
				 * [tUniqRow_1 begin ] stop
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
						.decryptPassword("enc:routine.encryption.key.v1:8vNNCh6ay4V+c4oBKQiW8c6vxBUzOtgh6ue/jFPs32E=");

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

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(1);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.Date = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row1.Date = tmpContent_tDBInput_2;
								}
							} else {
								row1.Date = null;
							}
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
						 * [tUniqRow_1 main ] start
						 */

						currentComponent = "tUniqRow_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

						row3 = null;
						if (row1.Date == null) {
							finder_tUniqRow_1.Date = null;
						} else {
							finder_tUniqRow_1.Date = row1.Date.toLowerCase();
						}
						if (row1.ProductName == null) {
							finder_tUniqRow_1.ProductName = null;
						} else {
							finder_tUniqRow_1.ProductName = row1.ProductName.toLowerCase();
						}
						if (row1.ProductCategory == null) {
							finder_tUniqRow_1.ProductCategory = null;
						} else {
							finder_tUniqRow_1.ProductCategory = row1.ProductCategory.toLowerCase();
						}
						if (row1.ProductSubCategory == null) {
							finder_tUniqRow_1.ProductSubCategory = null;
						} else {
							finder_tUniqRow_1.ProductSubCategory = row1.ProductSubCategory.toLowerCase();
						}
						if (row1.ProductPrice == null) {
							finder_tUniqRow_1.ProductPrice = null;
						} else {
							finder_tUniqRow_1.ProductPrice = row1.ProductPrice.toLowerCase();
						}
						if (row1.CustomerName == null) {
							finder_tUniqRow_1.CustomerName = null;
						} else {
							finder_tUniqRow_1.CustomerName = row1.CustomerName.toLowerCase();
						}
						if (row1.CustomerEmail == null) {
							finder_tUniqRow_1.CustomerEmail = null;
						} else {
							finder_tUniqRow_1.CustomerEmail = row1.CustomerEmail.toLowerCase();
						}
						if (row1.CustomerAddress == null) {
							finder_tUniqRow_1.CustomerAddress = null;
						} else {
							finder_tUniqRow_1.CustomerAddress = row1.CustomerAddress.toLowerCase();
						}
						if (row1.CustomerPhone == null) {
							finder_tUniqRow_1.CustomerPhone = null;
						} else {
							finder_tUniqRow_1.CustomerPhone = row1.CustomerPhone.toLowerCase();
						}
						if (row1.CustomerSegment == null) {
							finder_tUniqRow_1.CustomerSegment = null;
						} else {
							finder_tUniqRow_1.CustomerSegment = row1.CustomerSegment.toLowerCase();
						}
						if (row1.SupplierName == null) {
							finder_tUniqRow_1.SupplierName = null;
						} else {
							finder_tUniqRow_1.SupplierName = row1.SupplierName.toLowerCase();
						}
						if (row1.SupplierLocation == null) {
							finder_tUniqRow_1.SupplierLocation = null;
						} else {
							finder_tUniqRow_1.SupplierLocation = row1.SupplierLocation.toLowerCase();
						}
						if (row1.SupplierContact == null) {
							finder_tUniqRow_1.SupplierContact = null;
						} else {
							finder_tUniqRow_1.SupplierContact = row1.SupplierContact.toLowerCase();
						}
						if (row1.ShipperName == null) {
							finder_tUniqRow_1.ShipperName = null;
						} else {
							finder_tUniqRow_1.ShipperName = row1.ShipperName.toLowerCase();
						}
						if (row1.ShippingMethod == null) {
							finder_tUniqRow_1.ShippingMethod = null;
						} else {
							finder_tUniqRow_1.ShippingMethod = row1.ShippingMethod.toLowerCase();
						}
						if (row1.QuantitySold == null) {
							finder_tUniqRow_1.QuantitySold = null;
						} else {
							finder_tUniqRow_1.QuantitySold = row1.QuantitySold.toLowerCase();
						}
						if (row1.TotalAmount == null) {
							finder_tUniqRow_1.TotalAmount = null;
						} else {
							finder_tUniqRow_1.TotalAmount = row1.TotalAmount.toLowerCase();
						}
						if (row1.DiscountAmount == null) {
							finder_tUniqRow_1.DiscountAmount = null;
						} else {
							finder_tUniqRow_1.DiscountAmount = row1.DiscountAmount.toLowerCase();
						}
						finder_tUniqRow_1.NetAmount = row1.NetAmount;
						finder_tUniqRow_1.StockReceived = row1.StockReceived;
						finder_tUniqRow_1.StockSold = row1.StockSold;
						finder_tUniqRow_1.StockOnHand = row1.StockOnHand;
						finder_tUniqRow_1.hashCodeDirty = true;
						if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
							KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

							if (row1.Date == null) {
								new_tUniqRow_1.Date = null;
							} else {
								new_tUniqRow_1.Date = row1.Date.toLowerCase();
							}
							if (row1.ProductName == null) {
								new_tUniqRow_1.ProductName = null;
							} else {
								new_tUniqRow_1.ProductName = row1.ProductName.toLowerCase();
							}
							if (row1.ProductCategory == null) {
								new_tUniqRow_1.ProductCategory = null;
							} else {
								new_tUniqRow_1.ProductCategory = row1.ProductCategory.toLowerCase();
							}
							if (row1.ProductSubCategory == null) {
								new_tUniqRow_1.ProductSubCategory = null;
							} else {
								new_tUniqRow_1.ProductSubCategory = row1.ProductSubCategory.toLowerCase();
							}
							if (row1.ProductPrice == null) {
								new_tUniqRow_1.ProductPrice = null;
							} else {
								new_tUniqRow_1.ProductPrice = row1.ProductPrice.toLowerCase();
							}
							if (row1.CustomerName == null) {
								new_tUniqRow_1.CustomerName = null;
							} else {
								new_tUniqRow_1.CustomerName = row1.CustomerName.toLowerCase();
							}
							if (row1.CustomerEmail == null) {
								new_tUniqRow_1.CustomerEmail = null;
							} else {
								new_tUniqRow_1.CustomerEmail = row1.CustomerEmail.toLowerCase();
							}
							if (row1.CustomerAddress == null) {
								new_tUniqRow_1.CustomerAddress = null;
							} else {
								new_tUniqRow_1.CustomerAddress = row1.CustomerAddress.toLowerCase();
							}
							if (row1.CustomerPhone == null) {
								new_tUniqRow_1.CustomerPhone = null;
							} else {
								new_tUniqRow_1.CustomerPhone = row1.CustomerPhone.toLowerCase();
							}
							if (row1.CustomerSegment == null) {
								new_tUniqRow_1.CustomerSegment = null;
							} else {
								new_tUniqRow_1.CustomerSegment = row1.CustomerSegment.toLowerCase();
							}
							if (row1.SupplierName == null) {
								new_tUniqRow_1.SupplierName = null;
							} else {
								new_tUniqRow_1.SupplierName = row1.SupplierName.toLowerCase();
							}
							if (row1.SupplierLocation == null) {
								new_tUniqRow_1.SupplierLocation = null;
							} else {
								new_tUniqRow_1.SupplierLocation = row1.SupplierLocation.toLowerCase();
							}
							if (row1.SupplierContact == null) {
								new_tUniqRow_1.SupplierContact = null;
							} else {
								new_tUniqRow_1.SupplierContact = row1.SupplierContact.toLowerCase();
							}
							if (row1.ShipperName == null) {
								new_tUniqRow_1.ShipperName = null;
							} else {
								new_tUniqRow_1.ShipperName = row1.ShipperName.toLowerCase();
							}
							if (row1.ShippingMethod == null) {
								new_tUniqRow_1.ShippingMethod = null;
							} else {
								new_tUniqRow_1.ShippingMethod = row1.ShippingMethod.toLowerCase();
							}
							if (row1.QuantitySold == null) {
								new_tUniqRow_1.QuantitySold = null;
							} else {
								new_tUniqRow_1.QuantitySold = row1.QuantitySold.toLowerCase();
							}
							if (row1.TotalAmount == null) {
								new_tUniqRow_1.TotalAmount = null;
							} else {
								new_tUniqRow_1.TotalAmount = row1.TotalAmount.toLowerCase();
							}
							if (row1.DiscountAmount == null) {
								new_tUniqRow_1.DiscountAmount = null;
							} else {
								new_tUniqRow_1.DiscountAmount = row1.DiscountAmount.toLowerCase();
							}
							new_tUniqRow_1.NetAmount = row1.NetAmount;
							new_tUniqRow_1.StockReceived = row1.StockReceived;
							new_tUniqRow_1.StockSold = row1.StockSold;
							new_tUniqRow_1.StockOnHand = row1.StockOnHand;

							keystUniqRow_1.add(new_tUniqRow_1);
							if (row3 == null) {

								row3 = new row3Struct();
							}
							row3.Date = row1.Date;
							row3.ProductName = row1.ProductName;
							row3.ProductCategory = row1.ProductCategory;
							row3.ProductSubCategory = row1.ProductSubCategory;
							row3.ProductPrice = row1.ProductPrice;
							row3.CustomerName = row1.CustomerName;
							row3.CustomerEmail = row1.CustomerEmail;
							row3.CustomerAddress = row1.CustomerAddress;
							row3.CustomerPhone = row1.CustomerPhone;
							row3.CustomerSegment = row1.CustomerSegment;
							row3.SupplierName = row1.SupplierName;
							row3.SupplierLocation = row1.SupplierLocation;
							row3.SupplierContact = row1.SupplierContact;
							row3.ShipperName = row1.ShipperName;
							row3.ShippingMethod = row1.ShippingMethod;
							row3.QuantitySold = row1.QuantitySold;
							row3.TotalAmount = row1.TotalAmount;
							row3.DiscountAmount = row1.DiscountAmount;
							row3.NetAmount = row1.NetAmount;
							row3.StockReceived = row1.StockReceived;
							row3.StockSold = row1.StockSold;
							row3.StockOnHand = row1.StockOnHand;
							nb_uniques_tUniqRow_1++;
						} else {
							nb_duplicates_tUniqRow_1++;
						}

						tos_count_tUniqRow_1++;

						/**
						 * [tUniqRow_1 main ] stop
						 */

						/**
						 * [tUniqRow_1 process_data_begin ] start
						 */

						currentComponent = "tUniqRow_1";

						/**
						 * [tUniqRow_1 process_data_begin ] stop
						 */
// Start of branch "row3"
						if (row3 != null) {

							/**
							 * [tMap_2 main ] start
							 */

							currentComponent = "tMap_2";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row3"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_2 = false;
							boolean mainRowRejected_tMap_2 = false;

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
								// ###############################
								// # Output tables

								out2 = null;

// # Output table : 'out2'
								out2_tmp.Date = row1.Date == null || row1.Date.isEmpty() ? null
										: row1.Date.matches("^\\d{4}-\\d{2}-\\d{2}$")
												? TalendDate.parseDate("dd-MM-yyyy",
														TalendDate.formatDate("dd-MM-yyyy",
																TalendDate.parseDate("yyyy-MM-dd", row1.Date)))
												: TalendDate.parseDate("dd-MM-yyyy", row1.Date);
								out2_tmp.ProductName = row1.ProductName;
								out2_tmp.ProductCategory = (row1.ProductSubCategory.equals("Headphones") ? "Electronics"
										: (row1.ProductSubCategory.equals("Mobile") ? "Electronics"
												: (row1.ProductSubCategory.equals("Camera") ? "Electronics"
														: (row1.ProductSubCategory.equals("Academic") ? "Books"
																: (row1.ProductSubCategory.equals("Fiction") ? "Books"
																		: (row1.ProductSubCategory.equals("Non-fiction")
																				? "Books"
																				: (row1.ProductSubCategory
																						.equals("Shirt")
																								? "Clothing"
																								: (row1.ProductSubCategory
																										.equals("Educational")
																												? "Toys"
																												: (row1.ProductSubCategory
																														.equals("Dolls")
																																? "Toys"
																																: (row1.ProductSubCategory
																																		.equals("Action Figures")
																																				? "Toys"
																																				: (row1.ProductSubCategory
																																						.equals("Gardening Tools")
																																								? "Home & Garden"
																																								: (row1.ProductSubCategory
																																										.equals("Decor")
																																												? "Home & Garden"
																																												: (row1.ProductSubCategory
																																														.equals("Furniture")
																																																? "Home & Garden"
																																																: "Other")))))))))))));
								out2_tmp.ProductSubCategory = row1.ProductSubCategory;
								out2_tmp.ProductPrice = Double.valueOf(row1.TotalAmount)
										/ Integer.valueOf(row1.QuantitySold);
								out2_tmp.CustomerName = row1.CustomerName;
								out2_tmp.CustomerEmail = row1.CustomerEmail;
								out2_tmp.CustomerAddress = row1.CustomerAddress;
								out2_tmp.CustomerZipCode = row1.CustomerAddress
										.substring(row1.CustomerAddress.length() - 8, row1.CustomerAddress.length());
								out2_tmp.CustomerPhone = row1.CustomerPhone.replace("x", "-");
								out2_tmp.CustomerSegment = row1.CustomerSegment;
								out2_tmp.SupplierName = row1.SupplierName;
								out2_tmp.SupplierLocation = row1.SupplierLocation;
								out2_tmp.SupplierContact = row1.SupplierContact != null
										&& !row1.SupplierContact.isEmpty() ? row1.SupplierContact.replace("x", "-")
												: null;
								out2_tmp.ShipperName = row1.ShipperName;
								out2_tmp.ShippingMethod = row1.ShippingMethod;
								out2_tmp.QuantitySold = Integer.valueOf(row1.QuantitySold);
								out2_tmp.TotalAmount = Float.valueOf(row1.TotalAmount);
								out2_tmp.DiscountAmount = Float.valueOf(row1.DiscountAmount);
								out2_tmp.NetAmount = Float.valueOf(row1.NetAmount);
								out2_tmp.StockReceived = row1.StockReceived;
								out2_tmp.StockSold = row1.StockSold;
								out2_tmp.StockOnHand = row1.StockOnHand;
								out2 = out2_tmp;
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_2 = false;

							tos_count_tMap_2++;

							/**
							 * [tMap_2 main ] stop
							 */

							/**
							 * [tMap_2 process_data_begin ] start
							 */

							currentComponent = "tMap_2";

							/**
							 * [tMap_2 process_data_begin ] stop
							 */
// Start of branch "out2"
							if (out2 != null) {

								/**
								 * [tMap_1 main ] start
								 */

								currentComponent = "tMap_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "out2"

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
											(out2.ProductName + out2.ProductSubCategory + out2.ProductSubCategory)
													.hashCode() % 1000)
											+ 1);// ###############################
									// ###############################
									// # Output tables

									out1 = null;

// # Output table : 'out1'
									out1_tmp.ProductName = (out2.ProductCategory.equals("Electronics")
											&& out2.ProductSubCategory.equals("Headphones")
											&& out2.ProductName.equals("NonExistentProduct")
											&& (out2.ProductPrice > (185.942954 - 69.430179)
													&& out2.ProductPrice < (185.942954 + 69.430179)))
															? "Kristine"
															: (out2.ProductCategory.equals("Electronics")
																	&& out2.ProductSubCategory.equals("Headphones")
																	&& out2.ProductName.equals("NonExistentProduct")
																	&& (out2.ProductPrice > (377.444337 - 140.092750)
																			&& out2.ProductPrice < (377.444337
																					+ 140.092750)))
																							? "Shawn"
																							: (out2.ProductCategory
																									.equals("Electronics")
																									&& out2.ProductSubCategory
																											.equals("Headphones")
																									&& out2.ProductName
																											.equals("NonExistentProduct")
																									&& (out2.ProductPrice > (523.756141
																											- 204.923598)
																											&& out2.ProductPrice < (523.756141
																													+ 204.923598)))
																															? "Justin"
																															: (out2.ProductCategory
																																	.equals("Electronics")
																																	&& out2.ProductSubCategory
																																			.equals("Headphones")
																																	&& out2.ProductName
																																			.equals("NonExistentProduct")
																																	&& (out2.ProductPrice > (500.691539
																																			- 210.346327)
																																			&& out2.ProductPrice < (500.691539
																																					+ 210.346327)))
																																							? "Pamela"
																																							: (out2.ProductCategory
																																									.equals("Electronics")
																																									&& out2.ProductSubCategory
																																											.equals("Headphones")
																																									&& out2.ProductName
																																											.equals("NonExistentProduct")
																																									&& (out2.ProductPrice > (722.857148
																																											- 255.970663)
																																											&& out2.ProductPrice < (722.857148
																																													+ 255.970663)))
																																															? "Cynthia"
																																															: (out2.ProductCategory
																																																	.equals("Books")
																																																	&& out2.ProductSubCategory
																																																			.equals("Fiction")
																																																	&& out2.ProductPrice < 365.528403)
																																																			? "Martha"
																																																			: (out2.ProductCategory
																																																					.equals("Books")
																																																					&& out2.ProductSubCategory
																																																							.equals("Fiction")
																																																					&& out2.ProductPrice > 365.528403)
																																																							? "Jamie"
																																																							: (out2.ProductCategory
																																																									.equals("Books")
																																																									&& out2.ProductSubCategory
																																																											.equals("Academic")
																																																									&& (out2.ProductPrice > (551.970143
																																																											- 218.841416)
																																																											&& out2.ProductPrice < (551.970143
																																																													+ 218.841416)))
																																																															? "Anthony"
																																																															: (out2.ProductCategory
																																																																	.equals("Books")
																																																																	&& out2.ProductSubCategory
																																																																			.equals("Academic")
																																																																	&& (out2.ProductPrice > (786.051051
																																																																			- 286.436536)
																																																																			&& out2.ProductPrice < (786.051051
																																																																					+ 286.436536)))
																																																																							? "Fred"
																																																																							: (out2.ProductCategory
																																																																									.equals("Books")
																																																																									&& out2.ProductSubCategory
																																																																											.equals("Non-fiction"))
																																																																													? "Katie"
																																																																													: (out2.ProductCategory
																																																																															.equals("Toys")
																																																																															&& out2.ProductSubCategory
																																																																																	.equals("Educational"))
																																																																																			? "Wanda"
																																																																																			: (out2.ProductCategory
																																																																																					.equals("Toys")
																																																																																					&& out2.ProductSubCategory
																																																																																							.equals("Action Figures"))
																																																																																									? "Angela"
																																																																																									: (out2.ProductCategory
																																																																																											.equals("Toys")
																																																																																											&& out2.ProductSubCategory
																																																																																													.equals("Dolls"))
																																																																																															? "Michael"
																																																																																															: (out2.ProductCategory
																																																																																																	.equals("Home & Garden")
																																																																																																	&& out2.ProductSubCategory
																																																																																																			.equals("Decor"))
																																																																																																					? "Amy"
																																																																																																					: (out2.ProductCategory
																																																																																																							.equals("Home & Garden")
																																																																																																							&& out2.ProductSubCategory
																																																																																																									.equals("Gardening Tools"))
																																																																																																											? "Shannon"
																																																																																																											: (out2.ProductCategory
																																																																																																													.equals("Home & Garden")
																																																																																																													&& out2.ProductSubCategory
																																																																																																															.equals("Furniture"))
																																																																																																																	? "Tammy"
																																																																																																																	: (out2.ProductCategory
																																																																																																																			.equals("Clothing")
																																																																																																																			&& out2.ProductSubCategory
																																																																																																																					.equals("Shirt")
																																																																																																																			&& (out2.ProductPrice > (656.128275
																																																																																																																					- 260.997343)
																																																																																																																					&& out2.ProductPrice < (656.128275
																																																																																																																							+ 260.997343)))
																																																																																																																									? "Elizabeth"
																																																																																																																									: "Marvin";
									out1_tmp.ProductCategory = out2.ProductCategory;
									out1_tmp.ProductSubCategory = out2.ProductSubCategory;
									out1_tmp.ProductPrice = Float.valueOf(String.valueOf(out2.ProductPrice));
									out1_tmp.Date = out2.Date;
									out1_tmp.CustomerName = out2.CustomerName;
									out1_tmp.CustomerEmail = out2.CustomerEmail;
									out1_tmp.CustomerAddress = out2.CustomerAddress
											.substring(0, out2.CustomerAddress.length() - 9).replace(",", " ");
									out1_tmp.CustomerZipCode = out2.CustomerZipCode;
									out1_tmp.CustomerPhone = out2.CustomerPhone;
									out1_tmp.CustomerSegment = out2.CustomerSegment;
									out1_tmp.SupplierName = out2.SupplierName;
									out1_tmp.SupplierLocation = out2.SupplierLocation;
									out1_tmp.SupplierContact = out2.SupplierContact;
									out1_tmp.ShipperName = out2.ShipperName;
									out1_tmp.ShippingMethod = out2.ShippingMethod;
									out1_tmp.QuantitySold = out2.QuantitySold;
									out1_tmp.TotalAmount = out2.TotalAmount;
									out1_tmp.DiscountAmount = out2.DiscountAmount;
									out1_tmp.NetAmount = out2.NetAmount;
									out1_tmp.StockReceived = out2.StockReceived;
									out1_tmp.StockSold = out2.StockSold;
									out1_tmp.StockOnHand = out2.StockOnHand;
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
									 * [tDBOutput_1 main ] start
									 */

									currentComponent = "tDBOutput_1";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "out1"

										);
									}

									whetherReject_tDBOutput_1 = false;
									if (out1.ProductName == null) {
										pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(1, out1.ProductName);
									}

									if (out1.ProductCategory == null) {
										pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(2, out1.ProductCategory);
									}

									if (out1.ProductSubCategory == null) {
										pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(3, out1.ProductSubCategory);
									}

									if (out1.ProductPrice == null) {
										pstmt_tDBOutput_1.setNull(4, java.sql.Types.FLOAT);
									} else {
										pstmt_tDBOutput_1.setFloat(4, out1.ProductPrice);
									}

									if (out1.Date != null) {
										pstmt_tDBOutput_1.setTimestamp(5, new java.sql.Timestamp(out1.Date.getTime()));
									} else {
										pstmt_tDBOutput_1.setNull(5, java.sql.Types.TIMESTAMP);
									}

									if (out1.CustomerName == null) {
										pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(6, out1.CustomerName);
									}

									if (out1.CustomerEmail == null) {
										pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(7, out1.CustomerEmail);
									}

									if (out1.CustomerAddress == null) {
										pstmt_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(8, out1.CustomerAddress);
									}

									if (out1.CustomerZipCode == null) {
										pstmt_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(9, out1.CustomerZipCode);
									}

									if (out1.CustomerPhone == null) {
										pstmt_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(10, out1.CustomerPhone);
									}

									if (out1.CustomerSegment == null) {
										pstmt_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(11, out1.CustomerSegment);
									}

									if (out1.SupplierName == null) {
										pstmt_tDBOutput_1.setNull(12, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(12, out1.SupplierName);
									}

									if (out1.SupplierLocation == null) {
										pstmt_tDBOutput_1.setNull(13, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(13, out1.SupplierLocation);
									}

									if (out1.SupplierContact == null) {
										pstmt_tDBOutput_1.setNull(14, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(14, out1.SupplierContact);
									}

									if (out1.ShipperName == null) {
										pstmt_tDBOutput_1.setNull(15, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(15, out1.ShipperName);
									}

									if (out1.ShippingMethod == null) {
										pstmt_tDBOutput_1.setNull(16, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(16, out1.ShippingMethod);
									}

									if (out1.QuantitySold == null) {
										pstmt_tDBOutput_1.setNull(17, java.sql.Types.INTEGER);
									} else {
										pstmt_tDBOutput_1.setInt(17, out1.QuantitySold);
									}

									if (out1.TotalAmount == null) {
										pstmt_tDBOutput_1.setNull(18, java.sql.Types.FLOAT);
									} else {
										pstmt_tDBOutput_1.setFloat(18, out1.TotalAmount);
									}

									if (out1.DiscountAmount == null) {
										pstmt_tDBOutput_1.setNull(19, java.sql.Types.FLOAT);
									} else {
										pstmt_tDBOutput_1.setFloat(19, out1.DiscountAmount);
									}

									if (out1.NetAmount == null) {
										pstmt_tDBOutput_1.setNull(20, java.sql.Types.FLOAT);
									} else {
										pstmt_tDBOutput_1.setFloat(20, out1.NetAmount);
									}

									if (out1.StockReceived == null) {
										pstmt_tDBOutput_1.setNull(21, java.sql.Types.FLOAT);
									} else {
										pstmt_tDBOutput_1.setFloat(21, out1.StockReceived);
									}

									if (out1.StockSold == null) {
										pstmt_tDBOutput_1.setNull(22, java.sql.Types.FLOAT);
									} else {
										pstmt_tDBOutput_1.setFloat(22, out1.StockSold);
									}

									if (out1.StockOnHand == null) {
										pstmt_tDBOutput_1.setNull(23, java.sql.Types.FLOAT);
									} else {
										pstmt_tDBOutput_1.setFloat(23, out1.StockOnHand);
									}

									pstmt_tDBOutput_1.addBatch();
									nb_line_tDBOutput_1++;

									batchSizeCounter_tDBOutput_1++;

									////////// batch execute by batch size///////
									class LimitBytesHelper_tDBOutput_1 {
										public int limitBytePart1(int counter,
												java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
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

										public int limitBytePart2(int counter,
												java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
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

								} // End of branch "out1"

								/**
								 * [tMap_1 process_data_end ] start
								 */

								currentComponent = "tMap_1";

								/**
								 * [tMap_1 process_data_end ] stop
								 */

							} // End of branch "out2"

							/**
							 * [tMap_2 process_data_end ] start
							 */

							currentComponent = "tMap_2";

							/**
							 * [tMap_2 process_data_end ] stop
							 */

						} // End of branch "row3"

						/**
						 * [tUniqRow_1 process_data_end ] start
						 */

						currentComponent = "tUniqRow_1";

						/**
						 * [tUniqRow_1 process_data_end ] stop
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
				 * [tUniqRow_1 end ] start
				 */

				currentComponent = "tUniqRow_1";

				globalMap.put("tUniqRow_1_NB_UNIQUES", nb_uniques_tUniqRow_1);
				globalMap.put("tUniqRow_1_NB_DUPLICATES", nb_duplicates_tUniqRow_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tUniqRow_1", true);
				end_Hash.put("tUniqRow_1", System.currentTimeMillis());

				/**
				 * [tUniqRow_1 end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				currentComponent = "tMap_2";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tMap_2", true);
				end_Hash.put("tMap_2", System.currentTimeMillis());

				/**
				 * [tMap_2 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out2");
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
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out1");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

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
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tUniqRow_1 finally ] start
				 */

				currentComponent = "tUniqRow_1";

				/**
				 * [tUniqRow_1 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
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

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
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
						.decryptPassword("enc:routine.encryption.key.v1:DxeAu/gHUkz5zsmhA+ro/mpJ5JA1en+L5ckiO7XiV78=");
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
						.decryptPassword("enc:routine.encryption.key.v1:1KSi/Rzq1BhCxeyzcZptgbeGzgOrOHhyf5Dh9eyV43U=");

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
 * 183716 characters generated by Talend Open Studio for Data Integration on the
 * 30 janvier 2025, 19:27:18 UTC+01:00
 ************************************************************************************************/