/*
 * Created on Nov 21, 2013
 * Author Shridhar Pobbala
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cisco.pims.Core;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.log4j.BasicConfigurator;

import com.microsoft.sqlserver.jdbc.SQLServerException;
public class Test {
	public boolean mailStatus = false;
	static String mailMessage = "";

	public static void main(String[] args) {

		DBConnectionFactory client = new DBConnectionFactory();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rSet = null;
		ResultSet rSet1 = null;
		Connection con = null;
		Connection con1 = null;
//		client.connect("ODBC",
//				"jdbc:oracle:thin:@//lnxdb-stg-vm-271:1536/PIMSSTG", "hvp",
//				"vqcwb$40!lwm");

//		 client.connect("ODBC",
//		 "jdbc:oracle:thin:@//lnxdb-prd-514.cisco.com:1546/PIMS", "pims_v2", "ny*(0023");
		try {
//		con = client.connect("jdbc:oracle:thin:@//lnxdb-stg-vm-271:1536/PIMSSTG", "pims_v2", "ga*#0402");
			BasicConfigurator.configure();
			con = client.connect(
				"jdbc:sqlserver://173.36.28.36\\QMXSQL1:51005;databaseName=PIMS",
				"pimsdb", "Pimsdb!");
		con1 = client.connect("jdbc:cassandra://rcdn9-ats-cas5:22/apeg_poc", "cassandra", "cassandra");
			String readQuery = null;
//			PIMS_CONFIG
//			readQuery = "select * from dbo.PIMS_config";
//			PIMS_PRT_SERIAL_ATTRIBUTES
//			readQuery = "select SERIAL_ATTRIBUTE_ID , SERIAL_NUMBER , ITEM_NUMBER, ATTRIBUTE_GROUP_ID , ATTRIBUTE_ID, "
//					+ "ATTRIBUTE_SEQUENCE, ATTRIBUTE_VALUE , ATTRIBUTE_VALUE_QUALIFIER, TRANSACTION_DATE_TIME, "
//					+ "ITEM_GROUP_ID , SITE_ID , CREATED_BY"
//					+ " from dbo.pims_prt_serial_attributes where serial_number in (select dhct_sn from dbo.pims_batch_detail where batch_id = 704477)";
//			PIMS_TYPE_FILES
			readQuery = "select FILENAME, DHCT_TYPE, DHCT_REV, FILE_DATA, MFG_ID, MAC_REF from dbo.pims_type_files";
//			readQuery = "SELECT serial_number, item_number, attribute_id, attribute_sequence, "
//					+ "attribute_value "
//					+ "FROM pims.pims_PRT_SERIAL_ATTRIBUTES WHERE  serial_number = 'CTBBDZDVN' allow filtering";
//			PIMS_CUSTOMER_KEY
//			readQuery = "select CUST_CAA_ID, CUST_CAA_PUB_KEY_LENGTH, CUST_CAA_REV, "
//					+ "CUST_CAA_MFG_DT, CUST_CAA_PUB_KEY, CUST_RETAIL_MSO, CUST_MSO_NAME, "
//					+ "CUST_MSO_CODE from dbo.pims_customer_key";
//			PIMS_EMM_BUILD_STRATEGY
//			readQuery = "select MFG_ID, MODEL, HW_REV, STRATEGY from dbo.pims_emm_build_strategy";
//			PIMS_CA_CERTIFICATES
			readQuery = "select * from dbo.pims_ca_certificates";
			pstmt = DBConnectionFactory.prepareStatement(con, readQuery);
			rSet = pstmt.executeQuery();
			String insertQuery = null;
//			PIMS_CONFIG
//			insertQuery = "insert into pims_config (CONFIG_TYPE, CONFIG_SEQUENCE, DESCRIPTION, DEFAULT_VALUE) "
//					+ "values(?, ?, ?, ?)";
//			PIMS_TYPE_FILES
//			insertQuery = "insert into pims.pims_type_files (FILENAME, DHCT_TYPE, DHCT_REV, FILE_DATA, MFG_ID, MAC_REF) "
//						 +"values(?, ?, ?, ?, ?, ?)";
//			insertQuery = "insert into pims.pims_customer_key (CUST_CAA_ID, CUST_CAA_PUB_KEY_LENGTH, CUST_CAA_REV, "
//					+ "CUST_CAA_MFG_DT, CUST_CAA_PUB_KEY, CUST_RETAIL_MSO, CUST_MSO_NAME, CUST_MSO_CODE) "
//						+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
//			PIMS_EMM_BUILD_STRATEGY
//			insertQuery = "insert into pims.pims_emm_build_strategy (MFG_ID, MODEL, HW_REV, STRATEGY) "
//					+ "values(?, ?, ?, ?)";
//			PIMS_CA_CERTIFICATES
			insertQuery = "insert into pims.pims_ca_certificates (certificate_name, revision_date_time, certificate_blob) "
					+ "values(?, ?, ?)";
//			PIMS_PRT_SERIAL_ATTRIBUTES
//			insertQuery = "insert into pims.pims_prt_serial_attributes (SERIAL_ATTRIBUTE_ID, "
//					+ "SERIAL_NUMBER, ITEM_NUMBER, ATTRIBUTE_GROUP_ID, ATTRIBUTE_ID, ATTRIBUTE_SEQUENCE, "
//					+ "ATTRIBUTE_VALUE, ATTRIBUTE_VALUE_QUALIFIER, TRANSACTION_DATE_TIME, "
//					+ "ITEM_GROUP_ID , SITE_ID , CREATED_BY) "
//					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt1 = DBConnectionFactory.prepareStatement(con1, insertQuery) ;
			insertData(insertQuery, rSet,con1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}
		finally{
			DBConnectionFactory.close(con1, pstmt, rSet);
			DBConnectionFactory.close(con);

			
		}
		
	}

	public static void insertData(String insertQuery, ResultSet rSet, Connection con) throws SQLException, Exception {
			PreparedStatement updateTable = con.prepareStatement(insertQuery);
			ResultSetMetaData rsMetaData = rSet.getMetaData();
			Blob blobData = null;
			int blobLength = 0;
			byte[] blobAsBytes = null;
			int count = 0;
			while (rSet.next()) {
				count++;
//				 String uuid = UUID.randomUUID().toString();
				// updateTable.setString(1, uuid);
				// updateTable.setString(2, rSet.getString(1));
				// updateTable.setString(3, rSet.getString(2));
				// updateTable.setInt(4, rSet.getInt(3));
				// updateTable.setInt(5, rSet.getInt(4));
				// updateTable.setInt(6, rSet.getInt(5));
				// updateTable.setString(7, rSet.getString(6));
				// updateTable.setString(8, rSet.getString(7));
				// String dateTime = rSet.getString(8) + rSet.getString(9);
				// Date theDate = (Date) new SimpleDateFormat("yyyyMMddhhmmss",
				// Locale.ENGLISH).parse(dateTime);
				// java.sql.Timestamp sqlDate = new
				// Timestamp(theDate.getTime());
				// updateTable.setTimestamp(9, sqlDate);

				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					 System.out.println(+i +"->" +rsMetaData.getColumnName(i)
					 +":" +rsMetaData.getColumnTypeName(i) + ":"
					 +rsMetaData.getColumnType(i) +":");
					switch (rsMetaData.getColumnType(i)) {
					case -4:
					case -3:
						// if(rSet.getBytes(i)!=null)
						updateTable.setBytes(i, rSet.getBytes(i));
						break;
					case 4:
						updateTable.setInt(i, rSet.getInt(i));
						System.out.println(rSet.getInt(i));
						break;
					case 1:
						updateTable.setString(i, rSet.getString(i));
						System.out.println(rSet.getString(i));
						break;
					case 2004: // BLOB
						if (rSet.getBlob(i) != null) {
							blobData = rSet.getBlob(i);
							blobLength = (int) blobData.length();
							blobAsBytes = blobData.getBytes(1, blobLength);
							updateTable.setBytes(i, blobAsBytes);
						} else
							updateTable.setBytes(i, null);
						break;
					case 12: // VARCHAR2
						if(rSet.getString(i)!=null && rSet.getString(i).trim().length()>0){
						if(rSet.getString(i).trim().length()>0){
							updateTable.setString(i, rSet.getString(i));
							System.out.println(rSet.getString(i));
						}}
						else
							updateTable.setString(i, "");
						
						break;
					case 2: // NUMBER
						updateTable.setInt(i, rSet.getInt(i));
						System.out.println(rSet.getInt(i));
						break;
					case 93: // DATE
						if (rSet.getDate(i) != null){
							updateTable.setDate(i, rSet.getDate(i));
							System.out.println(rSet.getDate(i));
						}
						else
							updateTable.setString(i, null);
						break;
					default:
						System.out.println("Inside default");
						break;
					}

				}
				try {
					updateTable.executeUpdate();
				} catch (SQLServerException e) {
					e.printStackTrace();
				}
			}
			updateTable.close();
			System.out.println("No of Records Inserted:" + count);
	}

	private static void compareRSet(ResultSet rSet, ResultSet rSet1) {
		byte[] byteValue1 = null;
		byte[] byteValue2 = null;
		try {
			while(rSet.next() && rSet1.next())
			{
				System.out.println(rSet.getString(1));
				byteValue1 = rSet.getBytes(2);
				System.out.println(rSet1.getString(1));
				byteValue2 = rSet1.getBytes(2);
				displayBytes(byteValue1,byteValue2);
			}
//			while(rSet1.next())
//			{
//				System.out.println(rSet1.getString(1));
//				byteValue2 = rSet1.getBytes(2);
////				System.out.println(byteValue2.length);
//			}
//			displayBytes(byteValue1,byteValue2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void displayBytes(byte[] byteValue1, byte[] byteValue2) {
		byte[] tbyte = new byte[2740];
//		byte[] bytes = Hex.decodeHex(hexString .toCharArray());
		//raw1 = 44, raw2 = 76, 1024 + 1024 + 
		boolean bol = Arrays.equals(byteValue1, byteValue2);
		System.out.println(bol);
		System.arraycopy(byteValue1, 0, tbyte, 0, 2740);
		String str1 = convertByteToHex(tbyte);
//		displaybyte(tbyte, "Oracle");
		System.arraycopy(byteValue2, 0, tbyte, 0, 2740);
//		displaybyte(tbyte, "MSSQL ");
		String str2 = convertByteToHex(tbyte);
		if(str1.equals(str2))
			System.out.println("true");
		else
			System.out.println("false");
	}
private static String convertByteToHex(byte[] a){
		   StringBuilder sb = new StringBuilder();
		   for(byte b: a)
		      sb.append(String.format("%02x", b&0xff));
		   System.out.println("HEX:"+sb.toString());
		   return sb.toString();
}
	private static void displaybyte(byte[] tbyte, String str) {
		String tStr = null;
		tStr = new String(tbyte);
		System.out.println(str + ":" +  tStr);		
	}
}
