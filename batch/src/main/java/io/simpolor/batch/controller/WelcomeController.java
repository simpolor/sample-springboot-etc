package io.simpolor.batch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @RequestMapping({"/", "/index", "/welcome"})
    @ResponseBody
    public String welcome() {
        return "Sample Springboot Batch";
    }
}
