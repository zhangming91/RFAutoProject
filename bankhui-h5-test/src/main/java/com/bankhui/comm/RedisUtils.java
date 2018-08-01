package com.bankhui.comm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

/**
* redis 操作
* @author liuyang
* @time 2017年6月29日下午3:35:47
*       
*/ 
public class RedisUtils {

	private static Logger log = Logger.getLogger(RedisUtils.class);

	private static Jedis jedis;
	private static String host ;
	private static int port;
	private static String password;

	static {
		Properties pps = new Properties();
		try {
			InputStream in = RedisUtils.class.getClassLoader().getResourceAsStream("application.properties");
			pps.load(in);
			host = pps.getProperty("redis.host");
			port = Integer.valueOf(pps.getProperty("redis.port"));
			password = pps.getProperty("redis.password");
			jedis = new Jedis(host, port);
			// 权限认证
			jedis.auth(password);
		} catch (IOException e) {
			log.error("未获取到application配置文件" + e);
			e.printStackTrace();
		}
	}
	
	
	public static String get(String key){
		String value = jedis.get(key);
		if(null != value){
			value = value.replace("\"", "").replace("\"", "");
		}
		return value;
	}
	
//	public static void main(String[] args) {
//		jedis.set("abs", "css");
//		System.out.println(get("abs"));
//	}
}
