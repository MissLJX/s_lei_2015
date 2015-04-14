package com.sl.strategy01;
/**
 * 减法
 * @author s_lei
 *
 */
public class Sub implements Caculator {

	@Override
	public int exec(int a, int b) {
		return a-b;
	}

}
