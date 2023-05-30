package com.jacobconner.conference.dto

import com.jacobconner.conference.domain.LocationData
import java.time.Instant

data class ConferenceDTO(
    var id: String?,
    var name: String,
    var description: String?,
    var website: String?,
    var location: LocationData?,
    var dateStart: String?,
    var dateEnd: String?,
)