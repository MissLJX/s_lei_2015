package com.sl.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气数据
 * @author s_lei
 *
 */
public class WeatherData implements ISubject {
	
	/**
	 * 温度
	 */
	private double temperature;
	
	private List<IObserver> observers = new ArrayList<IObserver>();
	

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
		//通知观察者天气发生变化
		notifyObservers();
	}

	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		if(observers == null || observers.size() < 1)
			return;
		for(IObserver ob:observers){
			if(ob.equals(observer))
				observers.remove(observer);
			return;
		}
	}

	@Override
	public void notifyObservers() {
		for(IObserver ob:observers){
			ob.update(temperature);
		}
	}

}
