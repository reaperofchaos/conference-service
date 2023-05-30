package com.jacobconner.conference.service.mappers

import com.jacobconner.conference.domain.Author
import com.jacobconner.conference.domain.Presentation
import com.jacobconner.conference.dto.AuthorDTO
import com.jacobconner.conference.dto.PresentationDTO

class PresentationMapper {
    fun Presentation.toPresentationDTO() = PresentationDTO(
        id = id,
        conferenceId = conferenceId,
        name = name,
        description = description,
        authors = authors,
        notes = notes,
        date = date
    )

    fun presentationToPresentationDTO(presentation: Presentation): PresentationDTO{
        return presentation.toPresentationDTO()
    }

    fun presentationDTOToPresentation(presentationDTO: PresentationDTO): Presentation{
        return presentationDTO.toPresentation()
    }

    fun listPresentationToListPresentationDTO(presentationList: List<Presentation>): List<PresentationDTO>{
       var dtoList = mutableListOf<PresentationDTO>()
        presentationList.forEach{it->dtoList.add(it.toPresentationDTO())}
        return dtoList;
    }

    fun listPresentationDTOToListPresentation(presentationDTOList: List<PresentationDTO>): List<Presentation>{
        var presentationList = mutableListOf<Presentation>()
        presentationDTOList.forEach{it->presentationList.add(it.toPresentation())}
        return presentationList;
    }

    fun  PresentationDTO.toPresentation() =  Presentation(
        id = id,
        conferenceId = conferenceId,
        name = name,
        description = description,
        authors = authors,
        notes = notes,
        date = date
    )
}