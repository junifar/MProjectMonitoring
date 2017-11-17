package com.prasetia.mprojectmonitoring.service

object SiteProvider{
    fun providerSite():Site{
        return  Site(SiteApiService.Factory.create())
    }
}
