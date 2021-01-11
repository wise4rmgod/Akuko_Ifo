package com.dev.akukoifo.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.dev.akukoifo.model.AkukoDataClass
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object CloudFirestoredb {

    val db = Firebase.firestore


    fun saveword(
        context: Context,
        english: String,
        igbo: String,

        ) {

        val addwrd = hashMapOf(
            "english" to english,
            "igbo" to igbo,
        )
        // Add a new document with a generated ID
        db.collection("words")
            .add(addwrd)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show()
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
                Toast.makeText(context, "Not Saved Successfully", Toast.LENGTH_SHORT).show()
            }
    }


    fun save(context: Context, title: String, description: String, category: String, date: String) {

        val data = hashMapOf(
            "title" to title,
            "description" to description,
            "category" to category,
            "date" to date
        )
        // Add a new document with a generated ID
        db.collection("users")
            .add(data)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show()
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
                Toast.makeText(context, "Not Successfully", Toast.LENGTH_SHORT).show()
            }
    }


    val usersDetails = MutableLiveData<List<AkukoDataClass>>()
    fun retrieve(): ArrayList<AkukoDataClass> {
        val users: ArrayList<AkukoDataClass> = ArrayList<AkukoDataClass>()
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    users.add(
                        AkukoDataClass(
                            document.data.getValue("title").toString(),
                            document.data.getValue("description").toString(),
                            document.data.getValue("category").toString(),
                            document.data.getValue("date").toString(),
                        )
                    )

                    usersDetails.value = users
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }

        return users
    }


    val akukousersDetails = MutableLiveData<List<AkukoDataClass>>()
    fun retrieveakuko(): ArrayList<AkukoDataClass> {
        val users: ArrayList<AkukoDataClass> = ArrayList<AkukoDataClass>()
        db.collection("users").whereEqualTo("category", "akuko")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    users.add(
                        AkukoDataClass(
                            document.data.getValue("title").toString(),
                            document.data.getValue("description").toString(),
                            document.data.getValue("category").toString(),
                            document.data.getValue("date").toString(),
                        )
                    )

                    akukousersDetails.value = users
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }

        return users
    }

    val iluusersDetails = MutableLiveData<List<AkukoDataClass>>()
    fun retrieveIlu(): ArrayList<AkukoDataClass> {
        val users: ArrayList<AkukoDataClass> = ArrayList<AkukoDataClass>()
        db.collection("users").whereEqualTo("category", "Ilu").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    users.add(
                        AkukoDataClass(
                            document.data.getValue("title").toString(),
                            document.data.getValue("description").toString(),
                            document.data.getValue("category").toString(),
                            document.data.getValue("date").toString(),
                        )
                    )

                    iluusersDetails.value = users
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }

        return users
    }

    val egwuusersDetails = MutableLiveData<List<AkukoDataClass>>()
    fun retrieveEgwu(): ArrayList<AkukoDataClass> {
        val users: ArrayList<AkukoDataClass> = ArrayList<AkukoDataClass>()
        db.collection("users").whereEqualTo("category", "egwuregwu").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    users.add(
                        AkukoDataClass(
                            document.data.getValue("title").toString(),
                            document.data.getValue("description").toString(),
                            document.data.getValue("category").toString(),
                            document.data.getValue("date").toString(),
                        )
                    )

                    egwuusersDetails.value = users
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }

        return users
    }

}