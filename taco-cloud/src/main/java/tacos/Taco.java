package tacos;
 
import java.util.Date;
import java.util.List;
 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import lombok.Data;
 
@Data
public class Taco
{
   private Long id;
   private Date createdAt;
 
   @NotNull(message = "{taco.name.not_null}")
   @Size(min=5, message = "{taco.name.min_length}")
   private String name;
   @Size(min = 1, message = "{taco.ingredients.min_length}")
   private List<String> ingredients;
}