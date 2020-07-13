package com.flf.service;

import com.flf.entity.District;
import com.flf.entity.TbRule;
import com.flf.mapper.DistrictMapper;

import java.util.List;

public interface RuleService {
	List<TbRule>  listPageRule(TbRule rule );
	List <District>listDistrict (District district);
    void updateRule(TbRule rule);

	TbRule getRuleById(Integer id);
}
