package com.sl.service.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.sl.service.TxtFileIndexer;

public class TxtFileIndexerImpl implements TxtFileIndexer {

	@Override
	public void createIndexForTxt(File data, File indexDir) throws Exception {
		Analyzer analyzer = new IKAnalyzer();
		Document document = new Document();
		Reader reader = new FileReader(data);
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_45, analyzer);
		Directory directory = FSDirectory.open(indexDir);
		IndexWriter indexWriter = new IndexWriter(directory, config);
		document.add(new Field("path", data.getCanonicalPath(), TextField.TYPE_STORED));
		document.add(new Field("content", reader, TextField.TYPE_STORED));
		indexWriter.addDocument(document);
		indexWriter.commit();
	}

	@Override
	public void createIndexForDir(File dir, File indexDir) throws Exception {
		Analyzer analyzer = new IKAnalyzer();

		File[] datas = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return StringUtils.endsWith(pathname.getName(), ".txt");
			}
		});
		if (ArrayUtils.isEmpty(datas))
			return;
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_45, analyzer);
		Directory directory = FSDirectory.open(indexDir);
		IndexWriter indexWriter = new IndexWriter(directory, config);
		Reader reader;
		Document document;
		for (File data : datas) {
			document = new Document();
			reader = new FileReader(data);
			document.add(new Field("path", data.getCanonicalPath(), TextField.TYPE_STORED));
			document.add(new Field("content", reader, TextField.TYPE_NOT_STORED));
			indexWriter.addDocument(document);
		}
		indexWriter.commit();
	}

}
