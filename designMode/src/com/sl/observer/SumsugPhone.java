package com.sl.observer;

import java.util.Date;

/**
 * 三星手机
 * 显示天气
 * @author s_lei
 *
 */
public class SumsugPhone implements IDisplayer, IObserver {
	
	private double temperature;

	@Override
	public void update(double temperature) {
		System.out.println("更新前天气："+this.temperature +"C；更新后温度为："+temperature+"C");
		this.temperature = temperature;
	}

	@Override
	public void display() {
		System.out.println("当前时间："+new Date()+"；温度为："+temperature+"C");
	}



}
