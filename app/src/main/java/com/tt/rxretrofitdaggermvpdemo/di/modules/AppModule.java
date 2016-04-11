package com.tt.rxretrofitdaggermvpdemo.di.modules;

import android.content.Context;

import com.tt.rxretrofitdaggermvpdemo.app.RXRetrofitApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tuozhaobing on 16-4-11.
 * Add Some Description There
 */
@Module
public class AppModule {
    private final RXRetrofitApplication application;

    public AppModule(RXRetrofitApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }
}
