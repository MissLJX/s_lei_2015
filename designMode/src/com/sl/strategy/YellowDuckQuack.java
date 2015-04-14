package com.sl.strategy;

public class YellowDuckQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("我的叫声:呱呱呱");
	}

}
