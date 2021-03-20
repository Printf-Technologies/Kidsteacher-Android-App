package com.printf.kidsteacher.activity

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    var intentObservable = MutableLiveData<Intent>()
    fun setIntent(intent: Intent){
        intentObservable.value = intent
    }

    var repeatPlayObservable = MutableLiveData<Boolean>()
    fun setRepeatPlay(isRepeatPlay: Boolean){
        repeatPlayObservable.value = isRepeatPlay
    }

    var isSpeakerOnObservable = MutableLiveData<Boolean>().apply { value = true }
    fun setIsSpeakerOn(){
        isSpeakerOnObservable.value = !isSpeakerOnObservable.value!!
    }

    var subCategoryObservable = MutableLiveData<String>()
    fun setSubCategory(subCategory: String) {
        subCategoryObservable.value = subCategory
    }

    var positionObservable = MutableLiveData<Int>()
    fun setPosition(position: Int) {
        positionObservable.value = position
    }

    var searchObservable = MutableLiveData<String>()
    fun setOnSearch(search: String) {
        searchObservable.value = search
    }


}