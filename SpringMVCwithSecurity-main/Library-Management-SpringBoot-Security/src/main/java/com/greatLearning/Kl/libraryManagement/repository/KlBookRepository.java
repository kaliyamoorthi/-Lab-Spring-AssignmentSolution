package com.greatLearning.Kl.libraryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.Kl.libraryManagement.entity.KlBook;

public interface KlBookRepository extends JpaRepository<KlBook, Integer> {

	List<KlBook> findByNameContainsAndAuthorContainsAllIgnoreCase(String name,String author);
	
}
