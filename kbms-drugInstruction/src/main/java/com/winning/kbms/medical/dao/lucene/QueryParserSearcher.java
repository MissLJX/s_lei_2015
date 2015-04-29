package com.winning.kbms.medical.dao.lucene;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.winning.kbms.medical.commons.LuceneDataSource;
import com.winning.kbms.medical.dao.Searcher;
import com.winning.kbms.medical.entity.LinstrFileInfo;
import com.winning.kbms.medical.utils.BeanUtils;

public class QueryParserSearcher implements Searcher<LinstrFileInfo> {

	private Analyzer analyzer = new IKAnalyzer();

	@Override
	public LinstrFileInfo searchById(String id) {
		return search("id", id, 1).get(0);
	}

	@Override
	public List<LinstrFileInfo> search(String field, String value) {
		return search(field, value, default_size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LinstrFileInfo> search(String field, String value, int hitSize) {
		IndexSearcher searcher = new IndexSearcher(LuceneDataSource.getDirectoryReader());
		QueryParser queryParser = new QueryParser(Version.LUCENE_45, field, analyzer);
		// queryParser.setDefaultOperator(Operator.AND);
		Query query;
		TopDocs topDocs = null;
		try {
			query = queryParser.parse(value);
			topDocs = searcher.search(query, hitSize);
			if (topDocs == null || topDocs.scoreDocs == null)
				return null;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (List<LinstrFileInfo>) BeanUtils.convertDocToListBean(LinstrFileInfo.class, topDocs,
				searcher);
	}

	public static void main(String[] args) {
		List<LinstrFileInfo> list = new QueryParserSearcher().search("productNameCn", "婴儿保肺", 10);
		System.out.println(list.size());
		for (LinstrFileInfo info : list) {
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
