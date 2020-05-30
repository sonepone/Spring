package tacos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient.Type;
import com.sun.jna.platform.win32.Advapi32Util;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignTacoController
{
   @GetMapping
   public String showDesignForm(Model model)
   {
      System.out.println("Ovdje sam");
      System.out.println("--------------------------------------------------");
      System.out.println("Vracal ovaj ista >"+Advapi32Util.getCurrentUserGroups()+"<");
      System.out.println("--------------------------------------------------");

      for (Advapi32Util.Account account : Advapi32Util.getCurrentUserGroups()) {
         System.out.println(account.fqn);
     }
         
      List<Ingredient> listaSastojaka = Arrays.asList(
            new Ingredient("FLTO", "Fluor Tortilla", Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Type.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Type.CHEESE),
            new Ingredient("JACK", "Monterey Jack", Type.CHEESE),
            new Ingredient("SLSA", "Salsa", Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
            );
      Ingredient.Type[] tipovi = Ingredient.Type.values();
      for(Type type : tipovi)
      {
         List<Ingredient> subList = filterByType(type, listaSastojaka);
         model.addAttribute(type.toString().toLowerCase(), subList);
      }
      model.addAttribute("design", new Taco());
      log.info("My info");
      log.error("My error");
      return "design";
   }
   @PostMapping
   public String postIrajse(Taco design)
   {
      System.out.println("Evo me: ");
      System.out.println("design = " + design.getName());
      return "sone";
   }
   
   public List<Ingredient> filterByType(Ingredient.Type type, List<Ingredient> list)
   {
      return 
      list.stream().filter(  (sastojak) -> {return sastojak.getType().equals(type);}   )
                   .collect(Collectors.toList());
      
      /*
       * return ingredients .stream() .filter(x -> x.getType().equals(type))
       * .collect(Collectors.toList());
       */      
   }

}
