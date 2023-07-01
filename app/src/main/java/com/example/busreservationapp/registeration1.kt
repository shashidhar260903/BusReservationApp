package com.example.busreservationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class registeration1:AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var email:EditText
    private lateinit var pho:EditText
    private lateinit var pass:EditText
    private lateinit var register:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registeration)
        val intent:Intent=intent
        name=findViewById(R.id.editTextText)
        email=findViewById(R.id.editTextText4)
        pho=findViewById(R.id.editTextText3)
        pass= findViewById(R.id.editTextText5)
        register=findViewById(R.id.button)
        register.setOnClickListener{
             var name1=name.text.toString()
             var email=email.text.toString()
            var pho1=pho.text.toString()
            var pass1 =pass.text.toString()

        }


    }
}