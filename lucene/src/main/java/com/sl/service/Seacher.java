package com.sl.service;

import java.util.Map;

import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;

public interface Seacher {
	public TopDocs search(String field, Object value, Sort sort);

	public TopDocs search(String field, Object value, Sort sort, int hitSize);

	public TopDocs search(Map<String, Object> params, Sort sort);

	public TopDocs search(Map<String, Object> params, Sort sort, int hitSize);
}
