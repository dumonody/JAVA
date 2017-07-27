package com.duyanhan.internetweather;

/**
 * 当前的公告板
 * @author Pro.Du
 *
 */
public class CurrentConditions {

	// 下面三个成员是属于公告板自己的成员变量
	private float mTemperature;
	private float mPressure;
	private float mHumidity;
	
	public void update(float mTemperature, float mPressure, float mHumidity)
	{
		this.mTemperature = mTemperature;
		this.mPressure = mPressure;
		this.mHumidity = mHumidity;
		// 更新了之后直接显示
		display();
	}
	
	public void display()
	{
		System.out.println("Today mTemperature : " + this.mTemperature);
		System.out.println("Today mPressure : " + this.mPressure);
		System.out.println("Today mHumidity : " + this.mHumidity);
	}
}
