package com.example.busreservationapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity1 : AppCompatActivity() {
    private lateinit var userET:EditText
    private lateinit var passET:EditText
    private lateinit var login:Button
    private lateinit var newAccount:Button
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        auth = FirebaseAuth.getInstance()




        userET=findViewById(R.id.editTextText2)
        passET=findViewById(R.id.editTextText3)
        login=findViewById(R.id.button4)
        newAccount=findViewById(R.id.button5)

        newAccount.setOnClickListener {
            val intent=Intent(this,registeration1::class.java)
            startActivity(intent)
            Toast.makeText(this,"SIGNUP PAGE",Toast.LENGTH_LONG).show()
        }

        login.setOnClickListener{
           loginWithEmailAndPassword(userET.text.toString() , passET.text.toString() , auth)   //  registraction has some bugs -------
//            startActivity(Intent(this , homepage_activity::class.java))
        }
    }

    private fun loginWithEmailAndPassword(email: String, password: String, auth: FirebaseAuth) {
        auth.signInWithEmailAndPassword(email , password)
            .addOnCompleteListener(this){task ->
                if (task.isSuccessful){
                    Toast.makeText(this , "login successful " , Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this , homepage_activity::class.java))
                }else{
                    println("task message == ${task.exception?.message}")
                    Toast.makeText(this , "login faild " , Toast.LENGTH_SHORT).show()
                }
            }
    }
}