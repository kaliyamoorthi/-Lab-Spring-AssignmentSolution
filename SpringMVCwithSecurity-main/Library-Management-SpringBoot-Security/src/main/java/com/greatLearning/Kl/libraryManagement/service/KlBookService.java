package com.greatLearning.Kl.libraryManagement.service;

import java.util.List;

import com.greatLearning.Kl.libraryManagement.entity.KlBook;


public interface KlBookService {
	public List<KlBook> findAll();

	public KlBook findById(int theId);

	public void save(KlBook theBook);

	public void deleteById(int theId);

	public List<KlBook> searchBy(String name, String author);

}
