package pers.dzgodly.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class MeetInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idMeetInfo;
	private Integer idHouseInfo;
	private Integer studentId;
	private Integer houseOwnerId;
	private Timestamp meetTime;
	private String meetLocation;
	private Integer state;
	
	public Integer getIdHouseInfo() {
		return idHouseInfo;
	}
	public void setIdHouseInfo(Integer idHouseInfo) {
		this.idHouseInfo = idHouseInfo;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getIdMeetInfo() {
		return idMeetInfo;
	}
	public void setIdMeetInfo(Integer idMeetInfo) {
		this.idMeetInfo = idMeetInfo;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getHouseOwnerId() {
		return houseOwnerId;
	}
	public void setHouseOwnerId(Integer houseOwnerId) {
		this.houseOwnerId = houseOwnerId;
	}
	public Timestamp getMeetTime() {
		return meetTime;
	}
	public void setMeetTime(Timestamp meetTime) {
		this.meetTime = meetTime;
	}
	public String getMeetLocation() {
		return meetLocation;
	}
	public void setMeetLocation(String meetLocation) {
		this.meetLocation = meetLocation;
	} 
}
