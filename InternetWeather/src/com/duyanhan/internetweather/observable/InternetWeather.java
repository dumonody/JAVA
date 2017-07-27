package com.duyanhan.internetweather.observable;

public class InternetWeather {

	public static void main(String[] args) {

		CurrentConditions mCurrentConditions;
		ForcastConditions mForcastConditions;
		WeatherData mWeatherData;
		
		mWeatherData = new WeatherData();
		mCurrentConditions = new CurrentConditions();
		mForcastConditions = new ForcastConditions();
		
		// 将上面定义的两个观察者注册给气象站
		mWeatherData.addObserver(mCurrentConditions);
		mWeatherData.addObserver(mForcastConditions);
		
		
		// 气象站数据更新
		mWeatherData.setData(30, 101, 40);
		// 气象站移除当前天气公告板
		mWeatherData.deleteObserver(mCurrentConditions);;
		// 再次更新气象站数据
		mWeatherData.setData(40, 111, 50);
	}

}
