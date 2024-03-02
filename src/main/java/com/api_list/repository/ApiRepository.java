package com.api_list.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api_list.entity.ApiData;

import jakarta.transaction.Transactional;

public interface ApiRepository extends JpaRepository<ApiData, Integer> {

	List<ApiData> findByApiType(String apiType);

	List<ApiData> findByBlocked(Boolean blocked);

	@Transactional
	@Modifying
	@Query("UPDATE ApiData SET blocked = true WHERE id = :id")

	void addToBlockList(int id);

	@Transactional
	@Modifying
	@Query("UPDATE ApiData SET blocked = false WHERE id = :id")
	void clearBlockList(int id);

}
