package com.hqyj.SpringBootDemo.modules.test.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.SpringBootDemo.modules.common.vo.SearchVo;
import com.hqyj.SpringBootDemo.modules.test.dao.CityDao;
import com.hqyj.SpringBootDemo.modules.test.entity.City;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao cityDao;
	
	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		
//		return cityDao.getCitiesByCountryId(countryId);
		return Optional.ofNullable(cityDao.getCitiesByCountryId2(countryId))
			           .orElse(Collections.emptyList());
	}

	@Override
	public City getByName(String cityName, String localCityName) {
		return cityDao.getCityByName(cityName, localCityName);
	}

	@Override
	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId) {
		PageHelper.startPage(currentPage, pageSize);
		return new PageInfo<City>(Optional.ofNullable(cityDao.getCitiesByCountryId2(countryId))
				.orElse(Collections.emptyList()));
	}

	@Override
	public PageInfo<City> getCitiesBySearchVo(SearchVo searchVo) {
		searchVo.initSearchVo();
		PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
		return new PageInfo<City>(
				Optional.ofNullable(cityDao.getCitiesBySearchVo(searchVo))
				.orElse(Collections.emptyList()));
	}
	
	
	
	
}
