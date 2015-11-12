package com.app.sample.sampleapp.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.app.sample.sampleapp.R;
import com.app.sample.sampleapp.data.DataManager;
import com.app.sample.sampleapp.model.Repo;
import com.app.sample.sampleapp.presenter.PresenterRecyclerView;
import com.app.sample.sampleapp.presenter.RecyclerViewPresenter;
import com.app.sample.sampleapp.ui.BaseActivity;
import com.app.sample.sampleapp.ui.adapter.RepoItemHolder;
import com.app.sample.sampleapp.ui.view.dialog.DialogFactory;

import java.util.List;


import javax.inject.Inject;

import butterknife.Bind;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;
import uk.co.ribot.easyadapter.EasyRecyclerAdapter;

/**
 * Created by thibaud.bourgeois on 10/11/2015.
 * Main activity.
 */
public class MainActivity extends BaseActivity implements PresenterRecyclerView<Repo> {

    @Bind(R.id.recycler_repos)
    RecyclerView reposRecyclerView;

    @Bind(R.id.progress_indicator)
    ProgressBar progressBar;

    @Bind(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    DataManager dataManager;

    private boolean isRefreshing = false;

    private RecyclerViewPresenter presenter;

    private EasyRecyclerAdapter<Repo> recyclerAdapter;

    private CompositeSubscription subscriptions;

    @Override
    public int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean enableBinding() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        applicationComponent().inject(this);

        subscriptions = new CompositeSubscription();

        presenter = new RecyclerViewPresenter<Repo>(this, subscriptions) {
            @Override
            public Observable<List<Repo>> setObservable() {
                return dataManager.getMoviesService().getRepos("teabow");
            }
        };
        presenter.loadItems();
        dataManager.getPreferencesHelper().storeStringValue("user", "teabow");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriptions.unsubscribe();
    }

    @Override
    public void onPresenterInit() {
        reposRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new EasyRecyclerAdapter<>(reposRecyclerView.getContext(), RepoItemHolder.class);
        reposRecyclerView.setAdapter(recyclerAdapter);
        swipeRefreshLayout.setColorSchemeResources(R.color.primary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefreshing = true;
                presenter.loadItems();
            }
        });
    }

    @Override
    public void onPresenterLoad() {
        if (!isRefreshing) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPresenterFinished(List<Repo> items) {
        endLoading();
        recyclerAdapter.setItems(items);
    }

    @Override
    public void onPresenterError() {
        endLoading();
        DialogFactory.createSimpleErrorDialog(this).show();
    }

    private void endLoading() {
        isRefreshing = false;
        swipeRefreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
    }
}
