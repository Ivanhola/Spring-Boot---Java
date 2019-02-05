
package com.ivanllamas.SpringMvcFormTagApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*this controller will take take care of the main menu page*/
@Controller
public class MainMenuController {
    
    @RequestMapping("/")
    public String mainMenuPage(){
        return "main-menu";
    }
}
