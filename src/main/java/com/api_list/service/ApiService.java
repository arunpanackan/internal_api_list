package com.api_list.service;

import java.util.List;

import com.api_list.entity.ApiData;

public interface ApiService {

	public List<ApiData> getAllApi();

	// public ApiData getById(int id);

	public List<ApiData> getByApiType(String apiType);

	public void addToBlockList(int id);

	public void clearBlockList(int id);

	public List<ApiData> getBlockListed(Boolean blocked);

}
