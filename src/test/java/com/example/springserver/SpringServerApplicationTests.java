package com.example.springserver;

import com.example.springserver.Dao.UserDao;
import com.example.springserver.Models.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringServerApplicationTests
{
	private UserDao userDao;
	@Test
	void contextLoads() {
	}
	void addUserTest(){
		User user = new User();
		user.setFio("Булат Азатович");
		user.setLogin("bulat");
		user.setRole("dangeon master");
		user.setPassword("1231231");
		userDao.save(user);
	}
}
