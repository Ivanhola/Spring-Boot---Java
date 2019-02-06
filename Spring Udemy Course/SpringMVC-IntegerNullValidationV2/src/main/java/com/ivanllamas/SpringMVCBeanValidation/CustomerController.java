
package com.ivanllamas.SpringMVCBeanValidation;

import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    
    //add an initbinder annotation to convert trim input strings
    //trim removes leading and trailing whitespaces to resolve our issue for validation with whitespace
    
    
    /*InitBinder will always have WebDataBinder in our parameters, this method will always be called
    for every web request to this controller (whenever someone is in /custom/XXXXXX this method is called)
    it creates a StringTrimmerEditor and trims whitespace if (true), and registers it to dataBinder, to look for
    String classes. */
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
    StringTrimmerEditor stringTrimEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimEditor);
    }
    
    
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
        System.out.println("Binding Result : " + theBindResult);
        
        System.out.println("\n\n");
    if(theBindResult.hasErrors()){
        return "customer-form";
    }else{
        return "customer-confirmation";
    }    
        
        
        
        
    }

 

}
