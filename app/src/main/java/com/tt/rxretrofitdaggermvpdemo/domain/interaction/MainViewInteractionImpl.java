package com.tt.rxretrofitdaggermvpdemo.domain.interaction;

import com.tt.rxretrofitdaggermvpdemo.domain.entity.WeatherResultBean;
import com.tt.rxretrofitdaggermvpdemo.domain.service.WeatherApiService;
import com.tt.rxretrofitdaggermvpdemo.ui.listener.OnQueryWeatherListener;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tuozhaobing on 16-4-12.
 * Add Some Description There
 */
public class MainViewInteractionImpl implements MainViewInteraction {

    public static final String TAG = "WeatherInteractorImpl";
    private final WeatherApiService api;

    @Inject
    public MainViewInteractionImpl(WeatherApiService myApi) {
        this.api = myApi;
    }

    @Override
    public void queryWeather(String apikey, String cityname, final OnQueryWeatherListener onQueryWeatherListener) {
        Observable<WeatherResultBean> observable = api.queryWeather(apikey,cityname);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherResultBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onQueryWeatherListener.onFailure(e);
                    }

                    @Override
                    public void onNext(WeatherResultBean daily) {
                        onQueryWeatherListener.onFinished(daily);
                    }
                });
    }
}
