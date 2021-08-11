package springboot.controller;


import springboot.entity.SaleHistory;
import springboot.service.SaleHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class SaleHistoryController {

    @Autowired
    private SaleHistoryService service;

    @PostMapping("/addSaleHistory")
    public SaleHistory addSaleHistory(@RequestBody SaleHistory Sale) {
        return service.saveSaleHistory(Sale);
    }

   
}
