package sone.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
   // doadt komentar
   public int addPerson(Person person)
   {
      return personDao.insertPerson(person);
   }
   
   public List<Person> getAllPeople()
   {
      return personDao.selectAllPeople();
   }
   
   public Optional<Person> getPersonbyId(UUID id)  
   {
      return personDao.selectPersonById(id);
   }
}
