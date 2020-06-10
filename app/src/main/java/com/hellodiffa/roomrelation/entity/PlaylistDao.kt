package com.hellodiffa.roomrelation.entity

import androidx.room.*
import com.hellodiffa.roomrelation.network.Response

@Dao
interface PlaylistDao {

    fun insertPlaylistForUser(response: Response) {

        saveUser(response.user.map { userItem ->
            User(userId = userItem.userId.toLong(), username = userItem.username)
        })

        response.user.forEach { user ->
            savePlaylist(user.playlist.map { playlistItem ->
                Playlist(
                    playlistId = playlistItem.playlistId.toLong(),
                    song = playlistItem.song,
                    userCreatorId = user.userId.toLong()
                )
            })
        }
    }

    @Transaction
    @Query("SELECT * FROM user")
    fun getPlaylistUser(): List<PlaylistAndUserEntity>

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>

    @Query("SELECT * FROM Playlist")
    fun getAllPlaylist(): List<Playlist>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePlaylist(playlist: List<Playlist>)
}