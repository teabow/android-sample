package com.app.sample.sampleapp.data.service;

import com.app.sample.sampleapp.data.service.movies.MoviesService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by thibaud.bourgeois on 10/11/2015.
 * Service builder
 */
public class ServiceFactory<T> {

    public T createServiceInterface(Class<T> serviceClass, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return  retrofit.create(serviceClass);
    }

}
