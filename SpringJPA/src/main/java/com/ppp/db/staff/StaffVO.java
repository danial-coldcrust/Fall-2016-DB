package com.ppp.db.staff;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="STAFF")
public class StaffVO  {
	@Id
	//@GeneratedValue
	private String staff_num;
	private int office_num;
	private String staff_job;
	private String staff_name;
	private String staff_phonenum;
	private String staff_residentnum;
	private String staff_address;
	@Transient //해당변수를 매핑 대상에서 제외
	private String searchCondition;
	@Transient
	private String searchKeyword;
	
	public String getStaff_num() {
		return staff_num;
	}
	public void setStaff_num(String staff_num) {
		this.staff_num = staff_num;
	}
	public int getOffice_num() {
		return office_num;
	}
	public void setOffice_num(int office_num) {
		this.office_num = office_num;
	}
	public String getStaff_job() {
		return staff_job;
	}
	public void setStaff_job(String staff_job) {
		this.staff_job = staff_job;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_phonenum() {
		return staff_phonenum;
	}
	public void setStaff_phonenum(String staff_phonenum) {
		this.staff_phonenum = staff_phonenum;
	}
	public String getStaff_residentnum() {
		return staff_residentnum;
	}
	public void setStaff_residentnum(String staff_residentnum) {
		this.staff_residentnum = staff_residentnum;
	}
	public String getStaff_address() {
		return staff_address;
	}
	public void setStaff_address(String staff_address) {
		this.staff_address = staff_address;
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
		return "StaffVO [staff_num=" + staff_num + ", office_num="+ 
				office_num + ", staff_job=" + staff_job + ", staff_name="+
				staff_name + ", staff_phonenum=" + staff_phonenum + 
				", staff_residentnum="+ staff_residentnum +", staff_address="
				+ staff_address +"]";
	}
	
}
