package com.hellodiffa.roomrelation.network

import com.beust.klaxon.Klaxon

val response = Klaxon().parse<Response>(
    """
            {
             "user": [
                {
                    "userId" : 1,
                    "username" : "Mark",
                    "playlist" : [
                        {
                         "playlistId": 1,
                         "song" : "song 1"
                        },
                        {
                         "playlistId": 3,
                         "song" : "song 3"
                        }
                    ]
                }, 
                {
                    "userId" : 2,
                    "username" : "John",
                    "playlist" : [
                        {
                         "playlistId": 2,
                         "song" : "song 2"
                        }
                    ]
                },
                ]
            }
        """.trimIndent()
)