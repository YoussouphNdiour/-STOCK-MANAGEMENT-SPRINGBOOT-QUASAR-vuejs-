package springboot.repository;


import springboot.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
	Sale findByName(String name);
}
