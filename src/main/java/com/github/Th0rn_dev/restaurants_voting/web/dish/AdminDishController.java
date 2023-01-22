package com.github.Th0rn_dev.restaurants_voting.web.dish;


import com.github.Th0rn_dev.restaurants_voting.util.validation.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.github.Th0rn_dev.restaurants_voting.model.Dish;
import com.github.Th0rn_dev.restaurants_voting.repository.DishRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = AdminDishController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AdminDishController {
    static final String REST_URL = "/api/admin/dishes";

    protected final DishRepository repository;


    public AdminDishController(DishRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Dish> getAll(){
        log.info("getAll dish");
        return repository.findAll(Sort.by(Sort.Direction.DESC,"date"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> get(@PathVariable int id) {
        log.info("get dish with {}", id);
        return ResponseEntity.of(repository.findById(id));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        log.info("delete {}", id);
        repository.deleteExisted(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Dish dish, @PathVariable int id) {
        log.info("update {} with  id={}", dish, id);
        ValidationUtil.assureIdConsistent(dish, id);
        repository.save(dish);
    }
}
