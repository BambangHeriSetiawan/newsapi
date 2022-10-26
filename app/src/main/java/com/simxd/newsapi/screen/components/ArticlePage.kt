package com.simxd.newsapi.screen.components

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.simxd.newsapi.DetailArticleActivity
import com.simxd.newsapi.networking.models.Article
import com.simxd.newsapi.utils.ArticlesPreviewProvider
import kotlinx.coroutines.flow.Flow

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 */
@Preview(showBackground = true)
@Composable
fun ArticlePage(
	@PreviewParameter(ArticlesPreviewProvider::class) articles: Flow<PagingData<Article>>
){
	val listState = rememberLazyListState()
	var articleItems :LazyPagingItems<Article> = articles.collectAsLazyPagingItems()
	LazyColumn(
		state = listState,
		modifier = Modifier.fillMaxSize()
	){
		if (articleItems.itemCount >=1){
			items(articleItems){value: Article? ->
				ArticleItem(article = value, onClicked = {
				})
			}
		}
		
		articleItems.apply {
			when{
				loadState.refresh is LoadState.Loading -> {
					item {
						Loading(modifier = Modifier.fillParentMaxSize())
					}
				}
				loadState.append is LoadState.Loading -> {
					item{
						Load()
					}
				}
				loadState.refresh is LoadState.Error -> {
					val e = articleItems.loadState.refresh as LoadState.Error
					item {
						Column(
							verticalArrangement = Arrangement.Bottom,
							horizontalAlignment = Alignment.CenterHorizontally
						){
							Empty()
							Error(msg = e.error.message!!, onClickRetry = { retry()})
						}
						
					}
				}
				loadState.append is LoadState.Error -> {
					val e = articleItems.loadState.append as LoadState.Error
					item {
						Column(
							verticalArrangement = Arrangement.Bottom,
							horizontalAlignment = Alignment.CenterHorizontally
						) {
							Empty()
							Error(msg = e.error.message!!, onClickRetry = { retry()})
						}
						
					}
				}
			}
		}
	}
}