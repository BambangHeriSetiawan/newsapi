package com.simxd.newsapi.di

import android.content.Context
import android.graphics.ImageDecoder
import android.os.Build
import android.view.ContextMenu
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.simxd.newsapi.networking.NetworkService
import com.simxd.newsapi.networking.RequestInterceptor
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 25,October,2022
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
	@Provides
	@Singleton
	fun  provideOkHttpClient():OkHttpClient{
		return OkHttpClient.Builder()
			.addInterceptor(RequestInterceptor())
			.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
			.build()
	}
	@Provides
	@Singleton
	fun provideImageLoader(
		@ApplicationContext context: Context,
		okHttpClient: OkHttpClient
	): ImageLoader {
		return ImageLoader.Builder(context)
			.okHttpClient(okHttpClient = okHttpClient)
			.components {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) add(ImageDecoderDecoder.Factory())
				else add(GifDecoder.Factory())
			}
			.build()
	}
	@Provides
	@Singleton
	fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.client(okHttpClient)
			.baseUrl("https://newsapi.org/v2/")
			.addConverterFactory(GsonConverterFactory.create())
			.addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
			.build()
	}
	
	@Provides
	@Singleton
	fun provideNetworkService(retrofit: Retrofit): NetworkService {
		return retrofit.create(NetworkService::class.java)
	}
}