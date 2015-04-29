package com.winning.kbms.medical.commons;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LuceneDataSource {
	private static Logger logger = LoggerFactory.getLogger(LuceneDataSource.class);
	
	private static Directory directory = null;
//	private static String  indexPath = System.getProperty("java.io.tmpdir")+File.separator+"luc_20150318093632";
	private static String  indexPath = "h:\\luc_20150318093632";
	static{
		try {
			if(directory == null){
				directory = FSDirectory.open(new File(indexPath));
			}
		} catch (IOException e) {
			logger.error("加载索引目录时错误===",e);
		}
	}
	
	public static Directory getDirectory(){
		return directory;
	}
}
