package com.app.sample.sampleapp;

import android.app.Application;
import android.content.Context;

import com.app.sample.sampleapp.injection.component.ApplicationComponent;
import com.app.sample.sampleapp.injection.component.DaggerApplicationComponent;
import com.app.sample.sampleapp.injection.module.ApplicationModule;

/**
 * Created by thibaud.bourgeois on 11/11/2015.
 * Sample application
 */
public class SampleApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static SampleApplication get(Context context) {
        return (SampleApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

}
