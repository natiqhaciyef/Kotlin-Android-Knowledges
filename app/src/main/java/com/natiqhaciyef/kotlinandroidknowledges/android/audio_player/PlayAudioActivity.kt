package com.natiqhaciyef.kotlinandroidknowledges.android.audio_player

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.natiqhaciyef.kotlinandroidknowledges.databinding.ActivityPlayAudioBinding
import java.lang.Exception

class PlayAudioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayAudioBinding
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayAudioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener {
            playAudioFunction()
        }

        binding.stopButton.setOnClickListener {
            stopAudioFunction()
        }
    }

    fun playAudioFunction(){
        val audioURL = "/track/839/sene-halaldi-var-ustunde-makar-tipli-tapanca"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

        try {
            mediaPlayer!!.setDataSource(audioURL)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
        }catch (e: Exception){
            e.printStackTrace()
        }

        Toast.makeText(this@PlayAudioActivity, "Audio playing", Toast.LENGTH_SHORT).show()
    }

    fun stopAudioFunction(){
        if (mediaPlayer != null){
            if (mediaPlayer!!.isPlaying){
                mediaPlayer!!.stop()
                mediaPlayer!!.reset()
                mediaPlayer!!.release()
            }
        }

        Toast.makeText(this@PlayAudioActivity, "Audio stopped", Toast.LENGTH_SHORT).show()
    }
}