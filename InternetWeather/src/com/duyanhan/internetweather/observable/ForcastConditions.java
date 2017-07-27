package com.duyanhan.internetweather.observable;

import java.util.Observable;
import java.util.Observer;

import com.duyanhan.internetweather.observable.WeatherData.Data;

/**
 * 实现了Java内置的观察者接口的天气预报公告板
 * @author Pro.Du
 *
 */
public class ForcastConditions implements Observer{

	private float mTemperature;
	private float mPressure;
	private float mHumidity;
	
	@Override
	public void update(Observable o, Object arg) {
		this.mTemperature = ((Data)(arg)).getmTemperature();
		this.mPressure = ((Data)(arg)).getmPressure();
		this.mHumidity = ((Data)(arg)).getmHumidity();
		display();
	}
	
	public void display()
	{
		System.out.println("明天 温度 : " + (this.mTemperature + Math.random()));
		System.out.println("明天 气压 : " + (this.mPressure + 10*Math.random()));
		System.out.println("明天 湿度 : " + (this.mHumidity + Math.random()));
	}
}
