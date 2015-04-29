package com.winning.kbms.medical.service;

import java.util.List;
import java.util.Map;

import com.winning.kbms.medical.entity.LinstrFileInfo;

public interface SearchService {
	public List<LinstrFileInfo> searchDrugs(String drugName);
	public LinstrFileInfo searchDrug(String drugId);
	public List<LinstrFileInfo> searchDrugs(Map<String, String> params);
	public List<LinstrFileInfo> searchDrugs(Map<String, String> params,int hitSize);
}
