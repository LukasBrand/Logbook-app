package de.lukasbrand.logbook.trip

import androidx.lifecycle.ViewModel

class TripListViewModel : ViewModel() {

    val trips : MutableList<Trip> = mutableListOf()
}