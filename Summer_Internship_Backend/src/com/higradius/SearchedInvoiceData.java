package com.higradius;

public class SearchedInvoiceData 
{
	private String customer_name;
	private Integer customer_number_norm;
	private Float actual_open_amount;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Integer getCustomer_number_norm() {
		return customer_number_norm;
	}
	public void setCustomer_number_norm(Integer customer_number_norm) {
		this.customer_number_norm = customer_number_norm;
	}
	public Float getActual_open_amount() {
		return actual_open_amount;
	}
	public void setActual_open_amount(Float actual_open_amount) {
		this.actual_open_amount = actual_open_amount;
	}
	
}
