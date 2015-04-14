package com.sl.strategy;

/**
 * 鸭子<br/>
 * 鸭子特征：<br/>
 * 	飞行、叫、游泳、外形<br/>
 * 更具现实生活经验：鸭子的飞行方式、叫声、外形可能都不尽相同。
 * 但是一定是会游泳的（否则叫什么鸭子，别提旱鸭子这个败类）
 * @author s_lei
 *
 */
public abstract class Duck {
	
	/**
	 * 飞行
	 */
	private FlyBehavior fly;
	/**
	 * 叫唤
	 */
	private QuackBehavior quack;
	
	/**
	 * 飞行
	 */
	public void performFly(){
		fly.fly();
	}
	
	/**
	 * 叫唤
	 */
	public void performQuack(){
		quack.quack();
	}
	
	/**
	 * 游泳
	 */
	public void swim(){
		System.out.println("我会游泳，因为我是鸭子。");
	}
	
	/**
	 * 鸭子外形
	 */
	protected abstract void display();

	public void setFly(FlyBehavior fly) {
		this.fly = fly;
	}

	public void setQuack(QuackBehavior quack) {
		this.quack = quack;
	}
	
	
}
