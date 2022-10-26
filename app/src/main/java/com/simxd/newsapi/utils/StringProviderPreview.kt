package com.simxd.newsapi.utils

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 */
class StringProviderPreview:PreviewParameterProvider<String> {
	override val values: Sequence<String>
		get() = sequenceOf("Error message here")
}