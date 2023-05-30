package com.jacobconner.conference.dto

data class AuthorDTO (
    var id: String?,
    var prefix: String?,
    var firstName: String,
    var middleName: String?,
    var lastName: String,
    var suffix: String?
)