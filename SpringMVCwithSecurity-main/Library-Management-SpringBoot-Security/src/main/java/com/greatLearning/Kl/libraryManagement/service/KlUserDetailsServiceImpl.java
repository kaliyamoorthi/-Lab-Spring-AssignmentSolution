package com.greatLearning.Kl.libraryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatLearning.Kl.libraryManagement.entity.KlUser;
import com.greatLearning.Kl.libraryManagement.repository.KlUserRepository;
import com.greatLearning.Kl.libraryManagement.security.KlMyUserDetails;

public class KlUserDetailsServiceImpl implements UserDetailsService {

	   @Autowired
	    private KlUserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        KlUser user = userRepository.getUserByUsername(username);
	         
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new KlMyUserDetails(user);
	    }

}
