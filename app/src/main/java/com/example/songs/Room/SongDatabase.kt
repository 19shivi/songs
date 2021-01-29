package com.example.songs.Room

import com.example.songs.Model.ResultSongs
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [ResultSongs::class], version = 1, exportSchema = false)
abstract class SongDatabase:RoomDatabase() {

    abstract fun SongDao(): DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: SongDatabase? = null

        fun getDataseClient(context: Context): SongDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, SongDatabase::class.java, "SONG_DATABASE.db")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }
    }
}