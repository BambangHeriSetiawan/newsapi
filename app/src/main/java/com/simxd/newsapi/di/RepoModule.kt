package com.simxd.newsapi.di

import com.simxd.newsapi.data.MainRepo
import com.simxd.newsapi.networking.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 */
@Module
@InstallIn(ViewModelComponent::class)
object RepoModule {
	@Provides
	@ViewModelScoped
	fun providerMainRepo(
		networkService: NetworkService
	): MainRepo {
		return MainRepo(networkService = networkService)
	}
}