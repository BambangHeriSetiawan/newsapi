package com.simxd.newsapi.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.simxd.newsapi.networking.models.Article
import com.simxd.newsapi.utils.ArticlePreviewProvider
import com.simxd.newsapi.utils.NetworkImage

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022

 */
@Preview(showBackground = true)
@Composable
fun ArticleItem(
	@PreviewParameter(ArticlePreviewProvider::class) article: Article?
){
	Card(
		modifier = Modifier
			.padding(5.dp)
			.fillMaxWidth(),
	) {
		Column(
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			NetworkImage(url = article?.urlToImage!!, modifier = Modifier.fillMaxWidth().height(150.dp))
			Text(text = article?.title!!, modifier = Modifier.padding(10.dp))
		}
	}
}