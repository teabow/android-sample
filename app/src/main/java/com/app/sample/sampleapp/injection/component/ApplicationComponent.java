package com.app.sample.sampleapp.injection.component;

import android.app.Application;

import com.app.sample.sampleapp.data.DataManager;
import com.app.sample.sampleapp.injection.module.ApplicationModule;
import com.app.sample.sampleapp.ui.activity.MainActivity;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by thibaud.bourgeois on 11/11/2015.
 * Application component
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity activity);

    Application application();
    Bus bus();
    DataManager dataManager();

}
