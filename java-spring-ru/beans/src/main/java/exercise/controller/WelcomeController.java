package exercise.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

// BEGIN
@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    
    @Autowired
    private Daytime dayTime;
    
    @GetMapping("")
    public String welcome() {
        var res = dayTime.getName();
        return "It is " + res + " now! Welcome to Spring!";
    }
}
// END
