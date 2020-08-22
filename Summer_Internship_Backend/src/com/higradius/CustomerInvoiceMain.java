package com.higradius;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class CustomerInvoiceMain 
{
	public static void main(String[] args) 
	{
		Connection dbCon=null;
		String url="jdbc:mysql://127.0.0.1:3306/project";
		String username="root";
		String password="root";
		Statement stm=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon=DriverManager.getConnection(url,username,password);
			System.out.println("Connected ...");
			stm=dbCon.createStatement();
			ArrayList<InvoiceRecords> records=CSVLoader.loadCSV();
			LoadInDataBase.populateDataBase(records);
			
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
	static void showTableDetails(Connection dbCon)
	{
		try
		{
			Statement stm=dbCon.createStatement();
			ResultSet ret=stm.executeQuery("SELECT * FROM customer_invoice");
			ResultSetMetaData rsmd = ret.getMetaData();
			System.out.println("No. of columns : " + rsmd.getColumnCount());
			for(int i=1;i<=rsmd.getColumnCount();i++)
				System.out.println("pst.set("+(i-1)+",rec.get"+(Character.toUpperCase(rsmd.getColumnName(i).charAt(0))+rsmd.getColumnName(i).substring(1))+"());");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
	}
}
