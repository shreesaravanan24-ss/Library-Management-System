package com.shree.librarymanagement.service;

import com.shree.librarymanagement.entity.ReturnBook;
import com.shree.librarymanagement.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReturnService {

    @Autowired
    private ReturnRepository returnRepository;

    public ReturnBook returnBook(ReturnBook returnBook) {
        return returnRepository.save(returnBook);
    }

    public List<ReturnBook> getAllReturnedBooks() {
        return returnRepository.findAll();
    }

    public Optional<ReturnBook> getReturnById(Long id) {
        return returnRepository.findById(id);
    }

    public ReturnBook updateReturn(Long id, ReturnBook updatedReturn) {

        ReturnBook returnBook = returnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Return record not found"));

        returnBook.setIssueId(updatedReturn.getIssueId());
        returnBook.setReturnDate(updatedReturn.getReturnDate());
        returnBook.setFineAmount(updatedReturn.getFineAmount());
        returnBook.setStatus(updatedReturn.getStatus());

        return returnRepository.save(returnBook);
    }

    public String deleteReturn(Long id) {
        returnRepository.deleteById(id);
        return "Return record deleted successfully!";
    }
}