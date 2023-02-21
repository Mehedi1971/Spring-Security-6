package com.mahedi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahedi.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByUsername(String username);
//	public User findByUsername(String username);

}
