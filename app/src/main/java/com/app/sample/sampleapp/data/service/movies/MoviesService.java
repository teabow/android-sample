package com.app.sample.sampleapp.data.service.movies;

import com.app.sample.sampleapp.model.Repo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by thibaud.bourgeois on 10/11/2015.
 * Movies interface
 */
public interface MoviesService {

    String BASE_URL = "https://api.github.com";

    @GET("/users/{user}/repos")
    Observable<List<Repo>> getRepos(@Path("user") String user);

}
