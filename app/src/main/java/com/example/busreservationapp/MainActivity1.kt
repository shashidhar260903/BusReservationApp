package com.example.busreservationapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity1 : AppCompatActivity() {
    private lateinit var userET:EditText
    private lateinit var passET:EditText
    private lateinit var login:Button
    private lateinit var newAccount:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userET=findViewById(R.id.editTextText2)
        passET=findViewById(R.id.editTextText3)
        login=findViewById(R.id.button4)
        newAccount=findViewById(R.id.button5)
        newAccount.setOnClickListener {
            val intent=Intent(this,registeration1::class.java)
            startActivity(intent)
            Toast.makeText(this,"SIGNUP PAGE",Toast.LENGTH_LONG).show()
        }

    }
}