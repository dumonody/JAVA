package com.duyanhan.internetweather;

/**
 * 气象站
 * @author Pro.Du
 *
 */
public class WeatherData {

	private float mTemperature;	// 温度
	private float mPressure;	// 气压
	private float mHumidity;	// 湿度
	// 公告板的引用
	private CurrentConditions mCurrentConditions;	// 公告板
	
	
	public WeatherData(CurrentConditions mCurrentConditions)
	{
		this.mCurrentConditions = mCurrentConditions;
	}
	public float getmTemperatrue() {
		return mTemperature;
	}
	public float getmPressure() {
		return mPressure;
	}
	public float getmHumidity() {
		return mHumidity;
	}
	public void dataChange()
	{
		mCurrentConditions.update(getmTemperatrue(), getmPressure(), getmHumidity());
	}
	
	public void setData(float mTemperature, float mPressure, float mHumidity)
	{
		this.mTemperature = mTemperature;
		this.mPressure = mPressure;
		this.mHumidity = mHumidity;
		// 有信息更新了，则气象站要通知公告板有信息更新了
		dataChange();
	}
}
