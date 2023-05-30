package com.jacobconner.conference.service

import Conference

interface ConferenceService {

    fun getAllConferences(): List<Conference>

    fun findConferenceById(id: String): Conference?

    fun deleteConference(id: String): String

    fun createConference(conference: Conference): String

    fun updateConference(conference: Conference): String
}