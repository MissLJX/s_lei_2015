package com.sl.strategy01;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//策略模式
		Context context = new Context();
		context.setCaculator(new Add());
		System.out.println("20+5="+context.exec(20, 5));
		context.setCaculator(new Sub());
		System.out.println("20-5="+context.exec(20, 5));
		//策略枚举
		System.out.println("================");
		System.out.println("20+5="+EumnCaculator.ADD.exec(20, 5));
		System.out.println("20-5="+EumnCaculator.SUB.exec(20, 5));
	}

}
