package com.example.nativeandroid.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nativeandroid.data.CoworkingSpace

class DetailsViewModel : ViewModel() {
    var detailsData = MutableLiveData<CoworkingSpace>()
}