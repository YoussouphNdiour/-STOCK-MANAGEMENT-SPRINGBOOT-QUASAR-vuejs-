package springboot.service;


import springboot.entity.SaleHistory;
import springboot.repository.SaleHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleHistoryService {
    @Autowired
    private SaleHistoryRepository repository;

    public SaleHistory saveSaleHistory(SaleHistory SaleHistory) {
        return repository.save(SaleHistory);
    }

    public List<SaleHistory> saveSaleHistorys(List<SaleHistory> SaleHistory) {
        return repository.saveAll(SaleHistory);
    }

    public List<SaleHistory> getSaleHistorys() {
        return repository.findAll();
    }

    public SaleHistory getSaleHistoryById(int id) {
        return repository.findById(id).orElse(null);
    }

    public SaleHistory getSaleHistoryByName(String name) {
        return repository.findByName(name);
    }

    public String deleteSaleHistory(int id) {
        repository.deleteById(id);
        return "SaleHistory removed !! " + id;
    }

    public SaleHistory updateSaleHistory(SaleHistory SaleHistory) {
        SaleHistory existingSaleHistory = repository.findById(SaleHistory.getId()).orElse(null);
        existingSaleHistory.setName(SaleHistory.getName());
        existingSaleHistory.setQuantity(SaleHistory.getQuantity());
        existingSaleHistory.setIdProduct(SaleHistory.getIdProduct());
        existingSaleHistory.setIdinvoices(SaleHistory.getIdinvoices());
        return repository.save(existingSaleHistory);
    }


}