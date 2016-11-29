package com.ppp.db.receipt;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "RECEIPT")
public class ReceiptVO {
	@Id
	@GeneratedValue
	private int receipt_num;
	private int customer_num;
	private int item_num;
	private String staff_num;
	@Temporal(TemporalType.DATE)
	private Date receipt_date= new Date();
	private String send_type;
	private String pay_type;
	private int send_pay;
	@Transient // 해당변수를 매핑 대상에서 제외
	private String searchCondition;
	@Transient
	private String searchKeyword;

	public int getReceipt_num() {
		return receipt_num;
	}

	public void setReceipt_num(int receipt_num) {
		this.receipt_num = receipt_num;
	}

	public int getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}

	public int getItem_num() {
		return item_num;
	}

	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}

	public String getStaff_num() {
		return staff_num;
	}

	public void setStaff_num(String staff_num) {
		this.staff_num = staff_num;
	}

	public Date getReceipt_date() {
		return receipt_date;
	}

	public void setReceipt_date(Date receipt_date) {
		this.receipt_date = receipt_date;
	}

	public String getSend_type() {
		return send_type;
	}

	public void setSend_type(String send_type) {
		this.send_type = send_type;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public int getSend_pay() {
		return send_pay;
	}

	public void setSend_pay(int send_pay) {
		this.send_pay = send_pay;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "ReceiptVO [receipt_num=" + receipt_num + ", customer_num=" + customer_num + ", item_num=" + item_num
				+ ", staff_num=" + staff_num + ", receipt_date=" + receipt_date + ", send_type=" + send_type
				+ ", pay_type=" + pay_type + ", send_pay=" + send_pay + "]";
	}

}
