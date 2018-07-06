package pers.dzgodly.domain;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer studentId;
	private String studentpwd;
	private Integer idHouseInfo;
	private String studentName;
	private String studentLocation;
	private String studentPhone;
	private Integer studentAge;
	private char gender;
	public Student() {
		super();
	}
	public Student(String studentpwd, String name, String studentLocation, String studentPhone, String studentAge, String gender) {
		this.studentpwd=studentpwd;
		this.studentName=name;
		this.studentLocation=studentLocation;
		this.studentPhone=studentPhone;
		this.studentAge=Integer.valueOf(studentAge);
		this.gender=gender.charAt(0);
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentpwd() {
		return studentpwd;
	}
	public void setStudentpwd(String studentpwd) {
		this.studentpwd = studentpwd;
	}
	public Integer getIdHouseInfo() {
		return idHouseInfo;
	}
	public void setIdHouseInfo(Integer idHouseInfo) {
		this.idHouseInfo = idHouseInfo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String name) {
		this.studentName = name;
	}
	public String getStudentLocation() {
		return studentLocation;
	}
	public void setStudentLocation(String studentLocation) {
		this.studentLocation = studentLocation;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public Integer getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
