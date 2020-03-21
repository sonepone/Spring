package sone.spring.dao;

import java.util.UUID;

import sone.spring.model.Person;

public interface PersonDao
{
   int insertPerson(UUID id, Person person);
   
   default int insertPerson(Person person)
   {
      UUID id = UUID.randomUUID();
      return insertPerson(id, person);
   }
   

}
