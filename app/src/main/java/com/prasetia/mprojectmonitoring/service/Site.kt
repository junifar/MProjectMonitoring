package com.prasetia.mprojectmonitoring.service

import com.prasetia.mprojectmonitoring.pojo.SiteResult
import io.reactivex.Observable

/**
 * Created by prasetia on 11/17/2017.
 */
class Site(val siteApiService: SiteApiService){
    fun searchSite(): Observable<SiteResult> = siteApiService.getResultSite()
}