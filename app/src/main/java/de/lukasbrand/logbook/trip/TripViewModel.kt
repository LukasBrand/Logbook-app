package de.lukasbrand.logbook.trip

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TripViewModel : ViewModel() {

    val trip = MutableLiveData(Trip())
}