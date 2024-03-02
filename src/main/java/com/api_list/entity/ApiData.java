package com.api_list.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "api_data")
public class ApiData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "api_type")
	private String apiType;
	@Column(name = "api_url")
	private String apiUrl;
	@Column(name = "api_name")
	private String apiName;
	@Column(name = "blocked")
	private boolean blocked;

	public ApiData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApiType() {
		return apiType;
	}

	public void setApiType(String apiType) {
		this.apiType = apiType;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public ApiData(int id, String apiType, String apiUrl, String apiName, boolean blocked) {
		this.id = id;
		this.apiType = apiType;
		this.apiUrl = apiUrl;
		this.apiName = apiName;
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		return "ApiData [id=" + id + ", apiType=" + apiType + ", apiUrl=" + apiUrl + ", apiName=" + apiName
				+ ", blocked=" + blocked + "]";
	}

}
