package pers.dzgodly.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pers.dzgodly.domain.MeetInfo;

public interface MeetInfoMapper {

	@Insert("insert into meetinfo(idHouseInfo,studentId,houseOwnerId,meetTime,meetLocation,state) "
			+ "values(#{idHouseInfo},#{studentId},#{houseOwnerId},#{meetTime}, #{meetLocation},0)")
	int insert(@Param("idHouseInfo")String idHouseInfo,@Param("studentId")String studentId,
			@Param("houseOwnerId")String houseOwnerId,
			@Param("meetTime")String meetTime,@Param("meetLocation")String meetLocation);
	
	@Update("update meetinfo set state=#{state} where idMeetInfo=#{idMeetInfo}")
	int updateState(@Param("state")String state,@Param("idMeetInfo")String idMeetInfo);
	
	@Update("update meetinfo set meetTime=#{meetTime},meetLocation=#{meetLocation} where idMeetInfo=#{idMeetInfo}")
	int update(@Param("meetTime")String meetTime,@Param("meetLocation")String meetLocation,
			@Param("idMeetInfo")String idMeetInfo);
	
	@Select("select * from meetinfo where studentId=#{studentId}")
	List<MeetInfo> selectMeetInfoByStudentId(@Param("studentId")String studentId);
	
	@Select("select * from meetinfo where houseOwnerId=#{houseOwnerId}")
	List<MeetInfo> selectMeetInfoByHouseOwnerId(@Param("houseOwnerId")String houseOwnerId);
	
	@Delete("delete from meetinfo where idMeetInfo=#{idMeetInfo}")
	int delete(@Param("idMeetInfo")String idMeetInfo);
}
