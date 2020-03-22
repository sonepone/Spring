package tacos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient.Type;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignTacoController
{
   @GetMapping
   public String showDesignForm(Model model)
   {
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
