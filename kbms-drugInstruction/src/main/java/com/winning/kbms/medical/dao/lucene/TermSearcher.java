package com.winning.kbms.medical.dao.lucene;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;

import com.winning.kbms.medical.commons.LuceneDataSource;
import com.winning.kbms.medical.dao.Searcher;
import com.winning.kbms.medical.entity.LinstrFileInfo;
import com.winning.kbms.medical.utils.BeanUtils;

public class TermSearcher implements Searcher<LinstrFileInfo> {
	

	@Override
	public LinstrFileInfo searchById(String id) {
		List<LinstrFileInfo> list = search("id", id);
		return CollectionUtils.isEmpty(list)?null:list.get(0);
	}

	@Override
	public List<LinstrFileInfo> search(String field, String value) {
		return search(field, value, default_size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LinstrFileInfo> search(String field, String value, int hitSize) {
		Directory directory = LuceneDataSource.getDirectory();
		Term term = new Term(field,value);
		Query query = new TermQuery(term);
		IndexReader reader;
		IndexSearcher searcher;
		TopDocs topDocs;
		List<LinstrFileInfo> list = null;
		try {
			reader = DirectoryReader.open(directory);
			searcher = new IndexSearcher(reader);
			topDocs=searcher.search(query, hitSize);
			list = (List<LinstrFileInfo>) BeanUtils.convertDocToListBean(LinstrFileInfo.class, topDocs, searcher);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args){
		List<LinstrFileInfo> list = new TermSearcher().search("productNameCn", "抗病毒", 10);
		System.out.println(list.size());
		for(LinstrFileInfo info:list){
			System.out.println(info.getProductNameCn());
		}
	}

	@Override
	public List<LinstrFileInfo> search(String field, String value, int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LinstrFileInfo> search(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LinstrFileInfo> search(Map<String, String> params, int hitSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LinstrFileInfo> search(Map<String, String> params, int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

}
