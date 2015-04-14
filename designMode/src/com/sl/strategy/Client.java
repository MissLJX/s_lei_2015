package com.sl.strategy;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Duck yellowDuck = new YellowDuck();
		// 添加飞行策略
		yellowDuck.setFly(new YellowDuckFly());
		// 添加叫声策略
		yellowDuck.setQuack(new YellowDuckQuack());
		yellowDuck.display();
		yellowDuck.swim();
		yellowDuck.performFly();
		yellowDuck.performQuack();
	}

}
