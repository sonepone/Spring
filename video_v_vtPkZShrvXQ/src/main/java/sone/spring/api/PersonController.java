package sone.spring.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
   
   @GetMapping(path = "/{id}/{adresa}")
   public Person getPersonbyId(@PathVariable("id")  UUID id, @PathVariable("adresa") String pAdresa)
   {
      System.out.println("pAdresa >" + pAdresa + "<");
      return personService.getPersonbyId(id).orElse(null);
   }

   
}
