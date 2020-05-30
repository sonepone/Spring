package tacos;
 
 
 
import java.util.Date;
 
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
 
import org.hibernate.validator.constraints.CreditCardNumber;
 
import lombok.Data;
 
@Data
public class Order
{
   private Long id;
   private Date placedAt;
   @NotBlank(message = "{order.name.not_blank}")
   private String name;
   @NotBlank(message = "{order.street.not_blank}")
   private String street;
   @NotBlank(message = "{order.city.not_blank}")
   private String city;
   @NotBlank(message = "{order.state.not_blank}")
   private String state;
   @NotBlank(message = "{order.zip.not_blank}")
   private String zip;
   // @CreditCardNumber(message = "{order.ccNumber.CreditCardNumber}")
   private String ccNumber;
   @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", message = "Datum isteka neispravan.")
   private String ccExpiration;
   private String ccCVV;
}