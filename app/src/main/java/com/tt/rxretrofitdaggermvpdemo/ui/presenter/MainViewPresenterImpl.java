package com.tt.rxretrofitdaggermvpdemo.ui.presenter;

import com.tt.rxretrofitdaggermvpdemo.domain.entity.WeatherResultBean;
import com.tt.rxretrofitdaggermvpdemo.domain.interaction.MainViewInteraction;
import com.tt.rxretrofitdaggermvpdemo.ui.listener.OnQueryWeatherListener;
import com.tt.rxretrofitdaggermvpdemo.ui.view.MainView;

/**
 * Created by tuozhaobing on 16-4-11.
 * Add Some Description There
 */
public class MainViewPresenterImpl implements MainViewPresenter,OnQueryWeatherListener {
    private MainView mainView;
    private MainViewInteraction mainViewInteraction;

    @Override
    public void onFinished(WeatherResultBean weatherResultBeanResponse) {
        mainView.showWeatherInfor(weatherResultBeanResponse);
    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void load(String apikey, String strname) {
        mainViewInteraction.queryWeather(apikey,strname,this);
    }

    public MainViewPresenterImpl(MainView mainView, MainViewInteraction weatherInteractor) {
        this.mainView = mainView;
        this.mainViewInteraction = weatherInteractor;
    }
}
