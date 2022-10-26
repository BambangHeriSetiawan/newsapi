package com.simxd.newsapi.utils

import com.simxd.newsapi.networking.models.Article
import com.simxd.newsapi.networking.models.Source
import com.simxd.newsapi.networking.models.TabPageModel

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 */
object DataHelper {
	
	fun tabs(): ArrayList<TabPageModel> {
		return arrayListOf<TabPageModel>(
			TabPageModel(0,null,"All"),
			TabPageModel(1,"general","General"),
			TabPageModel(2,"technology","Technology"),
			TabPageModel(3,"sports","Sports"),
			TabPageModel(4,"science","Science"),
			TabPageModel(5,"health","Health"),
			TabPageModel(6,"entertainment","Entertainment"),
			TabPageModel(7,"business","Business"),
		);
	}
	fun sampleArticles(): List<Article> {
		return listOf(
			Article(
				source = Source(name = "", id = ""),
				author = "Rae Wee",
				publishedAt = "2022-10-05T07:34:33Z",
				url = "https://finance.yahoo.com/news/asias-borrowers-turn-homeward-local-073433936.html",
				urlToImage = "https://s.yimg.com/uu/api/res/1.2/SJyYQgHQd1rOmdvHoIPAfA--~B/aD02MDE7dz04MDA7YXBwaWQ9eXRhY2h5b24-/https://media.zenfs.com/en/reuters-finance.com/0f95275a5e6090233a464b75a5a5b453",
				title = "As Asia's borrowers turn homeward, local bond issuance surges",
				description = "Asian issuance of bonds denominated in local currencies have ballooned to their largest in more than a decade as borrowers turn shy of expensive U.S. dollar"
			),
			Article(
				source = Source(name = "", id = ""),
				author = "Rae Wee",
				publishedAt = "2022-10-05T07:34:33Z",
				url = "https://finance.yahoo.com/news/asias-borrowers-turn-homeward-local-073433936.html",
				urlToImage = "https://s.yimg.com/uu/api/res/1.2/SJyYQgHQd1rOmdvHoIPAfA--~B/aD02MDE7dz04MDA7YXBwaWQ9eXRhY2h5b24-/https://media.zenfs.com/en/reuters-finance.com/0f95275a5e6090233a464b75a5a5b453",
				title = "As Asia's borrowers turn homeward, local bond issuance surges",
				description = "Asian issuance of bonds denominated in local currencies have ballooned to their largest in more than a decade as borrowers turn shy of expensive U.S. dollar"
			)
		)
	}
}