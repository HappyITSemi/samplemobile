package com.example.sample.controller;

import com.example.sample.entity.Item;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/api/getItems")
@Transactional
public class RestItemController {
    String apiItemUrl     = "http://localhost:9000/api/items/";

    // @Inject
    // RestTemplate restTemplate;

    // HttpStatus statusCode = responseEntity.getStatusCode();
    // HttpHeaders header = responseEntity.getHeaders();
    // User user = responseEntity.getBody();

    @GetMapping
    public List<Item> getItemAll(){
        RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
        ResponseEntity<List<Item>> response = restTemplate.exchange(
                apiItemUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Item>>() { });
        return response.getBody();
    }

    @GetMapping(value="{id}")
    public Item getItem(@PathVariable("id") Long id) {
        RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());

        String apiItemId = apiItemUrl + String.valueOf(id);
        Item item = restTemplate.getForObject(apiItemId, Item.class);
        return item;
    }


// (POST)
// ResponseEntity<Item> response = restTemplate.postForEntity("http://localhost:9092/api/item/", newItem, Item.class);
//
// RequestEntity<User> requestEntity = RequestEntity
//    .post(uri)
    //   .contentType(MediaType.APPLICATION_JSON)
    //   .body(user);


}
