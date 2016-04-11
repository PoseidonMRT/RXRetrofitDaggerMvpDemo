package com.tt.rxretrofitdaggermvpdemo.di.component;

import android.app.Activity;

import com.tt.rxretrofitdaggermvpdemo.ui.activity.MainActivity;
import com.tt.rxretrofitdaggermvpdemo.di.ActivityScope;
import com.tt.rxretrofitdaggermvpdemo.di.modules.MainActivityModule;
import com.tt.rxretrofitdaggermvpdemo.ui.presenter.MainViewPresenter;

import dagger.Component;

/**
 * Created by tuozhaobing on 16-4-11.
 * Add Some Description There
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
    MainViewPresenter getMainPresenter();
}

