package com.github.Th0rn_dev.restaurants_voting.web.menu;


import com.github.Th0rn_dev.restaurants_voting.util.validation.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.github.Th0rn_dev.restaurants_voting.model.Menu;
import com.github.Th0rn_dev.restaurants_voting.repository.MenuRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = AdminMenuController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AdminMenuController {
    private final MenuRepository menuRepository;

    public AdminMenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    static final String REST_URL = "/api/menus";

    @GetMapping
    public List<Menu> getMenuPresentDay() {
        log.info("Get present day menu");
        return menuRepository.findAllPresentDayMenu();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> get(@PathVariable int id) {
        log.info("get menu with {}", id);
        return ResponseEntity.of(menuRepository.findById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @CacheEvict(value = "menus", allEntries = true)
    public ResponseEntity<Menu> createMenuWithDish(@Valid @RequestBody Menu menu) {
        log.info("create {}", menu);
        ValidationUtil.checkNew(menu);
        Menu created = menuRepository.save(menu);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = "menus", allEntries = true)
    public void delete(@PathVariable int id) {
        log.info("delete {}", id);
        menuRepository.deleteExisted(id);
    }
}
