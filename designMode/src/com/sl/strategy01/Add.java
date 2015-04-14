package com.sl.strategy01;
/**
 * 加法
 * @author s_lei
 *
 */
public class Add implements Caculator {

	@Override
	public int exec(int a, int b) {
		return a+b;
	}

}
