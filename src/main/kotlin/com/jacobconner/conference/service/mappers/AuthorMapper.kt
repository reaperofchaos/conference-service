package com.jacobconner.conference.service.mappers

import com.jacobconner.conference.domain.Author
import com.jacobconner.conference.dto.AuthorDTO

class AuthorMapper {
    fun Author.toAuthorDTO() = AuthorDTO(
        id = id,
        prefix = prefix,
        firstName = firstName,
        middleName = middleName,
        lastName = lastName,
        suffix = suffix
    )

    fun AuthorToAuthorDTO(author: Author): AuthorDTO{
        return author.toAuthorDTO()
    }

    fun AuthorDTOToAuthor(authorDTO: AuthorDTO): Author{
        return authorDTO.toAuthor()
    }

    fun listAuthorToListAuthorDTO(authorList: List<Author>): List<AuthorDTO>{
       var dtoList = mutableListOf<AuthorDTO>()
        authorList.forEach{it->dtoList.add(it.toAuthorDTO())}
        return dtoList;
    }

    fun listAuthorDTOToListAuthor(authorDTOList: List<AuthorDTO>): List<Author>{
        var authorList = mutableListOf<Author>()
        authorDTOList.forEach{it->authorList.add(it.toAuthor())}
        return authorList;
    }

    fun AuthorDTO.toAuthor() = Author(
        id = id,
        prefix = prefix,
        firstName = firstName,
        middleName = middleName,
        lastName = lastName,
        suffix = suffix
    )
}