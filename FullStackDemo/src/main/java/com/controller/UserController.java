package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/readAll")
	List<User> readAll() {
		return userService.readUser();
	}

	@GetMapping(value = "/readAllById/{userId}")
	public User readById(@PathVariable ("userId") int userId) {
		System.out.println("user id search:" +userId);
		return userService.readUserById(userId);
	}
	@GetMapping(value = "/readAllByName/{userName}")
	public User readById(@PathVariable ("userName") String userName) {
		System.out.println("user id search:" +userName);
		return userService.readUserByName(userName);
	}
@PostMapping(value="/createUserDetail")
	public User createUserDetail(@RequestBody User user) {
   
		return this.userService.createUser(user);
	}
@PutMapping(value="/update")
public User update(@RequestBody User user)
{
 return this.userService.updateUser(user);
}
@DeleteMapping(value="/delete")
public User delete(@RequestParam("userId") int userId)
{
	return this.userService.deleteById(userId);
}
@DeleteMapping(value="/deleteBYName")
public User deleteByName(@RequestParam("userName") String userName)
{
	return this.userService.deleteByName(userName);
}


}
