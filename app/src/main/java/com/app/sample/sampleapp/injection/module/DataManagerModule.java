package com.app.sample.sampleapp.injection.module;

import android.content.Context;

import com.app.sample.sampleapp.data.preferences.PreferencesHelper;
import com.app.sample.sampleapp.data.service.ServiceFactory;
import com.app.sample.sampleapp.data.service.movies.MoviesService;
import com.app.sample.sampleapp.injection.scope.PerDataManager;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by thibaud.bourgeois on 11/11/2015.
 * Data manager module
 */
@Module
public class DataManagerModule {

    private final Context context;

    public DataManagerModule(Context context) {
        this.context = context;
    }

    @Provides
    @PerDataManager
    public PreferencesHelper providesPreferencesHelper() {
        return new PreferencesHelper(context);
    }

    @Provides
    @PerDataManager
    public MoviesService providesMoviesService() {
        return new ServiceFactory<MoviesService>()
                .createServiceInterface(MoviesService.class, MoviesService.BASE_URL);
    }

}
