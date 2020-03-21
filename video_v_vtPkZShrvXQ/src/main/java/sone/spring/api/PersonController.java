package sone.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sone.spring.model.Person;
import sone.spring.service.PersonService;

@Controller
public class PersonController
{
   private final PersonService personService;

   @Autowired
   public PersonController(PersonService personService)
   {
      super();
      this.personService = personService;
   }
   
   public void addPerson(Person person)
   {
      this.personService.addPerson(person);
   }
   

}
