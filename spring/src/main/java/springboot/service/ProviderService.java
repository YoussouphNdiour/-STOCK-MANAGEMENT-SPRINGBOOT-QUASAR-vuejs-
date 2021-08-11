package springboot.service;


import springboot.entity.Provider;
import springboot.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repository;

    public Provider saveProvider(Provider Provider) {
        return repository.save(Provider);
    }

    public List<Provider> saveProviders(List<Provider> Providers) {
        return repository.saveAll(Providers);
    }

    public List<Provider> getProviders() {
        return repository.findAll();
    }

    public Provider getProviderById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Provider getProviderByName(String name) {
        return repository.findByName(name);
    }
    public Provider getProviderByProfile(String profile) {
        return repository.findByName(profile);
    }

    public String deleteProvider(int id) {
        repository.deleteById(id);
        return "Provider removed !! " + id;
    }

    public Provider updateProvider(Provider Provider) {
        Provider existingProvider = repository.findById(Provider.getId()).orElse(null);
        existingProvider.setName(Provider.getName());
        existingProvider.setadress(Provider.getadress());
        existingProvider.settelephone(Provider.gettelephone());
        existingProvider.setemail(Provider.getemail());
        return repository.save(existingProvider);
    }


}