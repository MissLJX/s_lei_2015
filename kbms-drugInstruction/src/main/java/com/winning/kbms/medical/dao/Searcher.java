package com.winning.kbms.medical.dao;

import java.util.List;
import java.util.Map;


public interface Searcher<T> {
	
	public static final int default_size = 10;
	
	public T searchById(String id);
	public List<T> search(String field,String value);
	public List<T> search(String field,String value,int hitSize);
	public List<T> search(String field,String value,int offset,int length);
	
	public List<T> search(Map<String, String> params);
	public List<T> search(Map<String, String> params,int hitSize);
	public List<T> search(Map<String, String> params,int offset,int length);
}
