package com.shree.librarymanagement.controller;

import com.shree.librarymanagement.entity.Issue;
import com.shree.librarymanagement.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping
    public Issue issueBook(@RequestBody Issue issue) {
        return issueService.issueBook(issue);
    }

    @GetMapping
    public List<Issue> getAllIssuedBooks() {
        return issueService.getAllIssuedBooks();
    }

    @GetMapping("/{id}")
    public Optional<Issue> getIssueById(@PathVariable Long id) {
        return issueService.getIssueById(id);
    }

    @PutMapping("/{id}")
    public Issue updateIssue(@PathVariable Long id,
                             @RequestBody Issue issue) {
        return issueService.updateIssue(id, issue);
    }

    @DeleteMapping("/{id}")
    public String deleteIssue(@PathVariable Long id) {
        return issueService.deleteIssue(id);
    }
}