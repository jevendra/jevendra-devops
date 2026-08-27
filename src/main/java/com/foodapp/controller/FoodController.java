package com.foodapp.controller;

import com.foodapp.model.Food;
import com.foodapp.repository.FoodRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin
public class FoodController {
    private final FoodRepository repository;
    public FoodController(FoodRepository repository){this.repository=repository;}

    @GetMapping public List<Food> all(){return repository.findAll();}
    @GetMapping("/{id}") public Food one(@PathVariable Long id){
        return repository.findById(id).orElseThrow();
    }
    @PostMapping public Food create(@RequestBody Food food){return repository.save(food);}
    @PutMapping("/{id}") public Food update(@PathVariable Long id,@RequestBody Food food){
        Food f=repository.findById(id).orElseThrow();
        f.setName(food.getName()); f.setDescription(food.getDescription());
        f.setPrice(food.getPrice()); f.setImageUrl(food.getImageUrl()); f.setCategory(food.getCategory());
        return repository.save(f);
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){repository.deleteById(id);}
}