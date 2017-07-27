package com.duyanhan.internetweather.observer;

/**
 * 实现了观察者接口的天气预报公告板
 * @author Pro.Du
 *
 */
public class ForcastConditions implements Observer{

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
		System.out.println("明天 温度 : " + (this.mTemperature + Math.random()));
		System.out.println("明天 气压 : " + (this.mPressure + 10*Math.random()));
		System.out.println("明天 湿度 : " + (this.mHumidity + Math.random()));
	}
}
