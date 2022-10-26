package com.simxd.newsapi.networking

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState

import com.simxd.newsapi.networking.models.Article
import com.skydoves.sandwich.suspendOnSuccess
import retrofit2.HttpException

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 */
class ArticlePageSource(private val networkService: NetworkService, var keyword:String?, var  category:String?): PagingSource<Int, Article>() {
	override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
		return state?.anchorPosition?.let { pos->
			state?.closestPageToPosition(pos)?.prevKey?.plus(1) ?: state?.closestPageToPosition(pos)?.nextKey?.minus(1)
		}
	}
	
	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
		return  try {
			val nextPage = params.key ?:1
			Log.v("ArticlePageSource","load -> ${params.key}")
			Log.v("ArticlePageSource","load -> ${nextPage}")
			var data:List<Article>? = listOf()
			networkService.headlines(keyword = keyword, category = category, nextPage).let {
				if (it.status == "ok"){
					data = it.articles
				}
			}
			
			LoadResult.Page(
				data = data!!,
				prevKey = if(nextPage == 1) null else nextPage.minus(1),
				nextKey = if (data?.isNotEmpty()!!) nextPage.plus(1) else null
			)
			
		}catch (e:HttpException){
			LoadResult.Error(e)
		}
	}
}