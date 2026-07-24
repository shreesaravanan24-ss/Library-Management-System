package com.shree.librarymanagement.controller;

import com.shree.librarymanagement.entity.Librarian;
import com.shree.librarymanagement.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @PostMapping
    public Librarian addLibrarian(@RequestBody Librarian librarian) {
        return librarianService.addLibrarian(librarian);
    }

    @GetMapping
    public List<Librarian> getAllLibrarians() {
        return librarianService.getAllLibrarians();
    }

    @GetMapping("/{id}")
    public Optional<Librarian> getLibrarianById(@PathVariable Long id) {
        return librarianService.getLibrarianById(id);
    }

    @PutMapping("/{id}")
    public Librarian updateLibrarian(@PathVariable Long id,
                                     @RequestBody Librarian librarian) {
        return librarianService.updateLibrarian(id, librarian);
    }

    @DeleteMapping("/{id}")
    public String deleteLibrarian(@PathVariable Long id) {
        return librarianService.deleteLibrarian(id);
    }
}