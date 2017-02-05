/**
 * 
 */
package com.quest.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.quest.model.Person;

/**
 * @author Macbook pro
 *
 */
@Component
public class UserFormValidator implements Validator {

	public boolean supports(Class<?> person) {
		return Person.class.equals(person);
	}

	public void validate(Object target, Errors errors) {
		Person person = (Person) target;

		setUserDate(person);
		System.out.println("Person in validator = " + person);
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -16);
		date = cal.getTime();
		if (null == person.getName() || person.getName().trim().isEmpty()) {
			errors.rejectValue("name", "name.required");
		} else if (person.getName().length() > 25) {
			errors.rejectValue("name", "name.max.char");
		}
		if (null == person.getPpsNumber() || person.getPpsNumber().trim().isEmpty()) {
			errors.rejectValue("ppsNumber", "pps.number.required");
		}
		if (null == person.getDateOfBirth()) {
			errors.rejectValue("dobInString", "date.required");
		} else if (person.getDateOfBirth().after(new Date())) {
			System.out.println("after current date");
			errors.rejectValue("dobInString", "future.date");
		} else if (person.getDateOfBirth().after(date)) {
			System.out.println("date not 16 years old");
			errors.rejectValue("dobInString", "date.older");
		}

		if (null != person.getMobileNumber() && !person.getMobileNumber().trim().isEmpty()
				&& !person.getMobileNumber().startsWith("08")) {
			errors.rejectValue("mobileNumber", "phone.number");
		}

	}

	private void setUserDate(Person person) {
		if (null != person && null != person.getDobInString() && !person.getDobInString().trim().isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dob = sdf.parse(person.getDobInString());
				person.setDateOfBirth(dob);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

	}

}
