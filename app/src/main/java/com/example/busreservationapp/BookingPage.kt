package com.example.busreservationapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.busreservationapp.Models.Bus
import com.example.busreservationapp.homepage_activity


class BookingPage : AppCompatActivity() {
    private lateinit var conformbtn:Button
    private lateinit var busid:TextView
    private lateinit var phoneno:TextView
    private lateinit var seatno:EditText
    private  lateinit var date:EditText
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_page)

        conformbtn = findViewById(R.id.conform)
        busid = findViewById(R.id.busid)
        phoneno = findViewById(R.id.phoneno)
        seatno = findViewById(R.id.seatno)
        date = findViewById(R.id.date)

        val id  = intent.getIntExtra("id", 0).toString()
//        val fbus = homepage_activity.busMap[intent.getStringExtra("bus")]
        var StartTime:String = ""
        var EndTime:String = ""
        var Price:Double = 0.0
        var TotalSeats:Int = 0
        var NumberOfSeatsLeft:Int = 0
        var DriverNo: Long = 123456
        var FromPlace:String = ""
        var ToPlac:String = ""



        homepage_activity().busMap.entries.forEach { entry ->
            val bus = entry.value
            if (bus.id == id.toInt()) {
                StartTime = bus.StartTime
                EndTime = bus.EndTime
                Price = bus.Price
                TotalSeats = bus.TotalSeats
                DriverNo = bus.DriverNo
                phoneno.text = bus.DriverNo.toString()
                FromPlace = bus.FromPlace
                ToPlac =  bus.ToPlac
                bus.NumberOfSeatsLeft--;
            }
        }



        var cid:Long = 8555807241


        conformbtn.setOnClickListener{
            sendConformationMessage(cid)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val importance = NotificationManager.IMPORTANCE_HIGH
                val channel = NotificationChannel("ConformNotification", "ConformNotification", importance)
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            }


            val builder = NotificationCompat.Builder(this , "ConformNotification")
                .setContentTitle("Conformed")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true)
                .setContentText("Your Bus Reservation is Conformed On ${date.text.toString()} from ${FromPlace} to ${ToPlac} at ${StartTime}")
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

            val managerr = NotificationManagerCompat.from(this)
            managerr.notify(999 , builder.build())


        }



    }

    private fun sendConformationMessage(cid: Long) {

    }


}

