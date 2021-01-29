package com.example.songs.ViewModel

import com.example.songs.Model.ResultSongs
import androidx.lifecycle.ViewModel
import retrofit2.Call
import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Callback
import retrofit2.Response
import com.example.songs.Model.SearchResult
import android.content.Context
import androidx.lifecycle.viewModelScope
import com.example.songs.Networks.ApiService
import com.example.songs.Networks.RetrofitInstance
import com.example.songs.Repository.SongRepository
import kotlinx.coroutines.launch

class SonglistModelView : ViewModel() {
      var mutableData: MutableLiveData<List<ResultSongs>> =MutableLiveData<List<ResultSongs>>()
    fun DataObserver():MutableLiveData<List<ResultSongs>>{
        return mutableData
    }

    fun makeSearchApiCall(query:String,context: Context)
    {
        val apiService: ApiService = RetrofitInstance.buildService(ApiService::class.java)
        val call:Call<SearchResult> =apiService.getSearchResult(query=query )
        call.enqueue(object: Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
            viewModelScope.launch {
                val r: List<ResultSongs>? = response.body()?.results
                r?.forEach {
                    SongRepository.addSong(context, it)
                }
            }

                mutableData.postValue(response.body()?.results)
                Log.v("api",response.body().toString())

            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                viewModelScope.launch{
                mutableData.postValue(SongRepository.getSongList(context,query))
               Log.v("error",t.message.toString())


            }}

        })
    }
}

