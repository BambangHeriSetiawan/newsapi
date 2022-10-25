package com.simxd.newsapi.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.simxd.newsapi.R
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.animation.crossfade.CrossfadePlugin
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent


/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 25,October,2022
 */

@Preview
@Composable
fun NetworkImage(
	@PreviewParameter(NetworkUrlPreviewProvider::class)url:String,
	modifier: Modifier =Modifier,
	scale:ContentScale = ContentScale.Crop
){
	CoilImage(
		imageModel = { url },
		modifier = modifier,
		component = rememberImageComponent {
			+CrossfadePlugin( duration = 250)
		},
		previewPlaceholder = R.drawable.ic_launcher_background,
		imageOptions = ImageOptions(contentScale = scale),
		failure = {
			Column(
				modifier = modifier,
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(text = "image request failed.", style = MaterialTheme.typography.titleMedium)
			}
		}
	)
}