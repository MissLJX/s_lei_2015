package com.sl.client;

import java.io.File;

import com.sl.service.TxtFileIndexer;
import com.sl.service.impl.TxtFileIndexerImpl;

public class Indexer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File datas = new File("H:\\lucene\\luceneData");
		File dir = new File("H:\\lucene\\luceneIndex");
		TxtFileIndexer txtFileIndexer = new TxtFileIndexerImpl();
		txtFileIndexer.createIndexForDir(datas, dir);
	}

}
