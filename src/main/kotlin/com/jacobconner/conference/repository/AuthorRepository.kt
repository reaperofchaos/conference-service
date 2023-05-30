package com.jacobconner.conference.repository

import com.jacobconner.conference.domain.Author
import org.springframework.data.mongodb.repository.MongoRepository

interface AuthorRepository: MongoRepository<Author, String> {

}