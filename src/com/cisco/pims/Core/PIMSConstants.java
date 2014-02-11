/*
 * Created on Jan 14, 2014
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cisco.pims.Core;
public interface PIMSConstants {
	public static final String ERR_DB_CONNECTION = "Error occurred while connecting to Database !!!";
	public static final String COM_ERR_RPT = "An Error occured  !!!";
	public static final String env = "Environment";
	public static final String envTest = "Test_Environment";
	public static final String envProd = "Production_Environment";
	public static final int testSeq = 1;
	public static final int prodSeq = 10;
	public static final String configErrMsg = "formatError";
	public static final String configErrMsgId = "Error_Msg_Type";
	public static final String configSuccessMsg = "formatsucess";
	public static final String configSuccessMsgId = "Success_Msg_Type";
	public static final String configTrackingMsg = "formatTracking";
	public static final String configTrackingMsgId = "Tracking_Msg_Type";
	public static final String configWarningMsg = "formatWarning";
	public static final String configWarningMsgId = "Warning_Msg_Type";;
	public static final String configPriorityC = "Priority_Critical";
	public static final String configPriorityH = "Priority_High";
	public static final String configPriorityM = "Priority_Medium";
	public static final String configPriorityL = "Priority_Low";
	public static final String configEmmSuccess = "Internal_EMM_Success";
	public static final String configEmmFailure = "Internal_EMM_Failure";
	public static final String STATUS_17 = "17";
	public static final String STATUS_20 = "20";
	public static final String STATUS_30 = "30";
	public static final String STATUS_40 = "40";
	public static final String STATUS_50 = "50";
	public static final String STATUS_70 = "70";
	public static final String PROCESS17_20 = "17_20";
	public static final String PROCESS20_30 = "20_30";
	public static final String PROCESS30_40 = "30_40";
	public static final String PROCESS40_50 = "40_50";
	public static final String PROCESS50_70 = "50_70";
	public static final String INITGLOBAL = "SELECT config_sequence, config_type, default_value FROM pims.pims_config "
											+ " WHERE config_type IN ('"
											+ PIMSConstants.env
											+ "', '"
											+ PIMSConstants.envTest
											+ "', '"
											+ PIMSConstants.envProd
											+ "', '"
											+ PIMSConstants.configErrMsg
											+ "', '"
											+ PIMSConstants.configSuccessMsg
											+ "', '"
											+ PIMSConstants.configTrackingMsg
											+ "', '"
											+ PIMSConstants.configWarningMsg
											+ PIMSConstants.configErrMsgId
											+ "', '"
											+ PIMSConstants.configSuccessMsgId
											+ "', '"
											+ PIMSConstants.configTrackingMsgId
											+ "', '"
											+ PIMSConstants.configWarningMsgId
											+ "', '"
											+ PIMSConstants.configPriorityC
											+ "', '"
											+ PIMSConstants.configPriorityH
											+ "', '"
											+ PIMSConstants.configPriorityM
											+ "', '"
											+ PIMSConstants.configPriorityL
											+ "', '"
											+ PIMSConstants.configEmmSuccess
											+ "', '"
											+ PIMSConstants.configEmmFailure + "')";
	public static final String QUERYBATCH = "select batch_id, ship_to_cust_id from pims.pims_batch_header where batch_id = ? "
												 + "and batch_status_cd = ?"; 
	public static final String QUERYSTATUS = "select batch_id, ship_to_cust_id from pims.pims_batch_header where batch_status_cd = ?";
	public static final String DELETEQUERY_17_20 = "delete from pims.pims_product where dhct_sn = ?";
	public static final String QUERYPRODUCT_17_20 = "select dhct_sn from pims.pims_product where dhct_sn = ?";
	public static final String QUERYBDET = "select dhct_sn, pallet_id "
												+ "from pims.pims_batch_detail "
												+ "where batch_id = ?";
	public static final String UPDATEDETQUERY_17_20 = "update pims.pims_batch_detail set "
												 + "DHCT_SN = ?, "
												 + "EMM_SMSN = ?, "
												 + "EMM_MACADDRESS = ?, "
												 + "EMM_MODEL = ?, "
												 + "EMM_REV = ?, "
												 + "EMM_MFGDATE = ?, "
												 + "EMM_MATLNO = ?, "
												 + "EMM_CCARD_ID = ?, "
												 + "EMM_CABLECARD_SN = ?, "
												 + "EMM_ORIGINALSN = ?, "
												 + "EMM_TYPEFLAG = ? "
												 + "where BATCH_ID = ? "
												 + "AND DHCT_SN = ?";
	public static final String INSERTQUERY_17_20 = "Insert into pims.pims_product (DHCT_SN, SM_SN, MAC_ADDR, "
												 + "MODEL, HW_REV, DHCT_MFG_DT, DATE_CREATE,"
												+ "DHCT_STATUS_CD, CUST_CAA_ID, MFG_ID) "
												+ "values (?,?,?,?,?,?,dateof(now()),'"+STATUS_20 +"',?,?)";
	public static final String QUERYSNGET = "SELECT serial_number, item_number, attribute_id, attribute_sequence, attribute_value"
											+ " FROM "
											+ "pims.pims_PRT_SERIAL_ATTRIBUTES"
											+ " WHERE  serial_number = ? allow filtering";
//											+ " AND ( attribute_id = 5 "
//											+ " or attribute_id = 7"
//											+ " or attribute_id = 14"
//											+ " or attribute_id = 16"
//											+ " or attribute_id = 20"
//											+ " or attribute_id = 43"
//											+ " or attribute_id = 71"
//											+ " or attribute_id = 152"
//											+ " or attribute_id = 157)"
//											+ " ORDER BY attribute_id, attribute_sequence, transaction_date_time desc";
	public static final String QUERYDNCSGET = "select DNCS_ID from pims.pims_ship_to "
											  + "where ship_to_cust_id = ?";
	public static final String QUERYCAAGET = "select cust_caa_id from pims.pims_dncs where dncs_id = ?";
	
	public static final String UPDATEBQUERY = "update pims.pims_batch_header set batch_status_cd = ? where batch_id = ?";
	
	public static final String QUERYMFGID = "select mfg_id from pims.pims_type_files where dhct_type = ? and dhct_rev = ? allow filtering";
	public static final String QUERYPROD_20_30 = "select dhct_sn, sm_sn, mac_addr "
		       + "from pims.pims_product where dhct_sn = ?";
		public static final String QUERYCERTS_20_30 = "select pub_key_cert_length, "
												+ "pub_key_cert "
												+ "from pims.pims_certificate "
												+ "where sm_sn = ? and cert_type_cd = 'PK'";

		public static final String QUERYSACERTSSMVER_20_30 = "select sm_ver "
				+ "from pims.pims_secure_micro where sm_sn = ?";

		public static final String QUERYSACERTS_20_30 = "select sa_caa_pub_keys, "
												+ "sa_caa_pub_keys_length "
												+ "from pims.pims_sa_key where sm_ver = ?";

	public static final String QUERYCKCERTS_20_30 = "select cust_caa_pub_key,"
												  + "cust_caa_pub_key_length "
												  + "from pims.pims_customer_key where cust_caa_id = ?";

	public static final String UPDATEQUERY_20_30 = "update pims.pims_batch_header set nothing_blob = ? where batch_id = ?";
	public static final String QUERYFTPSITEID = "select * from pims.pims_ftp where site_id = ?";
	public static final String UPDATEQUERYEMM130_40 = "update pims.pims_batch_header set emm1_blob = ? where batch_id = ?";
	public static final String UPDATEQUERYEMM230_40 = "update pims.pims_batch_header set emm2_blob = ? where batch_id = ?";
	public static final String UPDATEQUERYSTAT30_40 = "update pims.pims_batch_header set batch_status_cd = ? where batch_id = ?";
	public static final String QUERYBATCH_40_50 = "select BATCH_ID, "
												+ " emm1_blob, "
												+ "	emm2_blob from pims.pims_batch_header where batch_id = ?"
												+ " and batch_status_cd = ?";
	
	public static final String QUERY_40_50 = "select BATCH_ID, "
											+ " emm1_blob, "
											+ "	 emm2_blob from pims.pims_batch_header where batch_status_cd = ?";
	public static final String QUERYPROD40_50 = " SELECT sm_sn,"
											+ " mac_addr,"
											+ " model,"
											+ " hw_rev,"
											+ " mfg_id"
											+ " FROM pims.pims_product"
											+ " WHERE dhct_sn = ?";
	
	public static final String QUERYEBS40_50 = " SELECT strategy"
			+ " FROM pims.pims_emm_build_strategy"
			+ " WHERE mfg_id = ? AND model = ?"
			+ " AND hw_rev = ?";

	public static final String QUERYCERT_40_50 = "SELECT cert_type_cd, pub_key_cert, pub_key_cert_length "
												+ "	FROM pims.pims_certificate WHERE sm_sn = ?";
	
	public static final String QUERYBATCH_50_70 = "select batch_id, delivery_id, info1 from pims.pims_batch_header "
													+ "where batch_id = ? and batch_status_cd = ?";

	public static final String QUERY_50_70 = "select batch_id, delivery_id, info1 from pims.pims_batch_header "
											+ "where batch_status_cd = ?";
	public static final String QUERYPROD50_70 = "SELECT dhct_sn, "
												+ "cust_caa_id, mac_addr, "
												+ "emm_file, "
												+ "MODEL, "
												+ "hw_rev, "
												+ "mfg_id "
												+ "FROM pims.pims_PRODUCT where dhct_sn = ?";
	public static final String QUERYCACERTS = "select certificate_name, certificate_blob from pims.pims_ca_certificates";
	public static final String QUERYHCTTYPES = "SELECT sq.filename, t.file_data FROM "
			+ "(SELECT distinct filename FROM pims.PIMS_TYPE_FILES t, pims.PIMS_EMM_BUILD_STRATEGY ebs, "
			+ "(SELECT DISTINCT s.model, s.hw_rev, m.mfg_id,m.mac_prefix FROM pims.PIMS_PRODUCT s, "
			+ "pims.PIMS_MFG_MAC_ADDR_RANGE m,"
			+ " pims.PIMS_BATCH_DETAIL er WHERE er.batch_id = ?"
			+ " AND er.dhct_sn = s.dhct_sn AND m.mac_prefix=substring(s.mac_addr,1,6)"
			+ " ) psq WHERE psq.model = ebs.model AND psq.hw_rev = ebs.hw_rev AND psq.mfg_id = ebs.mfg_id "
			+ "AND ebs.model=t.dhct_type "
			+ "AND ebs.hw_rev=t.dhct_rev AND ebs.mfg_id=t.mfg_id AND ((SELECT CASE WHEN ebs.strategy = 'MFG_ID' "
			+ "THEN psq.mfg_id ELSE psq.mac_prefix"
			+ " END) = t.mac_ref ) )sq, PIMS_TYPE_FILES t WHERE t.filename = sq.filename";

	public static final String LOGUPDATEQUERY = "INSERT INTO pims.pims_error_detail (NOTIFICATION_ID, "
											+ "BATCH_ID, DHCT_SN, ITEM_NO, SEQ_NO, TYPE_MSG, CREATED_DATE_TIME, "
											+ "MESSAGE_ID, MESSAGE_DETAIL) " 
											+ "VALUES(?, ?, ?, ?, ?, ?, dateof(now()), ?, ?)";
	public static final String LOGINITQUERY = "SELECT @@SERVERNAME dbHost, DB_NAME() dbName, SCHEMA_NAME() dbSchema, "
			+ "@@SPID dbSessionId, SYSTEM_USER dbSessionUser, HOST_NAME() terminal, PROGRAM_NAME() module";
	
	public static final String UPDATEPRODQUERY = "update pims.pims_product set emm_file = ? , "
			+ "										  emm_date = ?,"
			+ "										  emm_file_size  = ? " + " where dhct_sn = ?";
	public static final String QUERYMAIL = "select batch_id, dhct_sn, item_no, type_msg, "
			+ "message_id, message_detail, error_detail from pims.pims_error_detail where notification_id in ";
	public static final String MSG_START_17_20 = "Entered 17_20 Process";
	public static final String MSG_ERRSMSN_17_20 = "Missing Secure Micro SN";
	public static final String MSG_START_20_30 = "Entered 20_30 Process";
	public static final String FILESTATUS = "Successfully";
	public static final String MSG_ERRCERT_20_30 = "Certificate files missing for serial number";
	public static final String MSG_ERRSACERT_20_30 = "SA Certificate files missing for serial number";
	public static final String MSG_ERRCKCERT_20_30 = "Customer Key Certificate files missing for serial number";
	public static final String MAILSSTARTMSG = "<!DOCTYPE HTML PUBLIC \" -//W3C//DTD HTML 4.0 Transitional//EN\"><html><head>"
												+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">"
												+"<title> PIMS Status Mail Messages </title><meta name=\"Generator\"" 
												+"content=\"EditPlus\"><meta name=\"Author\" content=\"Shridhar Pobbala\">"
												+"</head> <body><table border=\"1\" cellpadding=\"3\" rules=\"all\"" 
												+"bgcolor=\"#D8C454\"><tr><td><b><font color=\"#3300FF\">Serial Number</font>"
												+"</b></td>"
												+"<td><b><font color=\"#3300FF\">Message Type</font></b></td>"
												+"<td><b><font color=\"#3300FF\">Date and Time</font></b></td>"
												+"<td><b><font color=\"#3300FF\">Message ID</font></b></td>"
												+"<td><b><font color=\"#3300FF\">Message</font></b></td></tr>";
	public static final String MAILSTARTTAGMSG = "<td><b><font color=\"#3300FF\">"; 
	public static final String MAILENDTAGMSG = "</font></b></td>";
	public static final String MAILENDMSG = "</table><br><br><b>Cisco Systems Inc.,<br>5030 SugarLoaf<br>Lawrenceville GA 30044<br>"
											  + "</b></body></html>";
}
