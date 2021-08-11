package springboot.controller;


import springboot.entity.Provider;
import springboot.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProviderController {

    @Autowired
    private ProviderService service;
    @CrossOrigin
    @PostMapping("/addProvider")
    public Provider addProvider(@RequestBody Provider Provider) {
        return service.saveProvider(Provider);
    }
    @CrossOrigin
    @PostMapping("/addProviders")
    public List<Provider> addProviders(@RequestBody List<Provider> Providers) {
        return service.saveProviders(Providers);
    }
    @CrossOrigin
    @GetMapping("/Providers")
    public List<Provider> findAllProviders() {
        return service.getProviders();
    }
    @CrossOrigin
    @GetMapping("/ProviderById/{id}")
    public Provider findProviderById(@PathVariable int id) {
        return service.getProviderById(id);
    }
    @CrossOrigin
    @GetMapping("/Provider/{name}")
    public Provider findProviderByName(@PathVariable String name) {
        return service.getProviderByName(name);
    }
    @CrossOrigin
    @PutMapping("/updateProvider")
    public Provider updateProvider(@RequestBody Provider Provider) {
        return service.updateProvider(Provider);
    }
    @CrossOrigin
    @DeleteMapping("/deleteProvider/{id}")
    public String deleteProvider(@PathVariable int id) {
        return service.deleteProvider(id);
    }
}
