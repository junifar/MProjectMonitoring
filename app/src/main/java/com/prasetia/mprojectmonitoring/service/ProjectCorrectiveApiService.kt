package com.prasetia.mprojectmonitoring.service

import com.prasetia.mprojectmonitoring.pojo.ProjectCorrective
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by prasetia on 11/24/2017.
 */
interface ProjectCorrectiveApiService {
    @GET("/public/mprojectcorrective")
    fun getResultProjectCorrective(): Call<List<ProjectCorrective>>
}