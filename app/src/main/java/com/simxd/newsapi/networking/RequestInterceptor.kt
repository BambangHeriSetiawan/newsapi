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
			.addHeader("X-Api-Key","9b0c1f1ca1324bcc84958471d45de6fa")
			.addHeader("Accept","application/json")
			.url(origin.url).build()
		return  chain.proceed(req)
	}
}