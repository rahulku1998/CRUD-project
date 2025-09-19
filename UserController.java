package org.example.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private CustomRepository customRepository;


    @PostMapping
    public Item addUser(@RequestBody Item item) {
        return customRepository.save(item);
    }
    @GetMapping("/details")
    public List<Item> getAllItem(){
        return customRepository.findAll();
    }
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id){
        return customRepository.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id,@RequestBody Item updateItem){
        return customRepository.findById(id).map(item->{
            item.setName(updateItem.getName());
            return customRepository.save(item);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id){
        customRepository.deleteById(id);
        return "deleted item with id"+id;
    }
}
