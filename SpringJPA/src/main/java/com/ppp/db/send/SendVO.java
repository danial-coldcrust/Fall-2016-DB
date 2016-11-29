package com.ppp.db.send;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "SEND")
public class SendVO {
	@Id
	private int send_num; // 날짜-시간 이렇게
	private int item_num;
	private String staff_num;
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	@Temporal(TemporalType.TIME)
	private Date time = new Date();
	private String item_position;
	private String handling_state;
	private String receiver_name;
	@Transient // 해당변수를 매핑 대상에서 제외
	private String searchCondition;
	@Transient
	private String searchKeyword;
	private int customer_num;

	public int getSend_num() {
		return send_num;
	}

	public void setSend_num(int send_num) {
		this.send_num = send_num;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getItem_position() {
		return item_position;
	}

	public void setItem_position(String item_position) {
		this.item_position = item_position;
	}

	public String getHandling_state() {
		return handling_state;
	}

	public void setHandling_state(String handling_state) {
		this.handling_state = handling_state;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
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

	public int getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(int customer_num) {
		this.customer_num = customer_num;
	}

	@Override
	public String toString() {
		return "Send [send_num=" + send_num + ", item_num=" + item_num + ", staff_num=" + staff_num + ", date=" + date
				+ ", time=" + time + ", item_position=" + item_position + ", handling_state=" + handling_state
				+ ", receiver_name=" + receiver_name + "]";
	}
}
