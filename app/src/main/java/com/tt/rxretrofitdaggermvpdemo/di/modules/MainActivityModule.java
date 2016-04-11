package com.tt.rxretrofitdaggermvpdemo.di.modules;

import android.app.Activity;

import com.tt.rxretrofitdaggermvpdemo.di.ActivityScope;
import com.tt.rxretrofitdaggermvpdemo.domain.interaction.MainViewInteraction;
import com.tt.rxretrofitdaggermvpdemo.ui.presenter.MainViewPresenter;
import com.tt.rxretrofitdaggermvpdemo.ui.presenter.MainViewPresenterImpl;
import com.tt.rxretrofitdaggermvpdemo.ui.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tuozhaobing on 16-4-11.
 * Add Some Description There
 */
@Module
public class MainActivityModule {
    private MainView view;

    public MainActivityModule(MainView view) {
        this.view = view;
    }

    @Provides
    public MainView provideView() {
        return view;
    }

    @Provides
    public MainViewPresenter providePresenter(MainView mainView, MainViewInteraction mainViewInteraction) {
        return new MainViewPresenterImpl(mainView, mainViewInteraction);
    }
}
