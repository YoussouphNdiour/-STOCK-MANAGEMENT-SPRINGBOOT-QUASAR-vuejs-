package springboot.controller;


import springboot.entity.Sale;

import springboot.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SaleController {

    @Autowired
    private SaleService service;
    
    @CrossOrigin
    @PostMapping("/addSale")
    public Sale addSale(@RequestBody Sale Sale) {
        return service.saveSale(Sale);
    }
    
    @CrossOrigin
    @PostMapping("/addSales")
    public List<Sale> addSales(@RequestBody List<Sale> Sales) {
        return service.saveSales(Sales);
    }
    
    @CrossOrigin
    @GetMapping("/Sales")
    public List<Sale> findAllSales() {
        return service.getSales();
    }
    
    @CrossOrigin
    @GetMapping("/SaleById/{id}")
    public Sale findSaleById(@PathVariable int id) {
        return service.getSaleById(id);
    }
    
    @CrossOrigin
    @GetMapping("/Sale/{name}")
    public Sale findSaleByName(@PathVariable String name) {
        return service.getSaleByName(name);
    }
    
    @CrossOrigin
    @PutMapping("/updateSale")
    public Sale updateSale(@RequestBody Sale Sale) {
        return service.updateSale(Sale);
    }
    
    @CrossOrigin
    @DeleteMapping("/deleteSale/{id}")
    public String deleteSale(@PathVariable int id) {
        return service.deleteSale(id);
    }
}
