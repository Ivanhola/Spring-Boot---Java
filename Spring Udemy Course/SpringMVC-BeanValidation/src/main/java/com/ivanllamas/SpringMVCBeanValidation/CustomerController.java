
package com.ivanllamas.SpringMVCBeanValidation;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @RequestMapping("/showForm")
    public String customerForm(Model theModel){
        
        //add a customer object to our model attribute and the attribute is named 'customerObj'
        theModel.addAttribute("customerObj", new Customer());
        
        return "customer-form";
    }
    
    
    
    //perform validation after the form is submitted. use @Valid to check if our model attribute had any erros, 
    //will bind the result of validation to theBindResult.
    
    @RequestMapping("/processForm")
    public String processCustomerForm(@Valid @ModelAttribute("customerObj") Customer theCustomer, 
            BindingResult theBindResult){
        
        System.out.println("The customer last name: |" + theCustomer.getLastName() + "|");
        
    if(theBindResult.hasErrors()){
        return "customer-form";
    }else{
        return "customer-confirmation";
    }    
        
        
        
        
    }

}
