package com.sl.singleton;

/**
 * 单例模式-懒汉模式
 * 
 * @author s_lei
 * 
 */
public class Singleton01 {
	private Singleton01() {
	}

	private static Singleton01 instance = null;

	public static Singleton01 getInstance() {
		//判断instance是否为空
		//当instance为空时实例化一个对象，确保系统有且只有一个该类的实例
		if (instance == null) {
			instance = new Singleton01();
		}
		return instance;
	}
}
