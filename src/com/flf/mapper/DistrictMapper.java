package com.flf.mapper;

import com.flf.entity.District;

import java.util.List;

public interface DistrictMapper {
	List<District> listDistrict(District District);
	List<District> listWarnDistrict();
}
