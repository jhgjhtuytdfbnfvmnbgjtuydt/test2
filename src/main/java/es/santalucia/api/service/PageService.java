package es.santalucia.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import es.santalucia.api.model.Page;
import es.santalucia.api.repository.PageRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PageService {

	@Autowired
	private PageRepository pageRepository;

	public List<Page> findAll() {
		return pageRepository.findAll();
	}

	public Page findOne(Integer id) {
		return pageRepository.findById(id).get();
	}
	
	@Transactional(readOnly = false)
	public Page save(Page entity) {
		return pageRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Page entity) {
		pageRepository.delete(entity);
	}

}
	
