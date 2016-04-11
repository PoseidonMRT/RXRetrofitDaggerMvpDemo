package com.tt.rxretrofitdaggermvpdemo.di.component;

import com.tt.rxretrofitdaggermvpdemo.app.RXRetrofitApplication;
import com.tt.rxretrofitdaggermvpdemo.di.modules.AppModule;
import com.tt.rxretrofitdaggermvpdemo.di.modules.InteractorModule;
import com.tt.rxretrofitdaggermvpdemo.domain.interaction.MainViewInteraction;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tuozhaobing on 16-4-11.
 * Add Some Description There
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                InteractorModule.class,
        }
)
public interface AppComponent {
    RXRetrofitApplication inject(RXRetrofitApplication rxRetrofitApplication);
    MainViewInteraction getWeatherInteractor();
}
