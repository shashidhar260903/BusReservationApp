package com.example.busreservationapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.busreservationapp.Models.Bus

class homepage_activity : AppCompatActivity()  {
    private lateinit var from:EditText
    private lateinit var to:EditText
    private lateinit var checkbtn:Button
    private lateinit var layout:LinearLayout
    var busMap = mutableMapOf<String, Bus>()

    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        from = findViewById(R.id.from)
        to = findViewById(R.id.to)
        checkbtn = findViewById(R.id.check)
        layout = findViewById(R.id.container)

        var isCheckBtnClicked:Boolean = false


        busMap["A"] = Bus(1212 ,"1:00AM" , "2:00PM" ,200.23 , 30 , 20 ,8555555122 , "AWDASFASD" , "BASD"  )
        busMap["B"] = Bus(1232 ,"2:00AM" , "2:00PM" ,200.23 , 30 , 20 ,8555555122 , "BASDSADF" , "BASDF"  )
        busMap["C"] = Bus(1232 ,"3:00PM" , "2:00PM" ,200.23 , 30 , 20 ,85544455122 , "CASDFSD" , "ASDFSAD"  )
        busMap["D"] = Bus(1272 ,"5:00AM" , "2:00" ,200.23 , 30 , 20 ,85532455122 , "DASDFSADF" , "ASDFAS"  )
        busMap["E"] = Bus(1412 ,"5:00AM" , "2:00" ,200.23 , 30 , 20 ,82345555122 , "EASDFSD" , "ASDSFASDF"  )
        busMap["F"] = Bus(1342 ,"11:00AM" , "2:00" ,200.23 , 30 , 20 ,83456555122 , "FSADFS" , "DSFASFSA"  )
        busMap["G"] = Bus(1672 ,"2:00AM" , "2:00" ,200.23 , 30 , 20 ,8555255122 , "GASDF" , "BASDFS"  )
        busMap["H"] = Bus(1256 ,"8:00AM" , "2:00" ,200.23 , 30 , 20 ,2345325122 , "HASFASEFW" , "BSDFSAD"  )


        checkbtn.setOnClickListener {
            if(isCheckBtnClicked){
                layout.removeAllViews()
            }
            isCheckBtnClicked = true
          val ab:Bus? =   sortTheBuses(from.text.toString() , busMap)
            if(ab!= null ){
                addAvailableBusInfo(ab);
            }else{
                Toast.makeText(this , "No Buses are available " , Toast.LENGTH_SHORT).show();
            }
//           for ( i in 1..4){
//               addAvailableBusInfo()
//           }

        }

        /*

        Storing bus data in an list is for only testing --

        */

    }

    private fun sortTheBuses(from: String, busMap: MutableMap<String, Bus>): Bus? {
        if(busMap.containsKey(from)){
            return busMap.get(from)
        }
        return null
    }

    @SuppressLint("ResourceType", "MissingInflatedId")
    private fun addAvailableBusInfo(ab: Bus) {
        val view:View = layoutInflater.inflate(R.layout.avilable_bus_component, null);

//        var id:TextView = view.findViewById(R.id.busid)
        var startTime:TextView = view.findViewById(R.id.st)
        var endTime:TextView = view.findViewById(R.id.et)
        var price:TextView = view.findViewById(R.id.price)
        var bookbtn:TextView = view.findViewById(R.id.book)
        var avilableseats:TextView = view.findViewById(R.id.avs)
//        var fromplaceTV:TextView = view.findViewById(R.id.fp)
//        var toPlaceTV:TextView = view.findViewById(R.id.tp)

//        id.text = ab.id.toString()
        startTime.text = ab.StartTime
        endTime.text = ab.EndTime
        price.text = "${ab.Price}$"
        avilableseats.text = "Available seats : ${ab.NumberOfSeatsLeft}"
//        fromplaceTV.text = ab.FromPlace
//        toPlaceTV.text = ab.ToPlac

        bookbtn.setOnClickListener {

            val intent = Intent(this, BookingPage::class.java)
            intent.putExtra("id", ab.id)
            intent.putExtra("bus" , from.text.toString())
            startActivity(intent)
        }

        layout.addView(view)
    }
}