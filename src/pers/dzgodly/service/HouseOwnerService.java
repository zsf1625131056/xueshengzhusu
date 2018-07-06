package pers.dzgodly.service;

import pers.dzgodly.domain.HouseOwner;

public interface HouseOwnerService {

	HouseOwner findById(Integer houseOwnerId);
	
	int updateHouseOwner(String houseOwnerId,String phone,String location);
	
}
