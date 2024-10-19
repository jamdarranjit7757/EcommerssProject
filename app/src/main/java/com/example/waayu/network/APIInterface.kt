package com.example.waayu.network


import com.example.waayu.data.data_models.login.response.HomeResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.Date

interface APIInterface {

    @POST("home.php")
    suspend fun userLogin(): HomeResponse

}