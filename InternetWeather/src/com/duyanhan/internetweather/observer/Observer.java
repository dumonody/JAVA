package com.duyanhan.internetweather.observer;

/**
 * 观察者接口
 * @author Pro.Du
 *
 */
public interface Observer {

	public void update(float mTemperature, float mPressure, float mHumidity);
}
