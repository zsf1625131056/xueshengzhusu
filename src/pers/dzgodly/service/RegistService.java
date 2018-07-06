package pers.dzgodly.service;

public interface RegistService {

	int insertStudent(String password,String name,String location,
			String phone,String studentAge,String gender);
	
	int insertHouseOwner(String password,String name,
			String location,String phone);
}