package pers.dzgodly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.dzgodly.domain.HouseInfo;
import pers.dzgodly.mapper.HouseInfoMapper;
import pers.dzgodly.service.HouseListService;

@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.DEFAULT)
@Service
public class HouseListServiceImpl implements HouseListService {
	
	@Autowired
	private HouseInfoMapper houseInfoMapper;

	@Override
	public List<HouseInfo> getHouseList() {
		return houseInfoMapper.findAll();
	}

	@Override
	public HouseInfo findHouseById(Integer idHouseInfo) {
		return houseInfoMapper.findHouseById(idHouseInfo);
	}

	@Override
	public List<HouseInfo> findHouseByOwnerId(String houseOwnerId) {
		return houseInfoMapper.findHouseByOwnerId(houseOwnerId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateAvailable(String available, String idHouseInfo) {
		houseInfoMapper.updateAvailable(available, idHouseInfo);
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int delete(String idHouseInfo) {
		houseInfoMapper.delete(idHouseInfo);
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insert(String houseOwnerId, String location, String type, String theLimit, String rent) {
		houseInfoMapper.insert(houseOwnerId, location, type, theLimit, rent);
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int update(String location, String type, String theLimit, String rent, String available,String idHouseInfo) {
		houseInfoMapper.update(location, type, theLimit, rent, available,idHouseInfo);
		return 0;
	}

	@Override
	public List<HouseInfo> findUnavailable() {
		return houseInfoMapper.findUnavailable();
	}

}
