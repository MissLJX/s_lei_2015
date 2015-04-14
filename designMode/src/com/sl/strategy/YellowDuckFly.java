package com.sl.strategy;

public class YellowDuckFly implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("我只能飞2米远.");
	}

}
