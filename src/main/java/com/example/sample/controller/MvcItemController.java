package com.example.sample.controller;

import com.example.sample.entity.Item;
import com.example.sample.form.ItemForm;
import com.example.sample.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
@RequestMapping(path="/item")
public class MvcItemController {

    @ModelAttribute
    private ItemForm setUpItemForm(){
        return new ItemForm();
    }

    @Autowired
    private ItemService itemService;


    @GetMapping
    public ModelAndView indexItem(ModelAndView mv){

        mv.setViewName("/item/index");
        mv.addObject("itemFormObj", setUpItemForm());

        List<Item> items = itemService.findAll();
        mv.addObject("items", items);

        return mv;
    }

    @Modifying
    @PostMapping(path="/new")
    public ModelAndView newItem(@Validated @ModelAttribute ItemForm itemFormObj){
        itemService.createFromForm(itemFormObj);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/item/index");
        // mv.addObject("itemFormObj", itemFormObj);
        return mv;
        // 外部サイトへは redirect, 内部は、forward
    }

    @Modifying
    @PostMapping(path="/confirm")     // create
    public ModelAndView confirmItem(@Validated @ModelAttribute ItemForm itemFormObj){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/item/confirm");
        itemFormObj.setCreated(
                LocalDateTime.now()
                       // .format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))
        );
        mv.addObject("itemFormObj", itemFormObj);
        return mv;

    }




}
