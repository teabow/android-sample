package com.app.sample.sampleapp.injection.component;

import com.app.sample.sampleapp.data.DataManager;
import com.app.sample.sampleapp.injection.module.DataManagerModule;
import com.app.sample.sampleapp.injection.scope.PerDataManager;

import dagger.Component;

/**
 * Created by thibaud.bourgeois on 11/11/2015.
 * Data manager component
 */
@PerDataManager
@Component(dependencies = ApplicationComponent.class, modules = DataManagerModule.class)
public interface DataManagerComponent {

    void inject(DataManager dataManager);

}
