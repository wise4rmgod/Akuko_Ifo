package com.dev.akukoifo.util

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dev.akukoifo.model.AkukoDataClass

class RetrieveClass {
    val usersDetails = MutableLiveData<List<AkukoDataClass>>()

    fun retrieve(): ArrayList<AkukoDataClass> {
        val users: ArrayList<AkukoDataClass> = ArrayList<AkukoDataClass>()
        CloudFirestoredb.db.collection("users")
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
                    Log.d("TAG", "${document.data.getValue("title")}")
                    document.data.getValue("title")
                    Log.d("TAG", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }

        return users
    }

}