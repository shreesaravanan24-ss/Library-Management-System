package com.shree.librarymanagement.service;

import com.shree.librarymanagement.entity.Librarian;
import com.shree.librarymanagement.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    public Librarian addLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    public Optional<Librarian> getLibrarianById(Long id) {
        return librarianRepository.findById(id);
    }

    public Librarian updateLibrarian(Long id, Librarian updatedLibrarian) {

        Librarian librarian = librarianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Librarian not found"));

        librarian.setName(updatedLibrarian.getName());
        librarian.setEmail(updatedLibrarian.getEmail());
        librarian.setPhone(updatedLibrarian.getPhone());
        librarian.setPassword(updatedLibrarian.getPassword());

        return librarianRepository.save(librarian);
    }

    public String deleteLibrarian(Long id) {
        librarianRepository.deleteById(id);
        return "Librarian deleted successfully!";
    }
}