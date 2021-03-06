package com.dev.akukoifo.util

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dev.akukoifo.model.WordDataClasss
import com.dev.akukoifo.firebase.firestore.CloudFirestoredb

object TranslateLang {
    val usersDetails = MutableLiveData<List<WordDataClasss>>()
    fun translate() {
        val users = arrayListOf("come", "today", "food", "my love")
        CloudFirestoredb.db.collection("words")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {

                    Log.v("akuko_data", document.data.toString())
                    // usersDetails.value = users

                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }

    fun trans(users: ArrayList<WordDataClasss>) {

        usersDetails.value = users

    }

}