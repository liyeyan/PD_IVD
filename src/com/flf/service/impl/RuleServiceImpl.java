package com.flf.service.impl;

import com.flf.entity.District;
import com.flf.entity.TbRule;
import com.flf.mapper.DistrictMapper;
import com.flf.mapper.RuleMapper;
import com.flf.service.RuleService;

import java.util.List;

public class RuleServiceImpl implements RuleService {

	private RuleMapper ruleMapper;
	private DistrictMapper districtMapper;

	public DistrictMapper getDistrictMapper() {
		return districtMapper;
	}

	public void setDistrictMapper(DistrictMapper districtMapper) {
		this.districtMapper = districtMapper;
	}
	public RuleMapper getRuleMapper() {
		return ruleMapper;
	}

	public void setRuleMapper(RuleMapper ruleMapper) {
		this.ruleMapper = ruleMapper;
	}

	@Override
	public List<TbRule> listPageRule(TbRule rule) {
		return ruleMapper.listPageRule(rule);
	}
	public List<District> listDistrict (District district){
		return districtMapper.listDistrict(district);
	}

	@Override
	public void updateRule(TbRule rule) {
		if (rule.getId()!= null){
			ruleMapper.update(rule);
		}else{
			ruleMapper.insert(rule);
		}
	}

	@Override
	public TbRule getRuleById(Integer id) {
		return ruleMapper.getRuleById(id);
	}
}
