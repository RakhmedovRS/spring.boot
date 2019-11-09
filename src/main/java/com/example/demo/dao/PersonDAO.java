package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
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

	List<Person> selectAllPeople();

	Optional<Person> selectPersonById(UUID id);

	int deletePersonById(UUID id);

	int updatePersonById(UUID id, Person person);
}
