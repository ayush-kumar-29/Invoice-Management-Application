package com.higradius;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class CSVLoader 
{
	private static boolean isEmptyStr(String str)
	{
		if(str.length()==0)
			return true;
		return false;
	}
	public static ArrayList<InvoiceRecords> loadCSV()
	{
		ArrayList<InvoiceRecords> records=new ArrayList<>();
		BufferedReader bfr=null;
		try
		{
			bfr=new BufferedReader(new FileReader("D:\\Summer_Internship_Backend\\Data_Uploading.csv"));
			ArrayList<String> arr=new ArrayList(); 
			String r=null;
			while((r=bfr.readLine())!=null)
				arr.add(r);
			String[] rows=new String[47];
			for(int i=1;i<arr.size();i++)
			{
				rows=arr.get(i).split(",",-1);	
				InvoiceRecords rec=new InvoiceRecords();
				
				rec.setAcct_doc_header_id(isEmptyStr(rows[0])?null:Integer.parseInt(rows[0]));
				
				rec.setCompany_id(isEmptyStr(rows[1])?null:Integer.parseInt(rows[1]));
				
				rec.setDocument_number(isEmptyStr(rows[2])?null:Integer.parseInt(rows[2]));
				
				rec.setDocument_number_norm(isEmptyStr(rows[3])?null:Integer.parseInt(rows[3]));
				
				rec.setBusiness_code(isEmptyStr(rows[4])?null:rows[4]);
				
				rec.setCreate_year(isEmptyStr(rows[5])?null:rows[5]);
				
				rec.setDocument_line_number(isEmptyStr(rows[6])?null:Integer.parseInt(rows[6]));
				
				rec.setDoctype(isEmptyStr(rows[7])?null:rows[7]);
				
				rec.setCustomer_number(isEmptyStr(rows[8])?null:Integer.parseInt(rows[8]));
				
				rec.setCustomer_number_norm(isEmptyStr(rows[9])?null:Integer.parseInt(rows[9]));
				
				rec.setFk_customer_map_id(isEmptyStr(rows[10])?null:Integer.parseInt(rows[10]));
				
				rec.setCustomer_name(isEmptyStr(rows[11])?null:rows[11]);
				
				rec.setDivision(isEmptyStr(rows[12])?null:rows[12]);
				
				rec.setDocument_create_date(isEmptyStr(rows[13])?null:rows[13]);
				
				rec.setDocument_create_date_norm(isEmptyStr(rows[14])?null:rows[14]);
				
				rec.setPosting_date(isEmptyStr(rows[15])?null:rows[15]);
				
				rec.setPosting_date_norm(isEmptyStr(rows[16])?null:rows[16]);
				
				rec.setPosting_id(isEmptyStr(rows[17])?null:rows[17]);
				
				rec.setDue_date(isEmptyStr(rows[18])?null:rows[18]);
				
				rec.setDue_date_norm(isEmptyStr(rows[19])?null:rows[19]);
				
				rec.setOrder_date(isEmptyStr(rows[20])?null:rows[20]);
				
				rec.setOrder_date_norm(isEmptyStr(rows[21])?null:rows[21]);
				
				rec.setInvoice_id(isEmptyStr(rows[22])?null:Integer.parseInt(rows[22]));
				
				rec.setInvoice_id_norm(isEmptyStr(rows[23])?null:Integer.parseInt(rows[23]));
				
				rec.setBaseline_create_date(isEmptyStr(rows[24])?null:rows[24]);
				
				rec.setInvoice_date_norm(isEmptyStr(rows[25])?null:rows[25]);
				
				rec.setTotal_open_amount(isEmptyStr(rows[26])?null:Float.parseFloat(rows[26]));
				
				rec.setTotal_open_amount_norm(isEmptyStr(rows[27])?null:Float.parseFloat(rows[27]));
				
				rec.setCust_payment_terms(isEmptyStr(rows[28])?null:Integer.parseInt(rows[28]));
				
				rec.setBusiness_area(isEmptyStr(rows[29])?null:rows[29]);
				
				rec.setShip_date(isEmptyStr(rows[30])?null:rows[30]);
				
				rec.setShip_to(isEmptyStr(rows[31])?null:rows[31]);
				
				rec.setClearing_date(isEmptyStr(rows[32])?null:rows[32]);
				
				rec.setClearing_date_norm(isEmptyStr(rows[33])?null:rows[33]);
				
				rec.setReason_code(isEmptyStr(rows[34])?null:rows[34]);
				
				rec.setIsOpen(isEmptyStr(rows[35])?null:Integer.parseInt(rows[35]));
				
				rec.setDiscount_due_date_norm(isEmptyStr(rows[36])?null:rows[36]);
				
				rec.setDebit_credit_indicator(isEmptyStr(rows[37])?null:rows[37]);
				
				rec.setPayment_method(isEmptyStr(rows[38])?null:rows[38]);
				
				rec.setDocument_creation_date(isEmptyStr(rows[39])?null:rows[39]);
				
				rec.setInvoice_amount_doc_currency(isEmptyStr(rows[40])?null:Float.parseFloat(rows[40]));
				
				rec.setDocument_id(Integer.parseInt(isEmptyStr(rows[41])?null:rows[41]));
				
				rec.setActual_open_amount(isEmptyStr(rows[42])?null:Float.parseFloat(rows[42]));
				
				rec.setPaid_amount(isEmptyStr(rows[43])?null:Float.parseFloat(rows[43]));
				
				rec.setDayspast_due(isEmptyStr(rows[44])?null:Integer.parseInt(rows[44]));
				
				rec.setInvoice_age(isEmptyStr(rows[45])?null:Integer.parseInt(rows[45]));
				
				rec.setDisputed_amount(isEmptyStr(rows[46])?null:Float.parseFloat(rows[46]));
				
				records.add(rec);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				bfr.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			System.out.println(records.size()+" Records Read from CSV !");
		}
		return records;		
	}
}
