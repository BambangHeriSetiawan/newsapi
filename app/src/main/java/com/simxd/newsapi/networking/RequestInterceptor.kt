package com.simxd.newsapi.networking

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 25,October,2022
 */
class RequestInterceptor:Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val origin =   chain.request()
		
		val req = origin.newBuilder()
			.addHeader("X-Api-Key","fa009378af4140068bc3a65999aa996d")
			.addHeader("Accept","application/json")
			.url(origin.url).build()
		return  chain.proceed(req)
	}
}