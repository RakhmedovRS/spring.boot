package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;

/**
 * @author RakhmedovRS
 * @created 08-Nov-19
 */
public class PersonService
{
	private final PersonDAO personDAO;

	public PersonService(PersonDAO personDAO)
	{
		this.personDAO = personDAO;
	}

	public int addPerson(Person person)
	{
		return personDAO.insertPerson(person);
	}
}
