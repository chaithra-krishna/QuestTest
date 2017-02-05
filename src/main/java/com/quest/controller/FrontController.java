/**
 * 
 */
package com.quest.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quest.model.Person;
import com.quest.service.PersonService;
import com.quest.validator.UserFormValidator;

/**
 * @author Macbook pro
 *
 */
@Controller
public class FrontController {

	@Autowired
	UserFormValidator userFormValidator;

	@Autowired
	PersonService personService;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	@GetMapping("/welcome")
	public String hello(Model model) {

		model.addAttribute("name", "John Doe");

		return "welcome";
	}

	@GetMapping("/addPerson")
	public String getNewPerson(Model model) {
		Person person = new Person();
		model.addAttribute("userForm", person);
		return "person";
	}

	@GetMapping("/getAllPersons")
	public String getAllPerson(Model model) {

		List<Person> userList = personService.getAllUser();
		System.out.println("------------------");
		System.out.println(userList);
		if (null == userList || userList.isEmpty()) {
			model.addAttribute("noPerson", "No details available");
		} else {
			Collections.sort(userList);
			model.addAttribute("persons", userList);
		}
		return "personList";
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("userForm") @Validated Person person, BindingResult result, Model model) {
		System.out.println("save user");
		person.setCreatedDate(new Date());
		if (result.hasErrors()) {
			return "person";
		} else {
			personService.addUser(person);
			System.out.println("---------------------------");
			System.out.println(person);
			model.addAttribute("msg", "User added sucussfully");
			return "welcome";
		}

	}
}
