package com.jacobconner.conference.dto

import com.jacobconner.conference.domain.Author
import com.jacobconner.conference.domain.Section
import java.time.Instant

data class PresentationDTO(
    val id: String,
    val conferenceId: String,
    val name: String,
    val description: String,
    val authors: List<Author>,
    val notes: List<Section>,
    val date: Instant
)