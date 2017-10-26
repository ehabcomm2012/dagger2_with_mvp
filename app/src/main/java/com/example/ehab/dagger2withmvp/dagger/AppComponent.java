package com.example.ehab.dagger2withmvp.dagger;

import com.example.ehab.dagger2withmvp.activities.mainActivity.MainActivity;
import com.example.ehab.dagger2withmvp.activities.mainActivity.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ehab on 10/26/17.
 */
@Singleton
@Component(modules = {AppModule.class, MainActivityPresenterModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(MainActivityPresenter presenter);

}
