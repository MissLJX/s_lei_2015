package com.sl.strategy01;

/**
 * 策略枚举
 * 
 * @author s_lei
 * 
 */
public enum EumnCaculator {
	ADD("+") {
		@Override
		protected int exec(int a, int b) {
			return a + b;
		}
	},
	SUB("-") {
		@Override
		protected int exec(int a, int b) {
			return a - b;
		}
	};
	private String value;

	private EumnCaculator(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	protected abstract int exec(int a, int b);
}
