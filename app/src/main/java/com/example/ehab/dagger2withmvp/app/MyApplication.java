package com.example.ehab.dagger2withmvp.app;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.ehab.dagger2withmvp.activities.mainActivity.MainActivityPresenter;
import com.example.ehab.dagger2withmvp.activities.mainActivity.MainActivityView;
import com.example.ehab.dagger2withmvp.dagger.AppComponent;
import com.example.ehab.dagger2withmvp.dagger.AppModule;
import com.example.ehab.dagger2withmvp.dagger.DaggerAppComponent;
import com.example.ehab.dagger2withmvp.dagger.MainActivityPresenterModule;
import com.example.ehab.dagger2withmvp.dagger.NetworkModule;

/**
 * Created by ehab on 10/26/17.
 */

public class MyApplication extends MultiDexApplication{
    private AppComponent appComponent;

    public void onCreate() {
        super.onCreate();
       // appComponent = initDagger(this);
    }
    protected AppComponent initDagger(MyApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .networkModule(new NetworkModule())
                .build();
    }
    public AppComponent getDaggerMainComponent(Context context , MainActivityView view) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .mainActivityPresenterModule(new MainActivityPresenterModule(context,view))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
