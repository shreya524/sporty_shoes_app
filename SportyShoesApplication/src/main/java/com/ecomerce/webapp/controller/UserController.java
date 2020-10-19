package com.ecomerce.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecomerce.webapp.entity.User;
import com.ecomerce.webapp.exception.UserNotFound;
import com.ecomerce.webapp.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	 @Autowired
	 private UserRepository userRepository;

	 //get all user list
	 @GetMapping("/users")
		public List<User> getAllUsers() {
			return this.userRepository.findAll();
		}
	 
	 //Gets users by id
	 @GetMapping("/users/{id}")
		public User getUsersById(@PathVariable(value = "id") long userId) {
			return this.userRepository.findById(userId)
					.orElseThrow(() -> new UserNotFound("User Not found wit id " + userId));
		}
	
	 //add user
	 @PostMapping("/users")
	  public User createUser(@RequestBody User user) {
	    return userRepository.save(user);
	  }
	 //update user
	 @PutMapping("/users/{id}")
		public User updateUser(@RequestBody User user, @PathVariable(value = "id") long userId) {
			User fetchedUser = this.userRepository.findById(userId)
					.orElseThrow(() -> new UserNotFound("User Not found wit id " + userId));
			fetchedUser.setFname(user.getFname());
			fetchedUser.setLname(user.getLname());
	        fetchedUser.setEmailId(user.getEmailId());
          fetchedUser.setPwd(user.getPwd());
	 
			return this.userRepository.save(fetchedUser);
		}
	 @DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable(value = "id") long userId) {
			User fetchedUser = this.userRepository.findById(userId)
					.orElseThrow(() -> new UserNotFound("User Not found wit id " + userId));
			this.userRepository.delete(fetchedUser);
		}
}
