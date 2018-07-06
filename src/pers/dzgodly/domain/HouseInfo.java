package pers.dzgodly.domain;

import java.io.Serializable;

public class HouseInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idHouseInfo;
	private Integer houseOwnerId;
	private String location;
	private String type;
	private Integer theLimit;
	private Integer rent;
	private Integer available;
	public Integer getTheLimit() {
		return theLimit;
	}
	public void setTheLimit(Integer theLimit) {
		this.theLimit = theLimit;
	}
	public Integer getIdHouseInfo() {
		return idHouseInfo;
	}
	public void setIdHouseInfo(Integer idHouseInfo) {
		this.idHouseInfo = idHouseInfo;
	}
	public Integer getHouseOwnerId() {
		return houseOwnerId;
	}
	public void setHouseOwnerId(Integer houseOwnerId) {
		this.houseOwnerId = houseOwnerId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
}
