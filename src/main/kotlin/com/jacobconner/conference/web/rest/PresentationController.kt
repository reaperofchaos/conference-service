package com.jacobconner.conference.web.rest

import com.jacobconner.conference.dto.AuthorDTO
import com.jacobconner.conference.dto.PresentationDTO
import com.jacobconner.conference.service.AuthorService
import com.jacobconner.conference.service.PresentationService
import com.jacobconner.conference.service.mappers.AuthorMapper
import com.jacobconner.conference.service.mappers.PresentationMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/presentation")
class PresentationController(val presentationService: PresentationService) {

    val mapper = PresentationMapper()

    @GetMapping("/")
    fun getAllPresentations(): List<PresentationDTO>{
        return mapper.listPresentationToListPresentationDTO(presentationService.getAllPresentations())
    }

    @GetMapping("/{id}")
    fun getPresentationById(@PathVariable id: String): PresentationDTO?{
        return presentationService.findPresentationById(id)?.let { mapper.presentationToPresentationDTO(it) } ?: throw
        ResponseStatusException(HttpStatus.NOT_FOUND, "This presentation does not exist")
    }

    @DeleteMapping("/{id}")
    fun deletePresentation(@PathVariable id: String): ResponseEntity<String>{
        return ResponseEntity(presentationService.deletePresentation(id), HttpStatus.OK)
    }

    @PostMapping("/")
    fun createPresentation(@RequestBody presentation: PresentationDTO): ResponseEntity<String>{
        return ResponseEntity(presentationService.createPresentation(mapper.presentationDTOToPresentation(presentation)), HttpStatus.OK)
    }

    @PostMapping("/{id}")
    fun updatePresentation(@PathVariable id: String, @RequestBody presentation: PresentationDTO): ResponseEntity<String>{
        if(presentationService.findPresentationById(id) !== null){
            return ResponseEntity(presentationService.updatePresentation(mapper.presentationDTOToPresentation(presentation)), HttpStatus.OK)
        }
        return ResponseEntity("Unable to update. Presentation was not found", HttpStatus.NOT_FOUND)
    }



}