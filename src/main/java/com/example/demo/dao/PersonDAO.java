package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.UUID;

/**
 * @author RakhmedovRS
 * @created 08-Nov-19
 */
public interface PersonDAO
{
	int insert(UUID id, Person person);

	default int insertPerson(Person person)
	{
		UUID id = UUID.randomUUID();
		return insert(id, person);
	}
}
