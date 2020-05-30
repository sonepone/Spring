package tacos;
 
import java.util.List;
 
import javax.validation.Valid;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController
{
   @GetMapping("/current")
   public String orderForm(Model model)
   {
      model.addAttribute("order", new Order());
      return "orderForm";
     
   }
   @PostMapping
   public String postAnOrder(@Valid Order pOrder, Errors errors)
   {
      if(errors.hasErrors())
      {
         for(ObjectError error : errors.getAllErrors())
         {
            log.error("Greska: " + error.getDefaultMessage());
         }
        
         return "orderForm";
      }
      log.info("Order: " + pOrder);
      return "redirect:/";
   }
 
}