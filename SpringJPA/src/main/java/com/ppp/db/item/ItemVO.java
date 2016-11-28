package com.ppp.db.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ITEM")
public class ItemVO  {
	@Id
	@GeneratedValue
	private int item_num;
	private int item_name;
	private int customer_num;
	private String receiver_address;
	private String receiver_name;
	private int item_price;
    private String item_weight;
    @Transient //해당변수를 매핑 대상에서 제외
	private String searchCondition;
	@Transient
	private String searchKeyword;
    
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getItem_name() {
		return item_name;
	}
	public void setItem_name(int item_name) {
		this.item_name = item_name;
	}
	public int getCustomer_num() {
		return customer_num;
	}
	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}
	public String getReceiver_address() {
		return receiver_address;
	}
	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_weight() {
		return item_weight;
	}
	public void setItem_weight(String item_weight) {
		this.item_weight = item_weight;
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
		return "ItemVO [item_num=" + item_num + ", item_name=" + item_name + ", customer_num=" + customer_num
				+ ", receiver_address=" + receiver_address + ", receiver_name=" + receiver_name + ", item_price="
				+ item_price + ", item_weight=" + item_weight + "]";
	}
}
