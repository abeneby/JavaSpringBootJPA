package com.jpaway.SpringBootJPA.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaway.SpringBootJPA.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
