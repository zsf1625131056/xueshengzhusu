package pers.dzgodly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.dzgodly.domain.MeetInfo;
import pers.dzgodly.mapper.MeetInfoMapper;
import pers.dzgodly.service.InvationService;

@Service
public class InvationServiceImpl implements InvationService {

	@Autowired
	private MeetInfoMapper meetInfoMapper;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insert(String idHouseInfo,String studentId, String houseOwnerId, String meetTime, String meetLocation) {
		meetInfoMapper.insert(idHouseInfo,studentId, houseOwnerId, meetTime, meetLocation);
		return 0;
	}

	/*@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int acptInvation(String idMeetInfo) {
		meetInfoMapper.update("1", idMeetInfo);
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int refsInvation(String idMeetInfo) {
		meetInfoMapper.update("2", idMeetInfo);
		return 0;
	}*/

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<MeetInfo> showAcptInvations(String houseOwnerId) {
		return meetInfoMapper.selectMeetInfoByHouseOwnerId(houseOwnerId);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<MeetInfo> showSendInvations(String studentId) {
		return meetInfoMapper.selectMeetInfoByStudentId(studentId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateState(String state, String idMeetInfo) {
		meetInfoMapper.updateState(state, idMeetInfo);
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int update(String meetTime, String meetLocation, String idMeetInfo) {
		meetInfoMapper.update(meetTime, meetLocation, idMeetInfo);
		return 0;
	}

	@Override
	public int delete(String idMeetInfo) {
		meetInfoMapper.delete(idMeetInfo);
		return 0;
	}

}
