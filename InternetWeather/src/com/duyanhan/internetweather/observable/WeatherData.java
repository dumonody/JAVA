package com.duyanhan.internetweather.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * 继承了Observable类的气象站
 * @author Pro.Du
 *
 */
public class WeatherData extends Observable{

	private float mTemperature;	// 温度
	private float mPressure;	// 气压
	private float mHumidity;	// 湿度
	
	
	public WeatherData()
	{
		
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
		this.setChanged();	// 设置真的进行通知的bool变量   有时候不需要通知太频繁，所有调用这个方法前可以加上一些限制判断，当条件超过一定程度时，调用此方法。并真的进行通知
		this.notifyObservers(new Data(getmTemperatrue(), getmPressure(), getmHumidity()));
	}
	
	public void setData(float mTemperature, float mPressure, float mHumidity)
	{
		this.mTemperature = mTemperature;
		this.mPressure = mPressure;
		this.mHumidity = mHumidity;
		// 有信息更新了，则气象站要通知公告板有信息更新了
		dataChange();
	}
	
	
	public class Data{
		private float mTemperature;	// 温度
		private float mPressure;	// 气压
		private float mHumidity;	// 湿度
		public Data(float mTemperature, float mPressure, float mHumidity)
		{
			this.mTemperature = mTemperature;
			this.mPressure = mPressure;
			this.mHumidity = mHumidity;
		}
		public float getmTemperature() {
			return mTemperature;
		}
		public float getmPressure() {
			return mPressure;
		}
		public float getmHumidity() {
			return mHumidity;
		}
		
	}
}
