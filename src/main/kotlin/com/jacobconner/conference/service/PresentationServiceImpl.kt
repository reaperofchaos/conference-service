package com.jacobconner.conference.service

import com.jacobconner.conference.domain.Presentation
import com.jacobconner.conference.repository.PresentationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PresentationServiceImpl(val presentationRepository: PresentationRepository): PresentationService {

    override fun getAllPresentations(): List<Presentation>{
        return presentationRepository.findAll()
    }

    override fun findPresentationById(id: String): Presentation?{
        return presentationRepository.findByIdOrNull(id)
    }

    override fun deletePresentation(id: String): String {
        presentationRepository.deleteById(id)
        return "The presentation with the id, ${id} has been deleted."
    }

    override fun createPresentation(presentation: Presentation): String {
        presentationRepository.insert(presentation)
        return "The presentation, ${presentation.name} has been created."

    }

    override fun updatePresentation(presentation: Presentation): String{
        presentationRepository.save(presentation)
        return "The presentation, ${presentation.name} has been updated."
    }


}