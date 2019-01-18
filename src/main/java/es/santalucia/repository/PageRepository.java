package es.santalucia.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import es.santalucia.model.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Integer> {
	
}