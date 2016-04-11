package com.tt.rxretrofitdaggermvpdemo.domain.interaction;

import com.tt.rxretrofitdaggermvpdemo.ui.listener.OnQueryWeatherListener;

/**
 * Created by tuozhaobing on 16-4-12.
 * Add Some Description There
 */
public interface MainViewInteraction {
    void queryWeather(String apikey,String cityname,OnQueryWeatherListener onQueryWeatherListener);
}
