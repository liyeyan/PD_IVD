package com.flf.mapper;

import com.flf.entity.TbRule;

import java.util.List;

public interface RuleMapper {
	List<TbRule> listPageRule(TbRule rule);
    List<TbRule> listRule(TbRule rule);
    void insert(TbRule rule);

    void update(TbRule rule);

    TbRule getRuleById(Integer id);
}
