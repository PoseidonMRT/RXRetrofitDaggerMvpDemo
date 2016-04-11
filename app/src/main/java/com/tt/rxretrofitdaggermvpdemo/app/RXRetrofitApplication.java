package com.tt.rxretrofitdaggermvpdemo.app;

import android.app.Application;
import android.content.Context;

import com.tt.rxretrofitdaggermvpdemo.di.component.AppComponent;
import com.tt.rxretrofitdaggermvpdemo.di.component.DaggerAppComponent;
import com.tt.rxretrofitdaggermvpdemo.di.modules.AppModule;

/**
 * Created by tuozhaobing on 16-4-11.
 * Add Some Description There
 */
public class RXRetrofitApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.inject(this);

    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public static RXRetrofitApplication getApplication(Context context) {
        return (RXRetrofitApplication) context.getApplicationContext();
    }
}
