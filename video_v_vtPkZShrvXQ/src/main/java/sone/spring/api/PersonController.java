package sone.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sone.spring.model.Person;
import sone.spring.service.PersonService;

//import sone.spring.model.Person;
//import sone.spring.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController
{
   private final PersonService personService;

   @Autowired
   public PersonController(PersonService personService)
   {
      super();
      this.personService = personService;
   }
   
   @PostMapping
   public void addPerson(@RequestBody Person person)
   {
      System.out.println("Tu sam: " + person);
      this.personService.addPerson(person);
   }
   
   @GetMapping
   public List<Person> getAllPeople()
   {
      return personService.getAllPeople();
   }

   
}
