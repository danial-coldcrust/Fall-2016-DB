package com.ppp.db.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="CUSTOMER")	//테이블과 맵핑 설정안하면 클래스이름과 같은 테이블이 자동으로 맵핑
public class CustomerVO  {
	@Id
	@GeneratedValue
	private int customer_num;
	private String customer_name;
	private String customer_phonenum;
	private String customer_address;
	@Transient	//해당변수를 매핑 대상에서 제외
	private String searchCondition;
	@Transient
	private String searchKeyword;
	
	public int getCustomer_num() {
		return customer_num;
	}
	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_phonenum() {
		return customer_phonenum;
	}
	public void setCustomer_phonenum(String customer_phonenum) {
		this.customer_phonenum = customer_phonenum;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
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
	public String toString(){
		return "CustomerVO [customer_num=" + customer_num + ", customer_name="
				+ customer_name + ", customer_phonenum="+ customer_phonenum
				+", customer_address=" + customer_address +"]";
	} 
}
