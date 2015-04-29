package com.sl.service;

import java.io.File;

/**
 * 
 * @author s_lei
 *文本索引生成器
 */
public interface TxtFileIndexer {
	/**
	 * 单个文件
	 * @param file
	 */
	public void createIndexForTxt(File file,File indexDir)  throws Exception;
	/**
	 * 单个目录下的文件
	 * @param dir
	 */
	public void createIndexForDir(File dir,File indexDir)  throws Exception;
}
