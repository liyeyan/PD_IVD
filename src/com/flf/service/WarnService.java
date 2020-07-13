package com.flf.service;

import com.flf.entity.Warn;
import com.flf.entity.District;

import java.util.List;

public interface WarnService {

	List<Warn> listAllWarn();

	List<Warn> listPageWarn(Warn warn);

	List<Integer> selectWarnByLevel(int level);

	void insertWarn(Warn warn);

	void updateWarn(Warn warn);

	List<District> listWarnDistrict();



	
}
