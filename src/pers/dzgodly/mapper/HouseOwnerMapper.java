package pers.dzgodly.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pers.dzgodly.domain.HouseOwner;

public interface HouseOwnerMapper {

	@Select("select * from houseowner where houseOwnerId = #{loginId} and ownerPwd = #{password}")
	HouseOwner findWithLoginnameAndPassword(@Param("loginId")String loginId,
			@Param("password") String ownerPwd);
	
	@Select("select * from houseowner where houseOwnerId = #{houseOwnerId}")
	HouseOwner findById(@Param("houseOwnerId")Integer houseOwnerId);
	
	@Insert("insert into houseowner(ownerPwd,ownerName,location,phone)"
			+ " values(#{ownerPwd},#{ownerName},#{location},#{phone})")
	@Options(useGeneratedKeys=true, keyProperty="houseOwnerId")
	int insert(HouseOwner houseOwner);
	
	@Update("update houseowner set phone=#{phone},location=#{location}"
			+ " where houseOwnerId=#{houseOwnerId}")
	int update(@Param("houseOwnerId")String houseOwnerId,@Param("phone")String phone,@Param("location")String location);
}