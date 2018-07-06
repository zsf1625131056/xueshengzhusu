package pers.dzgodly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.dzgodly.domain.HouseOwner;
import pers.dzgodly.domain.Student;
import pers.dzgodly.mapper.HouseOwnerMapper;
import pers.dzgodly.mapper.StudentMapper;
import pers.dzgodly.service.LoginService;

@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.DEFAULT)
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private HouseOwnerMapper houseOwnerMapper;
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public HouseOwner ownerLogin(String loginId, String ownerPwd) {
		return houseOwnerMapper.findWithLoginnameAndPassword(loginId, ownerPwd);
	}

	@Override
	public Student studentLogin(String loginId, String studentPwd) {
		return studentMapper.findWithLoginnameAndPassword(loginId, studentPwd);
	}

}
