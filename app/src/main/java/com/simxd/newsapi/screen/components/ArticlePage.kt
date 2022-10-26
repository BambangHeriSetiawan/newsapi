package com.simxd.newsapi.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.simxd.newsapi.networking.models.Article
import com.simxd.newsapi.utils.ArticlesPreviewProvider

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 */
@Preview(showBackground = true)
@Composable
fun ArticlePage(
	@PreviewParameter(ArticlesPreviewProvider::class) articles:List<Article>
){
	val listState = rememberLazyListState()
	LazyColumn(
		state = listState,
		verticalArrangement = Arrangement.spacedBy(4.dp)
	){
		items(articles){
			item: Article -> ArticleItem(article = item)
		}
	}
}