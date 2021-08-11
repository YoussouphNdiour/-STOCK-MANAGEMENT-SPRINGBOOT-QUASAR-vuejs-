package springboot.repository;


import springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
    User findByemailAndPassword(String email, String password);
    
    }
