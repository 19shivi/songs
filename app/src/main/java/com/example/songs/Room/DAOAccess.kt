package com.example.songs.Room

import com.example.songs.Model.ResultSongs
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DAOAccess {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addSong(results: ResultSongs)
    @Query("SELECT * FROM Songs WHERE artistName LIKE :query")
   suspend fun getSongs(query:String): List<ResultSongs>
}