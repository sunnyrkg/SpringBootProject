package com.zycus.jtest;
import java.util.HashSet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zycus.boot.entities.Skill;
import com.zycus.boot.entities.User;
import com.zycus.boot.repositories.UserRepository;
import com.zycus.boot.services.UserService;

public class JTest {
	@Autowired
	UserService userService;
	@Test
	public void testUserService()
	{
		
	}
}
