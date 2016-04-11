package com.tt.rxretrofitdaggermvpdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tt.rxretrofitdaggermvpdemo.R;
import com.tt.rxretrofitdaggermvpdemo.app.RXRetrofitApplication;
import com.tt.rxretrofitdaggermvpdemo.di.component.AppComponent;
import com.tt.rxretrofitdaggermvpdemo.di.component.DaggerMainActivityComponent;
import com.tt.rxretrofitdaggermvpdemo.di.modules.MainActivityModule;
import com.tt.rxretrofitdaggermvpdemo.domain.entity.WeatherResultBean;
import com.tt.rxretrofitdaggermvpdemo.ui.presenter.MainViewPresenter;
import com.tt.rxretrofitdaggermvpdemo.ui.presenter.MainViewPresenterImpl;
import com.tt.rxretrofitdaggermvpdemo.ui.view.MainView;
import com.tt.rxretrofitdaggermvpdemo.utils.GlobalDefineValues;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    @Inject
    MainViewPresenter mainViewPresenter;

    @Bind(R.id.text)
    TextView mGetWeatherInforTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupComponent(((RXRetrofitApplication)getApplicationContext()).getAppComponent());
    }

    protected void setupComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void sucuess() {

    }

    @Override
    public void failure(Throwable t) {

    }

    @Override
    public void showWeatherInfor(WeatherResultBean weatherResultBeanResponse) {
        mGetWeatherInforTextView.setText(weatherResultBeanResponse.getRetData().getCity()+""+weatherResultBeanResponse.getRetData().getH_tmp());
        mGetWeatherInforTextView.invalidate();
    }

    @OnClick(R.id.text)
    public void onClick() {
        mainViewPresenter.load(GlobalDefineValues.baiduKey,"北京");
    }
}
