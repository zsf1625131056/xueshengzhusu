package pers.dzgodly.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pers.dzgodly.domain.HouseInfo;

public interface HouseInfoMapper {

	@Select("select * from houseinfo where available = 1")
	List<HouseInfo> findAll();
	
	@Select("select * from houseinfo where available = 0")
	List<HouseInfo> findUnavailable();
	
	@Select("select * from houseinfo where idHouseInfo=#{idHouseInfo}")
	HouseInfo findHouseById(@Param("idHouseInfo")Integer idHouseInfo);
	
	@Select("select * from houseinfo where houseOwnerId=#{houseOwnerId}")
	List<HouseInfo> findHouseByOwnerId(@Param("houseOwnerId")String houseOwnerId);
	
	@Update("update houseinfo set available=#{available} where idHouseInfo=#{idHouseInfo}")
	int updateAvailable(@Param("available")String available,@Param("idHouseInfo")String idHouseInfo);
	
	@Update("update houseinfo"
			+ " set location=#{location},type=#{type},theLimit=#{theLimit},rent=#{rent},available=#{available}"
			+ " where idHouseInfo=#{idHouseInfo}")
	int update(@Param("location")String location,@Param("type")String type,@Param("theLimit")String theLimit,
			@Param("rent")String rent,@Param("available")String available,@Param("idHouseInfo")String idHouseInfo);
	
	@Delete("delete from houseinfo where idHouseInfo=#{idHouseInfo}")
	int delete(@Param("idHouseInfo")String idHouseInfo);
	
	@Insert("insert into houseinfo(houseOwnerId,location,type,theLimit,rent)"
			+ " values (#{houseOwnerId},#{location},#{type},#{theLimit},#{rent})")
	int insert(@Param("houseOwnerId")String houseOwnerId,@Param("location")String location,@Param("type")String type,
				@Param("theLimit")String theLimit,@Param("rent")String rent);
}
