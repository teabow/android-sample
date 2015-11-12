package com.app.sample.sampleapp.data;

import android.content.Context;

import com.app.sample.sampleapp.SampleApplication;
import com.app.sample.sampleapp.data.preferences.PreferencesHelper;
import com.app.sample.sampleapp.data.service.ServiceFactory;
import com.app.sample.sampleapp.data.service.movies.MoviesService;
import com.app.sample.sampleapp.injection.component.DaggerDataManagerComponent;
import com.app.sample.sampleapp.injection.module.DataManagerModule;
import com.squareup.otto.Bus;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by thibaud.bourgeois on 10/11/2015.
 * Data manager
 */
@Singleton
public class DataManager {

    @Inject
    protected PreferencesHelper preferencesHelper;

    @Inject
    protected MoviesService moviesService;

    public DataManager(Context context) {
        DaggerDataManagerComponent
                .builder()
                .applicationComponent(SampleApplication.get(context).getComponent())
                .dataManagerModule(new DataManagerModule(context))
                .build()
                .inject(this);
    }

    public MoviesService getMoviesService() {
        return this.moviesService;
    }

    public PreferencesHelper getPreferencesHelper() {
        return this.preferencesHelper;
    }
}
