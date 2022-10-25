package com.simxd.newsapi.utils

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 25,October,2022
 */
class NetworkUrlPreviewProvider:PreviewParameterProvider<String> {
	override val count: Int
		get() = super.count
	override val values: Sequence<String>
		get() = sequenceOf("https://user-images.githubusercontent.com/24237865/75087936-5c1d9f80-553e-11ea-81d3-a912634dd8f7.jpg")
	
}