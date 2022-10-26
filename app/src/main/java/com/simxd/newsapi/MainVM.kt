package com.simxd.newsapi

import androidx.lifecycle.ViewModel
import com.simxd.newsapi.data.MainRepo
import com.simxd.newsapi.networking.models.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 25,October,2022
 */
@HiltViewModel
class MainVM @Inject constructor(
	private val mainRepo: MainRepo
):ViewModel() {
	fun load(keyword:String, category:String, page:Int,){
		mainRepo.loadHeadline(keyword = keyword, category = category, page = page, object : MainRepo.OnLoadHeadLine {
			override fun onLoad(state: Boolean) {
			
			}
			
			override fun onError(msg: String) {
			
			}
			
			override fun onSuccess(articles: List<Article>?) {
			
			}
		})
	}
}