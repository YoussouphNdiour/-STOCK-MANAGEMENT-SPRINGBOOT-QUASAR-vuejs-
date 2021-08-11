package springboot.repository;


import springboot.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider,Integer> {
	Provider findByName(String name);
}
