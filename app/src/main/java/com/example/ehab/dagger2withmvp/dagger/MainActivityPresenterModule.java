package com.example.ehab.dagger2withmvp.dagger;

import android.content.Context;

import com.example.ehab.dagger2withmvp.activities.mainActivity.MainActivity;
import com.example.ehab.dagger2withmvp.activities.mainActivity.MainActivityPresenter;
import com.example.ehab.dagger2withmvp.activities.mainActivity.MainActivityView;
import com.example.ehab.dagger2withmvp.app.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ehab on 10/26/17.
 */
@Module
public class MainActivityPresenterModule {
    private Context context;
    private MainActivityView mainActivityView ;

    public MainActivityPresenterModule(Context context,MainActivityView mainActivityView) {
        this.context=context;
        this.mainActivityView = mainActivityView;
    }


    @Provides
    @Singleton
    MainActivityPresenter provideFoodzPresenter() {
        return new MainActivityPresenter(context,  mainActivityView);
    }


}
