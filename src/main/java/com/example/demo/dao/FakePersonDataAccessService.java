package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author RakhmedovRS
 * @created 08-Nov-19
 */
public class FakePersonDataAccessService implements PersonDAO
{
	private static List<Person> DB = new ArrayList<>();

	@Override
	public int insert(UUID id, Person person)
	{
		DB.add(new Person(id, person.getName()));
		return 1;
	}
}
