package com.sl.client;

import java.util.List;

import com.sl.service.TxtFileSearcher;
import com.sl.service.impl.TxtFileSearcherImpl;

public class Searcher {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		TxtFileSearcher searcher = new TxtFileSearcherImpl();
		List<String> list=(List<String>) searcher.search("content", "搜索");
		if(list == null)
			return;
		for(String s:list){
			System.out.println(s);
		}
	}

}
