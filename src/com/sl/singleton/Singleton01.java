package com.sl.singleton;

/**
 * ÀÁººÄ£Ê½
 * 
 * @author s_lei
 * 
 */
public class Singleton01 {
	private Singleton01() {
	}

	private static Singleton01 instance = null;

	public static Singleton01 getInstance() {
		if (instance == null) {
			instance = new Singleton01();
		}
		return instance;
	}
}
