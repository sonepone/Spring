package sone.spring.demo.config;

import org.springframework.beans.factory.annotation.Autowired;

public class MojTest
{
   @Autowired 
   AppProperties mojaKonfiguracija;
   public void ispisi()
   {
      System.out.println("Opis: "  + mojaKonfiguracija.getDescription() );
   }

}
