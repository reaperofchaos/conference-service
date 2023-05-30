package com.jacobconner.conference.web.rest

import com.jacobconner.conference.dto.AuthorDTO
import com.jacobconner.conference.dto.ConferenceDTO
import com.jacobconner.conference.dto.PresentationDTO
import com.jacobconner.conference.service.AuthorService
import com.jacobconner.conference.service.ConferenceService
import com.jacobconner.conference.service.PresentationService
import com.jacobconner.conference.service.mappers.AuthorMapper
import com.jacobconner.conference.service.mappers.ConferenceMapper
import com.jacobconner.conference.service.mappers.PresentationMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/conference")
class ConferenceController(val conferenceService: ConferenceService) {

    val mapper = ConferenceMapper()

    @GetMapping("/")
    fun getAllConferences(): List<ConferenceDTO>{
        return mapper.listConferenceToListConferenceDTO(conferenceService.getAllConferences())
    }

    @GetMapping("/{id}")
    fun getConferenceById(@PathVariable id: String): ConferenceDTO?{
        return conferenceService.findConferenceById(id)?.let { mapper.ConferenceToConferenecDTO(it) } ?: throw
        ResponseStatusException(HttpStatus.NOT_FOUND, "This presentation does not exist")
    }

    @DeleteMapping("/{id}")
    fun deleteConference(@PathVariable id: String): ResponseEntity<String>{
        return ResponseEntity(conferenceService.deleteConference(id), HttpStatus.OK)
    }

    @PostMapping("/")
    fun createConference(@RequestBody conference: ConferenceDTO): ResponseEntity<String>{
        return ResponseEntity(conferenceService.createConference(mapper.ConferenceDTOToConference(conference)), HttpStatus.OK)
    }

    @PostMapping("/{id}")
    fun updateConference(@PathVariable id: String, @RequestBody conference: ConferenceDTO): ResponseEntity<String>{
        if(conferenceService.findConferenceById(id) !== null){
            return ResponseEntity(conferenceService.updateConference(mapper.ConferenceDTOToConference(conference)), HttpStatus.OK)
        }
        return ResponseEntity("Unable to update. Conference was not found", HttpStatus.NOT_FOUND)
    }



}