package com.winning.kbms.medical.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanUtils {
	
	private static Logger logger = LoggerFactory.getLogger(BeanUtils.class);
	
	public static Object convertDocToBean(Class<?> clazz, Document document) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			Object value;
			for (Field field : fields) {
				field.setAccessible(true);
				value = document.get(field.getName());
				if (value == null)
					continue;
				field.set(obj, value);
			}
		} catch (Exception e) {
		}
		return obj;
	}
	
	@SuppressWarnings("rawtypes")
	public static List<?> convertDocToListBean(Class<?> clazz,TopDocs topDocs,IndexSearcher searcher) {
		List list = new ArrayList();
		ScoreDoc[] docs = topDocs.scoreDocs;
		Document document;
		try {
			Object object;
			for(ScoreDoc doc:docs){
				document = searcher.doc(doc.doc);
				object = convertDocToBean(clazz, document);
				if(object!=null){
					list.add(object);
				}
			}
		} catch (Exception e) {
			logger.error("convertDocToListBean has a error",e);
		}
		return list;
	}
	
}
