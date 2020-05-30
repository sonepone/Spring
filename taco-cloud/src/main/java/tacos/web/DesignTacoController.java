package tacos.web;
 
import java.util.List;
import java.util.stream.Collectors;
 
import tacos.Ingredient;
import tacos.Ingredient.Type;
 
public class DesignTacoController
{
 
   private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type)
   {
      return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
   }
 
}