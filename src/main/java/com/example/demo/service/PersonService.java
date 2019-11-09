package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author RakhmedovRS
 * @created 08-Nov-19
 */
@Service
public class PersonService
{
	private final PersonDAO personDAO;

	@Autowired
	public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO)
	{
		this.personDAO = personDAO;
	}

	public int addPerson(Person person)
	{
		return personDAO.insertPerson(person);
	}

	public List<Person> getAllPeople()
	{
		return personDAO.selectAllPeople();
	}

	public Optional<Person> getPersonById(UUID id)
	{
		return personDAO.selectPersonById(id);
	}
}
