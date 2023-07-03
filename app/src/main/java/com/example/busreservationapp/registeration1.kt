package com.example.busreservationapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.busreservationapp.DatabaseHandler.StoreUserDataAccordingly
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.*


class registeration1:AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var email:EditText
    private lateinit var pho:EditText
    private lateinit var pass:EditText
    private lateinit var register:Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var  User: RadioButton
    private lateinit var  Emp: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registeration)
        val auth = FirebaseAuth.getInstance()

        radioGroup = findViewById(R.id.radioGroup)
        User = findViewById(R.id.radioButton)
        Emp  = findViewById(R.id.radioButton2)

        var isEmp:Boolean = false


        radioGroup.setOnCheckedChangeListener{group , checkedID ->
            when(checkedID){
                User.id -> {
                    isEmp = false
                }
                Emp.id  -> {
                    isEmp = true
                }
            }
        }



        name=findViewById(R.id.editTextText)
        email=findViewById(R.id.editTextText4)
        pho=findViewById(R.id.editTextText3)
        pass= findViewById(R.id.editTextText5)
        register=findViewById(R.id.button)
        register.setOnClickListener{
             val name1=name.text.toString()
             val email=email.text.toString()
            val pho2 = pho.text
            println("pho2 == ${pho2::class.java}")
            val pho1=pho.text.toString().toLongOrNull()
            val pass1 =pass.text.toString()

            // N e e d s checks or validate the user info ...
//            println("pho 1 == ${pho1::class.java}  " )

            registerWithEmailAndPassword(email , pass1 , auth  , name1 , pho1 , isEmp);
        }



    }


    private fun registerWithEmailAndPassword(
        email: String,
        pass1: String,
        auth: FirebaseAuth,
        name: String,
        pho: Long?,
        isEmp: Boolean
    ) {
        val res:kotlinx.coroutines.Deferred<String>
        auth.createUserWithEmailAndPassword(email, pass1).
                addOnCompleteListener(this){task ->
                    var token: String? = null
                    if(task.isSuccessful){
                        Toast.makeText(this , "Registraction Successful, Please Login  " , Toast.LENGTH_SHORT).show()
                        runBlocking {
                            val res  = async {

                                FirebaseMessaging.getInstance().token.addOnCompleteListener{task ->
                                    if(task.isSuccessful){
                                        token = task.result
                                    }else{
                                    }

                                }
                                StoreUserDataAccordingly().store(email, pass1, pho, name, isEmp , token)
                            }
                        }
                        if(token == null ){
                            Toast.makeText(this , "Your Messageing Token is set to null ,  Please check Internet" , Toast.LENGTH_SHORT)
                        }
                        // handle res object .. print what is it display ---

                        startActivity(Intent(this , MainActivity1::class.java))
                    }else{

                        val errorReturnd: String? = task.exception?.message
                        println("errorReturnd =  ${errorReturnd}" )
                        if(token == null ){
                            Toast.makeText(this , "Your Messageing Token is set to null ,  Please check Internet" , Toast.LENGTH_SHORT)
                        }
                    }
                }


    }
}