package com.jacobconner.conference.repository

import Conference
import org.springframework.data.mongodb.repository.MongoRepository

interface ConferenceRepository: MongoRepository<Conference, String> {
}