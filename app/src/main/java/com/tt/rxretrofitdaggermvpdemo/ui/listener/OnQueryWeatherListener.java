package com.tt.rxretrofitdaggermvpdemo.ui.listener;


import com.tt.rxretrofitdaggermvpdemo.domain.entity.WeatherResultBean;

/**
 * Created by tuozhaobing on 16-4-10.
 * Add Some Description There
 */
public interface OnQueryWeatherListener {
    void onFinished(WeatherResultBean weatherResultBeanResponse);
    void onFailure(Throwable t);
}