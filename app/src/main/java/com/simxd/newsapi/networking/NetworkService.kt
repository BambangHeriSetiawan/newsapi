package com.simxd.newsapi.networking

import com.simxd.newsapi.networking.models.Article
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 25,October,2022
 */
interface NetworkService {
	@GET("top-headlines?pageSize=15&language=en")
	suspend fun headlines(
		@Query("q") keyword:String?,
		@Query("category") category:String?,
		@Query("page") page:Int?,
		
	):ApiResponse<List<Article>>
	
	@GET("everything?pageSize=15&language=en")
	suspend fun everything(
		@Query("q") keyword:String?,
		@Query("page") page:Int?,
		
		):ApiResponse<List<Article>>
}