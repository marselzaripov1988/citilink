package tech.itpark.citilink.controller;
// 1. @RestController
// 2. Создаём поле, в котором будем хранить нужного менеджера
// 3. Создаём методы, над которыми пишем аннотации:
// - @Get/Post/DeleteMapping
// - @RequestBody/@RequestParam
// 4. Если во всех @...Mapping начало одинаковое, то можно его написать прямо над классом

import org.springframework.web.bind.annotation.*;
import tech.itpark.citilink.domain.*;
import tech.itpark.citilink.manager.ProductManager;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductManager manager = new ProductManager();

    @GetMapping() // над классом + то, что написано здесь -> "/products"
    public List<Product> getAll() {
        return manager.getAll();
    }

    @GetMapping("/search") // /search?text=телевизор
    public List<Product> search(@RequestParam String text) {
        return manager.search(text);
    }

    // {id}
    @GetMapping("/catalog/{type}") // /catalog/caps | books
    public ArrayList<Product> filter(@PathVariable String type) {
        return manager.filter(type);
    }

    @PostMapping("/caps") // "/products" + "/caps" -> "/products/caps"
    public void add(@RequestBody Cap product) {
        manager.add(product);
    }

    @PostMapping("/books")
    public void add(@RequestBody Book product) {
        manager.add(product);
    }

    @PostMapping("/notebook")
    public void add(@RequestBody Notebook product) {
        manager.add(product);
    }

    @PostMapping("/phone")
    public void add(@RequestBody Phone product) {
        manager.add(product);
    }

    @PutMapping("/caps/{id}")
    public void update(@PathVariable int id, @RequestBody Cap product) {
        manager.update(id, product);
    }

    @PutMapping("/notebook/{id}")
    public void update(@PathVariable int id, @RequestBody Notebook product) {
        manager.update(id, product);
    }

    @PutMapping("/phone/{id}")
    public void update(@PathVariable int id, @RequestBody Phone product) {
        manager.update(id, product);
    }

    @PutMapping("/book/{id}")
    public void update(@PathVariable int id, @RequestBody Book product) {
        manager.update(id, product);
    }

    @DeleteMapping("/caps/{id}")
    public void remove(@PathVariable int id, @RequestBody Cap product) {
        manager.remove(id, product);
    }

    @DeleteMapping("/book/{id}")
    public void remove(@PathVariable int id, @RequestBody Book product) {
        manager.remove(id, product);
    }

    @DeleteMapping("/notebook/{id}")
    public void remove(@PathVariable int id, @RequestBody Notebook product) {
        manager.remove(id, product);
    }

    @DeleteMapping("/phone/{id}")
    public void remove(@PathVariable int id, @RequestBody Phone product) {
        manager.remove(id, product);
    }
}
