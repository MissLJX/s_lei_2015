package com.winning.kbms.medical.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winning.kbms.medical.entity.LinstrFileInfo;
import com.winning.kbms.medical.service.SearchService;

@Controller
public class SearchController {
	@Resource(name = "luceneSearchService")
	private SearchService searchService;

	@RequestMapping("DrugSearchTerms.do")
	public String findItemsWithTerms(HttpServletRequest request) {
		String productNameCn = request.getParameter("mc");
		List<LinstrFileInfo> results = searchService.searchDrugs(productNameCn);
		if (CollectionUtils.isEmpty(results)) {
			return "errorpage/NoResult";
		}
		request.setAttribute("results", results);
		return "medical/DrugList";
	}

}
