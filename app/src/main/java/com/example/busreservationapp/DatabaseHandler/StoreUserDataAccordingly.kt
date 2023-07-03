package com.example.busreservationapp.DatabaseHandler

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class StoreUserDataAccordingly {

    val db = FirebaseFirestore.getInstance()
    val usersCollection = db.collection("AllUserInfo")
    val userDoc = usersCollection.document("customer")
    val empDoc = usersCollection.document("Employee")


    fun store(
        email: String,
        password: String,
        phoNo: Long?,
        name: String,
        emp: Boolean,
        token: String?
    ): String {
        var op = "Successfully Stored"
        val data = mapOf(
            "Name" to name,
            "PhoneNumber" to phoNo,
            "email" to email,
            "password" to password,
            "token" to token
        )
        if(emp == true){
            empDoc.set(data , SetOptions.merge()).
                    addOnCompleteListener{task ->

                        if(task.isSuccessful){

                        }else{
                            op = "Error saving data"
                            println("Error saving data ${task.exception?.message}")
                        }

                    }
        }else{
            userDoc.set(data, SetOptions.merge()).
                    addOnCompleteListener { task ->
                        if(!task.isSuccessful) {
                            op = "Error In Saving data"
                        }
                    }
        }
        return op;
    }
}

