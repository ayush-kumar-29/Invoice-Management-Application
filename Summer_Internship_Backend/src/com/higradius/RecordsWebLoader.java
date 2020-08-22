package com.higradius;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.mysql.cj.util.StringUtils;
@WebServlet("/RecordsWebLoader")
public class RecordsWebLoader extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public RecordsWebLoader() 
	{
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Connection dbCon=null;
		String url="jdbc:mysql://localhost:3306/project";
		String username="root";
		String password="root";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			dbCon=DriverManager.getConnection(url,username,password);
			Statement stm=dbCon.createStatement();
			String params=req.getParameter("name");
			System.out.println(params);
			String data=null;
			if(params.equals("ARStats"))
			{
				HashMap<String,Integer> ARStats=new HashMap<>();
				ResultSet rs=stm.executeQuery("SELECT COUNT(DISTINCT(customer_name)) FROM `project`.`customer_invoice`;");
				rs.next();
				ARStats.put("totCus",rs.getInt(1));
				rs=stm.executeQuery("SELECT ROUND(SUM(actual_open_amount),0) FROM `project`.`customer_invoice`;");
				rs.next();
				ARStats.put("totOpenAR",rs.getInt(1));
				rs=stm.executeQuery("SELECT ROUND(SUM(dayspast_due)/COUNT(dayspast_due),0) FROM `project`.`customer_invoice` WHERE dayspast_due>0;");
				rs.next();
				ARStats.put("dayDel",rs.getInt(1));
				rs=stm.executeQuery("SELECT COUNT(*) FROM `project`.`customer_invoice` WHERE isOpen=1;");
				rs.next();
				ARStats.put("openInv",rs.getInt(1));
				Gson gson = new Gson();
				data=gson.toJson(ARStats);
			}
			else if(params.equals("modify"))
			{
				ArrayList<InvoiceRecords> records=new ArrayList<>();
				String docType=req.getParameter("docType");
				String actualOpenAmount=req.getParameter("actualOpenAmount");
				String pkId=req.getParameter("pkId");
				String cusName=req.getParameter("cusName");
				System.out.println(docType+"--"+actualOpenAmount+"--"+pkId+"--"+cusName);
				Integer i=stm.executeUpdate("UPDATE `project`.`customer_invoice` SET	`doctype`='"+docType+"',`actual_open_amount`='"+actualOpenAmount+"' WHERE `pk_id`='"+pkId+"';");
				ResultSet rs=stm.executeQuery("SELECT  * FROM `project`.`customer_invoice` WHERE customer_name='"+cusName+"';");
				while(rs.next())
				{
					InvoiceRecords rec=new InvoiceRecords();
					rec.setPk_id(rs.getInt(1));
					rec.setAcct_doc_header_id(rs.getInt(2));				
					rec.setCompany_id(rs.getInt(3));				
					rec.setDocument_number(rs.getInt(4));				
					rec.setDocument_number_norm(rs.getInt(5));			
					rec.setBusiness_code(rs.getString(6));				
					rec.setCreate_year(rs.getString(7));				
					rec.setDocument_line_number(rs.getInt(8));			
					rec.setDoctype(rs.getString(9));
					rec.setCustomer_number(rs.getInt(10));				
					rec.setCustomer_number_norm(rs.getInt(11));				
					rec.setFk_customer_map_id(rs.getInt(12));				
					rec.setCustomer_name(rs.getString(13));
					rec.setDivision(rs.getString(14));				
					rec.setDocument_create_date(rs.getString(15));				
					rec.setDocument_create_date_norm(rs.getString(16));				
					rec.setPosting_date(rs.getString(17));				
					rec.setPosting_date_norm(rs.getString(18));				
					rec.setPosting_id(rs.getString(19));				
					rec.setDue_date(rs.getString(20));				
					rec.setDue_date_norm(rs.getString(21));				
					rec.setOrder_date(rs.getString(22));				
					rec.setOrder_date_norm(rs.getString(23));				
					rec.setInvoice_id(rs.getInt(24));				
					rec.setInvoice_id_norm(rs.getInt(25));				
					rec.setBaseline_create_date(rs.getString(26));				
					rec.setInvoice_date_norm(rs.getString(27));				
					rec.setTotal_open_amount(rs.getFloat(28));				
					rec.setTotal_open_amount_norm(rs.getFloat(29));				
					rec.setCust_payment_terms(rs.getInt(30));				
					rec.setBusiness_area(rs.getString(31));				
					rec.setShip_date(rs.getString(32));				
					rec.setShip_to(rs.getString(33));				
					rec.setClearing_date(rs.getString(34));				
					rec.setClearing_date_norm(rs.getString(35));				
					rec.setReason_code(rs.getString(36));				
					rec.setIsOpen(rs.getInt(37));				
					rec.setDiscount_due_date_norm(rs.getString(38));				
					rec.setDebit_credit_indicator(rs.getString(39));				
					rec.setPayment_method(rs.getString(40));				
					rec.setDocument_creation_date(rs.getString(41));				
					rec.setInvoice_amount_doc_currency(rs.getFloat(42));				
					rec.setDocument_id(rs.getInt(43));				
					rec.setActual_open_amount(rs.getFloat(44));				
					rec.setPaid_amount(rs.getFloat(45));
					rec.setDayspast_due(rs.getInt(46));
					rec.setInvoice_age(rs.getInt(47));
					rec.setDisputed_amount(rs.getFloat(48));
					records.add(rec);
				}
				Gson gson = new Gson();
				data=gson.toJson(records);
			}
			else if(params.equals("cusARStats"))
			{
				HashMap<String,Integer> ARStats=new HashMap<>();
				String cusName=req.getParameter("cusName");
				ResultSet rs=stm.executeQuery("SELECT ROUND(SUM(actual_open_amount),0) FROM `project`.`customer_invoice` WHERE customer_name='"+cusName+"';");
				rs.next();
				ARStats.put("totOpenAR",rs.getInt(1));
				rs=stm.executeQuery("SELECT COUNT(*) FROM `project`.`customer_invoice` WHERE isOpen=1 AND customer_name='"+cusName+"';");
				rs.next();
				ARStats.put("openInv",rs.getInt(1));
				rs=stm.executeQuery("SELECT DISTINCT(customer_number_norm) FROM `project`.`customer_invoice` WHERE customer_name='"+cusName+"';");
				rs.next();
				ARStats.put("cusNum",rs.getInt(1));
				System.out.println(ARStats);
				Gson gson = new Gson();
				data=gson.toJson(ARStats);
			}
			else if(params.equals("allComp"))
			{
				ArrayList<AllCompanyCode> arr=new ArrayList<>();
				ResultSet rs=stm.executeQuery("SELECT  business_code,ROUND(SUM(actual_open_amount),0) FROM `project`.`customer_invoice` GROUP BY business_code;");
				while(rs.next()) 
				{
					AllCompanyCode acc=new AllCompanyCode(rs.getString(1),rs.getInt(2));
					arr.add(acc);
				}
				//System.out.println(allComp.size());
				Gson gson = new Gson();
				data=gson.toJson(arr);
			}
			else if(params.equals("allCus"))
			{
				ArrayList<SearchedInvoiceData> records=new ArrayList<>();
				ResultSet rs=stm.executeQuery("SELECT  customer_number_norm,customer_name,ROUND(SUM(actual_open_amount),0) FROM `project`.`customer_invoice` GROUP BY customer_name;");
				while(rs.next())					
				{
					
					SearchedInvoiceData obj=new SearchedInvoiceData();obj.setActual_open_amount(rs.getFloat(3));
					obj.setCustomer_name(rs.getString(2));
					obj.setCustomer_number_norm(rs.getInt(1));
					records.add(obj);
				}
				Gson gson = new Gson();
				data=gson.toJson(records);
			}
			else if(params.equals("getCusDet"))
			{
				String cusDetail=req.getParameter("queryString");
				System.out.println("--"+cusDetail+"--");
				ArrayList<InvoiceRecords> records=new ArrayList<>();
				ResultSet rs=stm.executeQuery("SELECT  * FROM `project`.`customer_invoice` WHERE customer_name='"+cusDetail+"';");
				while(rs.next())
				{
					InvoiceRecords rec=new InvoiceRecords();
					rec.setPk_id(rs.getInt(1));
					rec.setAcct_doc_header_id(rs.getInt(2));				
					rec.setCompany_id(rs.getInt(3));				
					rec.setDocument_number(rs.getInt(4));				
					rec.setDocument_number_norm(rs.getInt(5));			
					rec.setBusiness_code(rs.getString(6));				
					rec.setCreate_year(rs.getString(7));				
					rec.setDocument_line_number(rs.getInt(8));			
					rec.setDoctype(rs.getString(9));
					rec.setCustomer_number(rs.getInt(10));				
					rec.setCustomer_number_norm(rs.getInt(11));				
					rec.setFk_customer_map_id(rs.getInt(12));				
					rec.setCustomer_name(rs.getString(13));
					rec.setDivision(rs.getString(14));				
					rec.setDocument_create_date(rs.getString(15));				
					rec.setDocument_create_date_norm(rs.getString(16));				
					rec.setPosting_date(rs.getString(17));				
					rec.setPosting_date_norm(rs.getString(18));				
					rec.setPosting_id(rs.getString(19));				
					rec.setDue_date(rs.getString(20));				
					rec.setDue_date_norm(rs.getString(21));				
					rec.setOrder_date(rs.getString(22));				
					rec.setOrder_date_norm(rs.getString(23));				
					rec.setInvoice_id(rs.getInt(24));				
					rec.setInvoice_id_norm(rs.getInt(25));				
					rec.setBaseline_create_date(rs.getString(26));				
					rec.setInvoice_date_norm(rs.getString(27));				
					rec.setTotal_open_amount(rs.getFloat(28));				
					rec.setTotal_open_amount_norm(rs.getFloat(29));				
					rec.setCust_payment_terms(rs.getInt(30));				
					rec.setBusiness_area(rs.getString(31));				
					rec.setShip_date(rs.getString(32));				
					rec.setShip_to(rs.getString(33));				
					rec.setClearing_date(rs.getString(34));				
					rec.setClearing_date_norm(rs.getString(35));				
					rec.setReason_code(rs.getString(36));				
					rec.setIsOpen(rs.getInt(37));				
					rec.setDiscount_due_date_norm(rs.getString(38));				
					rec.setDebit_credit_indicator(rs.getString(39));				
					rec.setPayment_method(rs.getString(40));				
					rec.setDocument_creation_date(rs.getString(41));				
					rec.setInvoice_amount_doc_currency(rs.getFloat(42));				
					rec.setDocument_id(rs.getInt(43));				
					rec.setActual_open_amount(rs.getFloat(44));				
					rec.setPaid_amount(rs.getFloat(45));
					rec.setDayspast_due(rs.getInt(46));
					rec.setInvoice_age(rs.getInt(47));
					rec.setDisputed_amount(rs.getFloat(48));
					records.add(rec);
				}
				Gson gson = new Gson();
				data=gson.toJson(records);
			}
			else if(params.equals("searchCus"))
			{
				String cusDetail=req.getParameter("queryString");
				System.out.println("--"+cusDetail+"--");
				ResultSet rs=null;
				ArrayList<SearchedInvoiceData> records=new ArrayList<>();
				if(isNumeric(cusDetail))
				{
					rs=stm.executeQuery("SELECT  customer_number_norm,customer_name,actual_open_amount FROM `project`.`customer_invoice` WHERE customer_number_norm="+cusDetail+" GROUP BY customer_name;");
					SearchedInvoiceData obj=new SearchedInvoiceData();
					while(rs.next())
					{
						obj.setActual_open_amount(rs.getFloat(3));
						obj.setCustomer_name(rs.getString(2));
						obj.setCustomer_number_norm(rs.getInt(1));
						records.add(obj);
					}
				}
				else
				{
					rs=stm.executeQuery("SELECT  customer_number_norm,customer_name,actual_open_amount FROM `project`.`customer_invoice` WHERE customer_name='"+cusDetail+"' GROUP BY customer_name;");
					SearchedInvoiceData obj=new SearchedInvoiceData();
					while(rs.next())
					{
						obj.setActual_open_amount(rs.getFloat(3));
						obj.setCustomer_name(rs.getString(2));
						obj.setCustomer_number_norm(rs.getInt(1));
						records.add(obj);
					}
				}
				//System.out.println(records.size());
				Gson gson = new Gson();
				data=gson.toJson(records);
			}
			else if(params.equals("cusTab"))
			{
				ResultSet rs=stm.executeQuery("SELECT * FROM `project`.`customer_invoice`;");
				ArrayList<InvoiceRecords> records=new ArrayList<>();
				while(rs.next())
				{
					InvoiceRecords rec=new InvoiceRecords();
					rec.setPk_id(rs.getInt(1));
					rec.setAcct_doc_header_id(rs.getInt(2));				
					rec.setCompany_id(rs.getInt(3));				
					rec.setDocument_number(rs.getInt(4));				
					rec.setDocument_number_norm(rs.getInt(5));			
					rec.setBusiness_code(rs.getString(6));				
					rec.setCreate_year(rs.getString(7));				
					rec.setDocument_line_number(rs.getInt(8));			
					rec.setDoctype(rs.getString(9));
					rec.setCustomer_number(rs.getInt(10));				
					rec.setCustomer_number_norm(rs.getInt(11));				
					rec.setFk_customer_map_id(rs.getInt(12));				
					rec.setCustomer_name(rs.getString(13));
					rec.setDivision(rs.getString(14));				
					rec.setDocument_create_date(rs.getString(15));				
					rec.setDocument_create_date_norm(rs.getString(16));				
					rec.setPosting_date(rs.getString(17));				
					rec.setPosting_date_norm(rs.getString(18));				
					rec.setPosting_id(rs.getString(19));				
					rec.setDue_date(rs.getString(20));				
					rec.setDue_date_norm(rs.getString(21));				
					rec.setOrder_date(rs.getString(22));				
					rec.setOrder_date_norm(rs.getString(23));				
					rec.setInvoice_id(rs.getInt(24));				
					rec.setInvoice_id_norm(rs.getInt(25));				
					rec.setBaseline_create_date(rs.getString(26));				
					rec.setInvoice_date_norm(rs.getString(27));				
					rec.setTotal_open_amount(rs.getFloat(28));				
					rec.setTotal_open_amount_norm(rs.getFloat(29));				
					rec.setCust_payment_terms(rs.getInt(30));				
					rec.setBusiness_area(rs.getString(31));				
					rec.setShip_date(rs.getString(32));				
					rec.setShip_to(rs.getString(33));				
					rec.setClearing_date(rs.getString(34));				
					rec.setClearing_date_norm(rs.getString(35));				
					rec.setReason_code(rs.getString(36));				
					rec.setIsOpen(rs.getInt(37));				
					rec.setDiscount_due_date_norm(rs.getString(38));				
					rec.setDebit_credit_indicator(rs.getString(39));				
					rec.setPayment_method(rs.getString(40));				
					rec.setDocument_creation_date(rs.getString(41));				
					rec.setInvoice_amount_doc_currency(rs.getFloat(42));				
					rec.setDocument_id(rs.getInt(43));				
					rec.setActual_open_amount(rs.getFloat(44));				
					rec.setPaid_amount(rs.getFloat(45));
					rec.setDayspast_due(rs.getInt(46));
					rec.setInvoice_age(rs.getInt(47));
					rec.setDisputed_amount(rs.getFloat(48));
					records.add(rec);
				}
				Gson gson = new Gson();
				data=gson.toJson(records);
			}
			PrintWriter pw=resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			pw.println(data);
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
		}		
	}
	private static boolean isNumeric(String str)
	{
		boolean flag=true;
		try
		{
			int i=Integer.parseInt(str);
		}
		catch(NumberFormatException e)
		{
			flag=false;
		}
		return flag;
	}
}
