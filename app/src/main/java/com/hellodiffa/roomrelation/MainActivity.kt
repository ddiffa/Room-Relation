package com.hellodiffa.roomrelation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import com.hellodiffa.roomrelation.entity.*
import com.hellodiffa.roomrelation.network.Response
import com.hellodiffa.roomrelation.network.response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dao: PlaylistDao
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dao = PlaylistApp.getInstance(applicationContext).playlistDao()


        btn_save.setOnClickListener {
            try {
                dao.insertPlaylistForUser(response!!)
            } catch (e: Throwable) {
                Log.e(TAG, e.message)
            }finally {
                Toast.makeText(this, "Success save data to room", Toast.LENGTH_LONG).show()
            }
        }

        btn_load.setOnClickListener {

            var result = ""

            for (list in dao.getPlaylistUser()){
                result += list.toString() + "\n\n"
            }

            tv_result.text = result
        }

    }
}