package com.example.songs.Model

import com.example.songs.Model.ResultSongs
import com.google.gson.annotations.SerializedName

data class SearchResult (

	@SerializedName("resultCount") val resultCount : Int,
	@SerializedName("results") val results : List<ResultSongs>
)