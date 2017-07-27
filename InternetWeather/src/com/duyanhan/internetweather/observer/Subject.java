package com.duyanhan.internetweather.observer;

/**
 * 被多个观察者所依赖的Subject接口
 * @author Pro.Du
 *
 */
public interface Subject {

	/**
	 * 注册观察者
	 * @param o
	 */
	public void registerObserver(Observer o);
	
	/**
	 * 移除观察者
	 * @param o
	 */
	public void removeObserver(Observer o);
	
	/**
	 * 通知观察者
	 * @param o
	 */
	public void notifyObservers();
}
