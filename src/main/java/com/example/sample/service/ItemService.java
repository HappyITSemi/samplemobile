package com.example.sample.service;

import com.example.sample.entity.Item;
import com.example.sample.form.ItemForm;
import com.example.sample.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    @Modifying
    @Transactional
    public Boolean createFromForm(ItemForm itemForm){

        Item item = new Item();
        item.setName(itemForm.getName());
        item.setPrice(itemForm.getPrice());
        item.setMemo(itemForm.getMemo());
        item.setFlag(itemForm.getFlag());
        item.setCreated(LocalDateTime.now());
        itemRepository.saveAndFlush(item);
        return true;
    }

    @Transactional(readOnly = true)
    public Item findById(Long id){
        return itemRepository.getOne(id);
    }

}
