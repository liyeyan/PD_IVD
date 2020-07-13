package com.flf.service.impl;

import com.flf.entity.District;
import com.flf.entity.Warn;
import com.flf.mapper.DistrictMapper;
import com.flf.mapper.WarnMapper;
import com.flf.service.WarnService;

import java.util.List;

public class WarnServiceImpl implements WarnService {

	private WarnMapper warnMapper;
	private DistrictMapper districtMapper;

	public DistrictMapper getDistrictMapper() {
		return districtMapper;
	}

	public void setDistrictMapper(DistrictMapper districtMapper) {
		this.districtMapper = districtMapper;
	}

	public WarnMapper getWarnMapper() {
		return warnMapper;
	}

	public void setWarnMapper(WarnMapper warnMapper) {
		this.warnMapper = warnMapper;
	}

	@Override
	public List<Warn> listAllWarn() {
		return warnMapper.listAllWarn();
	}

	@Override
	public List<Warn> listPageWarn(Warn warn) {
		return warnMapper.listPageWarn(warn);
	}

	@Override
	public List<Integer> selectWarnByLevel(int level) {
		return warnMapper.selectWarnByLevel(level);
	}

	@Override
	public void insertWarn(Warn warn) {
		warnMapper.insertWarn(warn);
	}

	@Override
	public void updateWarn(Warn warn) {
		warnMapper.updateWarn(warn);
	}

	@Override
	public List<District> listWarnDistrict() {
		return districtMapper.listWarnDistrict();
	}


}
