package com.example.busreservationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val auth = FirebaseAuth.getInstance();


            fun register(email:String , password:String ){
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this){task ->
                        if (task.isSuccessful){
                            // Tost the Message  and return back to login page
                            Toast.makeText( this,"Registraction Successful " , Toast.LENGTH_SHORT)
//                          // -----  startActivity(Intent(this , login::java class))
                        }else{
                            // Tost the message
                        }
                     }
            }

        fun login(email:String , password:String){
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->{
                if(task.isSuccessful){
                    // To Do take to home screen
                 //    startActivity(Intent(this , Home.java::class))
                }else{
                    // To Do Tost fail
                }
            }}
        }







    }
}