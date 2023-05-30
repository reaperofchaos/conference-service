package com.jacobconner.conference.service

import Conference
import com.jacobconner.conference.repository.ConferenceRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ConferenceServiceImpl(val conferenceRepository: ConferenceRepository): ConferenceService {

    override fun getAllConferences(): List<Conference>{
        return conferenceRepository.findAll()
    }

    override fun findConferenceById(id: String): Conference?{
        return conferenceRepository.findByIdOrNull(id)
    }

    override fun deleteConference(id: String): String {
        conferenceRepository.deleteById(id)
        return "The conference with the id, ${id} was successfully deleted."
    }

    override fun createConference(conference: Conference): String {
        conferenceRepository.insert(conference)
        return "The conference, ${conference.name} was successfully created."

    }

    override fun updateConference(conference: Conference): String{
        conferenceRepository.save(conference)
        return "The conference, ${conference.name} was successfully created."

    }


}