/**
 * 
 */
package com.quest.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.quest.model.Person;

/**
 * @author Macbook pro
 *
 */
@Component
public class UserDaoImpl implements UserDao {

	private Set<Person> personList = new HashSet<Person>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.quest.dao.UserDao#addUser(com.quest.model.Person)
	 */
	public void addUser(Person person) {
		personList.add(person);
	}

	public List<Person> getAllUser() {
		return new ArrayList<Person>(personList);
	}

}
