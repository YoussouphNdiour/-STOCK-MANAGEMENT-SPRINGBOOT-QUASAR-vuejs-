package springboot.service;


import springboot.entity.Sale;
import springboot.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;

    public Sale saveSale(Sale Sale) {
        return repository.save(Sale);
    }

    public List<Sale> saveSales(List<Sale> Sales) {
        return repository.saveAll(Sales);
    }

    public List<Sale> getSales() {
        return repository.findAll();
    }

    public Sale getSaleById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Sale getSaleByName(String name) {
        return repository.findByName(name);
    }

    public String deleteSale(int id) {
        repository.deleteById(id);
        return "Sale removed !! " + id;
    }

    public Sale updateSale(Sale Sale) {
        Sale existingSale = repository.findById(Sale.getId()).orElse(null);
        existingSale.setname(Sale.getname());
        existingSale.setDate(Sale.getDate());
        existingSale.setPrice_total(Sale.getPrice_total());
        return repository.save(existingSale);
    }


}