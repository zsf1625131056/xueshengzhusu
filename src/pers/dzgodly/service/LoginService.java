package pers.dzgodly.service;

import pers.dzgodly.domain.HouseOwner;
import pers.dzgodly.domain.Student;

public interface LoginService {

	HouseOwner ownerLogin(String loginId,String ownerPwd);
	
	Student studentLogin(String loginId,String studentPwd);
}
