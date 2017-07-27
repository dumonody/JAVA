package com.duyanhan.internetweather.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现了Subject接口的气象站
 * @author Pro.Du
 *
 */
public class WeatherData implements Subject{

	private float mTemperature;	// 温度
	private float mPressure;	// 气压
	private float mHumidity;	// 湿度
	
	private List<Observer> mObservers;	// 观察者对象集合
	
	public WeatherData()
	{
		mObservers = new ArrayList<Observer>();
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
		this.notifyObservers();
	}
	
	public void setData(float mTemperature, float mPressure, float mHumidity)
	{
		this.mTemperature = mTemperature;
		this.mPressure = mPressure;
		this.mHumidity = mHumidity;
		// 有信息更新了，则气象站要通知公告板有信息更新了
		dataChange();
	}
	@Override
	public void registerObserver(Observer o) {
		mObservers.add(o);		
	}
	@Override
	public void removeObserver(Observer o) {
		if(mObservers.contains(o)) 
		{
			mObservers.remove(o);
		}
	}
	@Override
	public void notifyObservers() {
		for(int i = 0, len = mObservers.size(); i < len; i++)
		{
			mObservers.get(i).update(getmTemperatrue(), getmPressure(), getmHumidity());
		}
	}
}
