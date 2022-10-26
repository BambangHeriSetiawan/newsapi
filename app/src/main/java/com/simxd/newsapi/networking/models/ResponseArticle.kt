package com.simxd.newsapi.networking.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseArticle(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("status")
	val status: String? = null,
	@field:SerializedName("articles")
	val articles: List<Article>? = null
) : Parcelable