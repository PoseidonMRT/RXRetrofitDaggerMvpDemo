package com.tt.rxretrofitdaggermvpdemo.di.modules;

import com.tt.rxretrofitdaggermvpdemo.domain.RestApiAdapter;
import com.tt.rxretrofitdaggermvpdemo.domain.interaction.MainViewInteraction;
import com.tt.rxretrofitdaggermvpdemo.domain.interaction.MainViewInteractionImpl;
import com.tt.rxretrofitdaggermvpdemo.domain.service.WeatherApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Module类
 * 提供需要注入的类
 *
 * @author finddreams
 * @address http://blog.csdn.net/finddreams
 */
@Module
public class InteractorModule {

    @Provides
    public Retrofit provideRestAdapter() {
        return RestApiAdapter.getInstance();
    }

    @Provides
    public WeatherApiService provideHomeApi(Retrofit restAdapter) {
        return restAdapter.create(WeatherApiService.class);
    }

    @Provides
    public MainViewInteraction provideHomeInteractor(WeatherApiService myApi) {
        return new MainViewInteractionImpl(myApi);
    }
}
