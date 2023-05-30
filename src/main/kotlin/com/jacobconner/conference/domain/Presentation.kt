package com.jacobconner.conference.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "presentation")
data class Presentation (
    @Id
    val id: String,
    val conferenceId: String,
    val name: String,
    val description: String,
    val authors: List<Author>,
    val notes: List<Section>,
    val date: Instant
        )