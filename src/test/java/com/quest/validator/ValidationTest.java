package com.quest.validator;

import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.quest.model.Person;
import com.quest.service.PersonService;

/**
 * @author Macbook pro
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidationTest {

	@InjectMocks
	private UserFormValidator validator;

	@Mock
	private PersonService personService;

	Person person = null;

	public Errors errors;

	@Before
	public void test() {
		person = new Person();
		person.setCreatedDate(new Date());
		person.setDobInString("1990-06-28");
		person.setMobileNumber("081234567");
		person.setName("chaithra");
		person.setPpsNumber("12345");
		errors = new BeanPropertyBindingResult(person, "person");
	}

	@Test
	public void testValidate() {
		validator.validate(person, errors);
		assertFalse(errors.hasErrors());
	}
}
