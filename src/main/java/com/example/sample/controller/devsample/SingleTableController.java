package com.example.sample.controller.devsample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/devsample/singletable")
public class SingleTableController {

        @GetMapping(value={"/tab1"})
        public String tab1Doing() {
            return "/devsample/singletable/index-tab1";
        }

        @GetMapping(value="/tab2")
        public String tab2Doing(){
            return "/devsample/singletable/index-tab2";
        }

        @GetMapping(path="/tab3")
        public String tab3Doing() {
            return "/devsample/singletable/index-tab3";
        }

        @GetMapping(path="/tab4")
        public String tab4Doing() {
            return "/devsample/singletable/index-tab4";
        }
}
