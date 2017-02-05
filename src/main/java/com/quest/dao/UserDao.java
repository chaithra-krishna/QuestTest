/**
 * 
 */
package com.quest.dao;

import java.util.List;

import com.quest.model.Person;

/**
 * @author Macbook pro
 *
 */
public interface UserDao {

	public void addUser(Person person);

	public List<Person> getAllUser();

	public boolean isUniquePPS(Person person);
}
