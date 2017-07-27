package com.duyanhan.internetweather.observable;

import java.util.Observable;
import java.util.Observer;

import com.duyanhan.internetweather.observable.WeatherData.Data;

/**
 * 实现了Java内置的观察者接口的当前的公告板
 * @author Pro.Du
 *
 */
public class CurrentConditions implements Observer{

	private float mTemperature;
	private float mPressure;
	private float mHumidity;
	
	public void display()
	{
		System.out.println("Today mTemperature : " + this.mTemperature);
		System.out.println("Today mPressure : " + this.mPressure);
		System.out.println("Today mHumidity : " + this.mHumidity);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.mTemperature = ((Data)(arg)).getmTemperature();
		this.mPressure = ((Data)(arg)).getmPressure();
		this.mHumidity = ((Data)(arg)).getmHumidity();
		display();
	}
}
