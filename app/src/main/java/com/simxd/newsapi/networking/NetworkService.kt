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
	@GET("top-headlines")
	suspend fun headlines(
		@Query("q") keyword:String?,
		@Query("page") page:Int?,
		@Query("pageSize") pageSize:Int?,
		
	):ApiResponse<List<Article>>
	
	@GET("everything")
	suspend fun everything(
		@Query("q") keyword:String?,
		@Query("page") page:Int?,
		@Query("pageSize") pageSize:Int?,
		
		):ApiResponse<List<Article>>
}