package com.simxd.newsapi.screen


import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.simxd.newsapi.MainVM
import com.simxd.newsapi.screen.components.ArticlePage
import com.simxd.newsapi.utils.DataHelper
import java.util.*

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun MainScreen(
	 viewModel: MainVM
){
	val pageState = rememberPagerState()
	val categories = DataHelper.tabs()
	Scaffold(
		topBar = {
			CenterAlignedTopAppBar(title = { Text(text = "NewApi")}, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
				containerColor = Color.Blue,
				titleContentColor = Color.White
			))
		}
	){
		ConstraintLayout(modifier = Modifier
			.padding(it)
			.fillMaxSize()) {
			Column(
				verticalArrangement = Arrangement.SpaceAround,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				ScrollableTabRow(
					selectedTabIndex = pageState.currentPage,
					modifier = Modifier.fillMaxWidth(),
					indicator = {tabPositions ->
						
						TabRowDefaults.Indicator(Modifier.tabIndicatorOffset(tabPositions[pageState.currentPage]))
					}
				) {
					categories.forEachIndexed { index, tabPageModel ->
						Tab(
							selected = pageState.currentPage == index,
							onClick = {
									  viewModel.load(null, categories[index].code)
							},
							text = { tabPageModel.title?.uppercase(Locale.ROOT)
								?.let { it1 -> Text(text = it1) } }
						)
					}
				}
				HorizontalPager(
					count = categories.size,
					state = pageState,
					modifier = Modifier
						.weight(1f)
						.fillMaxWidth()
				) { page: Int ->
					viewModel.load(null, categories[pageState.currentPage].code)
					
					Box(modifier = Modifier.fillMaxSize()) {
						viewModel.articles?.let { it1 -> ArticlePage(articles = it1) }
					}
				}
			}
		}
	}
}