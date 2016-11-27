package com.ppp.db.office;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="OFFICE")
public class OfficeVO{
	@Id
	private int office_num;
	private String office_name;
	private String office_address;
	private String office_phonenum;
	private String office_paxnum;
	@Transient //해당변수를 매핑 대상에서 제외
	private String searchCondition;
	@Transient
	private String searchKeyword;
	
	public int getOffice_num() {
		return office_num;
	}
	public void setOffice_num(int office_num) {
		this.office_num = office_num;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getOffice_address() {
		return office_address;
	}
	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}
	public String getOffice_phonenum() {
		return office_phonenum;
	}
	public void setOffice_phonenum(String office_phonenum) {
		this.office_phonenum = office_phonenum;
	}
	public String getOffice_paxnum() {
		return office_paxnum;
	}
	public void setOffice_paxnum(String office_paxnum) {
		this.office_paxnum = office_paxnum;
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
		return "OfficeVO [office_num=" + office_num + ", office_name=" + office_name + ", office_address="
				+ office_address + ", office_phonenum=" + office_phonenum + ", office_paxnum=" + office_paxnum
				+ ", searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}
	
	
	
}
