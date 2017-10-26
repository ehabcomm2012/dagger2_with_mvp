package com.example.ehab.dagger2withmvp.dagger;

import android.app.Application;
import android.content.Context;

import com.example.ehab.dagger2withmvp.app.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ehab on 10/26/17.
 */
@Module
public class AppModule {
    private MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}
