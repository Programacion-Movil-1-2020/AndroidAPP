package com.itnl.expotech.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itnl.expotech.model.Speaker
import com.itnl.expotech.network.Callback
import com.itnl.expotech.network.FirestoreService

class SpeakersViewModel : ViewModel() {
    val firestoreService = FirestoreService()
    var listSpeakers : MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()


    fun refresh() {
        getSpeakersFromFirebase()
    }

    fun getSpeakersFromFirebase()  {
        firestoreService.getSpeakers(object: Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>?) {
                listSpeakers.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    private fun processFinished() {
        isLoading.value = true
    }

}