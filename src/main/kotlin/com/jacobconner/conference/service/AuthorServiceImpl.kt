package com.jacobconner.conference.service

import com.jacobconner.conference.domain.Author
import com.jacobconner.conference.repository.AuthorRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(val authorRepository: AuthorRepository): AuthorService {

    override fun getAllAuthors(): List<Author>{
        return authorRepository.findAll()
    }

    override fun findByAuthorID(id: String): Author?{
        return authorRepository.findByIdOrNull(id)
    }

    override fun deleteAuthor(id: String): String {
        authorRepository.deleteById(id)
        return "Successfully deleted the author with the id, ${id}";
    }

    override fun createAuthor(author: Author): String {
        authorRepository.insert(author)
        return "Author ${author.firstName} ${author.lastName} was successfully added."
    }

    override fun updateAuthor(author: Author): String{
        authorRepository.save(author)
        return "Author ${author.firstName} ${author.lastName} was successfully updated."

    }


}