package de.lukasbrand.logbook.trip

import java.time.Instant
import java.util.*

data class Trip(
    var kmBegin: Int = 0,
    var kmEnd: Int = 0,
    var departureLocation: String = "",
    var arrivalLocation: String = "",
    var startTime: Date = Date.from(Instant.now()),
    var endTime: Date = Date.from(Instant.now())
)
