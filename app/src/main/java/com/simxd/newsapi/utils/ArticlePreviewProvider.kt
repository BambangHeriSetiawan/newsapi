package com.simxd.newsapi.utils

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.simxd.newsapi.networking.models.Article
import com.simxd.newsapi.networking.models.Source

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 */
class ArticlePreviewProvider:PreviewParameterProvider<Article> {
	override val values: Sequence<Article>
		get() = sequenceOf(
			Article(
			source = Source(name = "", id = 0),
				author = "Rae Wee",
				publishedAt = "2022-10-05T07:34:33Z",
				url = "https://finance.yahoo.com/news/asias-borrowers-turn-homeward-local-073433936.html",
				urlToImage = "https://s.yimg.com/uu/api/res/1.2/SJyYQgHQd1rOmdvHoIPAfA--~B/aD02MDE7dz04MDA7YXBwaWQ9eXRhY2h5b24-/https://media.zenfs.com/en/reuters-finance.com/0f95275a5e6090233a464b75a5a5b453",
				title = "As Asia's borrowers turn homeward, local bond issuance surges",
				description = "Asian issuance of bonds denominated in local currencies have ballooned to their largest in more than a decade as borrowers turn shy of expensive U.S. dollar"
		)
		)
}