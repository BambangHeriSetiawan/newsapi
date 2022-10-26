package com.simxd.newsapi

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.simxd.newsapi.networking.ArticlePageSource
import com.simxd.newsapi.networking.NetworkService
import com.simxd.newsapi.networking.models.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 25,October,2022
 */
@HiltViewModel
class MainVM @Inject constructor(
	private val networkService: NetworkService
):ViewModel() {
	var articles: Flow<PagingData<Article>>? = null
	fun load(keyword: String?, category:String?){
		articles = Pager(PagingConfig(pageSize = 5, enablePlaceholders = true)){
			ArticlePageSource(networkService, keyword, category)
		}.flow
	}
}