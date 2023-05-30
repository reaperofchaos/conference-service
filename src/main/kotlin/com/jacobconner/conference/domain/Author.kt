package com.jacobconner.conference.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "author")
data class Author (
    @Id
    val id: String?,
    val prefix: String?,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val suffix: String?
        )