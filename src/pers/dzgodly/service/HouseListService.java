package pers.dzgodly.service;

import java.util.List;

import pers.dzgodly.domain.HouseInfo;

public interface HouseListService {

	List<HouseInfo> getHouseList();
	
	List<HouseInfo> findUnavailable();
	
	HouseInfo findHouseById(Integer idHouseInfo);
	
	List<HouseInfo> findHouseByOwnerId(String houseOwnerId);
	
	int updateAvailable(String available,String idHouseInfo);
	
	int update(String location,String type,String theLimit,String rent,String available,String idHouseInfo);
	
	int delete(String idHouseInfo);
	
	int insert(String houseOwnerId,String location,String type,String theLimit,String rent);
}
