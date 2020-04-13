package sone.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import sone.spring.model.Person;

//import sone.spring.model.Person;

@Repository("fakeDao")
public class  FakePersonDataAccessService
//implements sone.spring.dao.PersonDao
implements PersonDao 
{
   private static List<Person> DB = new ArrayList<Person>();
   
   @Override
   public int insertPerson(UUID id, Person person)
   {
      DB.add(new Person(id, person.getName()));
      return 1;
   }

   @Override
   public List<Person> selectAllPeople()
   {
      // TODO Auto-generated method stub
      return DB;
   }

   @Override
   public int deletePersonById(UUID id)
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int updatePersonById(UUID id)
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public Optional<Person> selectPersonById(UUID id)
   {
      return 
      DB.stream()
        .filter(person -> person.getId().equals(id))
        .findFirst();
      //return null;
   }

   @Override
   public int sonePone()
   {
      // TODO Auto-generated method stub
      return 0;
   }
   

}
