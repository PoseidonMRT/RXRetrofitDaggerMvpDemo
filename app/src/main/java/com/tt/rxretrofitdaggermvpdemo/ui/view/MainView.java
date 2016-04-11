package com.tt.rxretrofitdaggermvpdemo.ui.view;

import com.tt.rxretrofitdaggermvpdemo.domain.entity.WeatherResultBean;

/**
 * Created by tuozhaobing on 16-4-11.
 * Add Some Description There
 */
public interface MainView {
    void sucuess();
    void failure(Throwable t);
    void showWeatherInfor(WeatherResultBean weatherResultBeanResponse);
}
