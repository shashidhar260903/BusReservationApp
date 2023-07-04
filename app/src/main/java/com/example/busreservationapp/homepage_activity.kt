package com.example.busreservationapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.busreservationapp.Models.Bus



class homepage_activity : AppCompatActivity()  {
    private lateinit var from:Spinner
    private lateinit var to:Spinner
    private lateinit var checkbtn:Button
    private lateinit var layout:LinearLayout

    private lateinit var result:String
    private lateinit var result1:String

    var busMap = mutableMapOf<String, Bus>()


    @SuppressLint("MissingInflatedId", "ResourceType", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
        from = findViewById(R.id.from)
        to = findViewById(R.id.to)
        checkbtn = findViewById(R.id.check)
        layout = findViewById(R.id.container)
        val place = arrayOf(" ","Hyderabad","Pune","Banglore","Mumbai","Chennai","Delhi")
        val arrayAdp = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,place)
        from.adapter=arrayAdp
        to.adapter=arrayAdp


        from.onItemSelectedListener= object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                result=place[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        to.onItemSelectedListener= object :AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                result1=place[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        var isCheckBtnClicked:Boolean = false


        busMap["Hyderabad"] = Bus(1212 ,"9:00AM" , "12:00PM" ,200.23 , 30 , 20 ,8555555122 , "Hyderabad" , "Pune"  )
        busMap["Hyderabad"] = Bus(1222 ,"10:00AM" , "6:00PM" ,600.23 , 30 , 20 ,8555255122 , "Hyderabad" , "Banglore"  )
        busMap["Hyderabad"] = Bus( 1232,"9:30AM" , "8:00PM" ,800.23 , 30 , 20 ,8555255122 , "Hyderabad" , "Mumbai"  )
        busMap["Hyderabad"] = Bus( 1242,"5:00AM" , "2:00PM" ,1000.23 , 30 , 20 ,8555255122 , "Hyderabad" , "Chennai"  )
        busMap["Hyderabad"] = Bus(1252 ,"3:00AM" , "9:00PM" ,1200.23 , 30 , 20 ,8555555122 , "Hyderabad" , "Delhi"  )
        busMap["Banglore"] = Bus(1412 ,"9:00AM" , "12:00PM" ,200.23 , 30 , 20 ,85544455122 , "Banglore" , "Pune"  )
        busMap["Banglore"] = Bus(1422 ,"10:00AM" , "6:00PM" ,200.23 , 30 , 20 ,85544455122 , "Banglore" , "Hyderabad"  )
        busMap["Banglore"] = Bus(1432 ,"9:30AM" , "8:00PM" ,200.23 , 30 , 20 ,85544455122 , "Banglore" , "Mumbai"  )
        busMap["Banglore"] = Bus(1442 ,"5:00AM" , "2:00PM" ,200.23 , 30 , 20 ,85544455122 , "Banglore" , "Chennai"  )
        busMap["Banglore"] = Bus(1452 ,"3:00AM" , "9:00PM" ,200.23 , 30 , 20 ,85544455122 , "Banglore" , "Delhi"  )
        busMap["Mumbai"] = Bus(1512 ,"5:00AM" , "2:00" ,200.23 , 30 , 20 ,85532455122 , "Mumbai" , "Pune"  )
        busMap["Mumbai"] = Bus(1522 ,"10:00AM" , "6:00PM" ,200.23 , 30 , 20 ,85544455122 , "Mumbai" , "Hyderabad"  )
        busMap["Mumbai"] = Bus(1532 ,"9:30AM" , "8:00PM" ,200.23 , 30 , 20 ,85544455122 , "Mumbai" , "Banglore"  )
        busMap["Mumbai"] = Bus(1542 ,"5:00AM" , "2:00PM" ,200.23 , 30 , 20 ,85544455122 , "Mumbai" , "Chennai"  )
        busMap["Mumbai"] = Bus(1552 ,"3:00AM" , "9:00PM" ,200.23 , 30 , 20 ,85544455122 , "Mumbai" , "Delhi"  )
        busMap["Chennai"] = Bus(1612 ,"5:00AM" , "2:00" ,200.23 , 30 , 20 ,82345555122 , "Chennai" , "Pune"  )
        busMap["Chennai"] = Bus(1622 ,"10:00AM" , "6:00PM" ,200.23 , 30 , 20 ,85544455122 , "Chennai" , "Hyderabad"  )
        busMap["Chennai"] = Bus(1632 ,"9:30AM" , "8:00PM" ,200.23 , 30 , 20 ,85544455122 , "Chennai" , "Banglore"  )
        busMap["Chennai"] = Bus(1642 ,"5:00AM" , "2:00PM" ,200.23 , 30 , 20 ,85544455122 , "Chennai" , "Mumbai"  )
        busMap["Chennai"] = Bus(1652 ,"3:00AM" , "9:00PM" ,200.23 , 30 , 20 ,85544455122 , "Chennai" , "Delhi"  )
        busMap["Delhi"] = Bus(1712 ,"11:00AM" , "2:00" ,200.23 , 30 , 20 ,83456555122 , "Delhi" , "Pune"  )
        busMap["Delhi"] = Bus(1722 ,"10:00AM" , "6:00PM" ,200.23 , 30 , 20 ,85544455122 , "Delhi" , "Hyderabad"  )
        busMap["Delhi"] = Bus(1732 ,"9:30AM" , "8:00PM" ,200.23 , 30 , 20 ,85544455122 , "Delhi" , "Banglore"  )
        busMap["Delhi"] = Bus(1742 ,"5:00AM" , "2:00PM" ,200.23 , 30 , 20 ,85544455122 , "Delhi" , "Mumbai"  )
        busMap["Delhi"] = Bus(1752 ,"3:00AM" , "9:00PM" ,200.23 , 30 , 20 ,85544455122 , "Delhi" , "Chennai"  )
        busMap["Pune"] = Bus(1812 ,"8:00AM" , "2:00" ,200.23 , 30 , 20 ,2345325122 , "Pune" , "Delhi"  )
        busMap["Pune"] = Bus(1822 ,"10:00AM" , "6:00PM" ,200.23 , 30 , 20 ,85544455122 , "Pune" , "Hyderabad"  )
        busMap["Pune"] = Bus(1832 ,"9:30AM" , "8:00PM" ,200.23 , 30 , 20 ,85544455122 , "Pune" , "Banglore"  )
        busMap["Pune"] = Bus(1842 ,"5:00AM" , "2:00PM" ,200.23 , 30 , 20 ,85544455122 , "Pune" , "Mumbai"  )
        busMap["Pune"] = Bus(1852 ,"3:00AM" , "9:00PM" ,200.23 , 30 , 20 ,85544455122 , "Pune" , "Chennai"  )


        checkbtn.setOnClickListener {
            if(isCheckBtnClicked){
                layout.removeAllViews()
            }
            isCheckBtnClicked = true
          val ab:Bus? = sortTheBuses(result,busMap)
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
            intent.putExtra("bus" , result)
            startActivity(intent)
        }

        layout.addView(view)
    }
}