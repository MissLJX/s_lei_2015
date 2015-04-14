package com.sl.strategy01;
/**
 * 上下文  策略的封装者
 * @author s_lei
 *
 */
public class Context {
	private Caculator caculator;

	public void setCaculator(Caculator caculator) {
		this.caculator = caculator;
	}

	public int exec(int a, int b) {
		return this.caculator.exec(a, b);
	}
}
