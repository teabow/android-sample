package com.app.sample.sampleapp.presenter;

import android.util.Log;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by thibaud.bourgeois on 11/11/2015.
 * List presenter.
 */
public abstract class RecyclerViewPresenter<T> {

    protected PresenterRecyclerView view;

    protected CompositeSubscription subscriptions;

    public RecyclerViewPresenter(PresenterRecyclerView view, CompositeSubscription subscriptions) {
        this.subscriptions = subscriptions;
        this.view = view;
        this.view.onPresenterInit();
    }

    public abstract Observable<List<T>> setObservable();

    @SuppressWarnings("unchecked")
    public void loadItems() {

        view.onPresenterLoad();

        subscriptions.add(setObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<T>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(getClass().getCanonicalName(), "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        view.onPresenterError();
                    }

                    @Override
                    public void onNext(List<T> items) {
                        view.onPresenterFinished(items);
                    }
                }));
    }

}
