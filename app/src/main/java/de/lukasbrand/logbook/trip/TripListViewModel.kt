package de.lukasbrand.logbook.trip

import androidx.lifecycle.ViewModel

class TripListViewModel : ViewModel() {

    var trips : MutableList<Trip> = mutableListOf()
}