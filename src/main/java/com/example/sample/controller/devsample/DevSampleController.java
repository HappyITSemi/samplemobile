package com.example.sample.controller.devsample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/devsample")
public class DevSampleController {

    @GetMapping
    public String tab1Doing() {
        return "/devsample/singletable/index-tab1";
    }

}
