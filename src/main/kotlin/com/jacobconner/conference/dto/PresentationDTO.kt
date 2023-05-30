package com.jacobconner.conference.dto

import com.jacobconner.conference.domain.Author
import com.jacobconner.conference.domain.Section
import java.time.Instant

data class PresentationDTO(
    var id: String?,
    var conferenceId: String,
    var name: String,
    var description: String,
    var authors: List<Author>,
    var notes: List<Section>,
    var date: Instant
)