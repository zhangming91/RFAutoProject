package com.bankhui.comm;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.log4j.Logger;

/**
 * 文件操作工具类
 * 
 * @author liuyang
 * @time 2017年7月17日下午3:43:36
 * 
 */
public class FileUtil {

	private static Logger log = Logger.getLogger(FileUtil.class);
	
	/**
	*  文件写入
	* @author liuyang
	* @time 2017年7月17日下午3:45:42
	* @param content 内容
	*/ 
	public static void write(String content) {
		String path = StaticResource.getFilePath() + "/test/" ;
		String fileName = "h5-test.txt" ;
		try {
			File file = new File(path);
			if(!file.exists()){
				file.mkdir();
				log.info("make new dir success---->" + path);
			}
			path = path + fileName;
			file = new File(path);
			if(!file.exists()){
				file.createNewFile();
				log.info("create new file success---->" + path);
			}
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(path, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(content + "\r\n");
			randomFile.close();
		} catch (IOException e) {
			log.error("file write error ", e);
		}
	}
}
