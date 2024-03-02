package com.api_list.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_list.entity.ApiData;
import com.api_list.service.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	ApiService apiService;

	@GetMapping(value = "/getAllApi")
	public ResponseEntity<List<ApiData>> getAllData() {
		try {
			List<ApiData> apiData = apiService.getAllApi();
			return new ResponseEntity<List<ApiData>>(apiData, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

//	@PostMapping("/{id}")
//	public ResponseEntity<ApiData> getById(@PathVariable("id") int id) {
//
//		try {
//			ApiData getById = apiService.getById(id);
//			return new ResponseEntity<ApiData>(getById, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@PostMapping("/getByApiType")
	public ResponseEntity<List<ApiData>> getByApiType(@RequestBody Map<String, String> requestBody) {
		String apiType = requestBody.get("type");
		List<ApiData> getByType = apiService.getByApiType(apiType);
		return new ResponseEntity<List<ApiData>>(getByType, HttpStatus.OK);

	}

	@PostMapping("/getBlockedData")
	public ResponseEntity<List<ApiData>> getByBlocked(@RequestBody Map<String, Boolean> requestBody) {
		Boolean apiBlocked = requestBody.get("blocked");
		List<ApiData> getByBlocked = apiService.getBlockListed(apiBlocked);
		return new ResponseEntity<List<ApiData>>(getByBlocked, HttpStatus.OK);

	}

	@PostMapping("/addToBlockList")
	public ResponseEntity<String> addToBlockList(@RequestBody Map<String, Integer> requestBody) {
		Integer apiBlocked = requestBody.get("id");
		apiService.addToBlockList(apiBlocked);
		return new ResponseEntity<String>("API's are blocklisted successfully", HttpStatus.OK);

	}

	@PostMapping("/clearBlockList")
	public ResponseEntity<String> clearBlockList(@RequestBody Map<String, Integer> requestBody) {
		int apiUnblock = requestBody.get("id");
		apiService.clearBlockList(apiUnblock);
		return new ResponseEntity<>("API's are unblocked successfully", HttpStatus.OK);

	}

}
