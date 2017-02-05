/**
 * 
 */
package com.quest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.dao.UserDao;
import com.quest.model.Person;

/**
 * @author Macbook pro
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	UserDao userDao;

	public void addUser(Person person) {
		userDao.addUser(person);
	}

	public List<Person> getAllUser() {
		return userDao.getAllUser();
	}

	public boolean isUniquePPS(Person person) {
		return userDao.isUniquePPS(person);
	}

}
