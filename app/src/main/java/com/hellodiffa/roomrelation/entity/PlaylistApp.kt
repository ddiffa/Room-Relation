package com.hellodiffa.roomrelation.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Playlist::class, User::class], version = 1, exportSchema = false)
abstract class PlaylistApp : RoomDatabase(){
    abstract fun playlistDao() : PlaylistDao

    companion object {

        @Volatile
        private var instance: PlaylistApp? = null

        fun getInstance(context: Context): PlaylistApp {
            return instance
                ?: synchronized(this) {
                instance
                    ?: buildDatabase(
                        context
                    )
                        .also { instance = it }
            }

        }

        private fun buildDatabase(context: Context): PlaylistApp {
            return Room.databaseBuilder(context, PlaylistApp::class.java, "playlist_db")
                .allowMainThreadQueries()
                .build()
        }
    }
}