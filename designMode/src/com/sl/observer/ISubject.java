package com.sl.observer;

/**
 * 被观察者
 * @author s_lei
 *
 */
public interface ISubject {
	/**
	 * 注册观察者
	 */
	public void registerObserver(IObserver observer);
	/**
	 * 移除观察者
	 * @param observer
	 */
	public void removeObserver(IObserver observer);
	/**
	 * 提醒观察者
	 */
	public void notifyObservers();
}
