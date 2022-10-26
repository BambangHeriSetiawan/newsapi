package com.simxd.newsapi.data

import com.simxd.newsapi.networking.NetworkService
import com.simxd.newsapi.networking.models.Article
import com.skydoves.sandwich.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 25,October,2022
 */
class MainRepo @Inject constructor(
	private val networkService: NetworkService
) {
	
	 @OptIn(DelicateCoroutinesApi::class)
	 fun loadHeadline(keyword:String? = "Indonesia", category:String, page:Int? = 1, listener:OnLoadHeadLine){
		
	}
	interface OnLoadHeadLine {
		fun onLoad(state:Boolean)
		fun onError(msg:String)
		fun onSuccess(articles:List<Article>?)
	}
}