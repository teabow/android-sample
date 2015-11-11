package com.app.sample.sampleapp.injection.module;

import android.app.Application;

import com.app.sample.sampleapp.data.DataManager;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by thibaud.bourgeois on 11/11/2015.
 * Application module
 */
@Module
public class ApplicationModule {

    protected final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    public DataManager providesDataManager() {
        return new DataManager(application);
    }

    @Provides
    @Singleton
    public Bus providesEventBus() {
        return new Bus();
    }

}
