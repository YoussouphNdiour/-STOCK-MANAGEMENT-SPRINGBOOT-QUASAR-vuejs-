package springboot.controller;


import springboot.entity.Product;
import springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    @CrossOrigin
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
    @CrossOrigin
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }
    @CrossOrigin
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }
    @CrossOrigin
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }
    @CrossOrigin
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }
    @CrossOrigin
    @PutMapping("/updateproduct")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
    @CrossOrigin
    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
