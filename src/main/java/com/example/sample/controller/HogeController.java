package com.example.sample.controller;

import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping(path="/hoge")
public class HogeController {

    /**
     *
     * @return resposeにリストを返す
     */
    @GetMapping(path="/list")
    public List<String> hogeList(){
        List<String> lst = new CopyOnWriteArrayList<>();
        lst.add("First-string-list1");
        lst.add("Second-string-list2");
        return lst;
    }

    @GetMapping(value="{id}")
    public ModelAndView hogeMvList(ModelAndView mv, @PathVariable("id") Long id){
         List<String> lst = new CopyOnWriteArrayList<>();

         // lst.add("id=" + id);
         lst.add("First-string-list1");
         lst.add("Second-string-list2");
         mv.setViewName("/hoge/index");
         mv.addObject("lst", lst);
         return mv;
    }

    @GetMapping(path="/map")
    public Map<String, Integer> hogeMap(){
        Map<String, Integer> mp = new ConcurrentHashMap<>();
        mp.put("map-string1", 1);
        mp.put("map-string2", 2);
        return mp;
    }

}
