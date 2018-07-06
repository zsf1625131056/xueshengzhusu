package pers.dzgodly.domain;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

public class HouseOwner implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer houseOwnerId;
	private String ownerPwd;
	private String ownerName;
	private String location;
	private String phone;
	public HouseOwner() {
		super();
	}
	public HouseOwner(String ownerPwd,String ownerName,	String location,String phone) {
		super();
		this.ownerPwd=ownerPwd;
		this.ownerName=ownerName;
		this.location=location;
		this.phone=phone;
	}
	public Integer getHouseOwnerId() {
		return houseOwnerId;
	}
	public void setHouseOwnerId(Integer houseOwnerId) {
		this.houseOwnerId = houseOwnerId;
	}
	public String getOwnerPwd() {
		return ownerPwd;
	}
	public void setOwnerPwd(String ownerPwd) {
		this.ownerPwd = ownerPwd;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String studentPhone) {
		this.phone = studentPhone;
	}
}
