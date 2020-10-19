package com.ecomerce.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomerce.webapp.entity.Product;
import com.ecomerce.webapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

}