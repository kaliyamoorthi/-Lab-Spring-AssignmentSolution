package com.greatLearning.Kl.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatLearning.Kl.libraryManagement.entity.KlUser;

public interface KlUserRepository extends JpaRepository<KlUser,Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public KlUser getUserByUsername(String username);
}