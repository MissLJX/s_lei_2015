package com.sl.observer;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//观察者 天气订阅者-三星手机
		IObserver sumsug = new SumsugPhone();
		//天气数据
		WeatherData weatherData = new WeatherData();
		//三星手机订阅天气
		weatherData.registerObserver(sumsug);
		weatherData.setTemperature(20);
		try {
			Thread.sleep(2000);
			weatherData.setTemperature(25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
