package com.app.sample.sampleapp.data;

import android.content.Context;

import com.app.sample.sampleapp.data.preferences.PreferencesHelper;
import com.app.sample.sampleapp.data.service.ServiceFactory;
import com.app.sample.sampleapp.data.service.movies.MoviesService;

/**
 * Created by thibaud.bourgeois on 10/11/2015.
 * Data manager
 */
public class DataManager {

    private PreferencesHelper preferencesHelper;

    private MoviesService moviesService;

    public DataManager(Context context) {
        this.preferencesHelper = new PreferencesHelper(context);
        this.moviesService = new ServiceFactory<MoviesService>()
                .createServiceInterface(MoviesService.class, MoviesService.BASE_URL);
    }

    public MoviesService getMoviesService() {
        return moviesService;
    }

    public PreferencesHelper getPreferencesHelper() {

        return preferencesHelper;
    }

}
