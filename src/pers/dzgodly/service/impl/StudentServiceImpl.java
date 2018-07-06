package pers.dzgodly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.dzgodly.domain.Student;
import pers.dzgodly.mapper.StudentMapper;
import pers.dzgodly.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper studentMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateStudent(String studentId,String studentPhone, String studentLocation, String studentAge, String gender) {
		studentMapper.update(studentId, studentPhone, studentLocation, studentAge, gender);
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Student findById(String studentId) {
		return studentMapper.findById(studentId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateHouseId(String studentId, String idHouseInfo) {
		studentMapper.updateHouseId(studentId, idHouseInfo);
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Student findByHouseId(String idHouseInfo) {
		return studentMapper.findByHouseId(idHouseInfo);
	}

}
