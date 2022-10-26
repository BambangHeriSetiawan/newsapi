package com.simxd.newsapi.screen

import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.web.WebView
import com.simxd.newsapi.R
import com.simxd.newsapi.networking.models.Article
import com.simxd.newsapi.utils.ArticlePreviewProvider

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DetailArticle(
	@PreviewParameter(ArticlePreviewProvider::class) article: Article
){
	Scaffold(
		topBar = {
			TopAppBar(
				title = { article.title?.let { Text(text = it, maxLines = 1) } },
				navigationIcon = {
					Icon(painter = painterResource(id = R.drawable.arrow_back_white), contentDescription = "", modifier = Modifier.size(24.dp))
				}
			)
		}
	) { padingValue->
		AndroidView(factory = {
							  WebView(it).apply {
								  webViewClient = WebViewClient()
								  webChromeClient = WebChromeClient()
								  article.url?.let { it1 -> loadUrl(it1) }
							  }
		}, update = {
			article.url?.let { it1 -> it.loadUrl(it1) }
		},  modifier = Modifier.padding(padingValue).fillMaxSize())
	}
}