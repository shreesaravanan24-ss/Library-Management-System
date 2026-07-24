package com.shree.librarymanagement.repository;

import com.shree.librarymanagement.entity.ReturnBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepository extends JpaRepository<ReturnBook, Long> {

}