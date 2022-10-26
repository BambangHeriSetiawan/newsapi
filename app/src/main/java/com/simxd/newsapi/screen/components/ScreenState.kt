package com.simxd.newsapi.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.simxd.newsapi.utils.StringProviderPreview
import com.simxd.newsapi.R
/**
 * @Author: Bambang Heri Setiawan
 * @Company: PT. Indoglobal Nusa Persada
 * @Date: 26,October,2022
 *
 */
@Preview(showBackground = true)
@Composable
fun Loading(modifier: Modifier=Modifier){
	Column(
     modifier = modifier,
     verticalArrangement = Arrangement.Center,
     horizontalAlignment = Alignment.CenterHorizontally
    ) {
     CircularProgressIndicator()
    }
 }
@Preview(showBackground = true)
@Composable
fun Load(){
 CircularProgressIndicator(
  modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
      .wrapContentWidth(Alignment.CenterHorizontally)
 )
}

@Composable
fun Error(
 @PreviewParameter(StringProviderPreview::class) msg:String,
 onClickRetry: () -> Unit
){
 
 Row (
  modifier = Modifier.padding(16.dp),
  horizontalArrangement = Arrangement.SpaceBetween,
  verticalAlignment = Alignment.CenterVertically
 ){
  Text(text = msg, maxLines = 1, modifier = Modifier.weight(1f), style = MaterialTheme.typography.titleSmall, color = Color.Red)
  OutlinedButton(onClick = onClickRetry){
   Text(text = "Try Again", color = Color.Red)
  }
 }
}
@Preview(showBackground = true)
@Composable
fun Empty(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.id_error), contentDescription = "", modifier = Modifier.size(50.dp))
        Text(text = "Data Not Found", style = MaterialTheme.typography.titleMedium, color = Color.Red)
    }
}