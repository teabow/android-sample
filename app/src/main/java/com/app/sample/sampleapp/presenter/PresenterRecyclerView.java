package com.app.sample.sampleapp.presenter;

import android.view.View;

import java.util.List;

import rx.Observable;

/**
 * Created by thibaud.bourgeois on 11/11/2015.
 * Presenter for recycler view.
 */
public interface PresenterRecyclerView<T> extends PresenterView {

    void onPresenterFinished(List<T> items);
}
