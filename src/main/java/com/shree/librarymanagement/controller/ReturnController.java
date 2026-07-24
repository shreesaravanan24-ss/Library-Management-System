package com.shree.librarymanagement.controller;

import com.shree.librarymanagement.entity.ReturnBook;
import com.shree.librarymanagement.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/returns")
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @PostMapping
    public ReturnBook returnBook(@RequestBody ReturnBook returnBook) {
        return returnService.returnBook(returnBook);
    }

    @GetMapping
    public List<ReturnBook> getAllReturnedBooks() {
        return returnService.getAllReturnedBooks();
    }

    @GetMapping("/{id}")
    public Optional<ReturnBook> getReturnById(@PathVariable Long id) {
        return returnService.getReturnById(id);
    }

    @PutMapping("/{id}")
    public ReturnBook updateReturn(@PathVariable Long id,
                                   @RequestBody ReturnBook returnBook) {
        return returnService.updateReturn(id, returnBook);
    }

    @DeleteMapping("/{id}")
    public String deleteReturn(@PathVariable Long id) {
        return returnService.deleteReturn(id);
    }
}