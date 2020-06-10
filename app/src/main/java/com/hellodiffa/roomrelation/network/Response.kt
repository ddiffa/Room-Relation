package com.hellodiffa.roomrelation.network


data class Response(
	val user: List<UserItem>
)

data class PlaylistItem(
	val playlistId: Int,
	val song: String
)

data class UserItem(
	val playlist: List<PlaylistItem>,
	val userId: Int,
	val username: String
)
