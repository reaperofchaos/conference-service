package com.jacobconner.conference.web.rest

import com.jacobconner.conference.dto.AuthorDTO
import com.jacobconner.conference.service.AuthorService
import com.jacobconner.conference.service.mappers.AuthorMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/author")
class AuthorController(val authorService: AuthorService) {

    val mapper = AuthorMapper()

    @GetMapping("/")
    fun getAllAuthors(): List<AuthorDTO>{
        return mapper.listAuthorToListAuthorDTO(authorService.getAllAuthors())
    }

    @GetMapping("/{id}")
    fun getAuthorById(@PathVariable id: String): AuthorDTO?{
        return authorService.findByAuthorID(id)?.let { mapper.AuthorToAuthorDTO(it) } ?: throw
        ResponseStatusException(HttpStatus.NOT_FOUND, "This author does not exist")
    }

    @DeleteMapping("/{id}")
    fun deleteAuthor(@PathVariable id: String): ResponseEntity<String>{
        return ResponseEntity(authorService.deleteAuthor(id), HttpStatus.OK)
    }

    @PostMapping("/")
    fun createAuthor(@RequestBody author: AuthorDTO): ResponseEntity<String>{
        return ResponseEntity(authorService.createAuthor(mapper.AuthorDTOToAuthor(author)), HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateAuthor(@PathVariable id: String, @RequestBody author: AuthorDTO): ResponseEntity<String>{
        var newAuthor = author
        newAuthor.id = id;
        return ResponseEntity(authorService.updateAuthor(mapper.AuthorDTOToAuthor(newAuthor)), HttpStatus.OK)
    }



}