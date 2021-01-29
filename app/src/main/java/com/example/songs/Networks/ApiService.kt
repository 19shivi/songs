package com.example.songs.Networks
import com.example.songs.Model.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("search")
    fun getSearchResult(@Query("term")query:String):Call<SearchResult>
}