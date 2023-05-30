package com.jacobconner.conference.service.mappers

import Conference
import com.jacobconner.conference.dto.ConferenceDTO

class ConferenceMapper {
    fun Conference.toConferenceDTO() = ConferenceDTO(
        id = id,
        name = name,
        description = description,
        website = website,
        location = location,
        dateStart = dateStart,
        dateEnd = dateEnd
    )

    fun ConferenceToConferenecDTO(conference: Conference): ConferenceDTO{
        return conference.toConferenceDTO()
    }

    fun ConferenceDTOToConference(conferenceDTO: ConferenceDTO): Conference{
        return conferenceDTO.toConference()
    }

    fun listConferenceToListConferenceDTO(conferenceList: List<Conference>): List<ConferenceDTO>{
       var dtoList = mutableListOf<ConferenceDTO>()
        conferenceList.forEach{it->dtoList.add(it.toConferenceDTO())}
        return dtoList;
    }

    fun listConferenceDTOToListConference(conferenceDTOList: List<ConferenceDTO>): List<Conference>{
        var conferenceList = mutableListOf<Conference>()
        conferenceDTOList.forEach{it->conferenceList.add(it.toConference())}
        return conferenceList;
    }

    fun ConferenceDTO.toConference() = Conference(
        id = id,
        name = name,
        description = description,
        website = website,
        location = location,
        dateStart = dateStart,
        dateEnd = dateEnd
    )
}