package es.santalucia.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import es.santalucia.model.Element;

@Repository
public interface ElementRepository extends JpaRepository<Element, Integer> {
	
}