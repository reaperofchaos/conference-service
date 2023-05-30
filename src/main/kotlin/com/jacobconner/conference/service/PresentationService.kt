package com.jacobconner.conference.service

import com.jacobconner.conference.domain.Presentation

interface PresentationService {

    fun getAllPresentations(): List<Presentation>

    fun findPresentationById(id: String): Presentation?

    fun deletePresentation(id: String): String

    fun createPresentation(presentation: Presentation): String

    fun updatePresentation(presentation: Presentation): String
}