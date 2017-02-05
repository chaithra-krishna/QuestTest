/**
 * 
 */
package com.quest.service;

import java.util.List;

import com.quest.model.Person;

/**
 * @author Macbook pro
 *
 */
public interface PersonService {

	public void addUser(Person person);

	public List<Person> getAllUser();

	public boolean isUniquePPS(Person person);
}
