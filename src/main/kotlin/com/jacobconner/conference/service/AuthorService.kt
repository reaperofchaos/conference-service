package com.jacobconner.conference.service

import com.jacobconner.conference.domain.Author

interface AuthorService {

    fun getAllAuthors(): List<Author>

    fun findByAuthorID(id: String): Author?

    fun deleteAuthor(id: String): String

    fun createAuthor(author: Author): String

    fun updateAuthor( author: Author): String
}