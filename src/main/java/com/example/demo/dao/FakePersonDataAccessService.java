package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author RakhmedovRS
 * @created 08-Nov-19
 */
@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDAO
{
	private static List<Person> DB = new ArrayList<>();

	@Override
	public int insert(UUID id, Person person)
	{
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> selectAllPeople()
	{
		return DB;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id)
	{
		return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
	}

	@Override
	public int deletePersonById(UUID id)
	{
		Optional<Person> person = selectPersonById(id);
		if (person.isPresent())
		{
			DB.remove(person.get());
			return 1;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public int updatePersonById(UUID id, Person updatedPerson)
	{
		return selectPersonById(id).map(person ->
		{
			int indexOfPerson = DB.indexOf(person);
			if (indexOfPerson >= 0)
			{
				DB.set(indexOfPerson, new Person(person.getId(), updatedPerson.getName()));
				return 1;
			}
			return 0;
		}).orElse(0);
	}
}
