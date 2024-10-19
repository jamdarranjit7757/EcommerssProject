package com.example.waayu.di

import com.example.waayu.data.repository.Repository
import com.example.waayu.data.repository.RepositoryImpl
import com.example.waayu.network.APIClient
import com.example.waayu.network.APIInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesAPIClient(): APIClient = APIClient

    @Provides
    @Singleton
    fun providesAPIInterface(apiClient: APIClient): APIInterface =
        apiClient.getClient()!!.create(APIInterface::class.java)

    @Provides
    @Singleton
    fun providesRepository(apiInterface: APIInterface): Repository = RepositoryImpl(apiInterface)

}