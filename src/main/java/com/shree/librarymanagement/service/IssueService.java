package com.shree.librarymanagement.service;

import com.shree.librarymanagement.entity.Issue;
import com.shree.librarymanagement.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public Issue issueBook(Issue issue) {
        return issueRepository.save(issue);
    }

    public List<Issue> getAllIssuedBooks() {
        return issueRepository.findAll();
    }

    public Optional<Issue> getIssueById(Long id) {
        return issueRepository.findById(id);
    }

    public Issue updateIssue(Long id, Issue updatedIssue) {

        Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue record not found"));

        issue.setBookId(updatedIssue.getBookId());
        issue.setMemberId(updatedIssue.getMemberId());
        issue.setIssueDate(updatedIssue.getIssueDate());
        issue.setDueDate(updatedIssue.getDueDate());
        issue.setStatus(updatedIssue.getStatus());

        return issueRepository.save(issue);
    }

    public String deleteIssue(Long id) {
        issueRepository.deleteById(id);
        return "Issue record deleted successfully!";
    }
}