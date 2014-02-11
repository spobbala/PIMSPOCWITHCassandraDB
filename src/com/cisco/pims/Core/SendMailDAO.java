/*
 * Created on Jan 21, 2014
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cisco.pims.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;

import com.cisco.pims.Utilities.SendMail;

public class SendMailDAO {
	private Connection pimsCon;
	private Properties propFile;
	public SendMailDAO(Connection con, Properties propFile){
		this.pimsCon = con;
		this.propFile = propFile;
	}
	public void generateEmail(int batchid, Set<String> nID, String processName)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		boolean status = true;
		String statusMessage = "<tr>";
		String subject = null;
		String qty = "(";
		int k = 0;
		for(String i: nID){
			k++;
			if(k==nID.size())
				qty = qty +i + ")";
			else
				qty = qty + i +", ";
		}
		String s = PIMSConstants.QUERYMAIL+qty; 
		pstmt = DBConnectionFactory.prepareStatement(pimsCon, s);
		rSet = pstmt.executeQuery();
		while (rSet.next()) {
			if (rSet.getString("type_msg").equalsIgnoreCase("ERROR") && status)
				status = false;
			statusMessage = statusMessage + PIMSConstants.MAILSTARTTAGMSG
					+ rSet.getString("dhct_sn") + PIMSConstants.MAILENDTAGMSG;
			statusMessage = statusMessage + PIMSConstants.MAILSTARTTAGMSG
					+ rSet.getString("type_msg") + PIMSConstants.MAILENDTAGMSG;
			statusMessage = statusMessage + PIMSConstants.MAILSTARTTAGMSG + "time"
//					+ rSet.getString("created_date_time")
					+ PIMSConstants.MAILENDTAGMSG;
			statusMessage = statusMessage + PIMSConstants.MAILSTARTTAGMSG
					+ rSet.getString("message_id")
					+ PIMSConstants.MAILENDTAGMSG;
			statusMessage = statusMessage + PIMSConstants.MAILSTARTTAGMSG
					+ rSet.getString("message_detail")
					+ PIMSConstants.MAILENDTAGMSG +"</tr>";
		}
		statusMessage = PIMSConstants.MAILSSTARTMSG + statusMessage
				+ PIMSConstants.MAILENDMSG;
		SendMail sendMail = new SendMail(propFile.getProperty("MailUserName"),
				propFile.getProperty("MailPassword"),
				propFile.getProperty("MailServer"),
				propFile.getProperty("MailPort"));
		if(status)
			subject = "Success in ";
		else
			subject = "Error in ";
		subject = subject + processName + " Process for Batch ID:" +batchid;
		sendMail.sendMail(subject, statusMessage,
				propFile.getProperty("FromEmail"),
				propFile.getProperty("ToEmail"));

	}

}
