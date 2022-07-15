package com.greatLearning.Kl.libraryManagement.service;



import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.greatLearning.Kl.libraryManagement.entity.KlBook;
import com.greatLearning.Kl.libraryManagement.repository.KlBookRepository;

import java.util.ArrayList;
import java.util.List;





@Service
public class KlBookServiceImpl implements KlBookService {


	@Autowired
	KlBookRepository bookRepository;

	@Override
	public List<KlBook> findAll() {
		// TODO Auto-generated method stub
		List<KlBook> books=bookRepository.findAll();
		return books;
	}

	@Override
	public KlBook findById(int theId) {
		// TODO Auto-generated method stub
		return bookRepository.findById(theId).get();
	}

	@Override
	public void save(KlBook theBook) {
		// TODO Auto-generated method stub
		bookRepository.save(theBook);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(theId);
		
	}

	@Override
	public List<KlBook> searchBy(String name, String author) {
		// TODO Auto-generated method stub
		List<KlBook> books=bookRepository.findByNameContainsAndAuthorContainsAllIgnoreCase(name, author);
		return books;
	}





}