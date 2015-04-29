package com.sl.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.sl.service.TxtFileSearcher;

public class TxtFileSearcherImpl implements TxtFileSearcher {

	@Override
	public List<String> search(String field,String value) throws Exception {
		Directory directory = FSDirectory.open(new File("H:\\lucene\\luceneIndex"));
		IndexReader reader = DirectoryReader.open(directory);
		IndexSearcher searcher = new IndexSearcher(reader);
		Term term = new Term(field, value);
		Query query = new TermQuery(term);
		TopDocs docs = searcher.search(query, 10);
		ScoreDoc[] hits = docs.scoreDocs;
		Document document;
		List<String> result = new ArrayList<String>();
		for(ScoreDoc doc : hits){
			document = searcher.doc(doc.doc);
			result.add(document.get("path")+"         "+document.get("content"));
		}
		return result;
	}

}
