package pers.dzgodly.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pers.dzgodly.domain.Student;

public interface StudentMapper {

	@Select("select * from student where studentId = #{loginId} and studentpwd = #{password}")
	Student findWithLoginnameAndPassword(@Param("loginId")String loginId,
			@Param("password") String studentPwd);
	
	@Select("select * from student where studentId=#{studentId}")
	Student findById(@Param("studentId")String studentId);
	
	@Select("select * from student where idHouseInfo=#{idHouseInfo}")
	Student findByHouseId(@Param("idHouseInfo")String idHouseInfo);
	
	@Insert("insert into student(studentpwd,studentName,studentLocation,studentPhone,studentAge,gender)"
			+ " values(#{studentpwd},#{studentName},#{studentLocation},#{studentPhone},#{studentAge},#{gender})")
	@Options(useGeneratedKeys=true, keyProperty="studentId")
	int insert(Student student);
	
	@Update("update student set studentPhone=#{studentPhone},studentLocation=#{studentLocation},studentAge=#{studentAge},gender=#{gender}"
			+ " where studentId=#{studentId}")
	int update(@Param("studentId")String studentId,@Param("studentPhone")String studentPhone,
			@Param("studentLocation")String studentLocation,@Param("studentAge")String studentAge,@Param("gender")String gender);
	
	@Update("update student set idHouseInfo=#{idHouseInfo} where studentId=#{studentId}")
	int updateHouseId(@Param("studentId")String studentId,@Param("idHouseInfo")String idHouseInfo);
}
