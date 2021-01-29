package com.example.songs.Repository

import com.example.songs.Model.ResultSongs
import android.content.Context
import com.example.songs.Room.SongDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class SongRepository {
    companion object {

        private var songDatabase: SongDatabase? = null

        private var resultList: List<ResultSongs>? = null

        private fun initializeDB(context: Context): SongDatabase {
            return SongDatabase.getDataseClient(context)
        }
      suspend  fun addSong(context: Context, results: ResultSongs) {

            songDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                songDatabase!!.SongDao().addSong(results)
            }
        }
       suspend fun getSongList(context: Context, query: String) : List<ResultSongs>? {

            songDatabase = initializeDB(context)

             resultList= songDatabase!!.SongDao().getSongs(query)
            return resultList


        }
    }
}