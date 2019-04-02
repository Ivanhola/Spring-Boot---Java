
package com.ivanllamas.RecipeProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

//this will be handled at a global level within controllers when they run across a 400 number format error
@ControllerAdvice
public class GlobalControllerExceptionHandlers {
    
    // 400 ERROR BAD REQUEST
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormat(Exception exception){

         System.err.println("Handling Number Format Exception");
         System.err.println(exception.getMessage());

         ModelAndView modelAndView = new ModelAndView();

         modelAndView.setViewName("400Error");
         //adding model attr to 404 error.html
         modelAndView.addObject("exception", exception);

         return modelAndView;
    }
}
