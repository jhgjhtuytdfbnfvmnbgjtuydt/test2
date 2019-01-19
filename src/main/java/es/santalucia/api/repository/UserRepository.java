package es.santalucia.api.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import es.santalucia.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}