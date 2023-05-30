package com.jacobconner.conference.dto

data class AuthorDTO (
    val id: String?,
    val prefix: String?,
    val firstName: String,
    val middleName: String?,
    val lastName: String,
    val suffix: String?
)