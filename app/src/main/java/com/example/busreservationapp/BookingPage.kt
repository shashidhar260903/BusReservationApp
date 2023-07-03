package com.example.busreservationapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BookingPage : AppCompatActivity() {
    private lateinit var conformbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_page)

        conformbtn = findViewById(R.id.conform)

        var cid:Long = 8555807241

        conformbtn.setOnClickListener{
            sendConformationMessage(cid)
        }



    }

    private fun sendConformationMessage(cid: Long) {

    }


}