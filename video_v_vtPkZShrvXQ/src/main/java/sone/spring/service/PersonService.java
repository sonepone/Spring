package sone.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sone.spring.dao.PersonDao;
import sone.spring.model.Person;

@Service
public class PersonService
{
   private final PersonDao personDao;
  
   @Autowired
   public PersonService(@Qualifier("fakeDao")  PersonDao personDao)
   {
      super();
      this.personDao = personDao;
   }

   public int addPerson(Person person)
   {
      return personDao.insertPerson(person);
   }
}
