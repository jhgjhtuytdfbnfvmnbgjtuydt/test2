package es.santalucia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import es.santalucia.model.Element;
import es.santalucia.repository.ElementRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ElementService {

	@Autowired
	private ElementRepository elementRepository;

	public List<Element> findAll() {
		return elementRepository.findAll();
	}

	public Element findOne(Integer id) {
		return elementRepository.findById(id).get();
	}
	
	@Transactional(readOnly = false)
	public Element save(Element entity) {
		return elementRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Element entity) {
		elementRepository.delete(entity);
	}

}
	
