package com.higradius;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
public class LoadInDataBase 
{
	private static Date strToDt(String d)
	{
		return Date.valueOf(d);
	}
	private static boolean isValueNull(Object obj)
	{
		if(obj==null)
			return true;
		return false;
	}
	static void populateDataBase(ArrayList<InvoiceRecords> records)
	{
		Connection dbCon=null;
		String url="jdbc:mysql://127.0.0.1:3306/project";
		String username="root";
		String password="root";
		int rowNum=0;
		PreparedStatement pst=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon=DriverManager.getConnection(url,username,password);
			String query="INSERT INTO `project`.`customer_invoice`" + 
						"(`acct_doc_header_id`, `company_id`,`document_number`,`document_number_norm`,"+ 
						"`business_code`,`create_year`,`document_line_number`, `doctype`,`customer_number`,"+ 
						"`customer_number_norm`,`fk_customer_map_id`,`customer_name`,`division`,"+ 
						"`document_create_date`,`document_create_date_norm`,`posting_date`,`posting_date_norm`,"+ 
						"`posting_id`,`due_date`,`due_date_norm`,`order_date`,`order_date_norm`,`invoice_id`,"+ 
						"`invoice_id_norm`,`baseline_create_date`,`invoice_date_norm`,`total_open_amount`,"+ 
						"`total_open_amount_norm`,`cust_payment_terms`,`business_area`,`ship_date`,`ship_to`,"+ 
						"`clearing_date`,`clearing_date_norm`,`reason_code`,`isOpen`,`discount_due_date_norm`,"+ 
						"`debit_credit_indicator`,`payment_method`,`document_creation_date`,`invoice_amount_doc_currency`,"+ 
						"`document_id`,`actual_open_amount`,`paid_amount`,`dayspast_due`,`invoice_age`,`disputed_amount`)"+ 
						"VALUES"+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"+ 
						"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			for(InvoiceRecords rec:records)
			{	
				pst=dbCon.prepareStatement(query);
				//(isValueNull(rec.getAcct_doc_header_id()))?:pst.setLong(1,rec.getAcct_doc_header_id());
				//pst.setLong(1,isValueNull(rec.getAcct_doc_header_id())?Types.NULL:rec.getAcct_doc_header_id());
				if(isValueNull(rec.getAcct_doc_header_id()))
					pst.setNull(1, Types.NULL);
				else
					pst.setInt(1,rec.getAcct_doc_header_id());
				
				if(isValueNull(rec.getCompany_id()))
					pst.setNull(2,Types.NULL);
				else
					pst.setInt(2, rec.getCompany_id());
				
				if(isValueNull(rec.getDocument_number()))
					pst.setNull(3, Types.NULL);
				else
					pst.setInt(3,rec.getDocument_number());
				
				if(isValueNull(rec.getDocument_number_norm()))
					pst.setNull(4, Types.NULL);
				else
					pst.setInt(4,rec.getDocument_number_norm());
				
				if (isValueNull(rec.getBusiness_code()))
					pst.setNull(5, Types.NULL);
				else
					pst.setString(5,rec.getBusiness_code());
				
				if(isValueNull(rec.getCreate_year()))
					pst.setNull(6, Types.NULL);
				else
					pst.setString(6,rec.getCreate_year());
				
				if(isValueNull(rec.getDocument_line_number()))
					pst.setNull(7, Types.NULL);
				else
					pst.setInt(7,rec.getDocument_line_number());
				
				if(isValueNull(rec.getDoctype()))
					pst.setNull(8, Types.NULL);
				else
					pst.setString(8,rec.getDoctype());
				
				if(isValueNull(rec.getCustomer_number()))
					pst.setNull(9, Types.NULL);
				else
					pst.setInt(9,rec.getCustomer_number());
				
				if(isValueNull(rec.getCustomer_number_norm()))
					pst.setNull(10, Types.NULL);
				else
					pst.setInt(10,rec.getCustomer_number_norm());
				
				if(isValueNull(rec.getFk_customer_map_id()))
					pst.setNull(11, Types.NULL);
				else
					pst.setInt(11,rec.getFk_customer_map_id());
				
				if(isValueNull(rec.getCustomer_name()))
					pst.setNull(12, Types.NULL);
				else
					pst.setString(12,rec.getCustomer_name());
				
				if(isValueNull(rec.getDivision()))
					pst.setNull(13, Types.NULL);
				else
					pst.setString(13,rec.getDivision());
				
				if(isValueNull(rec.getDocument_create_date()))
					pst.setNull(14, Types.NULL);
				else
					pst.setDate(14,strToDt(rec.getDocument_create_date()));
				
				if(isValueNull(rec.getDocument_create_date_norm()))
					pst.setNull(15, Types.NULL);
				else
					pst.setDate(15,strToDt(rec.getDocument_create_date_norm()));
				
				if(isValueNull(rec.getPosting_date()))
					pst.setNull(16, Types.NULL);
				else
					pst.setDate(16,strToDt(rec.getPosting_date()));
				
				if(isValueNull(rec.getPosting_date_norm()))
					pst.setNull(17, Types.NULL);
				else
					pst.setDate(17,strToDt(rec.getPosting_date_norm()));
					
				if(isValueNull(rec.getPosting_id()))
					pst.setNull(18, Types.NULL);
				else
					pst.setString(18,rec.getPosting_id());
				
				if(isValueNull(rec.getDue_date()))
					pst.setNull(19, Types.NULL);
				else
					pst.setDate(19,strToDt(rec.getDue_date()));
				
				if(isValueNull(rec.getDue_date_norm()))
					pst.setNull(20, Types.NULL);
				else
					pst.setDate(20,strToDt(rec.getDue_date_norm()));
				
				if(isValueNull(rec.getOrder_date()))
					pst.setNull(21, Types.NULL);
				else
					pst.setDate(21,strToDt(rec.getOrder_date()));
				
				if(isValueNull(rec.getOrder_date_norm()))
					pst.setNull(22, Types.NULL);
				else
					pst.setDate(22,strToDt(rec.getOrder_date_norm()));
				
				if(isValueNull(rec.getInvoice_id()))
					pst.setNull(23, Types.NULL);
				else
					pst.setInt(23,rec.getInvoice_id());
				
				if(isValueNull(rec.getInvoice_id_norm()))
					pst.setNull(24, Types.NULL);
				else
					pst.setInt(24,rec.getInvoice_id_norm());
				
				if(isValueNull(rec.getBaseline_create_date()))
					pst.setNull(25, Types.NULL);
				else
					pst.setDate(25,strToDt(rec.getBaseline_create_date()));
				
				if(isValueNull(rec.getInvoice_date_norm()))
					pst.setNull(26, Types.NULL);
				else
					pst.setDate(26,strToDt(rec.getInvoice_date_norm()));
				
				if(isValueNull(rec.getTotal_open_amount()))
					pst.setNull(27, Types.NULL);
				else
					pst.setFloat(27,rec.getTotal_open_amount());
				
				if(isValueNull(rec.getTotal_open_amount_norm()))
					pst.setNull(28, Types.NULL);
				else
					pst.setFloat(28,rec.getTotal_open_amount_norm());
				
				if(isValueNull(rec.getCust_payment_terms()))
					pst.setNull(29, Types.NULL);
				else
					pst.setInt(29,rec.getCust_payment_terms());
				
				if(isValueNull(rec.getBusiness_area()))
					pst.setNull(30, Types.NULL);
				else
					pst.setString(30,rec.getBusiness_area());
				
				if(isValueNull(rec.getShip_date()))
					pst.setNull(31, Types.NULL);
				else
				{
					String temp=rec.getShip_date();
					String date1 = temp.substring(0, 2) + "-" + temp.substring(3, 5) + "-" + temp.substring(6);
					SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					java.util.Date date=null;
					try {
						date = format.parse(date1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					java.sql.Date sql_date=new java.sql.Date(date.getTime());
					pst.setDate(31,sql_date);
				}
				
				if(isValueNull(rec.getShip_to()))
					pst.setNull(32, Types.NULL);
				else
					pst.setString(32,rec.getShip_to());
				
				if(isValueNull(rec.getClearing_date()))
					pst.setNull(33, Types.NULL);
				else
					pst.setDate(33,strToDt(rec.getClearing_date()));
				
				if(isValueNull(rec.getClearing_date_norm()))
					pst.setNull(34, Types.NULL);
				else
					pst.setDate(34,strToDt(rec.getClearing_date_norm()));
				
				if(isValueNull(rec.getReason_code()))
					pst.setNull(35, Types.NULL);
				else
					pst.setString(35,rec.getReason_code());
				
				if(isValueNull(rec.getIsOpen()))
					pst.setNull(36, Types.NULL);
				else
					pst.setInt(36,rec.getIsOpen());
				
				if(isValueNull(rec.getDiscount_due_date_norm()))
					pst.setNull(37, Types.NULL);
				else
					pst.setDate(37,strToDt(rec.getDiscount_due_date_norm()));
				
				if(isValueNull(rec.getDebit_credit_indicator()))
					pst.setNull(38, Types.NULL);
				else
					pst.setString(38,rec.getDebit_credit_indicator());
				
				if(isValueNull(rec.getPayment_method()))
					pst.setNull(39, Types.NULL);
				else
					pst.setString(39,rec.getPayment_method());
				
				if(isValueNull(rec.getDocument_creation_date()))
					pst.setNull(40, Types.NULL);
				else
					pst.setDate(40,strToDt(rec.getDocument_creation_date()));
				
				if(isValueNull(rec.getInvoice_amount_doc_currency()))
					pst.setNull(41, Types.NULL);
				else
					pst.setFloat(41,rec.getInvoice_amount_doc_currency());
				
				if(isValueNull(rec.getDocument_id()))
					pst.setNull(42, Types.NULL);
				else
					pst.setInt(42,rec.getDocument_id());
				
				if(isValueNull(rec.getActual_open_amount()))
					pst.setNull(43, Types.NULL);
				else
					pst.setFloat(43,rec.getActual_open_amount());
				
				if(isValueNull(rec.getPaid_amount()))
					pst.setNull(44, Types.NULL);
				else
					pst.setFloat(44,rec.getPaid_amount());
				
				if(isValueNull(rec.getDayspast_due()))
					pst.setNull(45, Types.NULL);
				else
					pst.setInt(45,rec.getDayspast_due());
				
				if(isValueNull(rec.getInvoice_age()))
					pst.setNull(46, Types.NULL);
				else
					pst.setInt(46,rec.getInvoice_age());
				
				if(isValueNull(rec.getDisputed_amount()))
					pst.setNull(47, Types.NULL);
				else
					pst.setFloat(46,rec.getDisputed_amount());
				
				int line=pst.executeUpdate();
				rowNum++;
				if(rowNum%1000==0)
					System.out.println(rowNum+" Rows Inserted !");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				dbCon.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			System.out.println(rowNum +" Records Loaded in Database Successfully !");
		}
	}
}
