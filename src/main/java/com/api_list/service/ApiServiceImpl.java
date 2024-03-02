package com.api_list.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_list.entity.ApiData;
import com.api_list.repository.ApiRepository;

@Service
public class ApiServiceImpl implements ApiService {

	@Autowired
	ApiRepository apiRepository;

	@Override
	public List<ApiData> getAllApi() {

		List<ApiData> getApiList = apiRepository.findAll();
		return getApiList;

	}

//	@Override
//	public ApiData getById(int id) {
//		ApiData getById = apiRepository.findById(id).get();
//		return getById;
//	}

	public List<ApiData> getByApiType(String apiType) {

		List<ApiData> apiTypez = apiRepository.findByApiType(apiType);
		return apiTypez;

	}

	public void addToBlockList(int id) {

		apiRepository.addToBlockList(id);

	}

	public void clearBlockList(int id) {

		apiRepository.clearBlockList(id);

	}

	public List<ApiData> getBlockListed(Boolean blocked) {

		List<ApiData> apiBlocked = apiRepository.findByBlocked(blocked);
		return apiBlocked;

	}

}
