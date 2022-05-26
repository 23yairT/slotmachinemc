package com.example.slotmachine

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var lever: View
    private var mMediaPlayer: MediaPlayer? = null
    private lateinit var slotOne: TextView
    private lateinit var slotTwo: TextView
    private lateinit var slotThree: TextView
    private lateinit var stevefrommc: ImageView
    private var numb1: Int = (1..7).random()
    private var numb2: Int = (1..7).random()
    private var numb3: Int = (1..7).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slotOne = findViewById(R.id.slot1)
        slotTwo = findViewById(R.id.slot2)
        slotThree = findViewById(R.id.slot3)
        stevefrommc = findViewById(R.id.beststeve)

        stevefrommc.setOnClickListener {
            spinAll()
            jackpot()
        }

        slotOne.setOnClickListener {
            spinOne()
        }

        slotTwo.setOnClickListener {
            spinTwo()
        }

        slotThree.setOnClickListener {
            spinThree()
        }

        lever = findViewById<View>(R.id.lever)

        lever.setOnClickListener {
            set(lever)
        }
    }



    private fun set(view: View) {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.creepa)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }




    private fun spinOne() {
        numb1 = (1..7).random()
        if (numb1 >= 8) numb1 = 1
        slotOne.text = numb1.toString()

    }

    private fun spinTwo() {
        numb2 = (1..7).random()
        if (numb2 >= 8) numb2 = 1
        slotTwo.text = numb2.toString()

    }

    private fun spinThree() {
        numb3 = (1..7).random()
        if (numb3 >= 8) numb3 = 1
        slotThree.text = numb3.toString()

    }

    private fun spinAll() {
        spinOne()
        spinTwo()
        spinThree()
    }

    private fun jackpot() {
        if (slotOne.text == "7" && slotTwo.text == "7" && slotThree.text == "7") {
            val text = "WIN"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
    }

}