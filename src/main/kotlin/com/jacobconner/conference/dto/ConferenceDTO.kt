package com.jacobconner.conference.dto

import com.jacobconner.conference.domain.LocationData
import java.time.Instant

data class ConferenceDTO(
    val id: String,
    val name: String,
    val description: String?,
    val website: String?,
    val location: LocationData?,
    val dateStart: Instant?,
    val dateEnd: Instant?,
)