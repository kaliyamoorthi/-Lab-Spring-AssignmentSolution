package com.greatLearning.Kl.libraryManagement.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class KlUser {

   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name="username")
   private String username;
   @Column(name="password")
   private String password;
    
   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinTable(
           name = "users_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id")
           )
   private List<KlRole> roles = new ArrayList<>();

public String getUsername() {
	// TODO Auto-generated method stub
	return null;
}

public String getPassword() {
	// TODO Auto-generated method stub
	return null;
}

public List<KlRole> getRoles() {
	// TODO Auto-generated method stub
	return null;
}

   


}

