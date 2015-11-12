package com.app.sample.sampleapp.presenter;

import android.content.Context;

/**
 * Created by thibaud.bourgeois on 11/11/2015.
 * Presenter view.
 */
public interface PresenterView {

    void onPresenterInit();

    void onPresenterLoad();

    void onPresenterError();

}
