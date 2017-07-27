package com.duyanhan.internetweather.observer;

/**
 * 实现了观察者接口的当前的公告板
 * @author Pro.Du
 *
 */
public class CurrentConditions implements Observer{

	private float mTemperature;
	private float mPressure;
	private float mHumidity;
	
	@Override
	public void update(float mTemperature, float mPressure, float mHumidity) {
		this.mTemperature = mTemperature;
		this.mPressure = mPressure;
		this.mHumidity = mHumidity;
		// 更新完了之后   直接显示
		display();
	}
	
	public void display()
	{
		System.out.println("Today mTemperature : " + this.mTemperature);
		System.out.println("Today mPressure : " + this.mPressure);
		System.out.println("Today mHumidity : " + this.mHumidity);
	}
}
