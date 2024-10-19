package com.example.waayu.data.repository


import com.example.waayu.data.data_models.login.response.HomeResponse
import com.example.waayu.network.APIInterface
import java.util.Date

class RepositoryImpl(
    private val apiInterface: APIInterface
) : Repository {
    override suspend fun getHomeData(): HomeResponse {
        return apiInterface.userLogin()
    }



}