package com.example.waayu.data.repository


import com.example.waayu.data.data_models.login.response.HomeResponse
import java.util.Date

interface Repository {

    suspend fun getHomeData(): HomeResponse


}