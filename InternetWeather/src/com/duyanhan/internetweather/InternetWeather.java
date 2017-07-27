package com.duyanhan.internetweather;

public class InternetWeather {

	public static void main(String[] args) {

		CurrentConditions mCurrentConditions;
		WeatherData mWeatherData;
		
		mCurrentConditions = new CurrentConditions();
		// 气象站需要获取公告板的引用才能通知公告板有新的数据
		mWeatherData = new WeatherData(mCurrentConditions);
		
		
		// 气象站数据更新
		mWeatherData.setData(30, 101, 40);
	}

}
