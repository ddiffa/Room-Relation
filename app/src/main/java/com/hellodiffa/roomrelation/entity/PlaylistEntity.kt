package com.hellodiffa.roomrelation.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation




@Entity
data class User(
    @PrimaryKey(autoGenerate = false)
    val userId: Long,
    val username: String
)

@Entity
data class Playlist(
    @PrimaryKey(autoGenerate = false)
    val playlistId: Long,
    val song: String,
    var userCreatorId: Long? = 0L
)

data class PlaylistAndUserEntity(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userCreatorId"
    )
    val playlist: List<Playlist>
)