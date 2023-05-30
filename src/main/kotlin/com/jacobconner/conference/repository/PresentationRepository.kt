package com.jacobconner.conference.repository

import com.jacobconner.conference.domain.Presentation
import org.springframework.data.mongodb.repository.MongoRepository

interface PresentationRepository: MongoRepository<Presentation, String> {
}