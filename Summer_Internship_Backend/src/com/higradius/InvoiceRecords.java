package com.higradius;

public class InvoiceRecords 
{
	private Integer pk_id;
	private Integer acct_doc_header_id;
	private Integer company_id;
	private Integer document_number;
	private Integer document_number_norm;
	private String business_code;
	private String create_year;
	private Integer document_line_number;
	private String doctype;
	private Integer customer_number;
	private Integer customer_number_norm;
	private Integer fk_customer_map_id;
	private String customer_name;
	private String division;
	private String document_create_date;
	private String document_create_date_norm;
	private String posting_date;
	private String posting_date_norm;
	private String posting_id;
	private String due_date;
	private String due_date_norm;
	private String order_date;
	private String order_date_norm;
	private Integer invoice_id;
	private Integer invoice_id_norm;
	private String baseline_create_date;
	private String invoice_date_norm;
	private Float total_open_amount;
	private Float total_open_amount_norm;
	private Integer cust_payment_terms;
	private String business_area;
	private String ship_date;
	private String ship_to;
	private String clearing_date;
	private String clearing_date_norm;
	private String reason_code;
	private Integer isOpen;
	private String discount_due_date_norm;
	private String debit_credit_indicator;
	private String payment_method;
	private String document_creation_date;
	private Float invoice_amount_doc_currency;
	private Integer document_id;
	private Float actual_open_amount;
	private Float paid_amount;
	private Integer dayspast_due;
	private Integer invoice_age;
	private Float disputed_amount;
	public Integer getPk_id() {
		return pk_id;
	}
	public void setPk_id(Integer pk_id) {
		this.pk_id = pk_id;
	}
	public Integer getAcct_doc_header_id() {
		return acct_doc_header_id;
	}
	public void setAcct_doc_header_id(Integer acct_doc_header_id) {
		this.acct_doc_header_id = acct_doc_header_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public Integer getDocument_number() {
		return document_number;
	}
	public void setDocument_number(Integer document_number) {
		this.document_number = document_number;
	}
	public Integer getDocument_number_norm() {
		return document_number_norm;
	}
	public void setDocument_number_norm(Integer document_number_norm) {
		this.document_number_norm = document_number_norm;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getCreate_year() {
		return create_year;
	}
	public void setCreate_year(String create_year) {
		this.create_year = create_year;
	}
	public Integer getDocument_line_number() {
		return document_line_number;
	}
	public void setDocument_line_number(Integer document_line_number) {
		this.document_line_number = document_line_number;
	}
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	public Integer getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(Integer customer_number) {
		this.customer_number = customer_number;
	}
	public Integer getCustomer_number_norm() {
		return customer_number_norm;
	}
	public void setCustomer_number_norm(Integer customer_number_norm) {
		this.customer_number_norm = customer_number_norm;
	}
	public Integer getFk_customer_map_id() {
		return fk_customer_map_id;
	}
	public void setFk_customer_map_id(Integer fk_customer_map_id) {
		this.fk_customer_map_id = fk_customer_map_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDocument_create_date() {
		return document_create_date;
	}
	public void setDocument_create_date(String document_create_date) {
		this.document_create_date = document_create_date;
	}
	public String getDocument_create_date_norm() {
		return document_create_date_norm;
	}
	public void setDocument_create_date_norm(String document_create_date_norm) {
		this.document_create_date_norm = document_create_date_norm;
	}
	public String getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(String posting_date) {
		this.posting_date = posting_date;
	}
	public String getPosting_date_norm() {
		return posting_date_norm;
	}
	public void setPosting_date_norm(String posting_date_norm) {
		this.posting_date_norm = posting_date_norm;
	}
	public String getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(String posting_id) {
		this.posting_id = posting_id;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getDue_date_norm() {
		return due_date_norm;
	}
	public void setDue_date_norm(String due_date_norm) {
		this.due_date_norm = due_date_norm;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_date_norm() {
		return order_date_norm;
	}
	public void setOrder_date_norm(String order_date_norm) {
		this.order_date_norm = order_date_norm;
	}
	public Integer getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}
	public Integer getInvoice_id_norm() {
		return invoice_id_norm;
	}
	public void setInvoice_id_norm(Integer invoice_id_norm) {
		this.invoice_id_norm = invoice_id_norm;
	}
	public String getBaseline_create_date() {
		return baseline_create_date;
	}
	public void setBaseline_create_date(String baseline_create_date) {
		this.baseline_create_date = baseline_create_date;
	}
	public String getInvoice_date_norm() {
		return invoice_date_norm;
	}
	public void setInvoice_date_norm(String invoice_date_norm) {
		this.invoice_date_norm = invoice_date_norm;
	}
	public Float getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(Float total_open_amount) {
		this.total_open_amount = total_open_amount;
	}
	public Float getTotal_open_amount_norm() {
		return total_open_amount_norm;
	}
	public void setTotal_open_amount_norm(Float total_open_amount_norm) {
		this.total_open_amount_norm = total_open_amount_norm;
	}
	public Integer getCust_payment_terms() {
		return cust_payment_terms;
	}
	public void setCust_payment_terms(Integer cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}
	public String getBusiness_area() {
		return business_area;
	}
	public void setBusiness_area(String business_area) {
		this.business_area = business_area;
	}
	public String getShip_date() {
		return ship_date;
	}
	public void setShip_date(String ship_date) {
		this.ship_date = ship_date;
	}
	public String getShip_to() {
		return ship_to;
	}
	public void setShip_to(String ship_to) {
		this.ship_to = ship_to;
	}
	public String getClearing_date() {
		return clearing_date;
	}
	public void setClearing_date(String clearing_date) {
		this.clearing_date = clearing_date;
	}
	public String getClearing_date_norm() {
		return clearing_date_norm;
	}
	public void setClearing_date_norm(String clearing_date_norm) {
		this.clearing_date_norm = clearing_date_norm;
	}
	public String getReason_code() {
		return reason_code;
	}
	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}
	public Integer getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}
	public String getDiscount_due_date_norm() {
		return discount_due_date_norm;
	}
	public void setDiscount_due_date_norm(String discount_due_date_norm) {
		this.discount_due_date_norm = discount_due_date_norm;
	}
	public String getDebit_credit_indicator() {
		return debit_credit_indicator;
	}
	public void setDebit_credit_indicator(String debit_credit_indicator) {
		this.debit_credit_indicator = debit_credit_indicator;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getDocument_creation_date() {
		return document_creation_date;
	}
	public void setDocument_creation_date(String document_creation_date) {
		this.document_creation_date = document_creation_date;
	}
	public Float getInvoice_amount_doc_currency() {
		return invoice_amount_doc_currency;
	}
	public void setInvoice_amount_doc_currency(Float invoice_amount_doc_currency) {
		this.invoice_amount_doc_currency = invoice_amount_doc_currency;
	}
	public Integer getDocument_id() {
		return document_id;
	}
	public void setDocument_id(Integer document_id) {
		this.document_id = document_id;
	}
	public Float getActual_open_amount() {
		return actual_open_amount;
	}
	public void setActual_open_amount(Float actual_open_amount) {
		this.actual_open_amount = actual_open_amount;
	}
	public Float getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(Float paid_amount) {
		this.paid_amount = paid_amount;
	}
	public Integer getDayspast_due() {
		return dayspast_due;
	}
	public void setDayspast_due(Integer dayspast_due) {
		this.dayspast_due = dayspast_due;
	}
	public Integer getInvoice_age() {
		return invoice_age;
	}
	public void setInvoice_age(Integer invoice_age) {
		this.invoice_age = invoice_age;
	}
	public Float getDisputed_amount() {
		return disputed_amount;
	}
	public void setDisputed_amount(Float disputed_amount) {
		this.disputed_amount = disputed_amount;
	}
}
