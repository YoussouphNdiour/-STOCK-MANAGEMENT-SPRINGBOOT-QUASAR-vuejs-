package springboot.repository;


import springboot.entity.SaleHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleHistoryRepository extends JpaRepository<SaleHistory,Integer> {
	SaleHistory findByName(String name);
}
